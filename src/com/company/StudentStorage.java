package com.company;

public class StudentStorage {
    static int size = 15;
    static Student[] array = new Student[size];
    int index = 0;

    public boolean addStudent(Student student) {
        array[index] = student;
        index++;
        return true;
    }

    public void deleteBook(int id) {
        array[id] = null;
        for (int i = id; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        index--;
    }

    public void showAllStudents() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public Student[] findStudentByName(String name) {
        Student[] foundStudents = new Student[size];
        int foundIndex = 0;
        for (int i = 0; i < array.length; i++) {
            Student current = array[i];
            if (current != null && current.getName().equals(name)) {
                foundStudents[foundIndex] = current;
                foundIndex++;
            }
        }
        return foundStudents;
    }

    public Student[] findStudentByGroup(int group) {
        Student[] foundStudents = new Student[size];
        int foundIndex = 0;
        for (int i = 0; i < array.length; i++) {
            Student current = array[i];
            if (current != null && current.getGroup() == group) {
                foundStudents[foundIndex] = current;
                foundIndex++;
            }
        }
        return foundStudents;
    }

    public Student[] showTop10StudentsByAvg() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                Student first = array[i];
                Student second = array[i + 1];
                if (first != null && second != null && first.getAvgGrade() < second.getAvgGrade()) {
                    Student bubble = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = bubble;
                    isSorted = false;
                }
            }
        }
        Student[] foundStudents = new Student[10];
        for (int i = 0; i < foundStudents.length - 1; i++) {
            foundStudents[i] = array[i];
        }
        return foundStudents;
    }
    public Student[] showTop10StudentsByAge() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0 ; i < array.length - 1; i++) {
                Student first = array[i];
                Student second = array[i + 1];
                if (first != null && second != null && first.getAge() < second.getAge()) {
                    Student bubble = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = bubble;
                    isSorted = false;
                }
            }
        }
        Student[] foundStudents = new Student[10];
        for (int i = 0; i < foundStudents.length - 1; i++) {
            foundStudents[i] = array[i];
        }
        return foundStudents;
    }
}
