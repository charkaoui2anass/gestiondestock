package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Rayon;

public class RayonService implements IDao<Rayon>{
	
	
	public RayonService() {
		
	}

	@Override
	public boolean create(Rayon o) {
		// TODO Auto-generated method stub
		try {
			String req=" insert into rayon values(null,?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getCode());
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
	public boolean delete(Rayon o) {
		// TODO Auto-generated method stub
		try {
			String req=" delete from rayon where id=?";
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
	public boolean update(Rayon o) {
		// TODO Auto-generated method stub
		try {
			String req=" update rayon set code = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getCode());
			ps.setInt(2, o.getId());
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
	public Rayon findById(int id) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from rayon where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Rayon(rs.getInt("id"), rs.getString("code"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public Rayon findByCode(String code) {
		// TODO Auto-generated method stub
		try {
			String req = "select * from rayon where code = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Rayon(rs.getInt("id"), rs.getString("code"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Rayon> findAll() {
		// TODO Auto-generated method stub
		List<Rayon> rayons = new ArrayList<Rayon>();
		try {
			String req = "select * from rayon";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
				rayons.add(new Rayon(rs.getInt("id"), rs.getString("code")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rayons;
	}

}
