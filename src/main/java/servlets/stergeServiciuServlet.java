package servlets;

import helpers.ServiceHelper;
import model.Rezervari;
import model.ServiceAuto;
import model.Servicii;
import repository.mainRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/stergeServiciuServlet")
public class stergeServiciuServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("servicii", serviceAuto.getServicii());
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("stergeServiciu.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"))-1;
        Servicii[] servicii = serviceAuto.getServicii();
        try{
            mainRepository.stergeServiciu(servicii, index);
        }catch (SQLException e){
            e.printStackTrace();
        }
        servicii = Servicii.removeServiciu(servicii, index);
        serviceAuto.setServicii(servicii);
        req.setAttribute("servicii", servicii);
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaServicii.jsp");
        rs.forward(req,resp);
    }
}
