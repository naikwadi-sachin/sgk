package org.sgk.domain;

import java.beans.PropertyEditorSupport;

import org.sgk.service.ReservationService;

public class SportTypeEditor extends PropertyEditorSupport{

	private ReservationService reservationService;
	
	public SportTypeEditor(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int sportTypeId = Integer.parseInt(text);
		SportType sportType = reservationService.getSportType(sportTypeId);
		setValue(sportType);
	}
}
