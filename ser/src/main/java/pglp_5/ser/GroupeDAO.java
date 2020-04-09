package pglp_5.ser;

import java.io.IOException;

public class GroupeDAO extends DAO<Groupe>{

	public GroupeDAO(int id) throws IOException {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Groupe create(Groupe obj) throws IOException {
		Groupe groupe = null;
		return groupe;
	}

	@Override
	public Groupe find(String id) throws IOException, ClassNotFoundException {
		
		Groupe groupe = null;
	    return groupe;
	}

	@Override
	public Groupe update(Groupe obj) throws IOException {
		Groupe groupe= null;
        return groupe;
	}

	@Override
	public void delete(Groupe obj) {
		
	}

}
