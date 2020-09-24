package model;


import java.util.ArrayList;

public abstract class Servicii {

    private String tipServiciu;
    private double costServiciu;
    private double durataExecutie;

    public Servicii(String tipServiciu, double costServiciu, double durataExecutie) {
        this.tipServiciu = tipServiciu;
        this.costServiciu = costServiciu;
        this.durataExecutie = durataExecutie;
    }

    public String getTipServiciu() {
        return tipServiciu;
    }

    public void setTipServiciu(String tipServiciu) {
        this.tipServiciu = tipServiciu;
    }

    public double getCostServiciu() {
        return costServiciu;
    }

    public void setCostServiciu(double costServiciu) {
        this.costServiciu = costServiciu;
    }

    public double getDurataExecutie() {
        return durataExecutie;
    }

    public void setDurataExecutie(double durataExecutie) {
        this.durataExecutie = durataExecutie;
    }

    public static Servicii[] addServiciu(Servicii[] servicii, Servicii serviciu) {
        if (servicii == null) {
            servicii = new Servicii[]{serviciu};
            return servicii;
        }
        ArrayList<Servicii> temp = new ArrayList<Servicii>();
        for (int i = 0; i < servicii.length; i++) {
            temp.add(servicii[i]);
        }
        temp.add(serviciu);
        servicii = temp.toArray(new Servicii[temp.size()]);
        return servicii;
    }

    public static Servicii[] removeServiciu(Servicii[] servicii, int index) {
        ArrayList<Servicii> temp = new ArrayList<Servicii>();
        for (int i = 0; i < servicii.length; i++) {
            if (i != index)
                temp.add(servicii[i]);
        }
        servicii = temp.toArray(new Servicii[temp.size()]);
        return servicii;
    }

    @Override
    public String toString() {
        return "Serviciul " + tipServiciu + " cu pretul " + costServiciu + " si durata de executie " + durataExecutie;
    }


}
