package model;

public class Controller {

	private User root;
	//private List<Score> listScores;
	private Board head;
	private Board tail;
	



	
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

		Board actual =  head;

		
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){	

				actual = actual.getNext();

				

				if(i == 2){
					actual.setAbove(current);
					current.setUnder(actual);
					System.out.println("Indicador de current " + (current.getUnder()).getIndicator());
					current = current.getNext();
					System.out.println("Indicador de actual " + (actual.getAbove()).getIndicator());
					
				}

		
				/*else if(i == 3){
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
				}else if(i == 8 && current.getNext() != null){
					actual.setAbove(current);
					current.setUnder(actual);
					current = current.getNext();
				}
				*/
				
			}
	
		}

	}


	public Board fill(){
		Board actual = null;
		return fill(head, actual);
	  }
	
	  private Board fill(Board current, Board actual){
		actual = head;
		if(current.getUnder() == null ){
			for(int i=1;i<=9;i++){
				actual = actual.getNext();
			}
		  return fill(current, actual);
		}
		
		actual.setAbove(current);
		current.setUnder(actual);
		return fill(current.getNext(), actual.getNext());
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












	  /* 
	public void createBoard(){

		for(int i=1;i<=8;i++){
			if(head == null){
				head = new Board(i,1 ,1 );
				tail = head;
				System.out.println(i);
			}else{
				Board box = new Board(i, 1, 1);
				this.tail.setNext(box);
      			box.setPrevious(this.tail);
      			this.tail = box;
				  System.out.println(i);
			}
		}

		

	}
	*/










	/* 
	public void createBoard(){
		int identificator = 1;


		while(identificator<64){
			
			if (head == null){
				this.head = new Board(identificator);
				this.tail = new Board(identificator);
				identificator++;

				System.out.println("hola");
				
			}
			else {
				Board box = new Board(identificator);
				this.tail.setNext(box);
				box.setPrevious(this.tail);
				this.tail = box;
				identificator++;

				System.out.println("xd");
			}
		}
	}
	*/


	
























	/**
	 * 
	 * @param score
	 * @param current
	 */
	private void addScore(User score, User current) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param goal
	 */
	public User searchScore(int goal) {
		// TODO - implement Controller.searchScore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param current
	 * @param target
	 */
	private User searchScore(User current, int target) {
		// TODO - implement Controller.searchScore
		throw new UnsupportedOperationException();
	}

	/* 
	public List<Score> showScore() {
		// TODO - implement Controller.showScore
		throw new UnsupportedOperationException();
	}
	*/

	/**
	 * 
	 * @param score
	 */
	/* 
	private List<Score> showScore(Score score) {
		// TODO - implement Controller.showScore
		throw new UnsupportedOperationException();
	}
	*/

	/**
	 * 
	 * @param pipe
	 * @param row
	 * @param column
	 */
	public void addPipe(Pipe pipe, int row, int column) {
		// TODO - implement Controller.addPipe
		throw new UnsupportedOperationException();
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

	public void showBoard() {
		// TODO - implement Controller.showBoard
		throw new UnsupportedOperationException();
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
	public void simulate(Board board) {
		long endTime = System.nanoTime();
	}

}