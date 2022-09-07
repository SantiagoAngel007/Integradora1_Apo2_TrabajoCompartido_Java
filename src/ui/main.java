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
			register();
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
		System.out.println(cll.showBoard());
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
        sc.nextLine();

        System.out.println(
            "Put the row of the box you want to switch the pipe:"
        );
        int row = sc.nextInt();
        sc.nextLine();
        System.out.println("Know put the column of the box you want to switch:");
        int column = sc.nextInt();
        if(row<=8 && column <= 8 && pipe<=3){
            if(pipe == 1){
                cll. addPipe("horizontal",false,row,column);
            }

            if(pipe == 2){
                cll. addPipe("vertical",false,row,column);
            }
            
            if(pipe == 3){
                cll. addPipe("circular",true,row,column);
            }
        }else{
            System.out.println("Invalid value :(");
        }
       
    }

	public void simulateGame(){
        
       
    }

    public void register(){
        System.out.println("nombre");
        String name = sc.nextLine();
        System.out.println("score");
        int score = sc.nextInt();
        System.out.println(cll.addUserScore(score,name));
        System.out.println(cll.showLeaderBoard());
    }


   



    



      
}