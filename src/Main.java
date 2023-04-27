import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;
        List<String> items = new ArrayList<>();
        System.out.println();
        System.out.println("   Составляем список покупок");

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию: 1 - добавить, 2 - показать, " +
                    "3 - удалить, 4 - найти, end - завершить программу");
            String input = scanner.nextLine();

            //Завершение работы программы при вводе end
            if (input.equals("end")) {
                break;
            }

            //Обработка ошибки при неверном вводе
            try {
                operation = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА ВВОДА. ПОВТОРИТЕ ЕЩЕ РАЗ!");
                continue;
            }

            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    items.add(scanner.nextLine());
                    System.out.println("Итого в списке покупок: " + items.size());
                    break;
                case 2:
                    printList(items);
                    break;
                case 3:
                    printList(items);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String inputDel = scanner.nextLine();
                    try {
                        int productNumber = Integer.parseInt(inputDel) - 1;
                        System.out.println("Покупка \"" + items.get(productNumber) + "\" удалена");
                        items.remove(productNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Покупка \"" + inputDel + "\" удалена");
                        items.remove(inputDel);
                    }
                    printList(items);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String inputSearch = scanner.nextLine();
                    String queryLower = inputSearch.toLowerCase();
                    String itemLower;
                    boolean finder = false;
                    System.out.println("Найдено:");
                    for (int i = 0; i < items.size(); i++) {
                        itemLower = items.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            finder = true;
                            System.out.println((i + 1) + ". " + items.get(i));
                        }
                    }
                    //Вывод сообщения при отрицательном результате поиска
                    if (!finder) {
                        System.out.println("поиск результатов не дал");
                    }
                    break;
                //Обработка ввода не существующих пунктов меню в switch/case
                default:
                    System.out.println("ОШИБКА ВВОДА, ПОВТОРИТЕ ЕЩЕ РАЗ!");
            }
        }
    }

    public static void printList(List items) {
        System.out.println("    Список покупок:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }
}