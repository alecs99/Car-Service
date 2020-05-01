package model;

public abstract class Angajat {

    private String numeAngajat;
    private String prenumeAngajat;
    private String pozitie;
    private double salariu;

    public Angajat(String numeAngajat, String prenumeAngajat, String pozitie, double salariu) {
        this.numeAngajat = numeAngajat;
        this.prenumeAngajat = prenumeAngajat;
        this.pozitie = pozitie;
        this.salariu = salariu;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
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
        this.salariu = salariu;
    }


    @Override
    public String toString() {
        return "Angajat{" +
                "numeAngajat='" + numeAngajat + '\'' +
                ", prenumeAngajat='" + prenumeAngajat + '\'' +
                ", pozitie='" + pozitie + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
