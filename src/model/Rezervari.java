package model;

import java.util.ArrayList;

public class Rezervari {

    private String numeClient;
    private String prenumeClient;
    private String marcaMasina;
    private String numeServiciu;
    private Data data;
    public Rezervari(String numeClient, String prenumeClient, String marcaMasina, String numeServiciu, int zi, int luna, int an) {
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
        this.marcaMasina = marcaMasina;
        this.numeServiciu = numeServiciu;
        this.data = new Data(zi,luna,an);
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getPrenumeClient() {
        return prenumeClient;
    }

    public void setPrenumeClient(String prenumeClient) {
        this.prenumeClient = prenumeClient;
    }

    public String getMarcaMasina() {
        return marcaMasina;
    }

    public void setMarcaMasina(String marcaMasina) {
        this.marcaMasina = marcaMasina;
    }

    public String getNumeServiciu() {
        return numeServiciu;
    }

    public void setNumeServiciu(String numeServiciu) {
        this.numeServiciu = numeServiciu;
    }


    public static Rezervari[] addRezervare(Rezervari [] rezervari, Rezervari rezervare) {
        if(rezervari == null) {
            rezervari = new Rezervari[]{ rezervare };
            return rezervari;
        }
        ArrayList<Rezervari> temp = new ArrayList<Rezervari>();
        for(int i = 0; i < rezervari.length; i++) {
            temp.add(rezervari[i]);
        }
        temp.add(rezervare);
        rezervari = temp.toArray(new Rezervari[temp.size()]);
        return rezervari;
    }

    public static Rezervari[] removeRezervare(Rezervari [] rezervari, int index) {
        ArrayList<Rezervari> temp = new ArrayList<Rezervari>();
        for(int i = 0; i < rezervari.length; i++) {
            if(i != index)
                temp.add(rezervari[i]);
        }
        rezervari = temp.toArray(new Rezervari[temp.size()]);
        return rezervari;
    }

    @Override
    public String toString() {
        return "Rezervari{" +
                "numeClient='" + numeClient + '\'' +
                ", prenumeClient='" + prenumeClient + '\'' +
                ", marcaMasina='" + marcaMasina + '\'' +
                ", numeServiciu='" + numeServiciu + '\'' +
                ", data=" + data +
                '}';
    }





}
