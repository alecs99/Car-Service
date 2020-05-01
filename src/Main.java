import helpers.ServiceHelper;
import model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
        serviciuAudit audit = serviciuAudit.getAudit();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Map<Integer, String> optiuni = new HashMap<Integer, String>();
        optiuni.put(1, "Afiseaza toti angajatii");
        optiuni.put(2, "Afiseaza toate serviciile");
        optiuni.put(3, "Afiseaza toate rezervarile in ordinea adaugarii");
        optiuni.put(4, "Afiseaza toti angajatii sortati dupa nume");
        optiuni.put(5, "Afiseaza rezervarile in ordinea datei");
        optiuni.put(6, "Adauga un angajat");
        optiuni.put(7, "Sterge un angajat");
        optiuni.put(8, "Adauga un serviciu");
        optiuni.put(9, "Sterge un serviciu");
        optiuni.put(10, "Adauga o rezervare");
        optiuni.put(11, "Sterge o rezervare");
        optiuni.put(12, "Afiseaza managerul firmei");
        optiuni.put(13, "Afiseaza informatii cu privire la service");
        optiuni.put(14, "Genereaza raport rezervari");
        optiuni.put(15, "Genereaza raport mecanici");
        optiuni.put(16, "Genereaza raport casieri");
        optiuni.put(17, "Genereaza raport servicii mecanica");
        optiuni.put(18, "Genereaza raport servicii tinichigerie");
        optiuni.put(19, "Genereaza raport servicii vulcanizare");
        optiuni.put(20, "Iesire");

        System.out.println("\n>>Bun venit la service-ul auto: " + serviceAuto.getNumeService() + "<<\n");
        System.out.println(">>Selectati una din comenzi prin tastarea numarului<<");

        for (Integer index : optiuni.keySet()) {
            System.out.println(index + ". " + optiuni.get(index));
        }

        while (true) {
            int selectie = scanner.nextInt();
            audit.scrie(optiuni.get(selectie));
            switch (selectie) {
                case 1:
                    serviceAuto.afiseazaAngajatii();
                    break;
                case 2:
                    serviceAuto.afiseazaServicii();
                    break;
                case 3:
                    serviceAuto.afiseazaRezervari();
                    break;
                case 4:
                    serviceAuto.afiseazaAngajatiSortat();
                    break;
                case 5:
                    serviceAuto.afisareUrmatoareleRezervari();
                    break;
                case 6:
                    serviceAuto.adaugaAngajat();
                    break;
                case 7:
                    serviceAuto.stergeAngajat();
                    break;
                case 8:
                    serviceAuto.adaugaServiciu();
                    break;
                case 9:
                    serviceAuto.stergeServiciu();
                    break;
                case 10:
                    serviceAuto.adaugaRezervare();
                    break;
                case 11:
                    serviceAuto.stergeRezervare();
                    break;
                case 12:
                    serviceAuto.afiseazaManager();
                    break;
                case 13:
                    System.out.println(serviceAuto);
                    break;
                case 14:
                    serviceAuto.genereazaCsvRezervari();
                    break;
                case 15:
                    serviceAuto.genereazaCsvMecanici();
                    break;
                case 16:
                    serviceAuto.genereazaCsvCasier();
                    break;
                case 17:
                    serviceAuto.genereazaCsvMecanica();
                    break;
                case 18:
                    serviceAuto.genereazaCsvTinichigerie();
                    break;
                case 19:
                    serviceAuto.genereazaCsvVulcanizare();
                    break;
                case 20:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ai ales o optiune gresita!!");

            }
        }
    }
}
