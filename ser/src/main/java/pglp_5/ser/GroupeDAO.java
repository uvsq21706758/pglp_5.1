package pglp_5.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GroupeDAO extends DAO<Groupe>{

	@Override
	public Groupe create(Groupe obj) throws IOException {
		 FileOutputStream fos = new FileOutputStream(obj.getNom());
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(obj);
	      oos.close();
	        System.out.println("Le fichier est créé!");
	        return obj;
	}

	@Override
	public Groupe find(String id) throws IOException, ClassNotFoundException {
		File f = new File(id);
		Groupe grp = null;
	    if (f.exists()) {
	      
	        FileInputStream fis = new FileInputStream(f);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        grp = (Groupe) ois.readObject();
	        ois.close();
	     
	    } else {
	      System.out.println("le fichier n'existe pas");
	    }
	    return grp;
	}

	@Override
	public Groupe update(Groupe obj) throws IOException {
		File f = new File(obj.getNom());
	    if (f.exists()) {
	      
	        FileOutputStream fos = new FileOutputStream(f);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(obj);
	        oos.close();

	     
	    } else {
	      System.out.println("fichier n'existe pas");
	    }

        return obj;
	}

	@Override
	public void delete(Groupe obj) {
		 File f = new File(obj.getNom());
		    if (f.exists() && f.delete()) {
		      System.out.println("fichier supprimé");
		    } else {
		      System.out.println("fichier n'existe pas");
		    }
	}

}
