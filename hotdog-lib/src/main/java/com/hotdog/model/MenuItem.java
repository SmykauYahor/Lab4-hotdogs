package com.hotdog.model;

/**
 * Абстрактный базовый класс для любой позиции меню, доступной к продаже.
 */
public abstract class MenuItem {

    private final String name;
    private final double price;

    /**
     * Создаёт позицию меню с указанным названием и ценой.
     *
     * @param name  название товара
     * @param price цена товара (не может быть отрицательной)
     * @throws IllegalArgumentException если название пустое или цена меньше нуля
     */
    public MenuItem(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название позиции не может быть пустым.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }
        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает название позиции меню.
     *
     * @return название товара
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает стоимость позиции меню.
     *
     * @return цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * Возвращает строковое представление товара с ценой.
     *
     * @return строка формата "Название - Цена руб."
     */
    @Override
    public String toString() {
        return String.format("%s - %.2f руб.", name, price);
    }
}