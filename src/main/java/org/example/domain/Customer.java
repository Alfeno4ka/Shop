package org.example.domain;

import java.util.UUID;

/**
 * Покупатель (базовая сущность).
 */
public class Customer {

    private UUID id;
    private String email;
    private String phone;

    public Customer() {
        this.id = UUID.randomUUID();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

