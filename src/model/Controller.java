package model;



public class Controller {

	private User root;
	//private List<Score> listScores;
	private Board head;
	private Board tail;
	private Board anterior;
	



	
	public void startGame(){

		long startTime = System.nanoTime();

		createBoard();

		search();

		ubicateFontSewer();

		//print();

		

	}



	public void createBoard(){

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



	
	
	public void search(){
		
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

		System.out.println(randomNum);
		System.out.println(randomNum2);

		for(int i=1;i<=randomNum;i++){
			for(int j=1;j<=randomNum2;j++){	

				pointer = pointer.getNext();
				

				if(i == randomNum && j == randomNum2){
					pointer.setPipe(font);
					System.out.println(pointer.getIndicator());
				}
			}
		}

		System.out.println(pointer.getPipe());
		System.out.println(pointer.getNext().getPipe());

		System.out.println(randomNum3);
		System.out.println(randomNum4);

		for(int i=1;i<=randomNum3;i++){
			for(int j=1;j<=randomNum4;j++){	

				pointer2 = pointer2.getNext();


				if(i == randomNum3 && j == randomNum4){
					pointer.setPipe(sewer);
					System.out.println(pointer2.getIndicator());
				}
			}
		}
	}







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



	public void deletePipeBoard(int row, int column){
		int indicator = ((row-1)*8)+column;
		Board node = head;
		boolean flag = false;
		


		for(int i = 1;i<=64;i++){
			
			if(flag != true){
				
				if(node.getIndicator()==indicator && node.getPipe() != null){
					flag = true;
					node.setPipe(null);
					System.out.println("The pipe has been deleted");
				}else{
					node = node.getNext();
				}

			}
		}




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