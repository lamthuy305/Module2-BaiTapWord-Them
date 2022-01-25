package com.codegym;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        int choice1 = -1;
        try {
            studentManagement.readFile("bill.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            menu();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1: {
                    System.out.println("---Danh sách sinh viên---");
                    studentManagement.displayAllStudent();
                    break;
                }
                case 2: {
                    System.out.println("---Thêm sinh viên---");
                    Student student = inputStudent();
                    studentManagement.addNewStudent(student);
                    break;
                }
                case 3: {
                    System.out.println("---Sửa thông tin sinh viên---");
                    System.out.println("Nhập vị trí cần sửa: ");
                    int index = scanner.nextInt();
                    Student student = inputStudent();
                    studentManagement.updateStudent(index, student);
                    break;
                }
                case 4: {
                    System.out.println("---Xóa---");
                    System.out.println("Nhập vị trí cần xóa: ");
                    int index = scanner.nextInt();
                    studentManagement.removeStudent(index);
                    break;
                }
                case 5: {
                    int choice2 = -1;
                    do {
                        System.out.println("---Menu sắp xếp điểm---");
                        menuCase5();
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1: {
                                System.out.println("Sắp xếp nổi bọt");
                                studentManagement.bubbleSort();
                                studentManagement.displayAllStudent();
                                break;
                            }
                            case 2: {
                                System.out.println("Sắp xếp chọn");
                                studentManagement.selectionSort();
                                studentManagement.displayAllStudent();
                                break;
                            }
                            case 3: {
                                System.out.println("Sắp xếp chèn");
                                studentManagement.insertionSort();
                                studentManagement.displayAllStudent();
                                break;
                            }
                            case 0: {
                                System.out.println("Quay lại");
                                break;
                            }
                            default: {
                                System.out.println("Nhập lại");
                            }
                        }
                    } while (choice2 != 0);
                }

                case 6: {
                    int choice3 = -1;
                    do {
                        System.out.println("Tìm kiếm theo mã sinh viên");
                        System.out.println("1. Tìm kiếm tuyến tính");
                        System.out.println("2. Tìm kiếm nhị phân");
                        System.out.println("0. Quay lại");
                        System.out.println("Nhập lựa chọn: ");
                        choice3 = scanner.nextInt();
                        switch (choice3) {
                            case 1: {
                                scanner.nextLine();
                                System.out.println("Tìm kiếm tuyến tính");
                                System.out.println("Nhập mã sinh viên: ");
                                int maSv = scanner.nextInt();
                                int index = studentManagement.timKiemTuyenTinh(maSv);
                                if (index == -1) {
                                    System.out.println("Mã sinh viên không có trong danh sách");
                                } else {
                                    studentManagement.displayStudent(index);
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Tìm kiếm nhị phân");
                                System.out.println("Nhập mã sinh viên: ");
                                int maSV = scanner.nextInt();
                                int index = studentManagement.timKiemNhiPhan(maSV);
                                if (index == -1) {
                                    System.out.println("Mã sinh viên không có trong danh sách");
                                } else {
                                    studentManagement.displayStudent(index);
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("Quay lại");
                                break;
                            }
                            default: {
                                System.out.println("Nhập lại");
                            }
                        }
                    } while (choice3 != 0);
                }
                case 0: {
                    System.out.println("Thoát");
                    break;
                }
                default: {
                    System.out.println("Nhập lại");
                }
            }
            try {
                studentManagement.writeToFile("bill.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice1 != 0);

    }


    private static void menuCase5() {
        System.out.println("1. Sắp xếp nổi bọt");
        System.out.println("2. Sắp xếp chọn");
        System.out.println("3. Sắp xếp chèn");
        System.out.println("0. Quay lại");
    }

    private static Student inputStudent() {
        scanner.nextLine();
        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mã sinh viên: ");
        int maSV = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập quê quán: ");
        String adress = scanner.nextLine();
        System.out.println("Nhập lớp: ");
        String lop = scanner.nextLine();
        System.out.println("Nhập điểm: ");
        int diem = scanner.nextInt();
        return new Student(name, maSV, adress, lop, diem);
    }

    private static void menu() {
        System.out.println("---Menu quản lý sinh viên---");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Sửa thông tin sinh viên");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp theo điểm");
        System.out.println("6. Tìm kiếm");
        System.out.println("0. Thoát chương trình");
    }
}
