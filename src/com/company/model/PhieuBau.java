package com.company.model;

public class PhieuBau {
    private MaHoa m1;
    private MaHoa m2;
    private MaHoa m3;
    private MaHoa m4;

    public PhieuBau(MaHoa m1, MaHoa m2, MaHoa m3, MaHoa m4) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
    }

    public MaHoa getM1() {
        return m1;
    }

    public MaHoa getM2() {
        return m2;
    }

    public MaHoa getM3() {
        return m3;
    }

    public MaHoa getM4() {
        return m4;
    }

}
