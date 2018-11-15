package model;

public class Avoir {

	private Activite id_Act;
	private Apprenant id_App;
	
	public Avoir() {
		super();
	}

	public Avoir(Activite id_Act, Apprenant id_App) {
		super();
		this.id_Act = id_Act;
		this.id_App = id_App;
	}

	public Activite getId_Act() {
		return id_Act;
	}

	public void setId_Act(Activite id_Act) {
		this.id_Act = id_Act;
	}

	public Apprenant getId_App() {
		return id_App;
	}

	public void setId_App(Apprenant id_App) {
		this.id_App = id_App;
	}

	@Override
	public String toString() {
		return "Avoir [id_Act=" + id_Act + ", id_App=" + id_App + "]";
	}
}
