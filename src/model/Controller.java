package model;
import java.util.ArrayList;




public class Controller {

	/**
	 * Description : Atribute of type long that help us to mesure an instant of time in miliseconds.
	 * This variable is the first instant to calculate the score.
	 */
	public static long startTime;

	/**
	 * Description : Atribute of type long that help us to mesure an instant of time in miliseconds.
	 * This variable is the second instant to calculate the score.
	 */
	public static long endTime;

	/**
	 * Description : Variable of type int that counts how many pipes are used in a game.
	 * Help us to calculate the game score.
	 */
	public static int usedPipes = 0;

	/**
	 * Description : Variable of type Board that helps as pointer of the Font on the board.
	 */
	public Board realFont;

	/**
	 * Description : Variable of type Board that helps as pointer of the Sewer on the board.
	 */
	public Board realSewer;

	/**
	 * Description : ArrayList that help us to implement some methods for the binary searh tree.
	 */
	private ArrayList<User> listScores;

	private ArrayList<String> listNames;

	/**
	 * Description : Variable of type User that help us to know the first object on the binary search tree.
	 */
	private User root;

	/**
	 * Description : Variable of type Board that help us to know the first object of the linked list.
	 */
	private Board head;

	/**
	 * Description : Variable of type Board that help us to know the first object of the linked list.
	 */
	private Board tail;

	/**
	 * Description : Variable of type Board that help us to know the object behind of the head of the linked list.
	 */
	private Board anterior;
	



	public Controller(){

		this.listScores = new ArrayList<User>();

		this.listNames = new ArrayList<String>();

	}



	/**
	 * 
	 * @param score
	 * @return
	 */


	/**
	 * Method that help us to inizilize other crucial methods to run the game.
	 * Besides it inizialize a variable named startTime that capture a instant of time to calculate the score.
	 */
	public void startGame(){

		startTime = System.nanoTime();

		createBoardDouble();

		createBoardCuadra();

		ubicateFontSewer();

		showBoard();

	}

	public void addNames(String name){

		listNames.add(name);
	}



