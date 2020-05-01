package model;

public class Casier extends Angajat {

    public Casier(String nume, String prenume, double salariu) {
        super(nume, prenume, "Casier", salariu);
    }

    public String toString() {
        return "Angajatul " + super.getNumeAngajat() + ' ' + super.getPrenumeAngajat() + " este casier " +
                "cu salariul " + super.getSalariu();
    }
}
