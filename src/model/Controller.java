package model;
import java.util.ArrayList;




public class Controller {

	public static long startTime;

	public static long endTime;

	public static int usedPipes;

	public Board realFont;

	public Board realSewer;

	private ArrayList<User> listScores;

	private ArrayList<String> listNames;

	private User root;
	private Board head;
	private Board tail;
	private Board anterior;
	

	public Controller(){

		this.listScores = new ArrayList<User>();

		this.listNames = new ArrayList<String>();

		listNames.add("Fabio");

	}



	
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
					//System.out.println(box.getIndicator());
				}
			}
		}
	}



	
	
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
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}else if(i == 4){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}else if(i == 5){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}else if(i == 6){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}else if(i == 7){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}else if(i == 8 && current.getNext() != null && actual != null){
					actual.setAbove(current);
					current.setUnder(actual);
					//System.out.println("Indicador de current under " + (current.getUnder()).getIndicator());
					current = current.getNext();
					//System.out.println("Indicador de actual above " + (actual.getAbove()).getIndicator());
				}
				
			}
	
		}

	}




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

		//System.out.println(randomNum);
		//System.out.println(randomNum2);

		for(int i=1;i<=randomNum;i++){
			for(int j=1;j<=randomNum2;j++){	

				pointer = pointer.getNext();
				

				if(i == randomNum && j == randomNum2){
					pointer.setPipe(font);
					realFont = pointer;
					//System.out.println(pointer.getIndicator());
				}
			}
		}

		//System.out.println(pointer.getPipe());
		//System.out.println(pointer.getNext().getPipe());

		//System.out.println(randomNum3);
		//System.out.println(randomNum4);

		for(int i=1;i<=randomNum3;i++){
			for(int j=1;j<=randomNum4;j++){	

				pointer2 = pointer2.getNext();


				if(i == randomNum3 && j == randomNum4){
					pointer2.setPipe(sewer);
					realSewer = pointer2;
					//System.out.println(pointer2.getIndicator());
				}
			}
		}
	}






	/* 
	public Board fill(){
		Board actual = head;
		return fill(head, head);
	  }
	
	  private Board fill(Board current, Board actual){
		

		if(current.getUnder() == null ){
			for(int i=1;i<=8;i++){
				actual = actual.getNext();
			}
		  return fill(current, actual);
		}

		if(actual.getNext() != null){
			actual.setAbove(current);
			current.setUnder(actual);

			return fill(current.getNext(), actual.getNext());
		}

		return current;
		
	  }
	  


	public void print(){
		print(head);
	}
	
	private void print(Board current){
		if(current == null){
		  return; 
		}
		System.out.println(current.getIndicator());
		print(current.getNext());
	}
	*/





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
			//System.out.println(toAddPipe.getIndicator());
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

		//int lastIdx = listNames.size() - 1;
		//nickname = listNames.get(lastIdx);

		//score = calculateScore();

		return addUserScore(score,nickname,root);
	}

	/**
	 * 
	 * @param score
	 * @param current
	 */
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
		return out;
	}

	
	
	public Board simulate() {
		return simulate(null, realFont);
	}


	private Board simulate(Board flag, Board current){

		if(current == realSewer){
			System.out.println("Felicidades, ha completado el juego");
			endTime = System.nanoTime();
			return realSewer;
		}

		if(current.getPipe().getPipeType() == Type.FONT_PIPE){

			if(current.getAbove().getPipe() != null && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getAbove().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
				return simulate(current, current.getAbove());
			}

			if(current.getUnder().getPipe() != null && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getUnder().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
				return simulate(current, current.getUnder());
			}

			if(current.getPrevious().getPipe() != null && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getPrevious().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
				return simulate(current, current.getPrevious());
			}

			if(current.getNext().getPipe() != null && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getNext().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
				return simulate(current, current.getNext());
			}
		}








		

	
		
		
		
		
		return null;
	}


	public int calculateScore(){

		int time = (int)(endTime - startTime);

		int points = usedPipes * 100 - (60 - time) * 10;

		return points;		

	}

}