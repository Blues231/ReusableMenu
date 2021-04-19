package reusablemenu.sample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {

	private Scanner input = new Scanner(System.in);
	private int ID;
	private String nume;
	private String prenume;
	private String specializare;
	private int an_studii;

	public void ReaderStudent(int id)
	{
		ID = id;
		System.out.print("Numele studentului este : ");
		nume = input.nextLine();
		System.out.print("Prenumele studentului este : ");
		prenume = input.nextLine();
		System.out.print("Specializarea studentului este : ");
		specializare = input.nextLine();
		System.out.print("Anul de studiu al studentului este : ");
		try
		{
		an_studii = input.nextInt();
		}
		catch(InputMismatchException e) //probabil a fost citit un caracter diferit de numere
		{
			System.out.println("S-a introdus o valoare gresita"); 
		}
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getSpecializare() {
		return specializare;
	}
	public void setSpecialisare(String specializare) {
		this.specializare = specializare;
	}
	public int getAn_studii() {
		return an_studii;
	}
	public void setAn_studii(int an_studii) {
		this.an_studii = an_studii;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
