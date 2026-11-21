package com.hotdog.model;

import java.util.List;

/**
 * Хот-дог вида HunterDog с охотничьей колбаской, горчицей и маринованными огурцами.
 */
public class HunterDog extends HotDog {

    /**
     * Создаёт стандартный хот-дог HunterDog со всеми входящими в рецепт компонентами.
     */
    public HunterDog() {
        super("HunterDog", List.of(
                new HotDogComponent("Ржано-пшеничная булочка", ComponentType.BUN, 60.0),
                new HotDogComponent("Охотничья колбаска", ComponentType.SAUSAGE, 150.0),
                new HotDogComponent("Зернистая горчица", ComponentType.SAUCE, 30.0),
                new HotDogComponent("Маринованный огурец", ComponentType.TOPPING, 40.0)
        ));
    }
}