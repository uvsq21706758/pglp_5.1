package pglp_5.ser;

import java.io.*;
import java.io.IOException;

public abstract class DAO <T>{
	
	public abstract T create(T obj) throws IOException;
   
	public abstract T find(String id) throws IOException, ClassNotFoundException;
    
	public abstract T update(T obj) throws IOException;
    
	public abstract void delete(T obj);
	
}
