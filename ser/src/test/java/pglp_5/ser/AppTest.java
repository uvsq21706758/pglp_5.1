package pglp_5.ser;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pglp_5.ser.Personne1.Builder;

import org.junit.*;


public class AppTest 
{
	DAO<Personne1> personne;
	Personne1 employee;
	
	 @Before
	    public void setUp() {
	   
		   personne = DAOFactory.getPersonne1DAO();
	        Numero_telephone portable = new Numero_telephone(Type_tel.portable,"06393939455");
			Builder b = new Builder("elgaamouss","manale", "employee", LocalDate.of(1996,8,27));
			b.Num_telephone(portable);
			Personne1 p = b.build();
			employee = p;
	        
	 }
	 private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
	        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
	        ObjectInputStream o = new ObjectInputStream(b);
	        return o.readObject();
	    }
	private byte[] serialize(final Object obj)throws IOException{
		
		 ByteArrayOutputStream a= new ByteArrayOutputStream(); 
		ObjectOutputStream b = new ObjectOutputStream(a);
		b.writeObject(obj);
		return a.toByteArray();
		
	}
	 @Test
	    public void transfoTest() throws IOException, ClassNotFoundException {
	        Personne1 p = employee;
	        byte[] serialized1 = serialize(p);
	        byte[] serialized2 = serialize(p);

	        Object deserialized1 = deserialize(serialized1);
	        Object deserialized2 = deserialize(serialized2);
	        Assert.assertEquals(deserialized1, deserialized2);
	        Assert.assertEquals(p, deserialized1);
	        Assert.assertEquals(p, deserialized2);
	    }
	@Test
	public void createTest()throws IOException, ClassNotFoundException{
		String nomF = "employee";
		File fichier = new File(nomF);
		personne.create(employee);
		File search = new File(nomF +employee.getNom()+".txt");
		Object deserialisable =null;
		 byte[] fileContent = Files.readAllBytes(search.toPath());
		  deserialisable = deserialize(fileContent);
		  Personne1 perso = (Personne1) deserialisable;
		  assertTrue(fichier.exists());
	        assertTrue(search.exists());
	        assertEquals(perso, employee);
	        personne.delete(employee);
				
	}
	@Test
	public void deleteTest() throws IOException, ClassNotFoundException {      

		
    }
	@Test
    public void findTest() throws IOException, ClassNotFoundException {
		String nomF = "employee";
		File fichier = new File(nomF);
        File search = new File(nomF + "\\" + employee.getPrenom() + ".txt");
        Personne1 expected;
        personne.create(employee);
        
        expected = personne.find("manale");
        
        assertTrue(search.exists());
        assertEquals(expected, employee);
        personne.delete(employee);
    }

}
