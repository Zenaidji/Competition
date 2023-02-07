package game;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import competition.Competition;
import competition.League;
import competition.Master;
import competition.Puissance2Exception;
import competition.Tournament;
import competition.observers.BookMaker;
import competition.observers.Observercmp;
import competition.observers.Reporter;
import competition.selection.SelectTwoFirst;
import competition.selection.SelectWithTwoRandomThird;
import competition.selection.Selection;
import competitor.Competitor;


public class Game {
	//proposer le nombre de bookmaker à ajouter à la competition
	
	public static void main(String[] args) {
		
		if(args.length!=1) {
			System.out.println("il manque un parametre lors de l'éxecution pour savoir le nombre de competiteurs");
			System.exit(0);
		}
		
		 	List<Competitor> competiteurs = readFile(args);
		
		 	System.out.println("waht do you want play ? \n press 1 for tournement \n press 2 for league \n press 3 for master");
		 	Scanner scan=new Scanner(System.in);
		 	int choice = 0;
		 	try {
		 	 choice=scan.nextInt();
		 	}catch(InputMismatchException e) {
		 		System.out.println("Retry and choose a 1 , 2 or 3 \n");
		 		System.exit(0);
		 	}
		 	Competition game;
		 	game = choseAndPlay(competiteurs, scan, choice);
		 	game.displayCompetition();
		 	scan.close();
		 	
		 
 		
		

	}


	private static Competition choseAndPlay(List<Competitor> competiteurs, Scanner scan, int choice) {
		Competition game;
		try {
		switch(choice) {
		case 1:game=new Tournament(competiteurs);
				break;
		case 2:game=new League(competiteurs);
			break;
		case 3 : System.out.println("which selection you want to your master \n 1-two first \n 2-two first with selection of the best third");
					Selection sel = choseStrategy(scan);
					System.out.println("How many groupes to your competition ");
					System.out.println("for the strategey with two random third the number of pull must be greater than 2");
					int nbPool = scan.nextInt();
					game=new Master(competiteurs,sel,nbPool);
					break;
		default: System.out.println(" retry and choose 1 or 2");
				 game = null;
				 System.exit(0);
		}
		}
		catch(Puissance2Exception e) {
			game=new League(competiteurs);
			System.out.println("the number of teams is not power of 2");
			System.exit(100);
		}
		try {
			addObserversToTheGame(scan, game);
			
		game.play();
		}
		catch(Puissance2Exception e){
			System.out.println("nombres de poule ne permets pas de dérouler le master\n");
			System.exit(100);
		}
		catch(IllegalArgumentException e){
			System.out.println("choix incorrecte");
			System.exit(100);
		}
		catch (NullPointerException e) {
			System.out.println("une erreur quelque part \n");
			System.exit(100);
		}
		
		return game;
	}


	/**
	 * @param scan
	 * @param game
	 */
	private static void addObserversToTheGame(Scanner scan, Competition game) {
		System.out.println("how many reporters to watch the competition ?");
		int r = scan.nextInt();
		System.out.println("how many bookmakers to follow the competition ?");
		int b = scan.nextInt();
		List<Observercmp> reporters = addReporters(r);
		List<Observercmp> bookMakers = addBookMakers(b);
		for(Observercmp o : reporters)
			game.addObserver(o);
		for(Observercmp o : bookMakers)
			game.addObserver(o);
	}


	private static Selection choseStrategy(Scanner scan) {
		int strategy = scan.nextInt();
		Selection sel;
		
		switch (strategy) {
		case 1 : sel = new SelectTwoFirst();
			break;
		case 2:
			sel=new SelectWithTwoRandomThird ();
			break;
		default :
			sel=null;
			System.out.println("wrong choice");
			System.exit(100);
			
		}
		return sel;
	}
	

	private static List<Competitor> readFile(String[] args) {
		   List<Competitor>competiteurs=new ArrayList<>();
		   String filePath = new File("").getAbsolutePath();
		   int cpt = 0;
		   int nbComp=Integer.parseInt(args[0]);
	 
		 try
		    {
		      FileInputStream file = new FileInputStream(filePath+"/src/game/teams.txt");   
		      Scanner scanner = new Scanner(file);  
		      while(scanner.hasNextLine() && cpt < nbComp)
		      {
		        competiteurs.add(new Competitor(scanner.nextLine()));
		        cpt++;
		      }
		      scanner.close();    
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		return competiteurs;
	}
	
	private static List<Observercmp> addReporters(int nb ) {
		   List<Observercmp>reporters=new ArrayList<>();
		   String filePath = new File("").getAbsolutePath();
		   int cpt = 0;
		   
	 
		 try
		    {
		      FileInputStream file = new FileInputStream(filePath+"/src/game/reporter.txt");   
		      Scanner scanner = new Scanner(file);  
		      while(scanner.hasNextLine() && cpt < nb)
		      {
		        reporters.add(new Reporter(scanner.nextLine()));
		        cpt++;
		      }
		      scanner.close();    
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		return reporters;
	}
	
	private static List<Observercmp> addBookMakers(int nb ) {
		   List<Observercmp>res=new ArrayList<>();
		   String filePath = new File("").getAbsolutePath();
		   int cpt = 0;
		   
	 
		 try
		    {
		      FileInputStream file = new FileInputStream(filePath+"/src/game/bookmakers.txt");   
		      Scanner scanner = new Scanner(file);  
		      while(scanner.hasNextLine() && cpt < nb)
		      {
		        res.add(new BookMaker(scanner.nextLine()));
		        cpt++;
		      }
		      scanner.close();    
		    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
		return res;
	}
	

}
