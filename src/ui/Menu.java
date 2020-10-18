package ui;
import java.util.Scanner;
import model.*;
public class Menu{
	static Scanner sc = new Scanner(System.in);
	static Championship champ = new Championship(2020,10);
		
	public Menu(){
		
	}	
		
	public static void menu(){
		boolean ended = false;
		do{
			System.out.println(showMenu());
			ended = manageOptions();
		}while(!ended);
	}
	
	private static String showMenu(){
		String options;
		options = "=============================\n";
		options+= "        Bienvenido           \n";
		options+= "=============================\n";
		options+= "1. Registrar nuevo campeonato\n";
		options+= "2. Registrar nuevo piloto\n";
		options+= "3. Mostrar promedios\n";
		options+= "4. Salir\n";
		return options;
	}
	
	private static  boolean manageOptions(){
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice){
			case 1: registerChampionship(); break;
			case 2: registerPilot(); break;
			case 3: showAverage(); break;
			case 4: return true;
			default: System.out.println("La opcion ingresada es invalida");
		}
		return false;
	}
	
	private static void registerChampionship(){
		System.out.println("Ingrese el año del campeonato");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese la cantidad de premios del campeonato");
		int races = Integer.parseInt(sc.nextLine());
		
		champ = new Championship(year,races);
	} 
	
	private static void registerPilot(){
		
		System.out.println("Ingrese el nombre del piloto");
		String name = sc.nextLine();
		
		System.out.println("Ingrese la edad del piloto");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("Ingrese el equipo del piloto");
		System.out.println(showTeams());
		
		String team = sc.nextLine();
		int[] scores = getScores(champ.getRaces());
		
		champ.addPilot(name, age, team, scores);
		
	}
	
	private static String showTeams(){
		String teams = "SUCUDERIA_FERRARI \n MCLAREN_F1_TEAM \n RED_BULL_RACING \n MERCEDES_AMG \n RACING_POINT \n ALFA_ROMEO \n RENAULT \n WILLIAMS";
		return teams;
	}
	
	private static int[] getScores(int races){
		int[] scores = new int[races];
		for (int i = 0; i< races; i++){
			System.out.println("Ingrese el tiempo (en segundos) del piloto en la carrera "+(i+1));
			scores[i] = Integer.parseInt(sc.nextLine());
		}
		return scores;
	}
	
	private static void showAverage(){
		System.out.println(champ.showAverageTimes());
	}
}