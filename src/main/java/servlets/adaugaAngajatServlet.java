package servlets;

import helpers.ServiceHelper;
import model.Angajat;
import model.Casier;
import model.Mecanic;
import model.ServiceAuto;
import repository.mainRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adaugaAngajatServlet")
public class adaugaAngajatServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rs = req.getRequestDispatcher("adaugaAngajat.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nume = req.getParameter("numeAngajat");
        String prenume = req.getParameter("prenumeAngajat");
        double salariu = Double.valueOf(req.getParameter("salariu"));
        String atributie = req.getParameter("atributie");
        if(atributie.equals("Casier")){
            Angajat casier = new Casier(nume, prenume, salariu);
            try{
                mainRepository.addAngajat(casier);
            }catch(SQLException e){
                e.printStackTrace();
            }
            serviceAuto.addAngajat(casier);
            req.setAttribute("angajati", serviceAuto.getAngajati());
            RequestDispatcher rs = req.getRequestDispatcher("afiseazaAng.jsp");
            rs.forward(req,resp);
        }else{
            double bonus = Double.parseDouble(req.getParameter("bonus"));
            Angajat mecanic = new Mecanic(nume, prenume, salariu, atributie, bonus);
            try{
                mainRepository.addAngajat(mecanic);
            }catch(SQLException e){
                e.printStackTrace();
            }
            serviceAuto.addAngajat(mecanic);
            req.setAttribute("angajati", serviceAuto.getAngajati());
            RequestDispatcher rs = req.getRequestDispatcher("afiseazaAng.jsp");
            rs.forward(req,resp);
        }
    }
}
