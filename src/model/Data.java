package model;

public class Data {

    private int zi,luna,an;

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public int getLuna() {
        return luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public Data(int zi, int luna, int an) {
        this.zi = zi;
        this.luna = luna;
        this.an = an;
    }

    public void printData(){
        System.out.println(zi + "/" + luna + "/" + an);
    }
    public Data setData(int zi, int luna, int an) {
        this.zi = zi;
        this.luna = luna;
        this.an = an;
        return null;
    }

}
