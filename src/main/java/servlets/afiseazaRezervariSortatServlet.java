package servlets;

import helpers.RezervariComparator;
import helpers.ServiceHelper;
import model.Rezervari;
import model.ServiceAuto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/afiseazaRezervariSortatServlet")
public class afiseazaRezervariSortatServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rezervari [] rezervari = serviceAuto.getRezervari();
        RezervariComparator sortareRezervari = new RezervariComparator();
        Arrays.sort(rezervari, sortareRezervari);
        req.setAttribute("rezervari", rezervari);
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaRezervari.jsp");
        rs.forward(req,resp);
    }
}