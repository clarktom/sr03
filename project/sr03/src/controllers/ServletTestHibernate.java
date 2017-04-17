package controllers;

import beans.Researcher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.System.out;


/**
 * Created by utilisateur on 17/04/2017.
 */
@WebServlet(name = "ServletTestHibernate", urlPatterns = "/ServletTestHibernate")
public class ServletTestHibernate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding( "UTF-8" );
        PrintWriter out = response.getWriter();


        out.println("<h2>Servlet de test HIBERNATE</h2>");

        //INSERER UNE DONNEE
        /*Researcher rs = new Researcher("yolo","yoloo","yay","earg","aear");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(rs);
        session.getTransaction().commit();*/

        //RECUPERER DES DONNEES
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        ArrayList<Researcher> researcherList = (ArrayList<Researcher>)session.createQuery("from Researcher s").list();
        out.println(researcherList.toString());
        out.println(researcherList.get(0).getName());

    }
}
