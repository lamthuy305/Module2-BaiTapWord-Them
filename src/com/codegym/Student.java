package com.codegym;

public class Student {
    private String name;
    private int maSV;
    private String adress;
    private String lop;
    private double diem;

    public Student() {
    }

    public Student(String name, int maSV, String adress, String lop, double diem) {
        this.name = name;
        this.maSV = maSV;
        this.adress = adress;
        this.lop = lop;
        this.diem = diem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Student " + this.name + ", mã sinh viên " + this.maSV + ", quê quán " + this.adress + ", lớp " + this.lop + ", điểm " + this.diem;
    }
}