	/**
	 * Description :Method that creates a double linked list in a iterative way.
	 */
	public void createBoardDouble(){

		int num = 1;

		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){

				
				if(head == null){
					head = new Board(num,i,j, null);
					tail = head;
					
					num++;
				}
				else{
					Board box = new Board(num, i, j, null);
					this.tail.setNext(box);
					box.setPrevious(this.tail);
					this.tail = box;
					num++;
					
				}
			}
		}
	}



	
	/**
	 * Description :Method that transform the previous double linked list into a quadruple linked list.
	 * The variable anterior is used to avoid a error with the conections.
	 */
	public void createBoardCuadra(){
		
		Board anterior = new Board(0, 0, 0, null);

		head.setPrevious(anterior);

		anterior.setNext(head);

		Board current = head;

		Board actual =  anterior;

		
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){	

				actual = actual.getNext();
				

				if(i == 2){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
					
				}
				else if(i == 3){
					actual.setAbove(current);
					current.setUnder(actual);
					
					current = current.getNext();
					
				}else if(i == 4){
					actual.setAbove(current);
					current.setUnder(actual);
					
					current = current.getNext();
					
				}else if(i == 5){
					actual.setAbove(current);
					current.setUnder(actual);
					
					current = current.getNext();
					
				}else if(i == 6){
					actual.setAbove(current);
					current.setUnder(actual);
					
					current = current.getNext();
					
				}else if(i == 7){
					actual.setAbove(current);
					current.setUnder(actual);
					
					current = current.getNext();
					
				}else if(i == 8 && current.getNext() != null && actual != null){
					actual.setAbove(current);
					current.setUnder(actual);
					current = current.getNext();
					
				}
				
			}
	
		}

	}



	/**
	 * Description : Create the font and the sewer in two different ways; 1) The pipe way 2) The Board way.
	 * Then ubicate these two in a random position in the board.
	 */
	public void ubicateFontSewer(){

		anterior = new Board(0, 0, 0, null);

		anterior.setNext(head);

		Pipe font = new Pipe(Type.FONT_PIPE, true);

		Pipe sewer = new Pipe(Type.SEWER_PIPE, true);

		int randomNum = (int)(Math.random()*(8)+1);

		int randomNum2 = (int)(Math.random()*(8)+1);

		int randomNum3 = (int)(Math.random()*(8)+1);

		int randomNum4 = (int)(Math.random()*(8)+1);
		
		while(randomNum == randomNum3 || randomNum == randomNum4 && randomNum2 == randomNum3 || randomNum2 == randomNum4){

			randomNum3 = (int)(Math.random()*(8)+1);

			randomNum4 = (int)(Math.random()*(8)+1);

		}
		
		Board pointer = anterior;

		Board pointer2 = anterior;

		for(int i=1;i<=randomNum;i++){
			for(int j=1;j<=randomNum2;j++){	

				pointer = pointer.getNext();
				

				if(i == randomNum && j == randomNum2){
					pointer.setPipe(font);
					realFont = pointer;
				}
			}
		}


		for(int i=1;i<=randomNum3;i++){
			for(int j=1;j<=randomNum4;j++){	

				pointer2 = pointer2.getNext();


				if(i == randomNum3 && j == randomNum4){
					pointer2.setPipe(sewer);
					realSewer = pointer2;
				}
			}
		}
	}




	  public void addPipe(String pipe, boolean isCircular, int row, int column) {
		int indicator = ((row-1)*8)+column;
		Board node = head;
		boolean flag = false;
		Board toAddPipe = null;
		
			for(int i = 1;i<=64;i++){
			
				if(flag != true){
					
					if(node.getIndicator()==indicator && node != realFont && node != realSewer){
						flag = true;
						toAddPipe = node;
						usedPipes++;
					}else{
						node = node.getNext();
					}

				}
			}
			if(toAddPipe == null){
				System.out.println("You can not put a pipe on this position");
			}else{
			addPipe(pipe, isCircular, toAddPipe);
			}
	}



	public void addPipe(String pipe,boolean isCircular,Board board){
		Pipe forAdd = null;
		if(pipe == "vertical" ){
			Type type = Type.VERTICAL_PIPE;
			forAdd = new Pipe(type, isCircular);
		}
		if(pipe == "horizontal"){
			Type type = Type.HORIZONTAL_PIPE;
			forAdd = new Pipe(type, isCircular);
		}
		if( pipe == "circular"){
			Type type = Type.CIRCULAR_PIPE;
			forAdd = new Pipe(type, isCircular);
		}
		System.out.println(forAdd.getPipeType());
		board.setPipe(forAdd);
	}



	/**
	 * Description : Delete a pipe by using the coords by the rows and the columns
	 * @param row : The inputs of the user to indicate the rows
	 * @param column : The inputs of the user to indicate the column
	 */
	public void deletePipeBoard(int row, int column){
		int indicator = ((row-1)*8)+column;
		Board node = head;
		boolean flag = false;
		
		for(int i = 1;i<=64;i++){
			
			if(flag != true){

				if(node.getIndicator()==indicator && node.getPipe() == null && node == realFont && node == realSewer){
					System.out.println("There is no pipe to delete");
				}

				if(node.getIndicator()==indicator && node.getPipe() != null && node != realFont && node != realSewer){
					flag = true;
					node.setPipe(null);
					System.out.println("The pipe has been deleted");
				}else{
					node = node.getNext();
				}
			}
		}
	}




	public String showBoard() {
		
		String out = "";
		Board current = new Board(0, 0, 0, null);
		current.setNext(head);
		for(int i = 1;i<=8;i++){
			if(i != 1){
				out += "\n";
			}
			for(int j = 1; j<=8;j++){
				if(current!= null){
					current = current.getNext();
					out += " " + current.toString();
					
				}
			}
		}
		return out;
	}



	
	public String  addUserScore(int score, String nickname) {
		return addUserScore(score,nickname,root);
	}

	
	private String addUserScore(int score,String nickname, User current) {
		
		if(root== null){
			User newUser = new User(score, nickname);
			root = newUser;
			return "Se agrego el puntaje";
		}else{

			if(current.getScore()<score){
				
				if(current.getRight()==null){
					User user = new User(score, nickname);
					current.setRight(user);
				}else{
					addUserScore(score, nickname, current.getRight());
				}
			}else{
				
				if(current.getLeft() == null){
					User user = new User(score, nickname);
					current.setLeft(user);
					
				}else{
					addUserScore(score, nickname, current.getLeft());
				}
			}
			return "Se agrego el puntaje a la tabla";
		}
		
		
		
	}

	

	public ArrayList<User> scoreInOrder() {
		return scoreInOrder(root);
	}

	/**
	 * 
	 * @param score
	 * @return
	 */
	private ArrayList<User> scoreInOrder(User user) {
		if(user == null){
            return listScores;
        }

        scoreInOrder(user.getLeft());
        listScores.add(user);
        scoreInOrder(user.getRight());
        return listScores;
	}
	


	public String showLeaderBoard(){
		scoreInOrder();
		String out = "";
		int size = listScores.size();

		for(int i = 0; i<size;i++){
			out += "|Nombre  " + listScores.get(i).getNickname() + " : " + listScores.get(i).getScore() + " |\n" ; 
		}
		listScores.clear();
		return out;
	}

	
	
	public boolean simulate() {
		return simulate(null, realFont);
	}


	private boolean simulate(Board flag, Board current){

		if(current == realSewer){
			endTime = System.nanoTime();
			usedPipes = 0;
			realFont = null;
			realSewer = null;
			head.setNext(null);
			head.setPrevious(null);
			head.setUnder(null);
			head.setAbove(null);
			tail.setNext(null);
			tail.setPrevious(null);
			tail.setUnder(null);
			tail.setAbove(null);
			head = null;
			tail=null;
			return true;
		}else{

			if(current.getPipe().getPipeType() == Type.FONT_PIPE){

				if(current.getAbove() != null && current.getAbove().getPipe() != null && current.getAbove().getPipe().getPipeType() != null && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getAbove().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
					return simulate(current, current.getAbove());
				}

				if(current.getUnder() != null && current.getUnder().getPipe() != null && current.getUnder().getPipe().getPipeType() != null && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getUnder().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
					return simulate(current, current.getUnder());
				}

				if(current.getPrevious() != null && current.getPrevious().getPipe() != null && current.getPrevious().getPipe().getPipeType() != null && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getPrevious().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
					return simulate(current, current.getPrevious());
				}

				if(current.getNext() != null && current.getNext().getPipe() != null && current.getNext().getPipe().getPipeType() != null && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getNext().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
					return simulate(current, current.getNext());
				}
			}

			if(current.getPipe() != null && current.getPipe().getPipeType() != null && current.getPipe().getPipeType() == Type.VERTICAL_PIPE){
				
				if(current.getAbove() != null && current.getAbove().getPipe() != null && current.getAbove() != flag && current.getAbove().getPipe().getPipeType() != null && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE){
					return simulate(current, current.getAbove());
				}

				if(current.getUnder() != null && current.getUnder().getPipe() != null && current.getUnder() != flag && current.getUnder().getPipe().getPipeType() != null && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE){
					return simulate(current, current.getUnder());
				}
			}

			if(current.getPipe() != null && current.getPipe().getPipeType() != null && current.getPipe().getPipeType() == Type.HORIZONTAL_PIPE){

				if(current.getNext() != null && current.getNext().getPipe() != null && current.getNext().getPipe().getPipeType() != null && current.getNext() != flag && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE){
					return  simulate(current,current.getNext());
				}
				if(current.getPrevious() != null && current.getPrevious().getPipe() != null && current.getPrevious().getPipe().getPipeType() != null && current.getPrevious() != flag && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE){
					return simulate(current, current.getPrevious());
				}

			}

			if(current.getPipe() != null && current.getPipe().getPipeType() != null && current.getPipe().getPipeType() == Type.CIRCULAR_PIPE){

				if(flag == current.getUnder() || flag == current.getAbove()){
					
					if(current.getNext() != null && current.getNext().getPipe() != null && current.getNext().getPipe().getPipeType() != null && current.getPrevious() != null && current.getPrevious().getPipe() != null && current.getPrevious().getPipe().getPipeType() != null ){
						return false;
					}else{
						
						if(current.getNext() != null && current.getNext().getPipe() != null && current.getNext().getPipe().getPipeType() != null && current.getNext() != flag && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getNext().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getNext());
						}
						if(current.getPrevious() != null && current.getPrevious().getPipe() != null && current.getPrevious().getPipe().getPipeType() != null && current.getPrevious() != flag && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getPrevious().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getPrevious());
						}
					}
				}

				if(flag == current.getNext() || flag == current.getPrevious()){
					
					if(current.getAbove() != null && current.getAbove().getPipe() != null && current.getAbove().getPipe().getPipeType() != null && current.getUnder() != null && current.getUnder().getPipe() != null && current.getUnder().getPipe().getPipeType() != null){
						return false;
					}else{

						if(current.getUnder() != null && current.getUnder().getPipe() != null && current.getUnder().getPipe().getPipeType() != null && current.getUnder() != flag && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getUnder().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getUnder());
						}
						if(current.getAbove() != null && current.getAbove().getPipe() != null && current.getAbove().getPipe().getPipeType() != null && current.getAbove() != flag && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getAbove().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getAbove());
						}

					}
				}
			}
		}
		return false;
	}


	
	/**
	 * Description : Calculate the Score of a game with the actual time, used pipes and a formula.
	 * @return int as the result of the operation.
	 */
	public int calculateScore(){

		long time = (endTime - startTime);

		time = time/1000000000;

		long points = (usedPipes * 100) - ((60 - time) * 10);

		int pointsInt = (int)(points);

		return pointsInt;		

	}

}