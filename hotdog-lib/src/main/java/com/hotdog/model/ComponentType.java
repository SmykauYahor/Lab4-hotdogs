package com.hotdog.model;

/**
 * Перечисление категорий компонентов, из которых собирается хот-дог.
 */
public enum ComponentType {

    /** Булочка для хот-дога. */
    BUN("Булочка"),

    /** Сосиска или колбаска. */
    SAUSAGE("Сосиска"),

    /** Соус. */
    SAUCE("Соус"),

    /** Дополнительный топпинг или гарнир. */
    TOPPING("Топпинг");

    private final String displayName;

    /**
     * Создаёт категорию компонента с читаемым названием.
     *
     * @param displayName отображаемое название категории
     */
    ComponentType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Возвращает отображаемое название категории компонента.
     *
     * @return название категории на русском языке
     */
    public String getDisplayName() {
        return displayName;
    }
}