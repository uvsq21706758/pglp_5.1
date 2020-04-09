package pglp_5.ser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GroupeDAO extends DAO<Groupe>{

	public GroupeDAO(int id) throws IOException {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Groupe create(Groupe obj) throws IOException {
		objetout.writeObject(obj);
		return obj;
	}

	@Override
	public Groupe find(String id) throws IOException, ClassNotFoundException {
		File s= new File(id + ".txt");
        Object deserializer = null;
        if (s.exists()) {
            byte[] content = Files.readAllBytes(s.toPath());
            deserializer = deserialize(content);
        }
        Groupe groupe= (Groupe) deserializer;
        System.out.println(groupe.toString());
        return groupe;
	}

	@Override
	public Groupe update(Groupe obj) throws IOException {
		fichier.delete();
		this.create(obj);
		return obj;
	}

	@Override
	public void delete(Groupe obj) {
		fichier.delete();
	}

}
