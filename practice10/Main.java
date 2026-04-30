import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Реєстрація | 2. Вхід | 3. Список | 4. Видалити | 0. Вихід");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Логін: "); String l = scanner.nextLine();
                System.out.print("Пароль: "); String p = scanner.nextLine();
                registry.registerUser(l, p);
            } else if (choice == 2) {
                System.out.print("Логін: "); String l = scanner.nextLine();
                System.out.print("Пароль: "); String p = scanner.nextLine();
                registry.loginUser(l, p);
            } else if (choice == 3) {
                registry.displayAllUsers();
            } else if (choice == 0) break;
                else if (choice == 4) {
                    System.out.print("Введіть логін для видалення: "); 
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();
                    registry.removeUser(idToDelete);
                } else {
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
        }
    }
}