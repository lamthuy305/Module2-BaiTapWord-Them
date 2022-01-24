package com.codegym;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    public int size() {
        return this.students.size();
    }

    public void displayAllStudent() {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public void addNewStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int index, Student student) {
        students.set(index, student);
    }

    public void removeStudent(int index) {
        students.remove(index);
    }

    public int timKiemTuyenTinh(int maSV) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (this.students.get(i).getMaSV() == maSV) {
                index = i;
            }
        }
        return index;
    }

//    public int timKiemNhiPhan(int maSV) {
//        int index = -1;
//
//        return index;
//    }


    public void displayStudent(int index) {
        System.out.println(students.get(index));
    }
}
