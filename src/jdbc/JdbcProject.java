package jdbc;

import java.util.Scanner;
import controller.MetodeJdbc;
import model.Kurs;
import model.User;

public class JdbcProject {

	public static void main(String[] args) {
		

		MetodeJdbc metode = new MetodeJdbc();
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Unesite id");
		String id = scanner.nextLine();
		
		
		/*
		Kurs k = metode.vratiKursPoId(3);
		
		System.out.println("Id: " + k.getIdKursa());
		System.out.println("Ime: " + k.getImeKursa());
		System.out.println("Cena: " + k.getCena());
		*/
		
		
		
		User user = metode.vratiUseraPoId(Integer.parseInt(id));
		System.out.println("ID:  " + user.getIdUser());
		System.out.println("Username :  " + user.getUserName());
		System.out.println("Password:  " + user.getPassword());
		System.out.println("Maticni broj:  " + user.getMaticniBroj());
		
		
		
		

	}

}