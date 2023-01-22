package com.caresoft.clinicapp;

public interface HippaCompiantUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(int confirmedAuthID);

}
