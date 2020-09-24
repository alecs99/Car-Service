package model;

/* Clasa singleton pentru definirea manaqerului */

public class Manager {
    private static Manager m = null;
    private final String nume;
    private final String prenume;

    private Manager() {
        this.nume = "Ciobanu";
        this.prenume = "Alecsandru";
    }

    public static Manager getManager() {
        if (m == null) {
            m = new Manager();
        }
        return m;
    }

    @Override
    public String toString() {
        return "Managerul service-ului este: " + nume + ' ' + prenume + '\n';
    }
}
