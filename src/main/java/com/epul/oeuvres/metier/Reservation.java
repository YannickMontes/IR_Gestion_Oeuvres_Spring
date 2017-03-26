package com.epul.oeuvres.metier;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Adherent adherent;
	private Oeuvrevente oeuvrevente;
    private String statut;
    private String dateDisplayed;

	public Reservation() {
	}



	public Reservation(Date date, Adherent adherent, Oeuvrevente oeuvrevente, String statut) {
		super();
		this.date = date;
		this.adherent = adherent;
		this.oeuvrevente = oeuvrevente;
		this.statut = statut;
		this.dateDisplayed = "";
	}



	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = df.format(date);
        this.dateDisplayed = dateString;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Oeuvrevente getOeuvrevente() {
		return this.oeuvrevente;
	}

	public void setOeuvrevente(Oeuvrevente oeuvrevente) {
		this.oeuvrevente = oeuvrevente;
	}

    public String getStatut() { return this.statut; }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateDisplayed() { return this.dateDisplayed; }
}