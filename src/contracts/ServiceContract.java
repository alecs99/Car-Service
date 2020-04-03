package contracts;

import model.Angajat;
import model.Rezervari;
import model.Servicii;

public interface ServiceContract {
    void adaugaAngajat(Angajat angajat);
    void stergeAngajat(int index);
    void afiseazaAngajatiSortat();
    void adaugaRezervare(Rezervari rezervare);
    void stergeRezervare(int index);
    void afisareUrmatoareleRezervari();
    void adaugaServiciu(Servicii serviciu);
    void stergeServiciu(int index);
}
