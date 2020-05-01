package helpers;

import model.Angajat;

import java.util.Comparator;

public class AngajatComparator implements Comparator<Angajat> { /*functia de comparare pentru sortarea angajatilor
                                                                 alfabetic*/
    @Override
    public int compare(Angajat a1, Angajat a2) {
        return a1.getNumeAngajat().compareTo(a2.getNumeAngajat());
    }
}
