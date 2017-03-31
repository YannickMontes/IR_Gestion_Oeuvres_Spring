package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.Adherent;
import com.epul.oeuvres.metier.Oeuvrevente;
import com.epul.oeuvres.metier.Proprietaire;
import com.epul.oeuvres.metier.Reservation;
import com.epul.oeuvres.persistance.DialogueBd;

import java.text.SimpleDateFormat;
import java.util.*;

public class Service {

    // Mise � jour des caract�ristiques d'un adh�rent
    // Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
    // une cr�ation

    public void insertAdherent(Adherent unAdherent) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
                    + unAdherent.getNomAdherent();
            mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    // gestion des adherents
    // Consultation d'un adh�rent par son num�ro
    // Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
    // BDD
    public Adherent consulterAdherent(int numero) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        try {
            String mysql = "select * from adherent where id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, numero);
            mParams.put(0, mParam);
            List<Adherent> mesAdh = consulterListeAdherents(mysql, mParams);
            if (mesAdh.isEmpty())
                return null;
            else {
                return mesAdh.get(0);
            }
        } catch (MonException e) {
            throw e;
        }
    }

    // gestion des adherents
    // Modification d'un adherent dans la BD, à partir d'un adhérent passé en paramètres
    // BDD
    public void supprimerAdherent(Integer id) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            String mysql = "DELETE FROM adherent WHERE id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }

    // gestion des adherents
    // Modification d'un adherent dans la BD, à partir d'un adhérent passé en paramètres
    // BDD
    public void modifierAdherent(Adherent unAdherent) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            String mysql = "UPDATE adherent SET nom_adherent = ?, prenom_adherent = ?, ville_adherent = ? WHERE id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, unAdherent.getNomAdherent());
            mParam.put(2, unAdherent.getPrenomAdherent());
            mParam.put(3, unAdherent.getVilleAdherent());
            mParam.put(4, unAdherent.getIdAdherent());
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }

    // Consultation des adh�rents
    // Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
    // la requ�te BDD
    public List<Adherent> consulterListeAdherents() throws MonException {
        String mysql = "select * from adherent";
        return consulterListeAdherents(mysql, null);
    }

    private List<Adherent> consulterListeAdherents(String mysql, Map params) throws MonException {
        List<Object> rs;
        List<Adherent> mesAdherents = new ArrayList<Adherent>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            if (params == null) {
                rs = unDialogueBd.lecture(mysql);
            } else {
                rs = unDialogueBd.lectureParametree(mysql, params);
            }
            while (index < rs.size()) {
                // On cr�e un stage
                Adherent unA = new Adherent();
                // il faut redecouper la liste pour retrouver les lignes
                unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
                unA.setNomAdherent(rs.get(index + 1).toString());
                unA.setPrenomAdherent(rs.get(index + 2).toString());
                unA.setVilleAdherent(rs.get(index + 3).toString());
                // On incr�mente tous les 3 champs
                index = index + 4;
                mesAdherents.add(unA);
            }

            return mesAdherents;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }


    // Consultation des oeuvres
    // Fabrique et renvoie une liste d'objets oeuvres ventes
    public List<Oeuvrevente> consulterListeOeuvres() throws MonException {
        String mysql = "select * from oeuvrevente";
        return consulterListeOeuvres(mysql, null);
    }

    public List<Oeuvrevente> consulterListeOeuvresLibres() throws MonException {
        String mysql = "select * from oeuvrevente WHERE etat_oeuvrevente = 'L'";
        return consulterListeOeuvres(mysql, null);
    }


    private List<Oeuvrevente> consulterListeOeuvres(String mysql, Map params) throws MonException {
        List<Object> rs;
        List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            if (params == null) {
                rs = unDialogueBd.lecture(mysql);
            } else {
                rs = unDialogueBd.lectureParametree(mysql, params);
            }
            while (index < rs.size()) {
                Oeuvrevente ov = new Oeuvrevente();

                // il faut redecouper la liste pour retrouver les lignes

                ov.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
                ov.setTitreOeuvrevente(rs.get(index + 1).toString());
                ov.setEtatOeuvrevente(rs.get(index + 2).toString());
                ov.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
                ov.setProprietaire(rechercherProprietaire(Integer.parseInt(rs.get(index + 4).toString())));

                // On incr�mente tous les 5 champs
                index = index + 5;
                mesOeuvres.add(ov);
            }

            return mesOeuvres;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public List<Proprietaire> consulterListeProprietaires() throws MonException {
        List<Object> rs;
        List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = unDialogueBd.lecture("select * from proprietaire");

            while (index < rs.size()) {
                Proprietaire p = new Proprietaire();

                // il faut redecouper la liste pour retrouver les lignes
                p.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
                p.setNomProprietaire(rs.get(index + 1).toString());
                p.setPrenomProprietaire(rs.get(index + 2).toString());

                // On incr�mente tous les 3 champs
                index = index + 3;
                proprietaires.add(p);
            }

            return proprietaires;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public Oeuvrevente rechercherOeuvreIdParam(int id) throws MonException {

        String mysql = "";
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Oeuvrevente uneOeuvre = null;
        ;
        try {
            mysql = "SELECT id_oeuvrevente, titre_oeuvrevente, etat_oeuvrevente,prix_oeuvrevente,id_proprietaire";
            mysql += " FROM Oeuvrevente WHERE id_Oeuvrevente = ? ";
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(mysql, mParams);
            if (rs.size() > 0) {

                uneOeuvre = new Oeuvrevente();
                uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(0).toString()));
                uneOeuvre.setTitreOeuvrevente(rs.get(1).toString());
                uneOeuvre.setEtatOeuvrevente(rs.get(2).toString());
                uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(3).toString()));
                int num = Integer.parseInt(rs.get(4).toString());
                // On appelle la recherche d'un propri�taire
                uneOeuvre.setProprietaire(rechercherProprietaire(num));
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return uneOeuvre;

    }

    public void insertOeuvreVente(Oeuvrevente ov) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvreVente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  " + "values ('"
                    + ov.getTitreOeuvrevente();
            mysql += "'" + ",'" + ov.getEtatOeuvrevente() + "'," + ov.getPrixOeuvrevente() + "," + ov.getProprietaire().getIdProprietaire() + ")";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }


    public Proprietaire rechercherProprietaire(int id) throws MonException {
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Proprietaire unProprietaire = null;
        String requete = " select * from Proprietaire where id_Proprietaire = ?";
        try {
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(requete, mParams);
            if (rs.size() > 0) {
                unProprietaire = new Proprietaire();

                unProprietaire.setIdProprietaire(Integer.parseInt(rs.get(0).toString()));
                unProprietaire.setNomProprietaire(rs.get(1).toString());
                unProprietaire.setPrenomProprietaire(rs.get(2).toString());
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return unProprietaire;
    }


    public void modifierOeuvre(Oeuvrevente ov) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            String mysql = "UPDATE oeuvrevente SET titre_oeuvrevente = ?, etat_oeuvrevente = ?, prix_oeuvrevente = ?, id_proprietaire = ? WHERE id_oeuvrevente = ?";
            mParam = new HashMap();
            mParam.put(1, ov.getTitreOeuvrevente());
            mParam.put(2, ov.getEtatOeuvrevente());
            mParam.put(3, ov.getPrixOeuvrevente());
            mParam.put(4, ov.getProprietaire().getIdProprietaire());
            mParam.put(5, ov.getIdOeuvrevente());
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }

    public void supprimerOeuvre(Integer id) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            String mysql = "DELETE FROM oeuvrevente WHERE id_oeuvrevente = ?";
            mParam = new HashMap();
            mParam.put(1, id);
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }






    public void insertReservation(Reservation resa) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            Date date = resa.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
            java.sql.Date dateDB = new java.sql.Date(date.getTime());

            mysql = "insert into reservation  (id_oeuvrevente, id_adherent, date_reservation, statut)  " + "values ("
                    + resa.getOeuvrevente().getIdOeuvrevente();
            mysql += "," + resa.getAdherent().getIdAdherent() + ",'" + dateDB + "', 'en attente')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public List<Reservation> consulterListeReservations() throws MonException {
        List<Object> rs;
        List<Reservation> reservations = new ArrayList<Reservation>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = unDialogueBd.lecture("select * from reservation");

            while (index < rs.size()) {
                Reservation res = new Reservation();

                // il faut redecouper la liste pour retrouver les lignes
                res.setOeuvrevente(rechercherOeuvreIdParam(Integer.parseInt(rs.get(index + 0).toString())));
                res.setAdherent(consulterAdherent(Integer.parseInt(rs.get(index + 1).toString())));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(rs.get(index + 2).toString());
                res.setDate(date);

                res.setStatut(rs.get(index + 3).toString());

                // On incr�mente tous les 3 champs
                index = index + 4;
                reservations.add(res);
            }

            return reservations;
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public Reservation rechercherReservation(int idOeuvre, int idAdherent) throws MonException {

        String mysql = "";
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Reservation resa = null;

        try {
            mysql = "SELECT * FROM reservation WHERE id_oeuvrevente = ? AND id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, idOeuvre);
            mParam.put(2, idAdherent);
            mParams.put(0, mParam);
            rs = DialogueBd.getInstance().lectureParametree(mysql, mParams);

            if (rs.size() > 0) {

                resa = new Reservation();
                resa.setOeuvrevente(rechercherOeuvreIdParam(Integer.parseInt(rs.get(0).toString())));
                resa.setAdherent(consulterAdherent(Integer.parseInt(rs.get(1).toString())));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(rs.get(2).toString());
                resa.setDate(date);

                resa.setStatut(rs.get(3).toString());
            }
        } catch (MonException e) {
            throw e;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
        return resa;

    }

    public void modifierReservation(Reservation resa) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            Date date = resa.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dateDB = new java.sql.Date(date.getTime());

            String mysql = "UPDATE reservation SET date_reservation = ?, statut = ? WHERE id_oeuvrevente = ? AND id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, dateDB);
            mParam.put(2, resa.getStatut());
            mParam.put(3, resa.getOeuvrevente().getIdOeuvrevente());
            mParam.put(4, resa.getAdherent().getIdAdherent());
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }

    public void supprimerReservation(Integer idOeuvre, Integer idAdherent) throws MonException {

        Map mParams = new HashMap();
        Map mParam;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        try {
            String mysql = "DELETE FROM reservation WHERE id_oeuvrevente = ? AND id_adherent = ?";
            mParam = new HashMap();
            mParam.put(1, idOeuvre);
            mParam.put(2, idAdherent);
            mParams.put(0, mParam);

            unDialogueBd.modificationDB(mysql, mParams);
        } catch (MonException e) {
            throw e;
        }
    }
}
