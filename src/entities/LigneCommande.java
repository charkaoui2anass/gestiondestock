package entities;

public class LigneCommande {
	private int id;
	private Commande commande;
	private Produit produit;
	private int quantite;
	private double prixVente;

	public LigneCommande(Commande commande, Produit produit, int quantite, double prixVente) {
		
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixVente = prixVente;
	}
	public LigneCommande(int id, Commande commande, Produit produit, int quantite, double prixVente) {
		this.id = id;
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixVente = prixVente;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
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
