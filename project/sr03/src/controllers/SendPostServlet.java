package controllers;

/**
 * Created by tompu on 29/04/2017.
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Post;
import models.Researcher;
import forms.ConnexionForm;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import resources.PostResource;
import resources.TopicResource;
import services.HibernateUtil;
import services.PostService;
import services.TopicService;



public class SendPostServlet extends HttpServlet {
    public static final String VUE              = "/index.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";


    public static String escapeHTML(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
                out.append("&#");
                out.append((int) c);
                out.append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        //Récupérer les données du post
        String txt = escapeHTML(request.getParameter("text"));
        int ideaId = Integer.parseInt( request.getParameter("ideaId"));
        int topicId = Integer.parseInt( request.getParameter("topicId"));

        System.out.println(txt);
        //Récupération de la session
        HttpSession session  = request.getSession();
        if(session.getAttribute(ATT_SESSION_USER) != null)
        {
            //Création du post
            Post post = new Post();
            post.setText(txt);
            post.setDate(new Timestamp(System.currentTimeMillis()));
            post.setResearcher((Researcher)session.getAttribute(ATT_SESSION_USER));
            post.setTopic(new TopicService().getTopic(ideaId,topicId,null));


            //Ajout du post
            PostService service = new PostService();
            service.addPost(post);
        }


    }
}