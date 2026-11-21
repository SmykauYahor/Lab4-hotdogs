package com.hotdog.order;

import com.hotdog.model.HotDog;
import com.hotdog.model.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Заказ покупателя, содержащий приобретённые позиции меню (готовые хот-доги и/или отдельные компоненты).
 */
public class Order {

    private final int id;
    private final List<MenuItem> items;

    /**
     * Создаёт новый пустой заказ с указанным номером.
     *
     * @param id уникальный идентификатор заказа (положительное число)
     * @throws IllegalArgumentException если номер заказа меньше или равен нулю
     */
    public Order(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Номер заказа должен быть положительным.");
        }
        this.id = id;
        this.items = new ArrayList<>();
    }

    /**
     * Добавляет позицию меню (хот-дог или отдельный компонент) в заказ.
     *
     * @param item добавляемая позиция меню
     */
    public void addItem(MenuItem item) {
        items.add(Objects.requireNonNull(item, "Позиция заказа не может быть null."));
    }

    /**
     * Возвращает неизменяемый список всех позиций в заказе.
     *
     * @return список позиций заказа
     */
    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Подсчитывает общую стоимость текущего заказа.
     *
     * @return сумма цен всех позиций в заказе
     */
    public double getTotalPrice() {
        double sum = 0.0;
        for (MenuItem item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    /**
     * Проверяет, является ли заказ полным.
     * Полным считается заказ, содержащий как минимум один готовый хот-дог ({@link HotDog}),
     * в отличие от заказа отдельных компонентов.
     *
     * @return {@code true}, если в заказе есть хотя бы один готовый хот-дог; иначе {@code false}
     */
    public boolean isFullOrder() {
        return items.stream().anyMatch(HotDog.class::isInstance);
    }

    /**
     * Возвращает идентификатор заказа.
     *
     * @return номер заказа
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает подробное текстовое описание заказа.
     *
     * @return строка с номером, типом заказа, списком позиций и итоговой суммой
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String orderType = isFullOrder() ? "Полный заказ" : "Заказ компонентов";
        sb.append(String.format("Заказ #%d [%s] - Итого: %.2f руб.%n", id, orderType, getTotalPrice()));
        for (MenuItem item : items) {
            sb.append("  - ").append(item).append(System.lineSeparator());
        }
        return sb.toString();
    }
}