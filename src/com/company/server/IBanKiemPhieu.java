package com.company.server;

import com.company.model.MaHoa;
import com.company.model.PhieuBau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface IBanKiemPhieu extends Remote {
    public void congKhoa(int x,int y) throws RemoteException;
    boolean checkNguyenTo(int n) throws RemoteException;
    MaHoa messageChild(int g,int a, int p, int v) throws RemoteException;
    double power3(double x, int n, int y, int m, int p) throws RemoteException;
    double power(int x, int y, int p) throws RemoteException;
    void bauChon(ArrayList<PhieuBau> dsPhieuBau,int a1, int b1, int c1, int d1,int g,int a, int p) throws RemoteException;
    int randomSK() throws RemoteException;
    int randomNumber() throws RemoteException;
    //Phân tích số nguyên thành tích các thừa số nguyên tố
    List<Integer> phanTichSoNguyen(int n) throws RemoteException;
    // tính module
    double module(double x, double n, double p) throws RemoteException;
    //nghịch đảo module
    int modInverse(double a, int p) throws RemoteException;
    void ketQua(int m, String s) throws RemoteException;
    void kiemPhieu(ArrayList<PhieuBau> dsPhieuBau, int p) throws RemoteException;
    // Chức năng tiện ích để lưu trữ các thừa số nguyên tố của một số
    void findPrimefactors(HashSet<Integer> s, int n) throws RemoteException;
    // Trả về true nếu n là số nguyên tố
    boolean isPrime(int n) throws RemoteException;
    // Hàm tìm căn nguyên nhỏ nhất của n
    // phần tử sinh
    int findPrimitive(int n) throws RemoteException;

}
