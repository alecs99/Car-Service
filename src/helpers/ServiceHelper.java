package helpers;

import contracts.ServiceHelperContract;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceHelper extends ServiceHelperContract {

    @Override
    public ServiceAuto creeazaServiceCuDateInitiale() {
        /*
          Aceasta parte de cod a fost lasata pentru a exemplifica modalitatea prin care s-a realizat introducerea
          datelor pentru partea 1.
         */
//        Angajat mecanic1 = new Mecanic("Costache", "Cornel", 2000, "Tinichigiu", 0.5);
//        Angajat mecanic2 = new Mecanic("Barbu", "Ionel", 1600, "Vopsitor", 0.5);
//        Angajat mecanic3 = new Mecanic("Sirbu", "Mihai", 1800, "Mecanic", 2.2);
//        Angajat mecanic4 = new Mecanic("Iordache", "Alexandru", 1500, "Vulcanizator", 2.5);
//        Angajat mecanic5 = new Mecanic("Popescu", "Cristi", 1200, "Ajutor", 0.2);
//        Angajat casier = new Casier("Cristoiu", "George", 1200);
//        List<Angajat> angajati= new ArrayList<>();
//        Manager manager = Manager.getManager();
//        angajati.add(mecanic1);
//        angajati.add(mecanic2);
//        angajati.add(mecanic3);
//        angajati.add(mecanic4);
//        angajati.add(mecanic5);
//        angajati.add(casier);
//        Rezervari rezervare1 = new Rezervari("Cordescu","Emil","Audi Q8",
//                "echilibrat roti","13/05/2020 18:00");
//        Rezervari rezervare2 = new Rezervari("Ionescu","Calin","Opel Astra",
//                "revizie","10/05/2020 11:00");
//        Rezervari rezervare3 = new Rezervari("Milea","Antonio","Dacia Logan",
//                "revizie frane","22/05/2020 17:00");
//        Rezervari rezervare4 = new Rezervari("Burlacu","Andrei","BMW M50D",
//                "tinichigerie","25/05/2020 14:00");
//        Rezervari [] rezervari = null;
//        rezervari = Rezervari.addRezervare(rezervari,rezervare1);
//        rezervari = Rezervari.addRezervare(rezervari,rezervare2);
//        rezervari = Rezervari.addRezervare(rezervari,rezervare3);
//        rezervari = Rezervari.addRezervare(rezervari,rezervare4);
//        Servicii serviciu1 = new Mecanica("Constatare", 100, 30, false);
//        Servicii serviciu2 = new Mecanica("Revizie frane", 300, 60, false);
//        Servicii serviciu3 = new Mecanica("Schimbare Ambreiaj", 2000, 360, true);
//        Servicii serviciu4 = new Tinichigerie("Vopsire totala masina",4500,3600,5);
//        Servicii serviciu5 = new Tinichigerie("Indreptat praguri",600,180,2);
//        Servicii serviciu6 = new Tinichigerie("Vopsire element exterior",500,300,3);
//        Servicii serviciu7 = new Vulcanizare("Schimb cauciucuri + echilibrat",200,60);
//        Servicii [] servicii = null;
//        servicii = Servicii.addServiciu(servicii, serviciu1);
//        servicii = Servicii.addServiciu(servicii, serviciu2);
//        servicii = Servicii.addServiciu(servicii, serviciu3);
//        servicii = Servicii.addServiciu(servicii, serviciu4);
//        servicii = Servicii.addServiciu(servicii, serviciu5);
//        servicii = Servicii.addServiciu(servicii, serviciu6);
//        servicii = Servicii.addServiciu(servicii, serviciu7);

        /* Execut citirea din csv pentru fiecare clasa in parte*/

        Manager manager = Manager.getManager();
        List<Angajat> angajati = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanici.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Angajat mecanic = new Mecanic(dateCsv[0], dateCsv[1], Double.valueOf(dateCsv[3]),
                        dateCsv[4], Double.valueOf(dateCsv[5]));
                angajati.add(mecanic);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/casier.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Angajat casier = new Casier(dateCsv[0], dateCsv[1], Double.valueOf(dateCsv[3]));
                angajati.add(casier);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Rezervari[] rezervari = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/rezervari.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Rezervari rezervare = new Rezervari(dateCsv[0], dateCsv[1], dateCsv[2], dateCsv[3], dateCsv[4]);
                rezervari = Rezervari.addRezervare(rezervari, rezervare);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Servicii[] servicii = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/mecanica.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Servicii serviciu = new Mecanica(dateCsv[3], Double.valueOf(dateCsv[1]), Double.valueOf(dateCsv[2]),
                        Boolean.valueOf(dateCsv[4]));
                servicii = Servicii.addServiciu(servicii, serviciu);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/tinichigerie.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Servicii serviciu = new Tinichigerie(dateCsv[3], Double.valueOf(dateCsv[1]), Double.valueOf(dateCsv[2]),
                        Double.valueOf(dateCsv[4]));
                servicii = Servicii.addServiciu(servicii, serviciu);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/vulcanizare.csv"))) {
            String linie;
            String linieHeader = bufferedReader.readLine(); //citire header de care nu am nevoie
            while ((linie = bufferedReader.readLine()) != null) {
                String[] dateCsv = linie.split(",");
                Servicii serviciu = new Vulcanizare(dateCsv[3], Double.valueOf(dateCsv[1]), Double.valueOf(dateCsv[2]));
                servicii = Servicii.addServiciu(servicii, serviciu);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ServiceAuto("UrgentService", "Strada Martisor nr 5, sector 4, Bucuresti",
                0766532341, angajati, rezervari, servicii, manager);
    }

}
