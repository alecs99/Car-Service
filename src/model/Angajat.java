package model;

public class Angajat {

    private String numeAngajat;
    private String prenumeAngajat;
    private double salariu;
    private double bonus;

    public Angajat(String numeAngajat, String prenumeAngajat, double salariu, double bonus) {
        this.numeAngajat = numeAngajat;
        this.prenumeAngajat = prenumeAngajat;
        this.salariu = salariu;
        this.bonus = bonus;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getPrenumeAngajat() {
        return prenumeAngajat;
    }

    public void setPrenumeAngajat(String prenumeAngajat) {
        this.prenumeAngajat = prenumeAngajat;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu * this.bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Angajati{" +
                "prenumeAngajat='" + prenumeAngajat + '\'' +
                ", salariu=" + salariu +
                ", bonus=" + bonus +
                ", numeAngajat='" + numeAngajat + '\'' +
                '}';
    }

}
