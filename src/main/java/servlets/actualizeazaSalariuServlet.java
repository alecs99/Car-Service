package servlets;

import helpers.ServiceHelper;
import model.Angajat;
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

@WebServlet("/actualizeazaSalariuServlet")
public class actualizeazaSalariuServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("angajati", serviceAuto.getAngajati());
        resp.setContentType("text/html");
        RequestDispatcher rs = req.getRequestDispatcher("actualizeazaSalariu.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"))-1;
        double salariu = Double.parseDouble(req.getParameter("salariu"));
        List<Angajat> angajati = serviceAuto.getAngajati();
        angajati.get(index).setSalariu(salariu);
        try{
            mainRepository.actualizeazaSalariu(angajati, salariu, index);
        }catch (SQLException e){
            e.printStackTrace();
        }
        req.setAttribute("angajati", angajati);
        RequestDispatcher rs = req.getRequestDispatcher("afiseazaAng.jsp");
        rs.forward(req,resp);
    }
}
