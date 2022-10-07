package OO;

public class Ordonnance {
	private int idO;
	private String contenue;
	
	public Ordonnance(int idO, String contenue) {
		super();
		this.idO = idO;
		this.contenue = contenue;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	
	
	
}
