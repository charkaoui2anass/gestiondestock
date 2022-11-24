package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Fournisseur;

public class FournisseurService implements IDao<Fournisseur>{

	
	
	public FournisseurService() {

	}

	@Override
	public boolean create(Fournisseur o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into fournisseur values(null,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNomFour());
			ps.setString(2, o.getTelFour());
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
	public boolean delete(Fournisseur o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from fournisseur where id=?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());

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
	public boolean update(Fournisseur o) {
		// TODO Auto-generated method stub
		try {
			String req=" update fournisseur set nom = ? , telephone = ? , email = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNomFour());
			ps.setString(2, o.getTelFour());
			ps.setInt(3, o.getId());

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
	public Fournisseur findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from fournisseur where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Fournisseur(rs.getInt("id"), rs.getString("nomFour"), rs.getString("telFour"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
		try {
			String req = "select * from fournisseur";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				fournisseurs.add(new Fournisseur(rs.getInt("id"), rs.getString("nomFour"), rs.getString("telFour")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fournisseurs;
	}
	

}
