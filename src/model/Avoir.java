package model;

public class Avoir {

	private int id_Act;
	private int id_App;
	
	public Avoir() {
		super();
	}

	public Avoir(int id_Act, int id_App) {
		super();
		this.id_Act = id_Act;
		this.id_App = id_App;
	}

	public int getId_Act() {
		return id_Act;
	}

	public void setId_Act(int id_Act) {
		this.id_Act = id_Act;
	}

	public int getId_App() {
		return id_App;
	}

	public void setId_App(int id_App) {
		this.id_App = id_App;
	}

	@Override
	public String toString() {
		return "Avoir [id_Act=" + id_Act + ", id_App=" + id_App + "]";
	}
}
