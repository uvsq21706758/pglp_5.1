package pglp_5.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Personne1DAO extends DAO<Personne1>{
	
	public Personne1 create(Personne1 obj) throws IOException{
		 FileOutputStream fos = new FileOutputStream(obj.getNom());
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(obj);
	      oos.close();
	        System.out.println("Le fichier est créé!");
	        return obj;
	}

	public Personne1 find(String id) throws IOException, ClassNotFoundException{
		File f = new File(id);
	    Personne1 p = null;
	    if (f.exists()) {
	      
	        FileInputStream fis = new FileInputStream(f);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        p = (Personne1) ois.readObject();
	        ois.close();
	     
	    } else {
	      System.out.println("le fichier n'existe pas");
	    }
	    return p;
    }
	

	public Personne1 update(Personne1 obj) throws IOException {
		 File f = new File(obj.getNom());
		    if (f.exists()) {
                FileOutputStream fos = new FileOutputStream(f);
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		        oos.writeObject(obj);
		        oos.close();
		        System.out.println("Mise a jour effectuée");
		     
		    } else {
		      System.out.println("fichier n'existe pas");
		    }

	        return obj;
	}

	public void delete(Personne1 obj) {
		 File f = new File(obj.getNom());
		    if (f.exists() && f.delete()) {
		      System.out.println("fichier supprimé");
		    } else {
		      System.out.println("fichier n'existe pas");
		    }
	}

}
