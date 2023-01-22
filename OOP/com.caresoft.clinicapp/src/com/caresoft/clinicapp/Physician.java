package com.caresoft.clinicapp;

import java.util.ArrayList;

public class Physician extends User implements HippaCompiantUser {
	private ArrayList<String> patientNotes;
	@SuppressWarnings("unused")
	private int pin;

	public Physician(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin >= 1000 && pin <= 9999) {
			super.setPin(pin);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(int confirmedAuthID) {
		int storedPin = super.getId();
		if(confirmedAuthID != storedPin) {
			return false;
		}
		else {
			return true;
		}
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(String patientNotes) {
		this.patientNotes.add(patientNotes);
	}
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	

}
