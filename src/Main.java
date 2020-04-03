import helpers.ServiceHelper;
import model.Angajat;
import model.Rezervari;
import model.ServiceAuto;
import model.Servicii;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>Bun venit la service-ul auto:" + serviceAuto.getNumeService() + "<<");
        System.out.println("\n");
        System.out.println(">>Selectati una din comenzi prin tastarea numarului<<");
        System.out.println("1.Afiseaza toti angajatii");
        System.out.println("2.Afiseaza toate serviciile");
        System.out.println("3.Afiseaza toate rezervarile");
        System.out.println("4.Afiseaza toti angajatii sortati dupa nume");
        System.out.println("5.Afiseaza urmatoarele rezervari");
        System.out.println("6.Adauga un angajat");
        System.out.println("7.Sterge un angajat");
        System.out.println("8.Adauga un serviciu");
        System.out.println("9.Sterge un serviciu");
        System.out.println("10.Adauga o rezervare");
        System.out.println("11.Sterge o rezervare");
        System.out.println("12.Iesire");

        while(true){
            String selectie = scanner.next();
            switch(selectie){
                case "1":
                    System.out.println("Service-ul are urmatorii angajati: ");
                    System.out.println("\n");
                    System.out.println(serviceAuto.getAngajati());
                    break;
                case "2":
                    System.out.println("Service-ul ofera urmatoarele servicii: ");
                    System.out.println("\n");
                    System.out.println(serviceAuto.getServicii());
                    break;
                case "3":
                    System.out.println("Service-ul are urmatoarele rezervari: ");
                    System.out.println("\n");
                    System.out.println(serviceAuto.getRezervari());
                    break;
                case "4":
                    System.out.println("Sortare angajati dupa nume:");
                    System.out.println("\n");
                    serviceAuto.afiseazaAngajatiSortat();
                case "5":
                    System.out.println("Service-ul va avea urmatoarele rezervari:");
                    System.out.println("\n");
                    serviceAuto.afisareUrmatoareleRezervari();
                case "6":
                    System.out.println("Introduceti numele angajatului");
                    String numeAngajat = scanner.next();
                    System.out.println("Introduceti prenumele angajatului");
                    String prenumeAngajat = scanner.next();
                    System.out.println("Introduceti salariul angajatului");
                    String salariu = scanner.next();
                    System.out.println("Introduceti bonusul angajatului");
                    String bonus = scanner.next();
                    Angajat angajat = new Angajat(numeAngajat,prenumeAngajat,Integer.valueOf(salariu),Integer.valueOf(bonus));
                    serviceAuto.adaugaAngajat(angajat);
                    break;
                case "7":
                    System.out.println("Introduceti index-ul angajatului pe care doriti sa il eliminati:");
                    String index = scanner.next();
                    serviceAuto.stergeAngajat(Integer.valueOf(index));
                    break;
                case "8":
                    System.out.println("Introduceti numele serviciului");
                    String numeServiciu = scanner.next();
                    System.out.println("Introduceti costul serviciului");
                    String cost = scanner.next();
                    System.out.println("Introduceti durata de executie");
                    String durata = scanner.next();
                    Servicii serviciu = new Servicii(numeServiciu,Integer.valueOf(cost),Integer.valueOf(durata));
                    serviceAuto.adaugaServiciu(serviciu);
                    break;
                case "9":
                    System.out.println("Introduceti index-ul serviciului pe care doriti sa il eliminati:");
                    index = scanner.next();
                    serviceAuto.stergeServiciu(Integer.valueOf(index));
                    break;
                case "10":
                    System.out.println("Introduceti numele clientului");
                    String nume = scanner.next();
                    System.out.println("Introduceti prenumele clientului");
                    String prenume = scanner.next();
                    System.out.println("Introduceti marca masinii clientului");
                    String marca = scanner.next();
                    System.out.println("Introduceti tipul serviciului");
                    String tipServiciu = scanner.next();
                    System.out.println("Introduceti data rezervarii zi, luna, an");
                    String zi = scanner.next();
                    String luna = scanner.next();
                    String an = scanner.next();
                    Rezervari rezervare = new Rezervari(nume, prenume, marca, tipServiciu,Integer.valueOf(zi), Integer.valueOf(luna), Integer.valueOf(an));
                    serviceAuto.adaugaRezervare(rezervare);
                    break;
                case "11":
                    System.out.println("Introduceti index-ul rezervarii pe care doriti sa o eliminati:");
                    index = scanner.next();
                    serviceAuto.stergeRezervare(Integer.valueOf(index));
                    break;
                case "12":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ai ales o optiune gresita!!");



            }
        }
    }
}
