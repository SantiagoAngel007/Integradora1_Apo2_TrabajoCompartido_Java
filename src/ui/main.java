package ui;
import model.Controller;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class Main {
    private Scanner sc;

    private Controller cll;
    
    public Main(){
        sc = new Scanner(System.in);

        cll = new Controller();
        

    }

    public static void main(String[] args) {

      Main ppal = new Main();
      
      System.out.println("");
		
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);

		
		
	}


    public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) New game \n" +
				"(2) Score \n"+
                "(0) Leave\n"   
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	public int showGameMenu() {
		int optionGame=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Put pipe \n" +
				"(2) Simulate \n"+
                "(0) Leave\n"   
				);
		optionGame= sc.nextInt();
		sc.nextLine();
		return optionGame;
	}
      


    public void executeOperation(int operation) {

		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createGame();
			break;
		case 2:
			searchScore();
			break;
		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}


	public void executeOperationInGame(int operation) {

		switch(operation) {
		case 0:
			System.out.println("Returning to the tittle!");
			break;
		case 1:
			pipeAction();
			break;
		case 2:
			simulateGame();
			break;
		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}


    public void createGame(){
        
		String name;

		System.out.println("Please input your nickname");
		name = sc.nextLine();

		cll.startGame();

		int optionGame=0;

		do{
			optionGame = showGameMenu();
			executeOperationInGame(optionGame);
			
		}while (optionGame!=0);

        
    }


    public void searchScore(){
        
       
    }

	public void pipeAction(){
        
		System.out.println(
				"What kind of pipe would you like to put?\n" +
				"(1) HORIZONTAL (=) \n" +
				"(2) VERTICAL (||) \n"+
                "(0) CIRCULAR (O)\n"   
				);

		int pipe = sc.nextInt();

		
       
    }

	public void simulateGame(){
        
	
       
    }


   



    



      
}