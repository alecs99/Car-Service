package model;

import helpers.AngajatComparator;
import helpers.DateComparator;
import contracts.ServiceContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceAuto implements ServiceContract {


    private String numeService;
    private String adresa;
    private int telefon;
    private List<Angajat> angajati = new ArrayList<>();
    private Rezervari [] rezervari;
    private Servicii [] servicii;

    public ServiceAuto(String numeService, String adresa, int telefon) {
        this.numeService = numeService;
        this.adresa = adresa;
        this.telefon = telefon;
    }
    public ServiceAuto(String numeService, String adresa, int telefon, List<Angajat> angajati, Rezervari[] rezervari, Servicii[] servicii) {
        this.numeService = numeService;
        this.adresa = adresa;
        this.telefon = telefon;
        this.angajati = angajati;
        this.rezervari = rezervari;
        this.servicii = servicii;
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
    public void adaugaAngajat(Angajat angajat){
        this.angajati.add(angajat);
        System.out.println("***Angajatul a fost adaugat cu succes!***");
        System.out.println(angajat);
    }

    @Override
    public void stergeAngajat(int index){
        this.angajati.remove(index);
        System.out.println("***Angajatul cu index-ul " + index +  " a fost sters cu succes!***");
    }

    @Override
    public void afiseazaAngajatiSortat(){
        AngajatComparator sortareAngajati = new AngajatComparator();
        Collections.sort(angajati, sortareAngajati);
        System.out.println("***Angajatii sunt:***");
        for(Angajat angajat : angajati){
            System.out.println(angajat);
        }
    }

    @Override
    public void adaugaRezervare(Rezervari rezervare){
        this.rezervari = Rezervari.addRezervare(rezervari,rezervare);
        System.out.println("***Rezervarea a fost adaugata cu succes!***");
        System.out.println(rezervare);
    }

    @Override
    public void stergeRezervare(int index){
        this.rezervari = Rezervari.removeRezervare(rezervari,index);
        System.out.println("***Rezervarea cu index-ul " + index +  " a fost stearsa cu succes!***");
    }

    @Override
    public void adaugaServiciu(Servicii serviciu){
        this.servicii = Servicii.addServiciu(servicii,serviciu);
        System.out.println("***Serviciul a fost adaugat cu succes!***");
        System.out.println(serviciu);
    }

    @Override
    public void stergeServiciu(int index){
        this.servicii = Servicii.removeServiciu(servicii,index);
        System.out.println("***Serviciul cu index-ul " + index +  " a fost stears cu succes!***");
    }

    @Override
    public void afisareUrmatoareleRezervari(){   //Am eroare aici si nu am reusit sa o depanez, urmeaza sa o rezolv
//        DateComparator sortareDate = new DateComparator();
//        Arrays.sort(rezervari, sortareDate);
        System.out.println("***Urmatoarele rezervari sunt:***");
        System.out.println(Arrays.toString(rezervari));
    }






}
