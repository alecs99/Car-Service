package contracts;

import model.Angajat;
import model.Rezervari;
import model.Servicii;

public interface ServiceContract {
    void afiseazaAngajatii();

    void afiseazaServicii();

    void afiseazaRezervari();

    void adaugaAngajat();

    void stergeAngajat();

    void afiseazaAngajatiSortat();

    void adaugaRezervare();

    void stergeRezervare();

    void afisareUrmatoareleRezervari();

    void adaugaServiciu();

    void stergeServiciu();

    void afiseazaManager();

    void genereazaCsvMecanici();

    void genereazaCsvCasier();

    void genereazaCsvMecanica();

    void genereazaCsvTinichigerie();

    void genereazaCsvVulcanizare();

    void genereazaCsvRezervari();

}
