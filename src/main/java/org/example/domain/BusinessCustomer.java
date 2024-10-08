package org.example.domain;

/**
 * Бизнес-покупатель (юрлицо).
 */
public class BusinessCustomer extends Customer {

    private String inn;
    private String kpp;
    private String name;

    public BusinessCustomer(String inn, String kpp, String name) {
        this.inn = inn;
        this.kpp = kpp;
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getName() {
        return name;
    }
}
