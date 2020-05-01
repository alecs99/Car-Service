package helpers;

import model.Rezervari;

import java.util.Comparator;

public class RezervariComparator implements Comparator<Rezervari> {  /* functia de comparare pentru sortarea rezervarilor
                                                                        dupa data */
    @Override
    public int compare(Rezervari rezervare1, Rezervari rezervare2) {
        return rezervare1.getData().compareTo(rezervare2.getData());
    }
}
