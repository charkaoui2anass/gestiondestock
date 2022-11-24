package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Commande;



public class CommandeService implements IDao<Commande> {
	ClientService cs ;
	 

	public CommandeService() {
		cs = new ClientService();
	}

	@Override
	public boolean create(Commande o) {
		try {
			String req=" insert into commande values(?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCode());
			ps.setDate(2, new java.sql.Date(o.getDate().getTime()));
			ps.setInt(3, o.getClient().getId());
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
	public boolean delete(Commande o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from commande where id=?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCode());
		
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
	public boolean update(Commande newCommande) {
		try {
		String req=" update commande set date = ? , client = ?  where code = ?";
		PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
		ps.setDate(1, new java.sql.Date(newCommande.getDate().getTime()));
		ps.setInt(2, newCommande.getClient().getId());
		ps.setInt(3, newCommande.getCode());
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
	public Commande findById(int code) {
		try {
			String req = "select * from commande where code = ?";
			PreparedStatement ps;
			ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Commande(rs.getInt("code"), rs.getDate("date"),cs.findById(rs.getInt("client")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			String req = "select * from commande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"),cs.findById(rs.getInt("client"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commandes;
	}


}
