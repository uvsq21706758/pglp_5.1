package pglp_5.ser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Numero_telephoneDAO extends DAO<Numero_telephone>{

	public Numero_telephoneDAO(int id) throws IOException {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Numero_telephone create(Numero_telephone obj) throws IOException {
		objetout.writeObject(obj);
		return obj;
	}

	@Override
	public Numero_telephone find(String id) throws IOException, ClassNotFoundException {
		File s= new File(id + ".txt");
        Object deserializer = null;
        if (s.exists()) {
            byte[] content = Files.readAllBytes(s.toPath());
            deserializer = deserialize(content);
        }
        Numero_telephone numero_tel= (Numero_telephone) deserializer;
        System.out.println(numero_tel.toString());
        return numero_tel;
	}

	@Override
	public Numero_telephone update(Numero_telephone obj) throws IOException {
		fichier.delete();
		this.create(obj);
		return obj;
	}

	@Override
	public void delete(Numero_telephone obj) {
		fichier.delete();
	}

}
