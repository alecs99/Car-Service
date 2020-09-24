package repository;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mainRepository {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD= "12345678";
    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM angajati";
    private static final String GET_ALL_RESERVATIONS = "SELECT * FROM rezervari";
    private static final String GET_ALL_SERVICES = "SELECT * FROM servicii";
    private static final String ADD_EMPLOYEE = "INSERT INTO angajati(nume, prenume, pozitie, salariu, atributie, bonus) " +
                                               "values(?,?,?,?,?,?)";
    private static final String ADD_RESERVATION = "INSERT INTO rezervari(Nume, Prenume, Masina, Serviciu, Data)" +
                                                "values(?,?,?,?,?)";
    private static final String ADD_SERVICE = "INSERT INTO servicii(nume, cost, durata, operatiune, `inlocuire piesa/e`, dificultate)"+
                                              "values(?,?,?,?,?,?)";
    private static final String REMOVE_EMPLOYEE = "DELETE FROM angajati WHERE nume = ? AND prenume = ?";
    private static final String REMOVE_RESERVATION = "DELETE FROM rezervari WHERE Nume = ? AND data = ?";
    private static final String REMOVE_SERVICE = "DELETE FROM servicii WHERE operatiune = ?";
    private static final String SET_SALARY = "UPDATE angajati SET salariu = ? WHERE nume = ? AND prenume = ?;";

    public static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
    }

    public List<Angajat> getAngajati() throws SQLException{
        List<Angajat> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(GET_ALL_EMPLOYEES);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            if(rs.getString(4).equals("Mecanic")){
                Angajat a = new Mecanic(rs.getString(2), rs.getString(3), rs.getDouble(5),
                                        rs.getString(6), rs.getDouble(7));
                returnedList.add(a);
            }else{
                Angajat a = new Casier(rs.getString(2), rs.getString(3), rs.getDouble(5));
                returnedList.add(a);
            }
        }
        return returnedList;
    }

    public Rezervari[] getRezervari() throws SQLException{
        Rezervari[] returnedArray = null;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(GET_ALL_RESERVATIONS);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Rezervari rezervare = new Rezervari(rs.getString(2), rs.getString(3), rs.getString(4),
                                                rs.getString(5), rs.getString(6));
            returnedArray = Rezervari.addRezervare(returnedArray, rezervare);
        }
        return returnedArray;
    }

    public Servicii[] getServicii() throws SQLException{
        Servicii[] returnedArray = null;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(GET_ALL_SERVICES);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            if(rs.getString(2).equals("Mecanica")){
                Servicii serviciu = new Mecanica(rs.getString(5), rs.getDouble(3), rs.getDouble(4),
                                                    rs.getBoolean(6));
                returnedArray = Servicii.addServiciu(returnedArray,serviciu);

            } else if(rs.getString(2).equals("Tinichigerie")){
                Servicii serviciu = new Tinichigerie(rs.getString(5), rs.getDouble(3), rs.getDouble(4),
                        rs.getDouble(7));
                returnedArray = Servicii.addServiciu(returnedArray,serviciu);

            } else if(rs.getString(2).equals("Vulcanizare")){
                Servicii serviciu = new Vulcanizare(rs.getString(5), rs.getDouble(3), rs.getDouble(4));
                returnedArray = Servicii.addServiciu(returnedArray,serviciu);
            }
        }
        return returnedArray;
    }

    public boolean addAngajat(Angajat a) throws SQLException{
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(ADD_EMPLOYEE);
        preparedStatement.setString(1, a.getNumeAngajat());
        preparedStatement.setString(2, a.getPrenumeAngajat());
        preparedStatement.setString(3, a.getPozitie());
        preparedStatement.setDouble(4, a.getSalariu());
        if(a.getPozitie().equals("Mecanic")){
            Mecanic m = (Mecanic)a;
            preparedStatement.setString(5, m.getAtributie());
            preparedStatement.setDouble(6, m.getBonus());
        }else{
            preparedStatement.setString(5,null);
            preparedStatement.setDouble(6, 0);
        }
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean addRezervare(Rezervari r) throws SQLException{
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(ADD_RESERVATION);
        preparedStatement.setString(1, r.getNumeClient());
        preparedStatement.setString(2, r.getPrenumeClient());
        preparedStatement.setString(3, r.getMarcaMasina());
        preparedStatement.setString(4, r.getNumeServiciu());
        preparedStatement.setString(5, r.getData());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean addServiciu(Servicii s) throws SQLException{
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(ADD_SERVICE);
        preparedStatement.setString(1, s.getTipServiciu());
        preparedStatement.setDouble(2, s.getCostServiciu());
        preparedStatement.setDouble(3, s.getDurataExecutie());
        if(s.getTipServiciu().equals("Mecanica")){
            Mecanica m = (Mecanica) s;
            preparedStatement.setString(4, m.getOperatiune());
            preparedStatement.setBoolean(5,m.isInlocuirePiesa());
            preparedStatement.setDouble(6, 0);
        }else if(s.getTipServiciu().equals("Tinichigerie")){
            Tinichigerie t = (Tinichigerie) s;
            preparedStatement.setString(4, t.getOperatiune());
            preparedStatement.setBoolean(5, false);
            preparedStatement.setDouble(6, t.getGradDificultate());
        }else if(s.getTipServiciu().equals("Vulcanizare")){
            Vulcanizare v = (Vulcanizare) s;
            preparedStatement.setString(4, v.getOperatiune());
            preparedStatement.setBoolean(5, false);
            preparedStatement.setDouble(6, 0);
        }
        return preparedStatement.executeUpdate() > 0;
    }
    public boolean stergeAngajat(List<Angajat> angajati, int index) throws SQLException{
        int indexAngajat = 0;
        String nume = null;
        String prenume = null;
        for(Angajat angajat: angajati){
            if(index == indexAngajat){
                nume = angajat.getNumeAngajat();
                prenume = angajat.getPrenumeAngajat();
                break;
            }
            indexAngajat++;
        }
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(REMOVE_EMPLOYEE);
        preparedStatement.setString(1, nume);
        preparedStatement.setString(2, prenume);
        return preparedStatement.executeUpdate() > 0;
    }
    public boolean stergeRezervare(Rezervari [] rezervari, int index) throws SQLException{
        int indexRezervare = 0;
        String nume =  null;
        String data = null;
        for(Rezervari rezervare:rezervari){
            if(index == indexRezervare){
                nume = rezervare.getNumeClient();
                data = rezervare.getData();
                break;
            }
            indexRezervare++;
        }
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(REMOVE_RESERVATION);
        preparedStatement.setString(1, nume);
        preparedStatement.setString(2, data);
        return preparedStatement.executeUpdate() > 0;
    }
    public boolean stergeServiciu(Servicii [] servicii, int index) throws SQLException{
        int indexServiciu = 0;
        String operatiune =  null;
        for(Servicii serviciu:servicii){
            if(index == indexServiciu){
               if(serviciu instanceof Mecanica){
                   Mecanica m = (Mecanica) serviciu;
                   operatiune = m.getOperatiune();
                   break;
               }
                if(serviciu instanceof Tinichigerie){
                    Tinichigerie t = (Tinichigerie) serviciu;
                    operatiune = t.getOperatiune();
                    break;
                }
                if(serviciu instanceof Vulcanizare){
                    Vulcanizare v = (Vulcanizare) serviciu;
                    operatiune = v.getOperatiune();
                    break;
                }

            }
            indexServiciu++;
        }

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(REMOVE_SERVICE);
        preparedStatement.setString(1, operatiune);
        return preparedStatement.executeUpdate() > 0;
    }
    public boolean actualizeazaSalariu(List<Angajat> angajati, double salariu, int index) throws SQLException{
        int indexAngajat = 0;
        String nume = null;
        String prenume = null;
        for(Angajat angajat: angajati){
            if(index == indexAngajat){
                nume = angajat.getNumeAngajat();
                prenume = angajat.getPrenumeAngajat();
                break;
            }
            indexAngajat++;
        }
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(SET_SALARY);
        preparedStatement.setDouble(1, salariu);
        preparedStatement.setString(2, nume);
        preparedStatement.setString(3, prenume);
        return preparedStatement.executeUpdate() > 0;
    }
}
