package org.example.service;

import org.example.domain.Cart;
import org.example.domain.Customer;
import org.example.domain.Product;

/**
 * Корзина.
 */
public interface CartService {

    /**
     * Добавить товар.
     *
     * @param customer покупатель
     * @param product товар
     */
    void add(Customer customer, Product product);

    /**
     * Отредактировать количество единиц товара.
     *
     * @param customer покупатель
     * @param product товар
     * @param newQuantity количество
     */
    void edit(Customer customer, Product product, int newQuantity);

    /**
     * Удалить товар из корзины.
     *
     * @param customer покупатель
     * @param product товар
     */
    void remove(Customer customer, Product product);

    /**
     * Получить корзинку по владельцу.
     *
     * @param customer покупатель (владелец корзинки)
     * @return сущность {@link Cart}
     */
    Cart getCart(Customer customer);
}
