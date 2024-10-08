package org.example.domain;

/**
 * Покупатель (физлицо).
 */
public class PersonalCustomer extends Customer {

    private String fullName;

    public PersonalCustomer(String fullPhone) {
        this.setPhone(fullName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
