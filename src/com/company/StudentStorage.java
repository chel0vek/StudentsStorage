package com.company;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;

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
    public Student[] findStudentByAge(int age) {
        Student[] foundStudents = new Student[size];
        int foundIndex = 0;
        for (int i = 0; i < array.length; i++) {
            Student current = array[i];
            if (current != null && current.getAge() == age) {
                foundStudents[foundIndex] = current;
                foundIndex++;
            }
        }
        return foundStudents;
    }
    public Student[] findStudentByAvg(double avg) {
        Student[] foundStudents = new Student[size];
        int foundIndex = 0;
        for (int i = 0; i < array.length; i++) {
            Student current = array[i];
            if (current !=null && current.getAvgGrade() == avg) {
                foundStudents[foundIndex] = current;
                foundIndex++;
            }
        }
        return foundStudents;
    }
    public Student[] showTop10StudentsByAvg() {
        Student[] foundStudents = new Student[10];
        for (int i = 0; i < foundStudents.length - 1; i++) {
            foundStudents[i] = array[i];
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < foundStudents.length - 1; i++) {
                Student first = foundStudents[i];
                Student second = foundStudents[i + 1];
                if (first != null && second != null && first.getAvgGrade() < second.getAvgGrade()) {
                    Student bubble = foundStudents[i];
                    foundStudents[i] = foundStudents[i + 1];
                    foundStudents[i + 1] = bubble;
                    isSorted = false;
                }
            }
        }
        return foundStudents;
    }

    public Student[] showTop10StudentsByAge() {
        Student[] foundStudents = new Student[10];
        for (int i = 0; i < foundStudents.length - 1; i++) {
            foundStudents[i] = array[i];
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < foundStudents.length - 1; i++) {
                Student first = foundStudents[i];
                Student second = foundStudents[i + 1];
                if (first != null && second != null && first.getAge() < second.getAge()) {
                    Student bubble = foundStudents[i];
                    foundStudents[i] = foundStudents[i + 1];
                    foundStudents[i + 1] = bubble;
                    isSorted = false;
                }
            }
        }
        return foundStudents;
    }
}
