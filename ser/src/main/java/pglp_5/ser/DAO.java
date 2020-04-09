package pglp_5.ser;

import java.io.*;
import java.io.IOException;

public abstract class DAO <T>{
	
	//protected Connection connect = /* ... */;
	protected File fichier;
    protected FileOutputStream fichout;
    protected ObjectOutputStream objetout;
    
    public DAO(int id) throws IOException{
    	fichier = new File(id +".txt");
    	fichout = new FileOutputStream(fichier);
    	objetout = new ObjectOutputStream(fichout);
    }
    
	public abstract T create(T obj) throws IOException;
   
	public abstract T find(String id) throws IOException, ClassNotFoundException;
    
	public abstract T update(T obj) throws IOException;
    
	public abstract void delete(T obj);
	
    public Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
	        ByteArrayInputStream arr= new ByteArrayInputStream(bytes);
	        ObjectInputStream objin= new ObjectInputStream(arr);
	        return objin.readObject();
	    }
	    
    public byte[] serialize(final Object obj) throws IOException {
	        ByteArrayOutputStream arr= new ByteArrayOutputStream();
	        ObjectOutputStream objout = new ObjectOutputStream(arr);
	        objout.writeObject(obj);
	        return arr.toByteArray();
	    }
}
