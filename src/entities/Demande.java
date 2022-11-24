package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {
	private int id;
	private Date date;
	private Fournisseur fournisseur;
	private List<LigneDemande> ligneDemande;
	public Demande( Date date, Fournisseur fournisseur) {
		this.date = date;
		this.fournisseur = fournisseur;
		this.ligneDemande = new ArrayList<LigneDemande>();
	}
	public Demande(int id,Date date, Fournisseur fournisseur) {
		this.id=id;
		this.date = date;
		this.fournisseur = fournisseur;
		this.ligneDemande = new ArrayList<LigneDemande>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public List<LigneDemande> getLigneDemande() {
		return ligneDemande;
	}
	public void setLigneDemande(List<LigneDemande> ligneDemande) {
		this.ligneDemande = ligneDemande;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Demande : " + id + " / " + sdf.format(date);
		
	}
	
	
	
	

}
