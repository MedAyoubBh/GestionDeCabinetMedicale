package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OO.Ordonnance;

public class OrdonnanceDAO {
	public static void AjoutOrdonnance(String o) {
		try {
			String url = "jdbc:postgresql://localhost:5432/projet";
			String user = "postgres";
			String passwd = "med53226555";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user,passwd);
		
			PreparedStatement s =conn.prepareStatement("INSERT INTO public.\"Ordonnance\"(\"contenue\") VALUES (?);");
			s.setString(1,o);
			s.executeUpdate();
			System.out.println("Ajout d'ordonnance effectué avec succés!!");
			conn.close ();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
}
		
		public static void SupprimerOrdonnance(int cin) {
			try {
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "med53226555";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user,passwd);
			
				PreparedStatement s =conn.prepareStatement("DELETE FROM public.\"Ordonnance\" WHERE \"idO\" = ?;");
				s.setInt(1, cin);
				s.executeUpdate();
				System.out.println("Suppression d'ordonnance effectué avec succés!!");
				conn.close ();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		
		@SuppressWarnings("finally")
		public static Ordonnance RechercherFichePatient(int idO) {
			Ordonnance f = null;
			try {
				String url = "jdbc:postgresql://localhost:5432/projet";
				String user = "postgres";
				String passwd = "med53226555";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user,passwd);
			
				PreparedStatement s =conn.prepareStatement("Select * from public.\"Ordonnance\" WHERE \"idO\" = ?;");
				s.setInt(1, idO);
				ResultSet rs = s.executeQuery();
				f = new Ordonnance(rs.getInt(1),rs.getString(2));
				conn.close ();
			} catch (Exception exp) {
				exp.printStackTrace();
			}finally {
				return f;
			}
		}


}
