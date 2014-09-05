package org.sgk.controller;

import java.util.logging.SimpleFormatter;

import org.sgk.domain.Reservation;
import org.sgk.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

	private ReservationService reservationService;

	@Autowired
	public ReservationFormController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitform(
			@ModelAttribute("reservation") Reservation reservation,
			BindingResult result, SessionStatus status)
			throws ReservationNotAvailableException {
		reservationService.make(reservation);
		return "redirect:reservationSuccess";
	}

}