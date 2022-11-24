package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Client;


public class ClientService implements IDao<Client> {

	

	public ClientService() {
		
	}

	@Override
	public boolean create(Client o) {
		
		
		try {
			String req=" insert into client values(null,?,?,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getTelephone());
			ps.setString(3, o.getEmail());
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
	public boolean delete(Client o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from client where id=?";
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
	public boolean update(Client newClient) {

		try {
			String req=" update client set nom = ? , telephone = ? , email = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, newClient.getNom());
			ps.setString(2, newClient.getTelephone());
			ps.setString(3, newClient.getEmail());
			ps.setInt(4, newClient.getId());
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
	public Client findById(int id) {
		
		try {
			String req = "select * from client where id = ?";
			PreparedStatement ps;
			ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			String req = "select * from client";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
