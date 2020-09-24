package servlets;

import helpers.ServiceHelper;
import model.ServiceAuto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/afiseazaRezervariServlet")
public class afiseazaRezervariServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rezervari", serviceAuto.getRezervari());
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaRezervari.jsp");
        rs.forward(req,resp);
    }
}
