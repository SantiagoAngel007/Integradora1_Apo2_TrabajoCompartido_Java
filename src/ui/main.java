package ui;
import model.Controller;
import model.User;
import java.util.Scanner;






public class Main {
    private Scanner sc;

    private Controller cll;

	public static String name = null;
    
	
	/**
	 * Description : Inicialize the scaner and the contection with controller.
	 */
    public Main(){
        sc = new Scanner(System.in);

        cll = new Controller();
        

    }

    public static void main(String[] args) {

      Main ppal = new Main();

	  ppal.prueba();
      
      System.out.println("");
		
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);

		
		
	}


	/**
	 * Description : Display the first menu to start a game, see the scores of the players or leave the game.
	 */
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


	/**
	 * Description : Displays the second menu to put a pipe, delete a pipe and simulate the game in the board.
	 */
	public int showGameMenu() {
		int optionGame=0;


		System.out.println(
				"Game menu, please pick an option\n" +
				"(1) Put pipe \n" +
				"(2) delete pipe \n" +
				"(3) Simulate \n"+
                "(0) Leave\n"   
				);
		optionGame= sc.nextInt();
		sc.nextLine();
		return optionGame;
	}


	/**
	 * Description : 
	 * @param score
	 * @return
	 */
      

	/**
	 * Description : Distribute the tasks by using a switch and complement the method showMenu.
	 * @param operation The value of the answer of the user to continue the game.
	 */
    public void executeOperation(int operation) {

		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createGame();
			break;
		case 2:
			//register();
			System.out.println(cll.showLeaderBoard()); 
			break;
		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

	/**
	 * Description : Distribute the tasks by using a switch and complement the method showGamemenu.
	 * @param operation The value of the answer of the user to continue the game.
	 */
	public void executeOperationInGame(int operation) {

		switch(operation) {
		case 0:
			System.out.println("Returning to the tittle!");
			break;
		case 1:
			pipeAction();
			break;
		case 2:
			deletePipe();
			break;
		//case 3:
			//simulateGame();
		//break;
		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}


	public void prueba(){

		cll.addUserScore(45, "Angel");

		cll.addUserScore(55, "Samuel");
	}



	
	/**
	 * Description : It gives us the name of the user and inicialized the showGameMenu to start the main game.
	 */
    public void createGame(){

		System.out.println("Please input your nickname");
		name = sc.nextLine();

		//cll.addNames(name);

		cll.startGame();

		System.out.println(cll.showBoard());

		int optionGame=0;

		boolean respuesta = false;

		do{
			optionGame = showGameMenu();
			if(optionGame == 3){
				respuesta = simulateGame();
			}else{
				executeOperationInGame(optionGame);
			}
			//executeOperationInGame(optionGame);
			System.out.println(respuesta);
		}while (optionGame !=0 || respuesta != true);

        
    }


	
	/**
	 * Description : Verify if the answer put by the user is the correct one.
	 * @return bollean
	 */
	public boolean simulateGame(){
        
		boolean ans = cll.simulate();
       if(ans == false){
		System.out.println("Hay un error");
	   }else{
		System.out.println("Felicidades has ganado");
		System.out.println("Su puntaje es de " + cll.calculateScore());
		cll.addUserScore(cll.calculateScore(),name);
		name = null;
		System.out.println("");
		System.out.println(cll.showLeaderBoard());
		//System.out.println(ans);
	   }
	   return ans;
    }


    

	public void pipeAction(){
        
		System.out.println(
				"What kind of pipe would you like to put?\n" +
				"(1) HORIZONTAL (=) \n" +
				"(2) VERTICAL (|) \n"+
                "(3) CIRCULAR (O)\n"   
				);

		int pipe = sc.nextInt();
        sc.nextLine();

        System.out.println(
            "Input the value of the row:"
        );
        int row = sc.nextInt();
        sc.nextLine();
        System.out.println("Input the value value of the column:");
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
			System.out.println(cll.showBoard());
        }else{
            System.out.println("Invalid value :(");
        }
       
    }


	
	/**
	 * Description : Let the user to delete a pipe in case that make a mistake
	 */
	public void deletePipe(){

		System.out.println("Input the row to delete the pipe");
		int row = sc.nextInt();
		sc.nextLine();

		System.out.println("Input the row to delete the pipe");
		int column = sc.nextInt();
		sc.nextLine();


		if(row<=8 && column <= 8){

			cll.deletePipeBoard(row, column);
			System.out.println(cll.showBoard());

		}else{
			System.out.println("The input is invalid");
		}
        
       
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