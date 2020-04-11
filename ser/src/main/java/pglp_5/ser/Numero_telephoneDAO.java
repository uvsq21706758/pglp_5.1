package pglp_5.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Numero_telephoneDAO extends DAO<Numero_telephone>{

    @Override
	public Numero_telephone create(Numero_telephone obj) throws IOException {
    	 FileOutputStream fos = new FileOutputStream(obj.getNumero());
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(obj);
	      oos.close();
	        System.out.println("Le fichier est créé!");
	        return obj;
	}

	@Override
	public Numero_telephone find(String id) throws IOException, ClassNotFoundException {
		File f = new File(id);
		Numero_telephone num = null;
	    if (f.exists()) {
	      
	        FileInputStream fis = new FileInputStream(f);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        num = (Numero_telephone) ois.readObject();
	        ois.close();
	     
	    } else {
	      System.out.println("le fichier n'existe pas");
	    }
	    return num;
	}

	@Override
	public Numero_telephone update(Numero_telephone obj) throws IOException {
		File f = new File(obj.getNumero());
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
	public void delete(Numero_telephone obj) {
		 File f = new File(obj.getNumero());
		    if (f.exists() && f.delete()) {
		      System.out.println("fichier supprimé");
		    } else {
		      System.out.println("fichier n'existe pas");
		    }
	}

}
