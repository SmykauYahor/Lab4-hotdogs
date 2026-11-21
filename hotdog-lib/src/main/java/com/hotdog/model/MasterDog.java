package com.hotdog.model;

import java.util.List;

/**
 * Хот-дог вида MasterDog на булочке бриошь с говяжьей сосиской, сырным соусом и беконом.
 */
public class MasterDog extends HotDog {

    /**
     * Создаёт стандартный хот-дог MasterDog со всеми входящими в рецепт компонентами.
     */
    public MasterDog() {
        super("MasterDog", List.of(
                new HotDogComponent("Булочка бриошь", ComponentType.BUN, 80.0),
                new HotDogComponent("Говяжья сосиска", ComponentType.SAUSAGE, 170.0),
                new HotDogComponent("Сырный соус", ComponentType.SAUCE, 40.0),
                new HotDogComponent("Хрустящий лук", ComponentType.TOPPING, 40.0),
                new HotDogComponent("Хрустящий бекон", ComponentType.TOPPING, 60.0)
        ));
    }
}