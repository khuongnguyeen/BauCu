package com.company.client;

import com.company.server.IBanKiemPhieu;

import java.rmi.Naming;
import java.util.Scanner;

public class CuTri {
    public static void main(String[] args) {
        try {
            IBanKiemPhieu obj=(IBanKiemPhieu) Naming.lookup("rmi://localhost:2022/Adtrue");
            System.out.println("nhap vao chuoi ki tu:");
            String S=new Scanner(System.in).nextLine();
            System.out.println("so ki tu cua chuoi la:_____");
        } catch (Exception e) {
        }
    }
}
