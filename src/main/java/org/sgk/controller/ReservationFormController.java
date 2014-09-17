package org.sgk.controller;

import java.util.List;

import org.sgk.domain.Player;
import org.sgk.domain.Reservation;
import org.sgk.domain.SportType;
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

@Controller
@SessionAttributes("reservation")
public class ReservationFormController {

	private ReservationService reservationService;
	private ReservationValidator reservationValidator;

	@Autowired
	public ReservationFormController(ReservationService reservationService,
			ReservationValidator reservationValidator) {
		this.reservationService = reservationService;
		this.reservationValidator = reservationValidator;
	}

	@ModelAttribute("sportTypes")
	public List<SportType> getAllSports() {
		return reservationService.getAllSportTypes();
	}

	@RequestMapping(value = "/reservationForm", method = RequestMethod.GET)
	public String setupForm(
			@RequestParam(required = false, value = "username") String username,
			Model model) {
		Reservation reservation = new Reservation();
		reservation.setPlayer(new Player(username, null));
		model.addAttribute("reservation", reservation);
		return "reservationForm";
	}

	@RequestMapping(value = "/reservationForm", method = RequestMethod.POST)
	public String submitform(
			@ModelAttribute("reservation") Reservation reservation,
			BindingResult result, Model model, SessionStatus status)
			throws ReservationNotAvailableException {
		reservationValidator.validate(reservation, result);
		System.out.println("hasErrors=" + result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("reservation", reservation);
			return "reservationForm";
		} else {
			reservationService.make(reservation);
			status.setComplete();
			return "redirect:reservationSuccess";
		}
	}

	@RequestMapping(value = "/reservationSuccess", method = RequestMethod.GET)
	public String onReservationSuccess() {
		return "reservationSuccess";
	}

}