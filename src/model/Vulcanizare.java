package model;

public class Vulcanizare extends Servicii {


    private String operatiune;

    public Vulcanizare(String operatiune, double cost, double durataExecutie) {
        super("Vulcanizare", cost, durataExecutie);
        this.operatiune = operatiune;
    }

    public Vulcanizare(double cost, double durataExecutie) {
        super("Vulcanizare", cost, durataExecutie);
    }

    public String getOperatiune() {
        return operatiune;
    }

    @Override
    public String toString() {
        return "Serviciul din categoria Vulcanizare ce are ca operatiune " + operatiune +
                " are pretul " + super.getCostServiciu() + " si durata de executie "
                + super.getDurataExecutie();
    }
}
