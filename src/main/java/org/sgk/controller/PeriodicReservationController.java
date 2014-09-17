package org.sgk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sgk.domain.PeriodicReservation;
import org.sgk.domain.Player;
import org.sgk.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping(value = "/periodicReservationForm")
@SessionAttributes("reservation")
public class PeriodicReservationController {

	private ReservationService reservationService;
	private PeriodicReservationValidator validator;

	@Autowired
	public PeriodicReservationController(ReservationService reservationService,PeriodicReservationValidator validator) {
		this.reservationService = reservationService;
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		PeriodicReservation reservation = new PeriodicReservation();
		reservation.setPlayer(new Player(null, null));
		model.addAttribute("reservation", reservation);
		return "reservationCourtForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("reservation") PeriodicReservation reservation,
			BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage, Model model)
			throws ReservationNotAvailableException {

		Map<Integer, String> pageForms = new HashMap<Integer, String>();
		pageForms.put(0, "reservationCourtForm");
		pageForms.put(1, "reservationTimeForm");
		pageForms.put(2, "reservationPlayerForm");
		if (request.getParameter("_cancel") != null) {
			return pageForms.get(currentPage);
		} else if (request.getParameter("_finish") != null) {
			validator.validate(reservation, result);
			if (result.hasErrors()) {
				return pageForms.get(currentPage);
			} else {
				reservationService.makePeriodic(reservation);
				status.setComplete();
				return "redirect:reservationSuccess";
			}
		} else {
			int targetPage = WebUtils.getTargetPage(request, "_target",
					currentPage);
			if (targetPage < currentPage)
				return pageForms.get(targetPage);

			switch (currentPage) {
			case 0:
				validator.validateCourt(reservation, result);
				break;
			case 1:
				validator.validateTime(reservation, result);
				break;
			case 2:
				validator.validatePlayer(reservation, result);
				break;
			}

			if (result.hasErrors())
				return pageForms.get(currentPage);
			else
				return pageForms.get(targetPage);
		}
	}

	@ModelAttribute("periods")
	public Map<Integer, String> periods() {
		Map<Integer, String> periods = new HashMap<Integer, String>();
		periods.put(1, "DAILY");
		periods.put(7, "WEEKLY");
		return periods;
	}
}
