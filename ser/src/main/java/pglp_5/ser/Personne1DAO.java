package pglp_5.ser;

import java.io.IOException;
import java.io.Serializable;

public class Personne1DAO extends DAO<Personne1> implements Serializable{

	public Personne1DAO(int id) throws IOException {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	public Personne1 create(Personne1 obj) throws IOException{
		Personne1 personne =null;
		return personne;
	}

	public Personne1 find(String id) throws IOException, ClassNotFoundException{
		Personne1 personne = null;
		return personne;
	}

	public Personne1 update(Personne1 obj) throws IOException {
		
		Personne1 personne = null;
		return personne;
	}

	public void delete(Personne1 obj) {
		
		
	}

}
