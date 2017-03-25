package com.epul.oeuvres.controle;


import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Adherent;
import com.epul.oeuvres.metier.Oeuvrevente;
import com.epul.oeuvres.metier.Proprietaire;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

///
/// Les méthode du contrôleur répondent à des sollicitations
/// des pages JSP

@Controller
public class MultiControleur {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

    @RequestMapping(value = "listerAdherent.htm")
    public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            Service unService = new Service();
            request.setAttribute("mesAdherents", unService.consulterListeAdherents());
            destinationPage = "listerAdherent";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererAdherent.htm")
    public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            Adherent unAdherent = new Adherent();
            unAdherent.setNomAdherent(request.getParameter("txtnom"));
            unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
            unAdherent.setVilleAdherent(request.getParameter("txtville"));
            Service unService = new Service();
            unService.insertAdherent(unAdherent);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        destinationPage = "home";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterAdherent.htm")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierAdherent.htm")
    public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();
            Adherent ad = unService.consulterAdherent(id);
            request.setAttribute("adherant", ad);
            destinationPage = "modifierAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierAdherentDB.htm")
    public ModelAndView modifierAdherentDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();
            Adherent ad = unService.consulterAdherent(id);
            ad.setNomAdherent(request.getParameter("txtnom"));
            ad.setPrenomAdherent(request.getParameter("txtprenom"));
            ad.setVilleAdherent(request.getParameter("txtville"));

            unService.modifierAdherent(ad);
            destinationPage = "home";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "supprimerAdherent.htm")
    public ModelAndView supprimerAdherentDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();

            unService.supprimerAdherent(id);
            destinationPage = "home";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "listerOeuvres.htm")
    public ModelAndView afficherOeuvres(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            Service unService = new Service();
            request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
            destinationPage = "listerOeuvres";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";

        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "insererOeuvre.htm")
    public ModelAndView insererOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            Service unService = new Service();

            Oeuvrevente ov = new Oeuvrevente();

            ov.setTitreOeuvrevente(request.getParameter("txttitre"));
            ov.setEtatOeuvrevente(request.getParameter("etat"));
            ov.setPrixOeuvrevente(Float.parseFloat(request.getParameter("numPrix")));
            ov.setProprietaire(unService.rechercherProprietaire(Integer.parseInt(request.getParameter("proprietaire"))));

            unService.insertOeuvreVente(ov);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        destinationPage = "home";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterOeuvre.htm")
    public ModelAndView ajouterOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterOeuvre";
            Service unService = new Service();
            List<Proprietaire> proprietaires = unService.consulterListeProprietaires();
            request.setAttribute("proprietaires", proprietaires);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierOeuvre.htm")
    public ModelAndView modifierOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();
            Oeuvrevente ov = unService.rechercherOeuvreIdParam(id);
            request.setAttribute("oeuvre", ov);
            request.setAttribute("proprietaires", unService.consulterListeProprietaires());
            destinationPage = "modifierOeuvre";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "modifierOeuvreDB.htm")
    public ModelAndView modifierOeuvreDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();
            Oeuvrevente ov = unService.rechercherOeuvreIdParam(id);

            ov.setTitreOeuvrevente(request.getParameter("txttitre"));
            ov.setEtatOeuvrevente(request.getParameter("etat"));
            ov.setPrixOeuvrevente(Float.parseFloat(request.getParameter("numPrix")));
            ov.setProprietaire(unService.rechercherProprietaire(Integer.parseInt(request.getParameter("proprietaire"))));

            unService.modifierOeuvre(ov);
            destinationPage = "home";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "supprimerOeuvre.htm")
    public ModelAndView supprimerOeuvreDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();

            unService.supprimerOeuvre(id);
            destinationPage = "home";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }


    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("home");
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("home");
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("erreur");
    }


}
