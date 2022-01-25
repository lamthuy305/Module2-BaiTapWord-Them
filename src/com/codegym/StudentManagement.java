package com.codegym;

import java.io.*;
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


    public void bubbleSort() {
        boolean needNextPass = true;
        for (int i = 1; i < size() && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < size() - i; j++) {
                if (students.get(j).getDiem() > students.get(j + 1).getDiem()) {
                    Student temp = students.get(j);
                    updateStudent(j, students.get(j + 1));
                    updateStudent(j + 1, temp);
                    needNextPass = true;
                }
            }
        }
    }

    public void selectionSort() {
        int min;
        for (int i = 0; i < size() - 1; i++) {
            min = i;

            for (int j = i + 1; j < size(); j++) {
                if (students.get(j).getDiem() < students.get(min).getDiem()) {
                    min = j;
                }
            }
            if (min != i) {
                Student temp = students.get(min);
                updateStudent(min, students.get(i));
                updateStudent(i, temp);
            }
        }
    }


    public void insertionSort() {
        int pos;
        for (int i = 1; i < size(); i++) {
            pos = i;
            Student temp = students.get(pos);

            while (pos > 0 && temp.getDiem() < students.get(pos - 1).getDiem()) {
                updateStudent(pos, students.get(pos - 1));
                pos--;
            }
            updateStudent(pos, temp);
        }
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


    public int timKiemNhiPhan(int maSV) {
        bubbleSortMaSV();
        int low = 0;
        int high = size() - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (maSV < students.get(mid).getMaSV())
                high = mid - 1;
            else if (maSV == students.get(mid).getMaSV())
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

    public void bubbleSortMaSV() {
        boolean needNextPass = true;
        for (int i = 1; i < size() && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < size() - i; j++) {
                if (students.get(j).getMaSV() > students.get(j + 1).getMaSV()) {
                    Student temp = students.get(j);
                    updateStudent(j, students.get(j + 1));
                    updateStudent(j + 1, temp);
                    needNextPass = true;
                }
            }
        }
    }

    public void displayStudent(int index) {
        System.out.println(students.get(index));
    }

    public int checkMaSV(int maSV) {  //Check xem mã SV đã xuất hiện chưa
        for (int i = 0; i < size(); i++) {
            if (students.get(i).getMaSV() == maSV) {
                return i;
            }
        }
        return -1;
    }

    public void writeToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : students) {
            bufferedWriter.write(student.toString() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            String name = lines[0].trim();
            int maSV = Integer.parseInt(lines[1].trim());
            String adress = lines[2].trim();
            String lop = lines[3].trim();
            double diem = Double.parseDouble(lines[4].trim());
            Student student = new Student(name,maSV,adress,lop,diem);
            this.addNewStudent(student);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
