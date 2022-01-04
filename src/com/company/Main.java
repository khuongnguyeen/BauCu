package com.company;


import com.company.model.CuTri;
import com.company.model.MaHoa;
import com.company.model.PhieuBau;

import java.util.*;

public class Main {
    public static int p = 7919; //mod
    public static int g = findPrimitive(p); //phan tu sinh
    public static int a = 3; // khoa bi mat
    public static int ok = 0;
    public static double h1 = 1; // khoa cong khai
    public static double h2 = 1; // khoa cong khai
    public static double h3 = 1; // khoa cong khai
    public static double h4 = 1; // khoa cong khai

    static ArrayList<PhieuBau> dsPhieuBau = new ArrayList<PhieuBau>();
    static ArrayList<Integer> dsNguyenTo = new ArrayList<Integer>();
    static ArrayList<CuTri> dsKhoaRieng = new ArrayList<CuTri>();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int select = 0;
        do {
            System.out.println("Menu");
            System.out.println("Bạn là ai ?");
            System.out.println("1: Cử tri");
            System.out.println("2: Ban kiểm phiếu");
            System.out.println("3: Nhập số lượng cử tri");
            System.out.println("4: Sinh khóa");
            System.out.println("5: Thoát chương trình");
            System.out.println("Mời bạn chọn:");
            try {
                select = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                select = 10;
            }
            switch (select) {
                case 1 -> cuTri();
                case 2 -> kiemPhieu();
                case 3 -> {
                    System.out.println("Nhập :");
                    ok = new Scanner(System.in).nextInt();
                }
                case 4 -> {
                    for (int i = 0; i<ok;i++){
                        int k1 = randomNumber();
                        int k2 = randomNumber();
                        int k3 = randomNumber();
                        int k4 = randomNumber();
                        CuTri ct = new CuTri(i,k1,k2,k3,k4);
                        dsKhoaRieng.add(ct);
                        double ka1 = power(g, k1, p);
                        double ka2 = power(g, k2, p);
                        double ka3 = power(g, k3, p);
                        double ka4 = power(g, k4, p);
                        h1 = (h1 * ka1) % p;
                        h2 = (h2 * ka2) % p;
                        h3 = (h3 * ka3) % p;
                        h4 = (h4 * ka4) % p;
                    }
                    System.out.println("____________h1 = "+h1);
                    System.out.println("____________h2 = "+h2);
                    System.out.println("____________h3 = "+h3);
                    System.out.println("____________h4 = "+h4);
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Mời bạn nhập lại");
            }

        } while (true);
    }


    // Hàm tìm căn nguyên nhỏ nhất của n
    // phần tử sinh
    static int findPrimitive(int n) {
        HashSet<Integer> s = new HashSet<Integer>();
        if (!isPrime(n)) {
            return -1;
        }
        int phi = n - 1;
        findPrimefactors(s, phi);
        for (int r = 2; r <= phi; r++) {
            boolean flag = false;
            for (Integer a : s) {
                if (power(r, phi / (a), n) == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return r;
            }
        }
        return -1;
    }


    // Trả về true nếu n là số nguyên tố
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Chức năng tiện ích để lưu trữ các thừa số nguyên tố của một số
    static void findPrimefactors(HashSet<Integer> s, int n) {
        // In ra số có 2 phép chia n
        while (n % 2 == 0) {
            s.add(2);
            n = n / 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                s.add(i);
                n = n / i;
            }
        }
        if (n > 2) {
            s.add(n);
        }
    }

    // Ban Kiểm Phiếu
    private static void kiemPhieu() {
        double x1 = 1, y1 = 1, x2 = 1, x3 = 1, x4 = 1, y2 = 1, y3 = 1, y4 = 1,b1=1,b2=1,b3=1,b4=1;
        for (PhieuBau phieuBau : dsPhieuBau) {
            x1 = (x1 * phieuBau.getM1().getX()) % p;
            y1 = (y1 * phieuBau.getM1().getY()) % p;
            x2 = (x2 * phieuBau.getM2().getX()) % p;
            y2 = (y2 * phieuBau.getM2().getY()) % p;
            x3 = (x3 * phieuBau.getM3().getX()) % p;
            y3 = (y3 * phieuBau.getM3().getY()) % p;
            x4 = (x4 * phieuBau.getM4().getX()) % p;
            y4 = (y4 * phieuBau.getM4().getY()) % p;

            System.out.println("*** : x1 = "+x1);
            System.out.println("*** : x2 = "+x2);
            System.out.println("*** : x3 = "+x3);
            System.out.println("*** : x4 = "+x4);

            System.out.println("*** : y1 = "+y1);
            System.out.println("*** : y2 = "+y2);
            System.out.println("*** : y3 = "+y3);
            System.out.println("*** : y4 = "+y4);

        }
        double m12 = modInverse(y1, p); //nghich dao Y
        double m1 = (x1 * m12) % p; // m: ban ro

        System.out.println("*** : m12 = "+m12);
        System.out.println("*** : m1 = "+m1);

        double m22 = modInverse(y2, p);
        double m2 = (x2 * m22) % p;

        System.out.println("*** : m22 = "+m22);
        System.out.println("*** : m2 = "+m2);

        double m32 = modInverse(y3, p);
        double m3 = (x3 * m32) % p;

        System.out.println("*** : m32 = "+m32);
        System.out.println("*** : m3 = "+m3);

        double m42 = modInverse(y4, p);
        double m4 = (x4 * m42) % p;

        System.out.println("*** : m42 = "+m42);
        System.out.println("*** : m4 = "+m4);

        ketQua((int) m1, "m1");
        ketQua((int) m2, "m2");
        ketQua((int) m3, "m3");
        ketQua((int) m4, "m4");

        //m= g^v = Y/X^a
    }

