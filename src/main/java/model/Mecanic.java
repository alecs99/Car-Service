package model;

public class Mecanic extends Angajat {

    private String atributie;
    private double bonus;

    public Mecanic(String nume, String prenume, double salariu, String atributie, double bonus) {
        super(nume, prenume, "Mecanic", salariu);
        this.atributie = atributie;
        this.bonus = bonus;
    }

    public Mecanic(String nume, String prenume, double salariu) {
        super(nume, prenume, "Mecanic", salariu);
    }

    public String getAtributie() {
        return atributie;
    }

    public void setAtributie(String atributie) {
        this.atributie = atributie;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) { this.bonus = bonus; }


    @Override
    public String toString() {
        return "Angajatul " + super.getNumeAngajat() + ' ' + super.getPrenumeAngajat() + " este mecanic " +
                "are salariul " + super.getSalariu() + ", atributia de " + atributie +
                " si bonusul " + bonus;
    }
}
