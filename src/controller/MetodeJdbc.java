package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodeJdbc {
	
	
	private static Connection uspostaviKonekciju(String imeBaze) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/" + imeBaze;
		final String pass = "root";
		final String user = "root";
		
		return  DriverManager.getConnection(url, user, pass);
			
	}

	
	public boolean ubaciUtabeluKursevi(String imeKursa, int cena) {
		
		
		Connection konekcija = null;
		PreparedStatement statement = null;
		
		
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena!");
			
			String query = "INSERT INTO courses VALUES(null,?,?)";
			statement = konekcija.prepareStatement(query);
				statement.setString(1, imeKursa);
				statement.setInt(2, cena);
			statement.execute();
			System.out.println("Uspesno ubacen kurs!");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}			
	}
	
	
	public boolean izmeniCenuKursa(String imeKursa, int cena) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena");
			
			String query = "UPDATE courses SET cena = ? WHERE ime_kursa = ?";
			pst = konekcija.prepareStatement(query);
				pst.setInt(1, cena);
				pst.setString(2, imeKursa);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void prikaziSveKurseve () {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null; 
		
		
		try {
			konekcija = uspostaviKonekciju("kursevi");
			System.out.println("Konekcija uspostavljena");
			
			String query = "select * from courses";
			pst = konekcija.prepareStatement(query);
			res = pst.executeQuery();
			
			while (res.next()) {
				
				int id = res.getInt("id_courses");
				String ime = res.getString("ime_kursa");
				double cena =	res.getDouble("cena");
				System.out.println(id + " " + ime + " " + cena);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	