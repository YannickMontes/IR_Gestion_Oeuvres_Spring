package com.epul.oeuvres.controle;


import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Adherent;
import com.epul.oeuvres.metier.Oeuvrevente;
import com.epul.oeuvres.metier.Proprietaire;
import com.epul.oeuvres.metier.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

///
/// Les méthode du contrôleur répondent à des sollicitations
/// des pages JSP

@Controller
public class MultiControleur {

    // /
    // / Liste les adhérents
    // /
    @RequestMapping(value = "listerAdherents.htm")
    public ModelAndView listerAdherents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            Service unService = new Service();
            request.setAttribute("mesAdherents", unService.consulterListeAdherents());
            request.setAttribute("pageName", "Adhérents");
            request.setAttribute("pageName", "Liste des adherents");

            destinationPage = "listerAdherents";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";

        }
        return new ModelAndView(destinationPage);
    }

    // /
    // / Insère  l'adhérent en BDD
    // /
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
        listerAdherents(request, response);
        destinationPage = "listerAdherents";
        request.setAttribute("success", true);
        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire d'ajout d'un adhérent
    // /
    @RequestMapping(value = "ajouterAdherent.htm")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        request.setAttribute("pageName", "Ajouter un adherent");
        try {
            destinationPage = "ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire de modification de l'adhérent
    // /
    @RequestMapping(value = "modifierAdherent.htm")
    public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();
            Adherent ad = unService.consulterAdherent(id);
            request.setAttribute("adherant", ad);
            destinationPage = "modifierAdherent";
            request.setAttribute("pageName", "Modifier un adherent");
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Modifie l'adhérent en BDD
    // /
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
            listerAdherents(request, response);
            destinationPage = "listerAdherents";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Supprime l'adherent en BDD
    // /
    @RequestMapping(value = "supprimerAdherent.htm")
    public ModelAndView supprimerAdherentDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();

            unService.supprimerAdherent(id);
            listerAdherents(request, response);
            destinationPage = "listerAdherents";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Liste les oeuvres
    // /
    @RequestMapping(value = "listerOeuvres.htm")
    public ModelAndView afficherOeuvres(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            Service unService = new Service();
            request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
            request.setAttribute("pageName", "Oeuvres");
            destinationPage = "listerOeuvres";
            request.setAttribute("pageName", "Lister les oeuvres");
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";

        }
        return new ModelAndView(destinationPage);
    }

    // /
    // / Insère  l'oeuvre en BDD
    // /
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
        afficherOeuvres(request, response);
        destinationPage = "listerOeuvres";
        request.setAttribute("success", true);

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire d'ajout d'une oeuvre
    // /
    @RequestMapping(value = "ajouterOeuvre.htm")
    public ModelAndView ajouterOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterOeuvre";
            Service unService = new Service();
            List<Proprietaire> proprietaires = unService.consulterListeProprietaires();
            request.setAttribute("proprietaires", proprietaires);
            request.setAttribute("pageName", "Ajouter une oeuvre");
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire de modification de l'oeuvre
    // /
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
            request.setAttribute("pageName", "Modifier une oeuvre");
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Modifie l'oeuvre en BDD
    // /
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
            afficherOeuvres(request, response);
            destinationPage = "listerOeuvres";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Supprime l'oeuvre en BDD
    // /
    @RequestMapping(value = "supprimerOeuvre.htm")
    public ModelAndView supprimerOeuvreDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Service unService = new Service();

            unService.supprimerOeuvre(id);
            afficherOeuvres(request, response);
            destinationPage = "listerOeuvres";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Insère  la réservation en BDD
    // /
    @RequestMapping(value = "insererReservation.htm")
    public ModelAndView insererReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            Service unService = new Service();

            Reservation res = new Reservation();

            res.setAdherent(unService.consulterAdherent(Integer.parseInt(request.getParameter("adherent"))));

            String dateStr = request.getParameter("dateReservation");
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

            Date dateResa = formater.parse(dateStr);
            res.setDate(dateResa);
            res.setOeuvrevente(unService.rechercherOeuvreIdParam(Integer.parseInt(request.getParameter("oeuvre"))));

            unService.insertReservation(res);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        listerReservations(request, response);
        destinationPage = "listerReservations";
        request.setAttribute("success", true);

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire d'ajout de la réservation
    // /
    @RequestMapping(value = "ajouterReservation.htm")
    public ModelAndView ajouterReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterReservation";
            request.setAttribute("pageName", "Ajouter une réservation");
            Service unService = new Service();
            List<Adherent> adherents = unService.consulterListeAdherents();
            List<Oeuvrevente> oeuvres = unService.consulterListeOeuvres();
            request.setAttribute("adherents", adherents);
            request.setAttribute("oeuvres", oeuvres);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Liste les réservations
    // /
    @RequestMapping(value = "listerReservations.htm")
    public ModelAndView listerReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            Service unService = new Service();
            request.setAttribute("reservations", unService.consulterListeReservations());
            destinationPage = "listerReservations";
            request.setAttribute("pageName", "Lister les réservations");
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";

        }
        return new ModelAndView(destinationPage);
    }

    // /
    // / Affiche le formulaire de modification de la réservation
    // /
    @RequestMapping(value = "modifierReservation.htm")
    public ModelAndView modifierReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        int idOeuvre = Integer.parseInt(request.getParameter("iOeuvre"));
        int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));

        try {
            Service unService = new Service();
            Reservation resa = unService.rechercherReservation(idOeuvre, idAdherent);

            request.setAttribute("reservation", resa);
            destinationPage = "modifierReservation";
            request.setAttribute("pageName", "Modifier une réservation");
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Modifie la réservation en BDD
    // /
    @RequestMapping(value = "modifierReservationDB.htm")
    public ModelAndView modifierReservationDB(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";

        try {
            Service unService = new Service();
            Reservation res = new Reservation();
            int idOeuvre = Integer.parseInt(request.getParameter("oeuvre"));
            int idAdherent = Integer.parseInt(request.getParameter("adherent"));
            String currentStatut = unService.rechercherReservation(idOeuvre, idAdherent).getStatut();

            res.setAdherent(unService.consulterAdherent(Integer.parseInt(request.getParameter("adherent"))));

            String dateStr = request.getParameter("dateReservation");
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date dateResa = formater.parse(dateStr);
            res.setDate(dateResa);
            res.setStatut(currentStatut);

            res.setOeuvrevente(unService.rechercherOeuvreIdParam(idOeuvre));

            unService.modifierReservation(res);
            listerReservations(request, response);
            destinationPage = "listerReservations";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Supprime la réservation en BDD
    // /
    @RequestMapping(value = "supprimerReservation.htm")
    public ModelAndView supprimerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        int idOeuvre = Integer.parseInt(request.getParameter("iOeuvre"));
        int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));

        try {
            Service unService = new Service();

            unService.supprimerReservation(idOeuvre, idAdherent);
            listerReservations(request, response);
            destinationPage = "listerReservations";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Confirmer la réservation en BDD
    // /
    @RequestMapping(value = "confirmerReservation.htm")
    public ModelAndView confirmerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        int idOeuvre = Integer.parseInt(request.getParameter("iOeuvre"));
        int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));

        try {
            Service unService = new Service();
            Reservation res = unService.rechercherReservation(idOeuvre, idAdherent);
            res.setStatut("confirmee");

            unService.modifierReservation(res);
            listerReservations(request, response);
            destinationPage = "listerReservations";
            request.setAttribute("success", true);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = {"/","home"})
    public ModelAndView home2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "home";

        request.setAttribute("pageName", "Tableau de bord");

        try {
            Service unService = new Service();

            request.setAttribute("nbOeuvres", unService.consulterListeOeuvres().size());
            request.setAttribute("nbAdherents", unService.consulterListeAdherents().size());
            request.setAttribute("nbOeuvresLibres", unService.consulterListeOeuvresLibres().size());
        } catch (Exception e) {

        }

        return new ModelAndView(destinationPage);
    }

    // /
    // / Affichage de la page d'erreur
    // /
    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("pageName", "Erreur");

        return new ModelAndView("erreur");
    }
}
