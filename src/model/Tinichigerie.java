package model;

public class Tinichigerie extends Servicii {


    private String operatiune;
    private double gradDificultate;

    public Tinichigerie(String operatiune, double cost, double durataExecutie, double gradDificultate) {
        super("Tinichigerie", cost, durataExecutie);
        this.operatiune = operatiune;
        this.gradDificultate = gradDificultate;
    }

    public Tinichigerie(double cost, double durataExecutie) {
        super("Tinichigerie", cost, durataExecutie);
    }

    public String getOperatiune() {
        return operatiune;
    }

    public double getGradDificultate() {
        return gradDificultate;
    }

    @Override
    public String toString() {
        return "Serviciul din categoria Tinichigerie ce are ca operatiune " + operatiune + " are pretul " +
                super.getCostServiciu() + ", durata de executie " + super.getDurataExecutie()
                + " si gradul de dificultate " + gradDificultate;
    }
}