    private static void ketQua(int m, String s) {
        List<Integer> listNumbers = phanTichSoNguyen(m);
        // in kết quả ra màn hình
        System.out.printf("Kết quả " + s + ": %d = ", m);
        int size = listNumbers.size();
        int k = 0;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(listNumbers.get(i) + " x ");
            k++;
        }
        System.out.print(listNumbers.get(size - 1));
        System.out.println("=> v = " + (k + 1));
    }

    //nghịch đảo module
    static int modInverse(double a, int p) {
        for (int x = 1; x < p; x++) {
            if (((a % p) * (x % p)) % p == 1) {
                return x;
            }
        }
        return 0;
    }

    // tính module
    static double module(double x, double n, double p) {
        return Math.pow(x, n) % p;
    }

    //Phân tích số nguyên thành tích các thừa số nguyên tố
    public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        // phân tích
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        // nếu listNumbers trống thì add n vào listNumbers
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }

    //  Cử tri
    private static void cuTri() {
        int select2 = 0;
        for (int i = 0; i<ok;i++){
            System.out.println("____________________________________________________");
            System.out.println("Chào mừng bạn đến với cổng bỏ phiếu điện tử của công ty Adtrue");
            System.out.println("Danh Sách ứng viên gồm:");
            System.out.println("1. Vũ Minh Phương");
            System.out.println("2. Nguyễn Phan Thùy Linh");
            System.out.println("3. Lê Trung Kiên");
            System.out.println("4. Nguyễn Phương Anh");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn phiếu bầu của mình:");
            try {
                select2 = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                select2 = 10;
            }
            switch (select2) {
                case 1 -> bauChon(i,1, 0, 0, 0);
                case 2 -> bauChon(i,0, 1, 0, 0);
                case 3 -> bauChon(i,0, 0, 1, 0);
                case 4 -> bauChon(i,0, 0, 0, 1);
                case 0 -> System.out.println("___Exit___");
                default -> System.out.println("Ứng viên không tồn tại, vui lòng chọn lại");
            }
        }

    }

    public static int randomNumber() {
        Random rd = new Random();
        int x = rd.nextInt(10);
        return x + 1;
    }


    public static int randomSK() {
        Random rd = new Random();
        int x = rd.nextInt(3);
        return x + 1;
    }

    private static void bauChon(int i,int a, int b, int c, int d) {
        CuTri ct = dsKhoaRieng.get(i);
        PhieuBau mA = new PhieuBau(messageChild(ct.getA1(), ct.getA2(), a,h1,h2), messageChild(ct.getA1(), ct.getA3(),b,h1,h3)
                , messageChild(ct.getA2(), ct.getA3(),c,h2,h3), messageChild(ct.getA1(), ct.getA4(),d,h1,h4));
        dsPhieuBau.add(mA);
    }

    static double power(int x, int y, int p) {
        return Math.pow(x, y) % p;
    }

    // tính module đa thức
    static double power3(double x, int n, int y, int m, int p) {
        double num = Math.pow(x, n);
        double num2 = Math.pow(y, m);
        double num3 = num * num2;
        return num3 % p;
    }

    private static MaHoa messageChild(int xi,int yi,int v,double x,double y) {
        int k = randomNumber();
        MaHoa m = new MaHoa(power3(x, yi, g, v, p),power((int) y, xi, p));
        System.out.println("*** : v = "+v+" x = "+x+" xi = "+xi+" yi = "+yi+" y = "+y+" mi = "+power3(x, yi, g, v, p)+" hi = "+power((int) y, xi, p));
        return m;
    }

        static boolean checkNguyenTo(int n){
            if(n<=2){
                return true;
            }else {
                for(int i =2;i<=Math.sqrt(n);i++){
                    if(n % i == 0)
                        return false;
                }
            }
            return true;
        }
        static void inputNguyenTo(int n){
        dsNguyenTo.clear();
            for(int i = 1 ;i<n;i++){
                if(checkNguyenTo(i)){
                    dsNguyenTo.add(i);
                }
            }
        }


}
