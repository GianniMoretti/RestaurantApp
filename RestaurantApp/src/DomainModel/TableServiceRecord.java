package DomainModel;

import java.util.Date;

public class TableServiceRecord {
	/*
	 * TODO: serve? Creato al momento della distruzione...
	 * TODO: ragionare su metodo save
	 */
	private String nominative;
	private String phoneNumber;
	private Date date;
	
	public TableServiceRecord(String nominative,String phoneNumber,Date date) {
		this.nominative=nominative;
		this.phoneNumber=phoneNumber;
		this.date=date;
	}

	public String getNominative() {
		return nominative;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getDate() {
		return date;
	}
	
}
