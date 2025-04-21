package org.example;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Создать пользователя");
            System.out.println("2. Получить пользователя по ID");
            System.out.println("3. Получить всех пользователей");
            System.out.println("4. Обновить пользователя");
            System.out.println("5. Удалить пользователя");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser(scanner, userDao);
                    break;
                case 2:
                    getUserById(scanner, userDao);
                    break;
                case 3:
                    getAllUsers(userDao);
                    break;
                case 4:
                    updateUser(scanner, userDao);
                    break;
                case 5:
                    deleteUser(scanner, userDao);
                    break;
                case 6:
                    HibernateUtil.shutdown();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void createUser(Scanner scanner, UserDao userDao) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        user.setCreatedAt(LocalDateTime.now());
        userDao.save(user);
        System.out.println("Пользователь создан.");
    }

    private static void getUserById(Scanner scanner, UserDao userDao) {
        System.out.print("Введите ID пользователя: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        User user = userDao.findById(id);
        if (user != null) {
            System.out.println("Пользователь: " + user.getName() + ", Email: " + user.getEmail());
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    private static void getAllUsers(UserDao userDao) {
        List<User> users = userDao.findAll();
        if (users != null && !users.isEmpty()) {
            users.forEach(u -> System.out.println(u.getId() + ": " + u.getName() + ", " + u.getEmail()));
        } else {
            System.out.println("Пользователи не найдены.");
        }
    }

    private static void updateUser(Scanner scanner, UserDao userDao) {
        System.out.print("Введите ID пользователя: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        User user = userDao.findById(id);
        if (user != null) {
            System.out.print("Введите новое имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите новый email: ");
            String email = scanner.nextLine();
            System.out.print("Введите новый возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            user.setName(name);
            user.setEmail(email);
            user.setAge(age);
            userDao.update(user);
            System.out.println("Пользователь обновлен.");
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    private static void deleteUser(Scanner scanner, UserDao userDao) {
        System.out.print("Введите ID пользователя: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        User user = userDao.findById(id);
        userDao.delete(user);
        System.out.println("Пользователь удален.");
    }
}