package helpers;

import contracts.ServiceHelperContract;
import model.Angajat;
import model.Rezervari;
import model.ServiceAuto;
import model.Servicii;

import java.util.ArrayList;
import java.util.List;

public class ServiceHelper extends ServiceHelperContract {

    @Override
    public ServiceAuto creeazaServiceCuDateInitiale(){
        Angajat angajat1 = new Angajat("Costache", "Cornel", 1000, 1.5);
        Angajat angajat2 = new Angajat("Barbu", "Ionel", 1400, 0.5);
        Angajat angajat3 = new Angajat("Sirbu", "Mihai", 1800, 2.2);
        Angajat angajat4 = new Angajat("Iordache", "Alexandru", 1500, 2.5);
        Angajat angajat5 = new Angajat("Popescu", "Cristi", 1200, 0.75);
        List<Angajat> angajati= new ArrayList<>();
        angajati.add(angajat1);
        angajati.add(angajat2);
        angajati.add(angajat3);
        angajati.add(angajat4);
        angajati.add(angajat5);
        Rezervari rezervare1 = new Rezervari("Cordescu","Emil","Audi Q8",
                "echilibrat roti",2,4,2020);
        Rezervari rezervare2 = new Rezervari("Ionescu","Calin","Opel Astra",
                "revizie",8,4,2020);
        Rezervari rezervare3 = new Rezervari("Milea","Antonio","Dacia Logan",
                "revizie frane",22,4,2020);
        Rezervari rezervare4 = new Rezervari("Burlacu","Andrei","BMW M50D",
                "tinichigerie",25,4,2020);
        Rezervari [] rezervari = null;
        rezervari = Rezervari.addRezervare(rezervari,rezervare1);
        rezervari = Rezervari.addRezervare(rezervari,rezervare2);
        rezervari = Rezervari.addRezervare(rezervari,rezervare3);
        rezervari = Rezervari.addRezervare(rezervari,rezervare4);
        Servicii serviciu1 = new Servicii("Echilibrat roti",100,30);
        Servicii serviciu2 = new Servicii("Revizie",200,60);
        Servicii serviciu3 = new Servicii("Revizie frane",400,90);
        Servicii serviciu4 = new Servicii("Tinichigerie",1000,600);
        Servicii serviciu5 = new Servicii("Schimbare distributie",1500,300);
        Servicii serviciu6 = new Servicii("Schimbare Ambreiaj",2000,360);
        Servicii serviciu7 = new Servicii("Schimb cauciucuri + echilibrat",200,60);
        Servicii [] servicii = null;
        servicii = Servicii.addServiciu(servicii, serviciu1);
        servicii = Servicii.addServiciu(servicii, serviciu2);
        servicii = Servicii.addServiciu(servicii, serviciu3);
        servicii = Servicii.addServiciu(servicii, serviciu4);
        servicii = Servicii.addServiciu(servicii, serviciu5);
        servicii = Servicii.addServiciu(servicii, serviciu6);
        servicii = Servicii.addServiciu(servicii, serviciu7);
        return new ServiceAuto("UrgentService","Strada Martisor nr 5, sector 4, Bucuresti",
                0766532341,angajati,rezervari,servicii);
    }

}
