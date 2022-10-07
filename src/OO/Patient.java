package OO;

import java.sql.Date;

public class Patient {
	
	private int Cin;
	private String Fname,Lname,Adr,Postal,Vill,Email,Phonenum,Profession,Sexe,Sgrp,Civility;
	private Date Dnes;
	public Patient(int cin,String fname, String lname, String adr, String postal, String vill, String email, String phonenum,
			String profession, String sexe, String sgrp, String civility, Date dnes) {
		super();
		Cin = cin;
		Fname = fname;
		Lname = lname;
		Adr = adr;
		Postal = postal;
		Vill = vill;
		Email = email;
		Phonenum = phonenum;
		Profession = profession;
		Sexe = sexe;
		Sgrp = sgrp;
		Civility = civility;
		Dnes = dnes;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getAdr() {
		return Adr;
	}
	public void setAdr(String adr) {
		Adr = adr;
	}
	public String getPostal() {
		return Postal;
	}
	public void setPostal(String postal) {
		Postal = postal;
	}
	public String getVill() {
		return Vill;
	}
	public void setVill(String vill) {
		Vill = vill;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhonenum() {
		return Phonenum;
	}
	public void setPhonenum(String phonenum) {
		Phonenum = phonenum;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	public String getSgrp() {
		return Sgrp;
	}
	public void setSgrp(String sgrp) {
		Sgrp = sgrp;
	}
	public String getCivility() {
		return Civility;
	}
	public void setCivility(String civility) {
		Civility = civility;
	}
	public Date getDnes() {
		return Dnes;
	}
	public void setDnes(Date dnes) {
		Dnes = dnes;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		this.Cin = cin;
	}
	
	
	
}
