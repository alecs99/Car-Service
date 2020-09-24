package servlets;

import helpers.ServiceHelper;
import model.*;
import repository.mainRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adaugaServiciuServlet")
public class adaugaServiciuServlet extends HttpServlet {
    ServiceAuto serviceAuto = new ServiceHelper().creeazaServiceCuDateInitiale();
    repository.mainRepository mainRepository = new mainRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher rs = req.getRequestDispatcher("adaugaServiciu.jsp");
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operatiune = req.getParameter("operatiune");
        String nume = req.getParameter("nume");
        Double cost = Double.valueOf(req.getParameter("cost"));
        Double durata = Double.valueOf(req.getParameter("durata"));
        if(operatiune.equals("mecanica")){

            Boolean schimb = Boolean.valueOf(req.getParameter("schimbat"));
            Servicii serviciu = new Mecanica(nume, cost, durata, schimb);
            try{
                mainRepository.addServiciu(serviciu);
            }catch(SQLException e){
                e.printStackTrace();
            }
            serviceAuto.addServiciu(serviciu);
            req.setAttribute("servicii", serviceAuto.getServicii());
            RequestDispatcher rs = req.getRequestDispatcher("afiseazaServicii.jsp");
            rs.forward(req,resp);
        }else if(operatiune.equals("tinichigerie")){
            Double dificultate = Double.valueOf(req.getParameter("dificultate"));
            Servicii serviciu = new Tinichigerie(nume, cost, durata, dificultate);
            try{
                mainRepository.addServiciu(serviciu);
            }catch(SQLException e){
                e.printStackTrace();
            }
            serviceAuto.addServiciu(serviciu);
            req.setAttribute("servicii", serviceAuto.getServicii());
            RequestDispatcher rs = req.getRequestDispatcher("afiseazaServicii.jsp");
            rs.forward(req,resp);
        }else{
            Servicii serviciu = new Vulcanizare(nume, cost, durata);
            try{
                mainRepository.addServiciu(serviciu);
            }catch(SQLException e){
                e.printStackTrace();
            }
            serviceAuto.addServiciu(serviciu);
            req.setAttribute("servicii", serviceAuto.getServicii());
            RequestDispatcher rs = req.getRequestDispatcher("afiseazaServicii.jsp");
            rs.forward(req,resp);
        }

    }
}
