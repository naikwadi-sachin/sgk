package org.sgk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sgk.domain.SportType;
import org.sgk.domain.SportTypeEditor;
import org.sgk.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class ReservationBindingInitializer implements WebBindingInitializer {

	private ReservationService reservationService;
	
	@Autowired
	public ReservationBindingInitializer(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(SportType.class, new SportTypeEditor(reservationService));
	}

}
