package forms;

/**
 * Created by tompu on 29/04/2017.
 */

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Researcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.security.MessageDigest;


public final class ConnexionForm {
    private static final String CHAMP_USERNAME  = "username";
    private static final String CHAMP_PASS   = "motdepasse";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public Researcher connectResearcher( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String username = getValeurChamp( request, CHAMP_USERNAME );
        String password = getValeurChamp( request, CHAMP_PASS );

        Researcher researcher = new Researcher();

        /* Validation du champ username. */
        try {
            validationUsername( username );
        } catch ( Exception e ) {
            setErreur( CHAMP_USERNAME, e.getMessage() );
        }

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }

        /* Hashage du mot de passe */
        try
        {
            password = sha256(password+username);
        }catch (NoSuchAlgorithmException E){
            setErreur( CHAMP_PASS, "Erreur d'opération sur le mot de passe." );}

        //RECUPERER DES DONNEES
        if ( erreurs.isEmpty() ) {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Query query = session.createQuery("from Researcher R where R.username = :username AND R.password = :pass");
            query.setParameter("username", username);
            query.setParameter("pass", password);
            ArrayList<Researcher> researcherList = (ArrayList<Researcher>) query.list();

            if (researcherList.size() == 0) {
                setErreur("all", "Le nom d'utilisateur ou le mot de passe ne correspond pas.");
            }
            else
                researcher = researcherList.get(0);
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion." + erreurs;
        }

        return researcher;
    }

    /**
     * Valide l'adresse email saisie.
     */
        private void validationUsername( String username ) throws Exception {

        if ( username.length() < 4 ) {
            throw new Exception( "Longueur du nom d'utilisateur invalide." );
        }
        if ( username == null  ) {
            throw new Exception( "Merci de saisir un nom d'utilisateur valide." );
        }
    }

    private void validationEmail( String email ) throws Exception {

        if ( email.length() < 5 ) {
            throw new Exception( "Longueur d'email invalide." );
        }
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}