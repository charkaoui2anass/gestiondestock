package test;

import java.util.Date;

import entities.Client;
import entities.Commande;
import entities.Fournisseur;
import entities.LigneCommande;
import entities.Produit;
import entities.Rayon;
import services.ClientService;
import services.CommandeService;
import services.FournisseurService;
import services.LigneCommandeService;
import services.ProduitService;
import services.RayonService;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientService cs = new ClientService();
		cs.create(new Client("ARRAJ mohamed", "0636147570", "mohamed.arraj@emsi-edu.ma"));
		cs.create(new Client("CHARKAOUI anass", "0678731303", "anass.charkaoui@emsi-edu.ma"));
		cs.create(new Client("Rami", "0254879555", "rami@gmail.com"));
		cs.create(new Client("Safi", "0865784554", "safi@gmail.com"));
		//cs.delete(cs.findById(4));
		//cs.update(new Client(3, "SAMIH saad", "0677777777", "saad.samih@emsi-edu.ma"));
		System.out.println(cs.findById(2));
		FournisseurService fs = new FournisseurService();
		fs.create(new Fournisseur("Fournisseur1", "0698551885"));
	    fs.create(new Fournisseur("Fournisseur2", "0524472514"));
		
		
		
		
		System.out.println(cs.findAll());

		
	}

 }
