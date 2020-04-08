package pglp_5.ser;

public class DAOFactory {
	 public static DAO<Personne1> getPersonne1DAO(){
	        
	        return new Personne1DAO();
	 }
}
