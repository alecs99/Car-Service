package model;

import helpers.AngajatComparator;
import contracts.ServiceContract;
import helpers.RezervariComparator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ServiceAuto implements ServiceContract {


    private String numeService;
    private String adresa;
    private int telefon;
    private List<Angajat> angajati = new ArrayList<>();
    private Rezervari[] rezervari;
    private Servicii[] servicii;
    private Manager manager;
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public ServiceAuto(String numeService, String adresa, int telefon, Manager manager) {
        this.numeService = numeService;
        this.adresa = adresa;
        this.telefon = telefon;
        this.manager = manager;
    }

    public ServiceAuto(String numeService, String adresa, int telefon, List<Angajat> angajati, Rezervari[] rezervari, Servicii[] servicii, Manager manager) {
        this.numeService = numeService;
        this.adresa = adresa;
        this.telefon = telefon;
        this.angajati = angajati;
        this.rezervari = rezervari;
        this.servicii = servicii;
        this.manager = manager;
    }

    public String getNumeService() {
        return numeService;
    }

    public void setNumeService(String numeService) {
        this.numeService = numeService;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }


    public List<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }


    public Rezervari[] getRezervari() {
        return rezervari;
    }

    public void setRezervari(Rezervari[] rezervari) {
        this.rezervari = rezervari;
    }

    public void setServicii(Servicii[] servicii) {
        this.servicii = servicii;
    }

    public Servicii[] getServicii() {
        return servicii;
    }

    @Override
    public void afiseazaAngajatii() {
        System.out.println("***Angajatii sunt:***");
        for (Angajat angajat : angajati) {
            System.out.println(angajat);
        }
    }

    @Override
    public void afiseazaServicii() {
        System.out.println("***Service-ul nostru va ofera urmatoarele servicii***");
        for (Servicii serviciu : servicii) {
            System.out.println(serviciu.toString());
        }
    }

    @Override
    public void afiseazaRezervari() {
        System.out.println("***Rezervarile sunt:***");
        for (Rezervari rezervare : rezervari) {
            System.out.println(rezervare.toString());
        }
    }

    @Override
    public void adaugaAngajat() {
        System.out.println("Introduceti numele angajatului");
        String numeAngajat = scanner.next();
        System.out.println("Introduceti prenumele angajatului");
        String prenumeAngajat = scanner.next();
        System.out.println("Introduceti functie angajatului");
        String pozitie = scanner.next();
        System.out.println("Introduceti salariul angajatului");
        int salariu = scanner.nextInt();
        if (pozitie.equals("Mecanic")) {
            System.out.println("Introduceti atributia mecanicului(Mecanic, Vopsitor, Vulcanizator, Tinichigiu, Ajutor)");
            String atributie = scanner.next();
            System.out.println("Introduceti bonusul mecanicului");
            int bonus = scanner.nextInt();
            Angajat mecanic = new Mecanic(numeAngajat, prenumeAngajat, salariu, atributie, bonus);
            this.angajati.add(mecanic);
            System.out.println("***Angajatul a fost adaugat cu succes!***");
            System.out.println(mecanic);
        } else if (pozitie.equals("Casier")) {
            Angajat casier = new Casier(numeAngajat, prenumeAngajat, salariu);
            this.angajati.add(casier);
            System.out.println("***Angajatul a fost adaugat cu succes!***");
            System.out.println(casier);
        } else {
            System.out.println("Ai ales o functie care nu exista! Mai incearca!");
        }
    }

    @Override
    public void stergeAngajat() {
        int indexAngajat = 0;
        for (Angajat angajat : angajati) {
            System.out.println(Integer.toString(indexAngajat) + '.' + angajat);
            indexAngajat++;
        }
        System.out.println("Introduceti index-ul angajatului pe care doriti sa il eliminati:");
        int index = scanner.nextInt();
        this.angajati.remove(index);
        System.out.println("***Angajatul cu index-ul " + index + " a fost sters cu succes!***");
    }

    @Override
    public void afiseazaAngajatiSortat() {
        AngajatComparator sortareAngajati = new AngajatComparator();
        Collections.sort(angajati, sortareAngajati);
        System.out.println("***Angajatii sunt:***");
        for (Angajat angajat : angajati) {
            System.out.println(angajat);
        }
    }

    @Override
    public void adaugaRezervare() {
        System.out.println("Introduceti numele clientului");
        String nume = scanner.next();
        System.out.println("Introduceti prenumele clientului");
        String prenume = scanner.next();
        System.out.println("Introduceti marca masinii clientului");
        String marca = scanner.next();
        System.out.println("Introduceti tipul serviciului");
        String tipServiciu = scanner.next();
        System.out.println("Introduceti data si ora rezervarii cu formatul urmator zz/ll/aa oo:mm");
        String data = scanner.next();
        Rezervari rezervare = new Rezervari(nume, prenume, marca, tipServiciu, data);
        this.rezervari = Rezervari.addRezervare(rezervari, rezervare);
        System.out.println("***Rezervarea a fost adaugata cu succes!***");
        System.out.println(rezervare);
    }

    @Override
    public void stergeRezervare() {
        int indexRezervare = 0;
        for (Rezervari rezervare : rezervari) {
            System.out.println(Integer.toString(indexRezervare) + '.' + rezervare);
            indexRezervare++;
        }
        System.out.println("Introduceti index-ul rezervarii pe care doriti sa il eliminati:");
        int index = scanner.nextInt();
        this.rezervari = Rezervari.removeRezervare(rezervari, index);
        System.out.println("***Rezervarea cu index-ul " + index + " a fost stearsa cu succes!***");
    }

    @Override
    public void adaugaServiciu() {

        System.out.println("Introduceti numele serviciului");
        String numeServiciu = scanner.next();
        System.out.println("Introduceti costul serviciului");
        double cost = scanner.nextDouble();
        System.out.println("Introduceti durata de executie");
        double durata = scanner.nextDouble();
        if (numeServiciu.equals("Mecanica")) {
            System.out.println("Introduceti operatiunea:");
            String operatiune = scanner.next();
            System.out.println("Raspundeti cu true sau false daca in cadrul operatiunii este necesara inlocuirea unei piese:");
            boolean inlocuire = scanner.nextBoolean();
            Servicii serviciu = new Mecanica(operatiune, cost, durata, inlocuire);
            this.servicii = Servicii.addServiciu(servicii, serviciu);
        } else if (numeServiciu.equals("Tinichigerie")) {
            System.out.println("Introduceti operatiunea:");
            String operatiune = scanner.next();
            System.out.println("Introduceti gradul de dificultate al operatiunii: ");
            double dificultate = scanner.nextDouble();
            Servicii serviciu = new Tinichigerie(operatiune, cost, durata, dificultate);
            this.servicii = Servicii.addServiciu(servicii, serviciu);
        } else {
            System.out.println("Introduceti operatiunea:");
            String operatiune = scanner.next();
            Servicii serviciu = new Vulcanizare(operatiune, cost, durata);
            this.servicii = Servicii.addServiciu(servicii, serviciu);
        }
        System.out.println("***Serviciul a fost adaugat cu succes!***");
    }

    @Override
    public void stergeServiciu() {
        int indexServiciu = 0;
        for (Servicii serviciu : servicii) {
            System.out.println(Integer.toString(indexServiciu) + '.' + serviciu);
            indexServiciu++;
        }
        System.out.println("Introduceti index-ul serviciului pe care doriti sa il eliminati:");
        int index = scanner.nextInt();
        this.servicii = Servicii.removeServiciu(servicii, index);
        System.out.println("***Serviciul cu index-ul " + index + " a fost stears cu succes!***");
    }

    @Override
    public void afisareUrmatoareleRezervari() {
        RezervariComparator sortareRezervari = new RezervariComparator();
        Arrays.sort(rezervari, sortareRezervari);
        System.out.println("***Urmatoarele rezervari sunt:***");
        for (Rezervari rezervare : rezervari) {
            System.out.println(rezervare);
        }
    }

    private void raportMecaniciHelper(Mecanic mecanic) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanici.csv", true))) {
            bufferedWriter.append(mecanic.getNumeAngajat());
            bufferedWriter.append(",");
            bufferedWriter.append(mecanic.getPrenumeAngajat());
            bufferedWriter.append(",");
            bufferedWriter.append(mecanic.getPozitie());
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(mecanic.getSalariu()));
            bufferedWriter.append(",");
            bufferedWriter.append(mecanic.getAtributie());
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(mecanic.getBonus()));
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void raportHeaderMecanici() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanici.csv"))) {
            bufferedWriter.append("Nume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Prenume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Pozitie");
            bufferedWriter.append(",");
            bufferedWriter.append("Salariu");
            bufferedWriter.append(",");
            bufferedWriter.append("Atributie");
            bufferedWriter.append(",");
            bufferedWriter.append("Bonus");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void genereazaCsvMecanici() {
        raportHeaderMecanici();
        for (Angajat angajat : angajati) {
            if (angajat.getPozitie().equals("Mecanic")) {
                raportMecaniciHelper((Mecanic) angajat);
            }

        }
        System.out.println("***Raport generat cu succes!***");
    }

    private void raportCasierHelper(Casier casier) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/casier.csv", true))) {
            bufferedWriter.append(casier.getNumeAngajat());
            bufferedWriter.append(",");
            bufferedWriter.append(casier.getPrenumeAngajat());
            bufferedWriter.append(",");
            bufferedWriter.append(casier.getPozitie());
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(casier.getSalariu()));
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void raportHeaderCasier() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/casier.csv"))) {
            bufferedWriter.append("Nume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Prenume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Pozitie");
            bufferedWriter.append(",");
            bufferedWriter.append("Salariu");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void genereazaCsvCasier() {
        raportHeaderCasier();
        for (Angajat angajat : angajati) {
            if (angajat.getPozitie().equals("Casier")) {
                raportCasierHelper((Casier) angajat);
            }

        }
        System.out.println("***Raport generat cu succes!***");
    }


    private void raportMecanicaHelper(Mecanica serviciu) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanica.csv", true))) {
            bufferedWriter.append("Mecanica");
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getCostServiciu()));
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getDurataExecutie()));
            bufferedWriter.append(",");
            bufferedWriter.append(serviciu.getOperatiune());
            bufferedWriter.append(",");
            bufferedWriter.append(Boolean.toString(serviciu.isInlocuirePiesa()));
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void raportHeaderMecanica() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanica.csv"))) {
            bufferedWriter.append("Nume");
            bufferedWriter.append(",");
            bufferedWriter.append("Cost");
            bufferedWriter.append(",");
            bufferedWriter.append("Durata (min)");
            bufferedWriter.append(",");
            bufferedWriter.append("Operatiune");
            bufferedWriter.append(",");
            bufferedWriter.append("Inlocuire Piesa true/false");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void genereazaCsvMecanica() {
        raportHeaderMecanica();
        for (Servicii serviciu : servicii) {
            if (serviciu.getTipServiciu().equals("Mecanica")) {
                raportMecanicaHelper((Mecanica) serviciu);
            }
        }
        System.out.println("***Raport generat cu succes!***");

    }

    private void raportTinichigerieHelper(Tinichigerie serviciu) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/tinichigerie.csv", true))) {
            bufferedWriter.append("Tinichigerie");
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getCostServiciu()));
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getDurataExecutie()));
            bufferedWriter.append(",");
            bufferedWriter.append(serviciu.getOperatiune());
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getGradDificultate()));
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void raportHeaderTinichigerie() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/tinichigerie.csv"))) {
            bufferedWriter.append("Nume");
            bufferedWriter.append(",");
            bufferedWriter.append("Cost");
            bufferedWriter.append(",");
            bufferedWriter.append("Durata (min)");
            bufferedWriter.append(",");
            bufferedWriter.append("Operatiune");
            bufferedWriter.append(",");
            bufferedWriter.append("Grad de dificultate");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void genereazaCsvTinichigerie() {
        raportHeaderTinichigerie();
        for (Servicii serviciu : servicii) {
            if (serviciu.getTipServiciu().equals("Tinichigerie")) {
                raportTinichigerieHelper((Tinichigerie) serviciu);
            }
        }
        System.out.println("***Raport generat cu succes!***");

    }

    private void raportVulcanizareHelper(Vulcanizare serviciu) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/vulcanizare.csv", true))) {
            bufferedWriter.append("Vulcanizare");
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getCostServiciu()));
            bufferedWriter.append(",");
            bufferedWriter.append(Double.toString(serviciu.getDurataExecutie()));
            bufferedWriter.append(",");
            bufferedWriter.append(serviciu.getOperatiune());
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void raportHeaderVulcanizare() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/vulcanizare.csv"))) {
            bufferedWriter.append("Nume");
            bufferedWriter.append(",");
            bufferedWriter.append("Cost");
            bufferedWriter.append(",");
            bufferedWriter.append("Durata (min)");
            bufferedWriter.append(",");
            bufferedWriter.append("Operatiune");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void genereazaCsvVulcanizare() {
        raportHeaderVulcanizare();
        for (Servicii serviciu : servicii) {
            if (serviciu.getTipServiciu().equals("Vulcanizare")) {
                raportVulcanizareHelper((Vulcanizare) serviciu);
            }
        }
        System.out.println("***Raport generat cu succes!***");

    }

    private void RaportRezervariHelper(Rezervari rezervare) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/rezervari.csv", true))) {
            bufferedWriter.append(rezervare.getNumeClient());
            bufferedWriter.append(",");
            bufferedWriter.append(rezervare.getPrenumeClient());
            bufferedWriter.append(",");
            bufferedWriter.append(rezervare.getMarcaMasina());
            bufferedWriter.append(",");
            bufferedWriter.append(rezervare.getNumeServiciu());
            bufferedWriter.append(",");
            bufferedWriter.append(rezervare.getData());
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void raportHeaderRezervari() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/rezervari.csv"))) {
            bufferedWriter.append("Nume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Prenume Client");
            bufferedWriter.append(",");
            bufferedWriter.append("Marca masina");
            bufferedWriter.append(",");
            bufferedWriter.append("Nume serviciu");
            bufferedWriter.append(",");
            bufferedWriter.append("Data");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void genereazaCsvRezervari() {
        raportHeaderRezervari();
        for (Rezervari rezervare : rezervari) {
            RaportRezervariHelper(rezervare);
        }
        System.out.println("***Raport generat cu succes!***");
    }

    @Override
    public void afiseazaManager() {
        System.out.println(manager.toString());
    }


    @Override
    public String toString() {
        return "Service-ul Auto cu numele " + numeService + " are adresa " + adresa + " si numarul de telefon " + telefon;
    }
}
