package entities;

public class Fournisseur {
	private int id;
	private String nomFour;
	private String telFour;
	public Fournisseur(String nomFour, String telFour) {
		
		this.nomFour = nomFour;
		this.telFour = telFour;
	}
	public Fournisseur(int id,String nomFour, String telFour) {
		this.id =id;
		this.nomFour = nomFour;
		this.telFour = telFour;
	}
	@Override
	public String toString() {
		return "Fournisseur [nomFour=" + nomFour + ", telFour=" + telFour + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomFour() {
		return nomFour;
	}
	public void setNomFour(String nomFour) {
		this.nomFour = nomFour;
	}
	public String getTelFour() {
		return telFour;
	}
	public void setTelFour(String telFour) {
		this.telFour = telFour;
	}
	 
	
}
