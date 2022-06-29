package com.company;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static Student student;
    static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Выберите действие.");
            System.out.println("""
                    1. Добавить студента
                    2. Удалить студента
                    3. Показать список всех студентов
                    4. Поиск студента по составляющим
                    5. Поиск студентов по успеваемости
                    """);
            int choice = input.nextInt();
            if (choice == 1) {
                addStudentM();
            }
            if (choice == 2) {
                removeStudentM();
            }
            if (choice == 3) {
                showAllStudentsM();
            }
            if (choice == 4) {
                sortSearchByСonstituents();
            }
            if (choice == 5) {
                sortSearchByPerfomance();
            }
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        } finally {
            menu();
        }
    }

    public static void sortSearchByPerfomance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите действие");
        System.out.println("""
                1. Показать топ 10 учеников по показателю среднего балла
                2. Показать топ 10 учеников по возрасту
                3. Вернуться назад
                """);
        int choice = input.nextInt();
        if (choice == 1) {
            showTop10StudentsByAvgM();
        }
        if (choice == 2) {
            showTop10StudentsByAgeM();
        }
        if (choice == 3) {
            menu();
        }
        else {
            sortSearchByPerfomance();
        }
    }
    public static void showTop10StudentsByAgeM() {
        System.out.println("Топ 10 учеников по возрасту");
        var students = studentStorage.showTop10StudentsByAge();
        for (Student list : students) {
            System.out.println(list);
        }
    }
    public static void showTop10StudentsByAvgM() {
        System.out.println("Топ 10 учеников по показателю среднего балла");
        var students = studentStorage.showTop10StudentsByAvg();
        for (Student list : students) {
            System.out.println(list);
        }
    }
    public static void sortSearchByСonstituents() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите действие");
        System.out.println("""
                1. Поиск по имени студента
                2. Поиск по группе студента
                3. Вернуться назад
                """);
        int choice = input.nextInt();
        if (choice == 1) {
            findStudentByNameM();
        }
        if (choice == 2) {
            findStudentByGroupM();
        }
        if (choice == 3) {
            menu();
        } else {
            sortSearchByСonstituents();
        }
    }

    public static void addStudentM() {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);;
        System.out.println("Введите имя студента");
        String name = input.nextLine();
        System.out.println("Введите возраст студента");
        int age = input.nextInt();
        System.out.println("Введите номер группы студента");
        int group = input.nextInt();
        System.out.println("Введите средний балл студента");
        double avgGrade = input.nextDouble();
        Student student = new Student(name, age, group, avgGrade);
        var check = studentStorage.addStudent(student);
        if (check) {
            System.out.println("Студент успешно добавлен");
        } else {
            System.out.println("Произошла ошибка при добавлении студента");
        }
    }

    public static void removeStudentM() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер студента");
        int id = input.nextInt();
        studentStorage.deleteBook(id);
    }

    public static void showAllStudentsM() {
        studentStorage.showAllStudents();
    }

    public static void findStudentByNameM() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = input.nextLine();
        var students = studentStorage.findStudentByName(name);
        for (Student list : students) {
            System.out.println(list);
        }
    }

    public static void findStudentByGroupM() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер группы студента");
        int group = input.nextInt();
        var students = studentStorage.findStudentByGroup(group);
        for (Student list : students) {
            System.out.println(list);
        }
    }
}
