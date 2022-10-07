package OO;

import java.sql.Date;

public class Consultation {
	
	private int id,codePatient;
	private Date date;
	private String type,remarque;
	
	public Consultation(int id, int codePatient, Date date, String type, String remarque) {
		super();
		this.setId(id);
		this.codePatient = codePatient;
		this.date = date;
		this.type = type;
		this.remarque = remarque;
	}

	public int getCodePatient() {
		return codePatient;
	}

	public void setCodePatient(int codePatient) {
		this.codePatient = codePatient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
