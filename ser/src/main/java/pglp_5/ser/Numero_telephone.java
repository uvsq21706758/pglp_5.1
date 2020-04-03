package pglp_5.ser;

public class Numero_telephone {
  
	private Type_tel type;
	private String numero;
	
	public Numero_telephone(Type_tel type,String numero) {
		this.type=type;
		this.numero=numero;
	}
	
	public Type_tel getType() {
		return type;
	}
	
	public String getNumero() {
		return numero;
	}
}
