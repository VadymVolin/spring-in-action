package org.phonenums.phoneproj.contact;

import org.phonenums.phoneproj.phonenumber.PhoneNumber;

public class Contact {

    private PhoneNumber phoneNumber;

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return new StringBuilder("(")
                .append(phoneNumber.getAreaCode()).append(")-")
                .append(phoneNumber.getPrefix()).append("-")
                .append(phoneNumber.getNumber())
                .toString();
    }

}
