package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

	private User root;
	private ArrayList<User> listScores;
	private Board head;
	private Board tail;


	public Controller(){
		this.listScores = new ArrayList<User>();
	}
	
	
	public void startGame(){

		long startTime = System.nanoTime();

		createBoard();

		search();

		//print();

		

	}

	public void createBoard(){

		int num = 1;

		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){

				
				if(head == null){
					head = new Board(num,i,j);
					tail = head;
					
					num++;
				}
				else{
					Board box = new Board(num, i, j);
					this.tail.setNext(box);
					box.setPrevious(this.tail);
					this.tail = box;
					num++;
				}
			}
		}
	}



	
	
	public void search(){
		
		Board anterior = new Board(0, 0, 0);

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
					System.out.println("Indicador de current " + (current.getUnder()).getIndicator());
					current = current.getNext();
					System.out.println("Indicador de actual " + (actual.getAbove()).getIndicator());
					
				}else if(i == 3){
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
				}else if(i == 8 && current.getNext() != null && actual!= null){
					actual.setAbove(current);
					current = current.getNext();
				}
				
				
			}
	
		}

	}
	//Miooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo

	public String  addUserScore(int score, String nickname) {
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
			out += "| " + listScores.get(i).getNickname() + " : " + listScores.get(i).getScore() + " |"; 
		}
		return out;
	}
	/**
	 * 
	 * @param pipe
	 * @param row
	 * @param column
	 */
	public void addPipe(String pipe, boolean isCircular, int row, int column) {
		int indicator = ((row-1)*8)+column;
		Board node = head;
		boolean flag = false;
		Board toAddPipe = null;
		
			for(int i = 1;i<=64;i++){
			
				if(flag != true){
					
					if(node.getIndicator()==indicator){
						flag = true;
						toAddPipe = node;
					}else{
						node = node.getNext();
					}

				}
			}
			System.out.println(toAddPipe.getIndicator());
			addPipe(pipe, isCircular, toAddPipe);
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
	 * 
	 * @param row
	 * @param column
	 */
	public void deletePipe(int row, int column) {
		// TODO - implement Controller.deletePipe
		throw new UnsupportedOperationException();
	}

	public String showBoard() {
		
		String out = "";
		Board current = new Board(0, 0, 0);
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

	/**
	 * 
	 * @param current
	 */
	private void showBoard(Board current) {
		// TODO - implement Controller.showBoard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param board
	 */
	public String simulate(Board board) {
		// TODO - implement Controller.simulate
		throw new UnsupportedOperationException();
	}

}