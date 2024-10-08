package org.example.service.impl;

import org.example.domain.BusinessCustomer;
import org.example.domain.PersonalCustomer;
import org.example.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public PersonalCustomer registerPersonalCustomer(String phone, String fullName) {
        PersonalCustomer customer = new PersonalCustomer(phone);
        customer.setFullName(fullName);
        return customer;
    }

    @Override
    public BusinessCustomer registerBusinessCustomer(String inn, String kpp, String organizationName) {
        return new BusinessCustomer(inn, kpp, organizationName);
    }
}
