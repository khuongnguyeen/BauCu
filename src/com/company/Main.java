package com.company;


import com.company.model.MaHoa;
import com.company.model.PhieuBau;

import java.util.*;

public class Main {
    public static int p = 7919; //mod
    public static int g = findPrimitive(p); //phan tu sinh
    public static int a = 3; // khoa bi mat
    public static int ok = 0;
    public static double h = power(g, a, p); // khoa cong khai

    static ArrayList<PhieuBau> dsPhieuBau = new ArrayList<PhieuBau>();
    static ArrayList<Integer> dsNguyenTo = new ArrayList<Integer>();

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
            System.out.println("4: Thoát chương trình");
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
                case 4 -> System.exit(0);
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
            b1 = (b1 * phieuBau.getM1().getH()) % p;
            b2 = (b2 * phieuBau.getM2().getH()) % p;
            b3 = (b3 * phieuBau.getM3().getH()) % p;
            b4 = (b4 * phieuBau.getM4().getH()) % p;

            System.out.println("*** : b1 = "+b1);
            System.out.println("*** : b2 = "+b2);
            System.out.println("*** : b3 = "+b3);
            System.out.println("*** : b4 = "+b4);

            System.out.println("*** : x1 = "+x1);
            System.out.println("*** : x2 = "+x2);
            System.out.println("*** : x3 = "+x3);
            System.out.println("*** : x4 = "+x4);

            System.out.println("*** : y1 = "+y1);
            System.out.println("*** : y2 = "+y2);
            System.out.println("*** : y3 = "+y3);
            System.out.println("*** : y4 = "+y4);

        }
        double m11 = module(x1, b1, p); //X^a
        double m12 = modInverse(m11, p); //nghich dao X^a
        double m1 = (y1 * m12) % p; // m: ban ro


        System.out.println("*** : m11 = "+m11);
        System.out.println("*** : m12 = "+m12);
        System.out.println("*** : m1 = "+m1);

        double m21 = module(x2, b2, p);
        double m22 = modInverse(m21, p);
        double m2 = (y2 * m22) % p;


        System.out.println("*** : m21 = "+m21);
        System.out.println("*** : m22 = "+m22);
        System.out.println("*** : m2 = "+m2);

        double m31 = module(x3, b3, p);
        double m32 = modInverse(m31, p);
        double m3 = (y3 * m32) % p;


        System.out.println("*** : m31 = "+m31);
        System.out.println("*** : m32 = "+m32);
        System.out.println("*** : m3 = "+m3);

        double m41 = module(x4, b4, p);
        double m42 = modInverse(m41, p);
        double m4 = (y4 * m42) % p;


        System.out.println("*** : m41 = "+m41);
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
                case 1 -> bauChon(1, 0, 0, 0);
                case 2 -> bauChon(0, 1, 0, 0);
                case 3 -> bauChon(0, 0, 1, 0);
                case 4 -> bauChon(0, 0, 0, 1);
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

    private static void bauChon(int a, int b, int c, int d) {
        PhieuBau mA = new PhieuBau(messageChild(a), messageChild(b), messageChild(c), messageChild(d));
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

    private static MaHoa messageChild(int v) {
        int k = randomNumber();
        inputNguyenTo(30);
        int rnd = new Random().nextInt(dsNguyenTo.size() - 1);
        int a = dsNguyenTo.get(rnd);
        double h = power(g, a, p);
        MaHoa m = new MaHoa(power(g, k, p), power3(a, k, g, v, p),h);
        System.out.println("*** : v = "+v+" a = "+a+" h = "+h+" k = "+k+" x = "+power(g, k, p)+" y = "+power3(a, k, g, v, p));
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
