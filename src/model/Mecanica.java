package model;

public class Mecanica extends Servicii {
    private String operatiune;
    private boolean inlocuirePiesa;


    public Mecanica(String operatiune, double cost, double durataExecutie, boolean inlocuirePiesa) {
        super("Mecanica", cost, durataExecutie);
        this.operatiune = operatiune;
        this.inlocuirePiesa = inlocuirePiesa;
    }

    public Mecanica(double cost, double durataExecutie) {
        super("Mecanica", cost, durataExecutie);
    }

    public String getOperatiune() {
        return operatiune;
    }

    public boolean isInlocuirePiesa() {
        return inlocuirePiesa;
    }


    @Override
    public String toString() {
        return "Serviciul din categoria Mecanica ce are ca operatiune " + operatiune + " are pretul " +
                super.getCostServiciu() + ", durata de executie " + super.getDurataExecutie()
                + " si este necesara inlocuirea unei piese: " + inlocuirePiesa;
    }
}
