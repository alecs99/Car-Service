package servlets;

import helpers.AngajatComparator;
import helpers.ServiceHelper;
import model.Angajat;
import model.ServiceAuto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/afiseazaAngajatiSortatServlet")
public class afiseazaAngajatiSortatServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Angajat> angajati = serviceAuto.getAngajati();
        AngajatComparator sortareAngajati = new AngajatComparator();
        Collections.sort(angajati, sortareAngajati);
        req.setAttribute("angajati", angajati );
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaAng.jsp");
        rs.forward(req,resp);
    }
}
