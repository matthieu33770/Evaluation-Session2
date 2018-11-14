package model;

public class Possede {
	
	private Activite id;
	private Apprenant id_Apprenant;
	
	
	public Possede() {
		super();
	}


	public Possede(Activite id, Apprenant id_Apprenant) {
		super();
		this.id = id;
		this.id_Apprenant = id_Apprenant;
	}


	public Activite getId() {
		return id;
	}


	public void setId(Activite id) {
		this.id = id;
	}


	public Apprenant getId_Apprenant() {
		return id_Apprenant;
	}


	public void setId_Apprenant(Apprenant id_Apprenant) {
		this.id_Apprenant = id_Apprenant;
	}


	@Override
	public String toString() {
		return "Possede [id=" + id + ", id_Apprenant=" + id_Apprenant + "]";
	}
	
	

}
