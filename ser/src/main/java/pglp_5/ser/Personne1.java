package pglp_5.ser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Personne1 implements Composite,Serializable{

	private final String nom;
     private final String prenom;
     private final String fonction;
     private final LocalDate date_naissance;
     private final ArrayList<Numero_telephone> num_telephone;
     
     public static class Builder{
    	 private final String nom;
         private final String prenom;
         private String fonction;
         private LocalDate date_naissance=null;
         private ArrayList<Numero_telephone> num_telephone=null;
        
         public Builder(String nom,String prenom, String fonction, LocalDate date_naissance) {
        	 this.nom=nom;
        	 this.prenom=prenom;
        	 this.fonction = fonction;
 			 this.num_telephone= new ArrayList<Numero_telephone>();
 			 this.date_naissance= date_naissance;
         }
         
         public Builder fonction(String fonction) {
        	 this.fonction=fonction;
        	 return this;
         }
         
         public Builder Date_naissance(LocalDate date_naissance) {
        	 this.date_naissance=date_naissance;
        	 return this;
         }
         
         public Builder Num_telephone(Numero_telephone num_telephone) {
        	  this.num_telephone = new ArrayList<Numero_telephone>();
              this.num_telephone.add(num_telephone);
        	  return this;
         }
       public Personne1 build() {
    	   return new Personne1(this);
       }
     }
     private Personne1(Builder builder) {
 		nom=builder.nom;
 		prenom=builder.prenom;
 		fonction=builder.fonction;
 		num_telephone=builder.num_telephone;
 		date_naissance = builder.date_naissance;
 	}
     
     public String getNom() {
 		return nom;
 	}

 	
 	public String getPrenom() {
 		return prenom;
 	}


 	public String getFonction() {
 		return fonction;
 	}


 	public LocalDate getDate_naissance() {
 		return date_naissance;
 	}

 	
 	public ArrayList<Numero_telephone> getNumero_telephone() {
 		return num_telephone;
 	}
 	
 	public void print() {
		System.out.println(this.nom + " " + this.prenom + ": \nfonction: " 
		+ this.fonction + "\ndate de naissance: "+this.date_naissance + "\n");	
	}
}
