package pglp_5.ser;


import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	    @Test
	    public void sauvegarder() throws IOException
	    {
	    	Personne1 p1= new Personne1.Builder("elgaamouss","manale", "employee", LocalDate.of(1996,8,27)).build();

	    	
	    	FileOutputStream file = new FileOutputStream("fichier");
	    	ObjectOutputStream obj = new ObjectOutputStream(file);
	    	obj.writeObject(p1); 
	    	obj.close();
	        
	    }
	    @Test
		public void lire()throws IOException, FileNotFoundException, ClassNotFoundException {
		
				Personne1 p1 = new Personne1.Builder("elgaamouss","manale", "employee", LocalDate.of(1996,8,27)).build();
				FileInputStream file = new FileInputStream("fichier") ;
				ObjectInputStream obj = new ObjectInputStream(file);
				Personne1 perso = (Personne1) obj.readObject() ;
				assertEquals(perso.getNom(),"elgaamouss");
				assertEquals(perso.getPrenom(),"manale");
		
	    }

}
