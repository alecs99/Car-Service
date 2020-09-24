package servlets;

import helpers.ServiceHelper;
import model.Rezervari;
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

@WebServlet("/adaugaRezervareServlet")
public class adaugaRezervareServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rs = req.getRequestDispatcher("adaugaRezervare.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nume = req.getParameter("nume");
        String prenume = req.getParameter("prenume");
        String masina = req.getParameter("masina");
        String tipServiciu = req.getParameter("serviciu");
        String data = req.getParameter("data");
        Rezervari rezervare = new Rezervari(nume, prenume, masina, tipServiciu, data);
        try{
            mainRepository.addRezervare(rezervare);
        }catch(SQLException e){
            e.printStackTrace();
        }
        serviceAuto.addRezervare(rezervare);
        req.setAttribute("rezervari", serviceAuto.getRezervari());
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaRezervari.jsp");
        rs.forward(req,resp);

    }
}
