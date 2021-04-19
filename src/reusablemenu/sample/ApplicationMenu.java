/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusablemenu.sample;



import java.util.ArrayList;
import java.util.Scanner;

import reusablemenu.abstractions.IMenuItem;
import reusablemenu.implementation.Menu;
import reusablemenu.implementation.MenuItem;


public class ApplicationMenu{
	private Scanner consoleScanner = new Scanner(System.in);
	
	private ArrayList<Student> grupa = new ArrayList<Student>();
    private Menu mainMenu = null;
    private int Nr_Studenti = 0;
    
    public ApplicationMenu()
    {
                 
    }
	private void uiDelete() {
		int id;
		System.out.print("ID-ul studentului pe care il dorim sters este : ");
		try
		{
		id = consoleScanner.nextInt();
		grupa.remove(id-1);
		Nr_Studenti--;
		System.out.println("Studentul " +id +" a fost sters");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); //probabil id iese din range sau id a fost citit alt caracter inafara de numere
		}
	}
	
	private void uiModify() {
		int id;
		System.out.print("ID-ul studentului pe care il dorim modificat este : ");
		id = consoleScanner.nextInt();
		
		Student StudentNou = new Student();
		System.out.println("Noiile date ale studentului sunt : ");
		StudentNou.ReaderStudent(id);
		
		grupa.set(id-1, StudentNou);
	}
	
    private void uiAdd() {
    	Student StudentNou = new Student();
		Nr_Studenti++;
		StudentNou.ReaderStudent(Nr_Studenti);
		grupa.add(StudentNou);	
		
	}
    
    private void listStudent(Student student)
	{
		System.out.println(student.getID() + "\t" + student.getNume() + "\t" + student.getPrenume() + "\t" +  student.getSpecializare() + "\t" + student.getAn_studii() );
	}
    
    private void uiPrint() {
		
System.out.println("\nID\tNUME\tPRENUME\tSPCIALIZARE\tAN_STUDII");
		
		for(Student currentStudent: grupa)
		{
			listStudent(currentStudent);			
		}
		System.out.println("\n");
	}
    
    
    public void load()
    {
        
        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
        
        int shortCut = 1;    
        
         
       IMenuItem currentItem = new MenuItem("Adaugare student", shortCut++, (parameters)->{
           uiAdd();
       });       
       menuItems.add(currentItem);
       
       currentItem = new MenuItem("Sterge student", shortCut++, (parameters)->{
    	   	uiDelete();
       });       
       menuItems.add(currentItem);   
       
       currentItem = new MenuItem("Modificare student", shortCut++, (parameters)->{
   	   	uiModify();
      });       
      menuItems.add(currentItem); 
       
       currentItem = new MenuItem("Afisaza studenti", shortCut++, (parameters)->{
   	   	uiPrint();
      });              
       menuItems.add(currentItem);
       
       
        
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }
    
    public void execute()
    {
        mainMenu.execute();
    }
    
}
