package org.example;

import org.example.domain.Customer;
import org.example.domain.Product;
import org.example.service.CartService;
import org.example.service.RegistrationService;
import org.example.service.impl.CartServiceImpl;
import org.example.service.impl.RegistrationServiceImpl;

/**
 * Работа, демонстрирующая принципы SOLID, DRY и Magic Number.
 * SOLID:
 * <p>
 * 1. Single Responsibility демонстрируется на примере классов в пакете domain. Каждый класс отвечает за свою
 * бизнесовую сущность;
 * <p>
 * 2. Open/Close Principle: демонстрируется на примере иерархии классов Customer -> PersonalCustomer, BusinessCustomer.
 * Класс Customer не изменяется для решения разных задач, а расширяется дочерними, отвечающими каждый за свою задачу;
 * <p>
 * 3. Liskov Substitution Principle: демонстрируется на примере CartService, который может работать с любыми видами клиентов,
 * принимая в качестве аргумента родительскую сущность Customer;
 * <p>
 * 4. Interface Segregation Principle: вместо единого интерфейса общего назначения используются специализированнные
 * интерфейсы по управлению корзиной, заказами, регистрацией, уведомлениями и тд
 * <p>
 * 5. Dependency Injection используется в классе Store, имитирующем работу цельного приложения магазина.
 * Его зависимости внедряются через конструктор и инстанцируются снаружи.
 * <p>
 * DRY:
 * <p>
 * Принцип DRY можно увидеть, например, в реализации CartSerivce, где повторяющийся код вынесен в приватный метод getCart(),
 * который вызывается в различных методах сервиса.
 * <p>
 * Magic Numbers. От магических чисел в данном проекте избавились разными способами:
 * 1. С использованием именованных локальных переменных, как в методе main;
 * 2. С использованием именованной константы, как в классе Product.
 */
public class Main {

    public static void main(String[] args) {
        int breadPrice = 50;
        int sausagePrice = 350;
        int cheesePrice = 500;

        //Создание продуктов
        Product product1 = new Product("Хлеб", breadPrice);
        Product product2 = new Product("Колбаса", sausagePrice);
        Product product3 = new Product("Сыр", cheesePrice);

        //Инстанцирование сервисов (для DI)
        RegistrationService registrationService = new RegistrationServiceImpl();
        CartService cartService = new CartServiceImpl();

        //Запуск магазина с инъекцией зависимостей
        Store store = new Store(registrationService, cartService);

        //Регистрация пользователей
        Customer customer1 = store.register("+78005553535", "Саня");
        Customer customer2 = store.register("8349213164", "482201313", "ООО Подсолнух");

        System.out.println("Покупатель 1\n");

        //Добавляем товары в корзину покупателю 1
        store.addProductToCart(customer1, product1);
        store.addProductToCart(customer1, product1);
        store.addProductToCart(customer1, product2);

        //Выводим корзину покупателю 1
        System.out.println(store.getCartByCustomer(customer1));

        //Редактируем количество продукта 1 покупателю 1
        store.editProductInCart(customer1, product1, 10);

        //Выводим корзину покупателю 1 после редактирования
        System.out.println(store.getCartByCustomer(customer1));

        //Удаляем продукт 1 из корзины
        store.removeProductFromCart(customer1, product1);

        //Выводим корзину покупателю 1 после удаления
        System.out.println(store.getCartByCustomer(customer1));

        System.out.println("=====================");
        System.out.println("Покупатель 2\n");
        //Добавляем товары в корзину покупателю 2
        store.addProductToCart(customer2, product2);
        store.addProductToCart(customer2, product3);

        //Выводим корзину покупателю 2
        System.out.println(store.getCartByCustomer(customer2));

        //Редактируем количество продукта 2 покупателю 2
        store.editProductInCart(customer2, product2, 5);

        //Выводим корзину покупателю 2 после редактирования
        System.out.println(store.getCartByCustomer(customer2));

        //Удаляем продукт 2 из корзины
        store.removeProductFromCart(customer2, product2);

        //Выводим корзину покупателю 2 после удаления продукта
        System.out.println(store.getCartByCustomer(customer2));
    }
}
