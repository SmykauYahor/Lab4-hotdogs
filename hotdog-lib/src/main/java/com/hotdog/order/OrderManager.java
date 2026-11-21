package com.hotdog.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Менеджер учёта заказов. Хранит все оформленные заказы и вычисляет общую статистику продаж.
 */
public class OrderManager {

    private final List<Order> orders;

    /**
     * Создаёт пустой менеджер учёта заказов.
     */
    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    /**
     * Регистрирует новый заказ в системе учёта.
     *
     * @param order оформленный заказ
     */
    public void addOrder(Order order) {
        orders.add(Objects.requireNonNull(order, "Заказ не может быть null."));
    }

    /**
     * Возвращает неизменяемый список всех зарегистрированных заказов.
     *
     * @return список заказов
     */
    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    /**
     * Подсчитывает общую сумму всех зарегистрированных заказов.
     *
     * @return суммарная выручка по всем заказам
     */
    public double getTotalRevenue() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }

    /**
     * Подсчитывает количество полных заказов (содержащих хотя бы один готовый хот-дог).
     *
     * @return количество полных заказов
     */
    public long getFullOrdersCount() {
        return orders.stream()
                .filter(Order::isFullOrder)
                .count();
    }

    /**
     * Подсчитывает среднюю стоимость заказа.
     *
     * @return средняя стоимость по всем заказам, либо {@code 0.0}, если заказов нет
     */
    public double getAverageOrderPrice() {
        if (orders.isEmpty()) {
            return 0.0;
        }
        return getTotalRevenue() / orders.size();
    }
}