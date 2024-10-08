package org.example.service;

import org.example.domain.BusinessCustomer;
import org.example.domain.PersonalCustomer;

/**
 * Сервис регистрации.
 */
public interface RegistrationService {

    /**
     * Зарегистрировать покупателя-физицо.
     *
     * @param phone    телефон
     * @param fullName полные ФИО
     * @return сущность {@link PersonalCustomer}
     */
    PersonalCustomer registerPersonalCustomer(String phone, String fullName);

    /**
     * Зарегистрировать покупателя-юрлицо.
     *
     * @param inn              ИНН организаци
     * @param kpp              КПП организации
     * @param organizationName наименование организации
     * @return сущность {@link BusinessCustomer}
     */
    BusinessCustomer registerBusinessCustomer(String inn, String kpp, String organizationName);
}
