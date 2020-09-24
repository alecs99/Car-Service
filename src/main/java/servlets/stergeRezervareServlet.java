package servlets;

import helpers.ServiceHelper;
import model.Angajat;
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
import java.util.List;

@WebServlet("/stergeRezervareServlet")
public class stergeRezervareServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rezervari", serviceAuto.getRezervari());
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("stergeRezervare.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"))-1;
        Rezervari [] rezervari = serviceAuto.getRezervari();
        try{
            mainRepository.stergeRezervare(rezervari, index);
        }catch (SQLException e){
            e.printStackTrace();
        }
        rezervari = Rezervari.removeRezervare(rezervari, index);
        serviceAuto.setRezervari(rezervari);
        req.setAttribute("rezervari", rezervari);
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaRezervari.jsp");
        rs.forward(req,resp);
    }
}
