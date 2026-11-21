package com.hotdog;

import com.hotdog.model.Berlinka;
import com.hotdog.model.ComponentType;
import com.hotdog.model.HotDogComponent;
import com.hotdog.model.HunterDog;
import com.hotdog.model.MasterDog;
import com.hotdog.order.Order;
import com.hotdog.order.OrderManager;

import java.util.Scanner;

/**
 * Консольное приложение для демонстрации работы библиотеки учёта продаж хот-догов.
 */
public class App {

    private App() {
    }

    /**
     * Точка входа в консольное приложение.
     * Выполняет демонстрационную продажу всех видов хот-догов и отдельных компонентов,
     * выводит статистику по заказам и запускает интерактивное меню.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        seedDemoOrders(manager);

        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ СИСТЕМЫ УЧЁТА ХОТ-ДОГОВ ===");
        printAllOrders(manager);
        printStatistics(manager);

        runInteractiveMenu(manager);
    }

    private static void seedDemoOrders(OrderManager manager) {
        // Заказ 1: продажа HunterDog (полный заказ)
        Order order1 = new Order(1);
        order1.addItem(new HunterDog());
        manager.addOrder(order1);

        // Заказ 2: продажа MasterDog и Berlinka вместе (полный заказ)
        Order order2 = new Order(2);
        order2.addItem(new MasterDog());
        order2.addItem(new Berlinka());
        manager.addOrder(order2);

        // Заказ 3: продажа отдельных компонентов без целого хот-дога (неполный заказ)
        Order order3 = new Order(3);
        order3.addItem(new HotDogComponent("Охотничья колбаска", ComponentType.SAUSAGE, 150.0));
        order3.addItem(new HotDogComponent("Сырный соус", ComponentType.SAUCE, 40.0));
        manager.addOrder(order3);

        // Заказ 4: продажа Berlinka + дополнительный компонент отдельно (полный заказ)
        Order order4 = new Order(4);
        order4.addItem(new Berlinka());
        order4.addItem(new HotDogComponent("Булочка бриошь", ComponentType.BUN, 80.0));
        manager.addOrder(order4);
    }

    private static void printAllOrders(OrderManager manager) {
        System.out.println("\n--- Список оформленных заказов ---");
        for (Order order : manager.getOrders()) {
            System.out.print(order);
        }
    }

    private static void printStatistics(OrderManager manager) {
        System.out.println("\n--- Итоговая статистика ---");
        System.out.printf("Всего заказов: %d%n", manager.getOrders().size());
        System.out.printf("Количество полных заказов: %d%n", manager.getFullOrdersCount());
        System.out.printf("Общая сумма всех заказов: %.2f руб.%n", manager.getTotalRevenue());
        System.out.printf("Средняя стоимость заказа: %.2f руб.%n", manager.getAverageOrderPrice());
    }

    private static void runInteractiveMenu(OrderManager manager) {
        try (Scanner scanner = new Scanner(System.in)) {
            int nextOrderId = manager.getOrders().size() + 1;

            while (true) {
                System.out.println("\n=== МЕНЮ ===");
                System.out.println("1. Создать новый заказ");
                System.out.println("2. Показать все заказы");
                System.out.println("3. Показать статистику");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        Order customOrder = buildCustomOrder(scanner, nextOrderId);
                        if (!customOrder.getItems().isEmpty()) {
                            manager.addOrder(customOrder);
                            nextOrderId++;
                            System.out.println("Заказ добавлен:\n" + customOrder);
                        } else {
                            System.out.println("Пустой заказ отменён.");
                        }
                        break;
                    case "2":
                        printAllOrders(manager);
                        break;
                    case "3":
                        printStatistics(manager);
                        break;
                    case "0":
                        System.out.println("Работа завершена.");
                        return;
                    default:
                        System.out.println("Неизвестный пункт, введите цифру от 0 до 3.");
                }
            }
        }
    }

    private static Order buildCustomOrder(Scanner scanner, int orderId) {
        Order order = new Order(orderId);
        while (true) {
            System.out.println("\nДобавить в заказ #" + orderId + ":");
            System.out.println("1. HunterDog (280.00 руб.)");
            System.out.println("2. MasterDog (390.00 руб.)");
            System.out.println("3. Berlinka (320.00 руб.)");
            System.out.println("4. Отдельно: Булочка бриошь (80.00 руб.)");
            System.out.println("5. Отдельно: Охотничья колбаска (150.00 руб.)");
            System.out.println("6. Отдельно: Сырный соус (40.00 руб.)");
            System.out.println("7. Отдельно: Хрустящий бекон (60.00 руб.)");
            System.out.println("0. Завершить оформление заказа");
            System.out.print("Позиция: ");

            String itemChoice = scanner.nextLine().trim();
            switch (itemChoice) {
                case "1":
                    order.addItem(new HunterDog());
                    System.out.println("Добавлен HunterDog.");
                    break;
                case "2":
                    order.addItem(new MasterDog());
                    System.out.println("Добавлен MasterDog.");
                    break;
                case "3":
                    order.addItem(new Berlinka());
                    System.out.println("Добавлен Master/Berlinka -> Berlinka.");
                    break;
                case "4":
                    order.addItem(new HotDogComponent("Булочка бриошь", ComponentType.BUN, 80.0));
                    System.out.println("Добавлена булочка.");
                    break;
                case "5":
                    order.addItem(new HotDogComponent("Охотничья колбаска", ComponentType.SAUSAGE, 150.0));
                    System.out.println("Добавлена колбаска.");
                    break;
                case "6":
                    order.addItem(new HotDogComponent("Сырный соус", ComponentType.SAUCE, 40.0));
                    System.out.println("Добавлен соус.");
                    break;
                case "7":
                    order.addItem(new HotDogComponent("Хрустящий бекон", ComponentType.TOPPING, 60.0));
                    System.out.println("Добавлен бекон.");
                    break;
                case "0":
                    return order;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}