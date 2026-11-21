package com.hotdog.model;

import java.util.List;

/**
 * Хот-дог вида Berlinka в немецком стиле с сосиской карривурст и тушёной капустой.
 */
public class Berlinka extends HotDog {

    /**
     * Создаёт стандартный хот-дог Berlinka со всеми входящими в рецепт компонентами.
     */
    public Berlinka() {
        super("Berlinka", List.of(
                new HotDogComponent("Баварская булочка", ComponentType.BUN, 70.0),
                new HotDogComponent("Сосиска карривурст", ComponentType.SAUSAGE, 160.0),
                new HotDogComponent("Соус карри", ComponentType.SAUCE, 40.0),
                new HotDogComponent("Тушёная капуста", ComponentType.TOPPING, 50.0)
        ));
    }
}