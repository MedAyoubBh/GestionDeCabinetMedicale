package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OO.Patient;

public class PatientDAO {
	
	public static void AjoutPatient(Patient f) {
			try {
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "med53226555";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user,passwd);
			
				PreparedStatement s =conn.prepareStatement("INSERT INTO public.\"Patient\"(\"Cin\",\"Fname\",\"Lname\",\"Adr\",\"Postal\",\"Vill\",\"Email\",\"Phonenum\",\"Profession\",\"Sexe\",\"Sgrp\",\"Civility\",\"Dnes\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
				s.setInt(1, f.getCin());	
				s.setString(2,f.getFname());
				s.setString(3,f.getLname());
				s.setString(4,f.getAdr());
				s.setString(5,f.getPostal());
				s.setString(6,f.getVill());
				s.setString(7,f.getEmail());
				s.setString(8,f.getPhonenum());
				s.setString(9,f.getProfession());
				s.setString(10,f.getSexe());
				s.setString(11,f.getSgrp());
				s.setString(12,f.getCivility());
				s.setDate(13,f.getDnes());
				s.executeUpdate();
				System.out.println("Ajout de Patient effectué avec succés!!");
				conn.close ();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
	}
			
			public static void SupprimerPatient(int cin) {
				try {
					String url = "jdbc:postgresql://localhost:5432/projet";
					String user = "postgres";
					String passwd = "med53226555";
					Class.forName("org.postgresql.Driver");
					Connection conn = DriverManager.getConnection(url, user,passwd);
				
					PreparedStatement s =conn.prepareStatement("DELETE FROM public.\"Patient\" WHERE \"Cin\" = ?;");
					s.setInt(1, cin);
					s.executeUpdate();
					System.out.println("Suppression de Patient effectué avec succés!!");
					conn.close ();
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
			
			@SuppressWarnings("finally")
			public static Patient RechercherPatient(int cin) {
				Patient f = null;
				try {
					String url = "jdbc:postgresql://localhost:5432/projet";
					String user = "postgres";
					String passwd = "med53226555";
					Class.forName("org.postgresql.Driver");
					Connection conn = DriverManager.getConnection(url, user,passwd);
				
					PreparedStatement s =conn.prepareStatement("Select * from public.\"Patient\" WHERE \"Cin\" = ?;");
					s.setInt(1, cin);
					ResultSet rs = s.executeQuery();
					f = new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getDate(13));
					conn.close ();
				} catch (Exception exp) {
					exp.printStackTrace();
				}finally {
					return f;
				}
			}

	
}
