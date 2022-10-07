package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import OO.Consultation;

public class ConsultationDAO {
	public static void AjoutConsultation(Consultation f) {
		try {
			String url = "jdbc:postgresql://localhost:5432/projet";
			String user = "postgres";
			String passwd = "med53226555";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user,passwd);
		
			PreparedStatement s =conn.prepareStatement("INSERT INTO public.\"Consultation\"(\"codePatient\",\"date\",\"type\",\"remarque\") VALUES (?,?,?,?);");
			s.setInt(1, f.getCodePatient());	
			s.setDate(2,f.getDate());
			s.setString(3,f.getType());
			s.setString(4,f.getRemarque());
			s.executeUpdate();
			System.out.println("Ajout de consultation effectué avec succés!!");
			conn.close ();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
}
		
		public static void SupprimerConsultation(int id) {
			try {
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "med53226555";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user,passwd);
			
				PreparedStatement s =conn.prepareStatement("DELETE FROM public.\"Consultation\" WHERE \"id\" = ?;");
				s.setInt(1, id);
				s.executeUpdate();
				System.out.println("Suppression de Consultation effectué avec succés!!");
				conn.close ();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		
		@SuppressWarnings({ "finally", "null" })
		public static LinkedList<Consultation> RechercherConsultation(int cin) {
			LinkedList<Consultation> fl = null;
			Consultation f = null;
			try {
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "med53226555";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user,passwd);
			
				PreparedStatement s =conn.prepareStatement("Select * from public.\"Consultation\" WHERE \"codePatient\" = ?;");
				s.setInt(1, cin);
				ResultSet rs = s.executeQuery();
				while(rs.next()) {
					f = new Consultation(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5));
					fl.add(f);
				}
				conn.close ();
			} catch (Exception exp) {
				exp.printStackTrace();
			}finally {
				return fl;
			}
		}


}
