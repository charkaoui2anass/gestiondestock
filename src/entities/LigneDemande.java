package entities;

public class LigneDemande {
	private Demande demande;
	private Produit produit;
	private int quantite;
	private double prixVente;
	public LigneDemande(Demande demande, Produit produit, int quantite, double prixVente) {
		
		this.demande = demande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixVente = prixVente;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	@Override
	public String toString() {
		return produit.getDesignation() + " Q : " + quantite + " Prix : " + prixVente;
	}
	
	
	

}
