package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.LigneCommande;

public class LigneCommandeService implements IDao<LigneCommande> {
	CommandeService cs;
	ProduitService ps;
	
	public LigneCommandeService() {
		cs= new CommandeService();
		ps= new ProduitService();
	}
	@Override
	public boolean create(LigneCommande o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into lignecommande values(null,?,?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getCode());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			ps.setDouble(4, o.getPrixVente());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(LigneCommande o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from lignecommande where commande=? and produit=?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getCode());
			ps.setInt(2, o.getProduit().getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(LigneCommande o) {
		// TODO Auto-generated method stub
		try {
			String req=" update lignecommande set quantité = ? , prixVente = ?  where commande = ? and produit= ? and id = ? ";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getQuantite());
			ps.setDouble(2, o.getPrixVente());
			ps.setInt(3, o.getCommande().getCode());
			ps.setInt(4, o.getProduit().getId());
			ps.setInt(5, o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LigneCommande findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from lignecommande where id = ?";
			PreparedStatement pss = Connexion.getConnection().prepareStatement(req);
			pss.setInt(1, id);
			ResultSet rs = pss.executeQuery();
			while (rs.next()) {
				return new LigneCommande(rs.getInt("id"),cs.findById(rs.getInt("commande")),ps.findById(rs.getInt("produit")),rs.getInt("quantité"),rs.getDouble("prixVente"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public List<LigneCommande> findAll() {
		// TODO Auto-generated method stub
		List<LigneCommande> lignecommandes = new ArrayList<LigneCommande>();
		try {
			String req = "select * from lignecommande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				lignecommandes.add(new LigneCommande(cs.findById(rs.getInt("commande")),ps.findById(rs.getInt("produit")),rs.getInt("quantité"),rs.getDouble("prixVente")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignecommandes;
	}
	


}
