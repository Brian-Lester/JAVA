package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HippaCompiantUser, HippaCompliantAdmin  {
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
	
    
    public AdminUser(Integer id, String role) {
		super(id);
	    this.role= role;
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<String> reportSecurityIncidents() {

		return securityIncidents;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}


	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}


	@Override
	public boolean assignPin(int pin) {
		if (pin >= 100000 && pin <= 999999) {
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
			authIncident();
			return false;
		}
		else {
			return true;
		}
	}
	
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

}
