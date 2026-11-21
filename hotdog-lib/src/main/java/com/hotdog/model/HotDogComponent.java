package com.hotdog.model;

import java.util.Objects;

/**
 * Отдельный компонент хот-дога (булочка, сосиска, соус, топпинг).
 * Наследуется от {@link MenuItem}, поэтому может продаваться как самостоятельный товар.
 */
public class HotDogComponent extends MenuItem {

    private final ComponentType type;

    /**
     * Создаёт компонент хот-дога.
     *
     * @param name  название компонента
     * @param type  категория компонента
     * @param price цена при отдельной продаже и в составе хот-дога
     */
    public HotDogComponent(String name, ComponentType type, double price) {
        super(name, price);
        this.type = Objects.requireNonNull(type, "Тип компонента не может быть null.");
    }

    /**
     * Возвращает категорию данного компонента.
     *
     * @return категория компонента
     */
    public ComponentType getType() {
        return type;
    }

    /**
     * Возвращает строковое представление компонента с указанием его категории и цены.
     *
     * @return строка формата "[Категория] Название - Цена руб."
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", type.getDisplayName(), super.toString());
    }
}