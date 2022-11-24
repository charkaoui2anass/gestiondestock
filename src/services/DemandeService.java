package services;

import java.util.ArrayList;
import java.util.List;
import dao.IDao;
import entities.Demande;

public class DemandeService implements IDao<Demande>{
	List<Demande> demandes;
	
	
	public DemandeService() {
		
		this.demandes = new ArrayList<Demande>();
	}

	@Override
	public boolean create(Demande o) {
		// TODO Auto-generated method stub
		return demandes.add(o);
	}

	@Override
	public boolean delete(Demande o) {
		// TODO Auto-generated method stub
		return demandes.remove(o);
	}

	@Override
	public boolean update(Demande o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Demande findById(int id) {
		// TODO Auto-generated method stub
		for (Demande s : demandes) {
			if (s.getId() == id)
				return s;
		}
			
		return null;
	}

	@Override
	public List<Demande> findAll() {
		// TODO Auto-generated method stub
		return demandes;
	}

}
