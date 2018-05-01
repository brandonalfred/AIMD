package hw4;

public class Host {
    private double myBandwidth;
    private double inc;
    private double dec;

    Host(double inc, double dec, double myBandwidth) {
        this.inc = inc;
        this.dec = dec;
        this.myBandwidth = myBandwidth;
    }

    public double getMyBandwidth() {
        return this.myBandwidth;
    }

    public double getInc() {
        return inc;
    }

    public double getDec() {
        return dec;
    }

    public void incMyBandwidth(double num) {
        this.myBandwidth += num;
    }

    public void decMyBandwidth(double num) {
        this.myBandwidth *= num;
    }

    public void setMyBandwidth(double num) {
        this.myBandwidth = num;
    }
}
