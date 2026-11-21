package com.hotdog.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Абстрактный класс готового хот-дога.
 * Использует композицию для хранения набора компонентов, из которых складывается его цена.
 */
public abstract class HotDog extends MenuItem {

    private final List<HotDogComponent> components;

    /**
     * Конструктор базового хот-дога. Рассчитывает итоговую стоимость как сумму цен всех компонентов.
     *
     * @param name       название вида хот-дога
     * @param components список компонентов, входящих в состав хот-дога
     * @throws IllegalArgumentException если список компонентов пуст или содержит null
     */
    protected HotDog(String name, List<HotDogComponent> components) {
        super(name, calculatePrice(components));
        this.components = List.copyOf(components);
    }

    private static double calculatePrice(List<HotDogComponent> components) {
        if (components == null || components.isEmpty()) {
            throw new IllegalArgumentException("Хот-дог должен содержать хотя бы один компонент.");
        }
        double sum = 0.0;
        for (HotDogComponent component : components) {
            if (component == null) {
                throw new IllegalArgumentException("Компонент хот-дога не может быть null.");
            }
            sum += component.getPrice();
        }
        return sum;
    }

    /**
     * Возвращает неизменяемый список компонентов, из которых состоит хот-дог.
     *
     * @return список компонентов хот-дога
     */
    public List<HotDogComponent> getComponents() {
        return components;
    }

    /**
     * Возвращает строковое описание хот-дога с его составом и ценой.
     *
     * @return строка с названием, ценой и списком ингредиентов
     */
    @Override
    public String toString() {
        String ingredients = components.stream()
                .map(HotDogComponent::getName)
                .collect(Collectors.joining(", "));
        return String.format("Хот-дог %s (состав: %s) - %.2f руб.", getName(), ingredients, getPrice());
    }
}