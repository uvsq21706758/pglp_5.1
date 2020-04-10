package pglp_5.ser;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

public class Personne1DAO extends DAO<Personne1>{

	public Personne1DAO(int id) throws IOException {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	public Personne1 create(Personne1 obj) throws IOException{
		objetout.writeObject(obj);
		return obj;
	}

	public Personne1 find(String id) throws IOException, ClassNotFoundException{
		File s= new File(id + ".txt");
        Object deserializer = null;
        if (s.exists()) {
            byte[] content = Files.readAllBytes(s.toPath());
            deserializer = deserialize(content);
        }
        Personne1 personne= (Personne1) deserializer;
        personne.print();
        return personne;
	}

	public Personne1 update(Personne1 obj) throws IOException {
		fichier.delete();
		this.create(obj);
		return obj;
	}

	public void delete(Personne1 obj) {
		fichier.delete();
	}

}
