import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречннивая крупа", "Булочка", "Кефир", "Сыр"};
        int[] prices = {50, 14, 80, 40, 125, 190};
        int[] shoping = new int[products.length];
        int[] countProducts = new int[products.length];
        int productNumber = 0;
        int productCount = 0;
        int sumProduct = 0;

        while (true) {

            showMenu();
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);

            if (productNumber >= 0 && productNumber < products.length) {
                if (productCount > 0) {
                    shoping[productNumber] += productCount * prices[productNumber];
                    countProducts[productNumber] += productCount;
                } else {
                    System.out.println("Ошибка: товара с номером " + (productNumber + 1) + " нет");
                }

            }
        }

        for (int num : shoping) {
            sumProduct += num;
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < shoping.length; i++) {
            if (shoping[i] != 0) {
                System.out.printf("%s %d шт %d руб/шт %d руб в сумме\n"
                        , products[i], countProducts[i], prices[i], shoping[i]);
            }
        }
        System.out.printf("Итого %d руб", sumProduct);

    }

    public static void showMenu() {
        System.out.println("Список возможных товаров для покупки\n" +
                "1. Молоко 50 руб/шт\n" +
                "2. Хлеб 14 руб/шт\n" +
                "3. Гречневая крупа 80 руб/шт\n" +
                "4. Булочка 40 руб/шт\n" +
                "5. Кефир 125 руб/шт\n" +
                "6. Сыр 190 руб/шт\n" +
                "Выберите товар и количество или введите `end`");
    }
}