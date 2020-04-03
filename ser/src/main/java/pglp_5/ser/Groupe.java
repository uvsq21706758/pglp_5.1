package pglp_5.ser;


import java.io.Serializable;
import java.util.ArrayList;

public class Groupe implements Composite, Serializable{

	private ArrayList<Composite> personnes = new ArrayList<Composite>();
	
	public void print() {
	
		for(Composite composant: personnes) {
			composant.print();
		}
	}
	
	public void add(Composite composant) {
		personnes.add(composant);
	}
	
	public void remove(Composite composant) {
		personnes.remove(composant);
	}
}
