package model;

public class Compte {
	public static int c=0;
	private int num ;
	private String nom;
	private float solde ;
	public Compte( String nom, float solde) {
		super();
		this.num = ++c;
		this.nom = nom;
		this.solde = solde;
	}
	
	public Compte() {
	}

	public static int getC() {
		return c;
	}
	public static void setC(int c) {
		Compte.c = c;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
	
}
