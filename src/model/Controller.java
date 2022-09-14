package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

	private User root;
	private ArrayList<User> listScores;
	private Board head;
	private Board tail;
	public Board realFont;
	public Board realSewer;

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
			out += "| " + listScores.get(i).getNickname() + " : " + listScores.get(i).getScore() + " | \n"; 
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

	/**
	 * 
	 * @param current
	 */
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

	

	public boolean simulate() {
		return simulate(null, realFont);
	}


	private boolean simulate(Board flag, Board current){

		if(current == realSewer){
			System.out.println("Felicidades, ha completado el juego");
			//endTime = System.nanoTime();
			return true;
		}else{

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

			if(current.getPipe().getPipeType() == Type.VERTICAL_PIPE){
				
				if(current.getAbove().getPipe() != null && current.getAbove() != flag && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE){
					return simulate(current, current.getAbove());
				}

				if(current.getUnder().getPipe() != null && current.getUnder() != flag && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE){
					return simulate(current, current.getUnder());
				}
			}

			if(current.getPipe().getPipeType() == Type.HORIZONTAL_PIPE){

				if(current.getNext().getPipe() != null && current.getNext() != flag && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE){
					return  simulate(current,current.getNext());
				}
				if(current.getPrevious().getPipe() != null && current.getPrevious() != flag && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE){
					return simulate(current, current.getPrevious());
				}

			}

			if(current.getPipe().getPipeType() == Type.CIRCULAR_PIPE){

				if(flag == current.getUnder() || flag == current.getAbove()){
					
					if(current.getNext().getPipe().getPipeType() != null && current.getPrevious().getPipe().getPipeType() != null ){
						return false;
					}else{
						
						if(current.getNext().getPipe() != null && current.getNext() != flag && current.getNext().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getNext().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getNext());
						}
						if(current.getPrevious().getPipe() != null && current.getPrevious() != flag && current.getPrevious().getPipe().getPipeType() != Type.VERTICAL_PIPE && current.getPrevious().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getPrevious());
						}
					}
				}

				if(flag == current.getNext() || flag == current.getPrevious()){
					
					if(current.getAbove().getPipe().getPipeType() != null && current.getUnder().getPipe().getPipeType() != null){
						return false;
					}else{

						if(current.getUnder().getPipe() != null && current.getUnder() != flag && current.getUnder().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getUnder().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getUnder());
						}
						if(current.getAbove().getPipe() != null && current.getAbove() != flag && current.getAbove().getPipe().getPipeType() != Type.HORIZONTAL_PIPE && current.getAbove().getPipe().getPipeType() != Type.CIRCULAR_PIPE){
							return  simulate(current,current.getAbove());
						}

					}
				}
			}
		}
		return false;
	}
}