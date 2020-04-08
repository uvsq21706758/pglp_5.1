package pglp_5.ser;

public interface DAO <T>{
	//protected Connection connect = /* ... */;
	public abstract T create(T obj);
   
	public abstract T find(String id);
    
	public abstract T update(T obj);
    
	public abstract void delete(T obj);

}
