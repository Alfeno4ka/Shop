package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {

    private List<CartEntry> products = new ArrayList<>();

    /**
     * Добавить товар в корзинку либо прибавить его количество на 1.
     *
     * @param product товар
     */
    public void add(Product product) {
        CartEntry existing = getByProduct(product);
        if (Objects.isNull(existing)) {
            products.add(new CartEntry(product));
        } else {
            existing.incrementQuantity();
        }
    }

    /**
     * Отредактировать количество товара в корзинке.
     *
     * @param product  товар
     * @param quantity новое количество
     */
    public void edit(Product product, int quantity) {
        CartEntry existing = getByProduct(product);
        if (Objects.isNull(existing)) {
            products.add(new CartEntry(product, quantity));
        } else {
            existing.setQuantity(quantity);
        }
    }

    /**
     * Удалить товар из корзинки.
     *
     * @param product товар
     */
    public void remove(Product product) {
        CartEntry existing = getByProduct(product);
        if (Objects.nonNull(existing)) {
            products.remove(existing);
        }
    }

    private CartEntry getByProduct(Product product) {
        return products.stream()
                .filter(cartEntry -> cartEntry.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        products.forEach(cartEntry -> sb.append(
                cartEntry.product.getName() + " " +
                        cartEntry.product.getPrice() + "руб : " +
                        cartEntry.quantity + "\n"));
        return sb.toString();
    }

    /**
     * Продукт в корзинке и его количество.
     */
    public class CartEntry {
        private Product product;
        private int quantity;

        private static final int DEFAULT_PRODUCT_QUANTITY = 1;

        public CartEntry(Product product) {
            this.product = product;
            this.quantity = DEFAULT_PRODUCT_QUANTITY;
        }

        public CartEntry(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public void incrementQuantity() {
            this.quantity++;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    /*
    public double totalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
     */
}
