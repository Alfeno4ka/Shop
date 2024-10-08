package org.example;

import org.example.domain.Cart;
import org.example.domain.Customer;
import org.example.domain.Product;
import org.example.service.CartService;
import org.example.service.RegistrationService;

public class Store {

    private final CartService cartService;
    private final RegistrationService registrationService;

    public Store(RegistrationService registrationService,
                 CartService cartService) {
        this.registrationService = registrationService;
        this.cartService = cartService;
    }

    /**
     * Зарегистрировать покупателя физлицо.
     *
     * @param phone телефон
     * @param fullName ФИО
     * @return зарегистрированный покупатель
     */
    public Customer register(String phone, String fullName) {
        return registrationService.registerPersonalCustomer(phone, fullName);
    }

    /**
     * Зарегистрировать покупателя юрлицо.
     *
     * @param inn ИНН организации
     * @param kpp КПП организации
     * @param organizationName наименование организации
     * @return зарегистриованный покупатель
     */
    public Customer register(String inn, String kpp, String organizationName) {
        return registrationService.registerBusinessCustomer(inn, kpp, organizationName);
    }

    /**
     * Добавить товар в корзинку.
     *
     * @param customer покупатель
     * @param product товар
     */
    public void addProductToCart(Customer customer, Product product) {
        cartService.add(customer, product);
    }

    /**
     * Отредактировать товар в корзинке
     *
     * @param customer покупатель
     * @param product товар
     * @param quantity новое количество
     */
    public void editProductInCart(Customer customer, Product product, int quantity) {
        cartService.edit(customer, product, quantity);
    }

    /**
     * Удалить товар из корзинки.
     *
     * @param customer покупатель
     * @param product товар
     */
    public void removeProductFromCart(Customer customer, Product product) {
        cartService.remove(customer, product);
    }

    /**
     * Вывести данные корзинки по указанному клиенту.
     *
     * @param customer покупатель
     * @return корзинка
     */
    public Cart getCartByCustomer(Customer customer) {
        return cartService.getCart(customer);
    }
}
