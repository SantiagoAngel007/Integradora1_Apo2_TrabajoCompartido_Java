package model;

public class Board {

	Controller boxes;

	//Ints
	/**
	 * Description : Atribute to indicate the column of the board 8x8.
	 */
	private int column;
	/**
	 * Description : Atribute to indicate the row of the board 8x8.
	 */
	private int row;

	/**
	 * Description : Atribute that indicates the position of the object on the linked list.
	 */
	private int indicator;

	//Board
	/**
	 * Description : Atribute to indicate what is next of the current object.
	 */
	private Board next;
	/**
	 * Description : Atribute to indicate what is above of the current object.
	 */
	private Board above;
	/**
	 * Description : Atribute to indicate what is under of the current object.
	 */
	private Board under;
	/**
	 * Description : Atribute to indicate what is previous of the current object.
	 */
	private Board previous;

	//Pipes
	//public  Pipe font;
	//public Pipe sewer;

	/**
	 * Description : Atribute to instantiate a pipe in a board object.
	 */
	private Pipe pipe;


	/**
	 * Contructor of class Board
	 * @param font
	 * @param sewer
	 * @param indicator
	 * @param pipe@param 
	 */
	public Board(int indicator, int row, int column, Pipe pipe) {

		this.indicator = indicator;

		this.row = row;

		this.column = column;

	}


	/**
	 * Get the Board object next.
	 */
	public Board getNext() {
		return next;
	}

	/**
	 * Change the next Board object.
	 * @param next
	 */
	public void setNext(Board next) {
		this.next = next;
	}

	/**
	 * Get the Board object Above.
	 */
	public Board getAbove() {
		return this.above;
	}

	/**
	 * Change the above Board object.
	 * @param above
	 */
	public void setAbove(Board above) {
		this.above = above;
	}

	/**
	 * Get the Board object Under.
	 */
	public Board getUnder() {
		return this.under;
	}

	/**
	 * Change the under Board object.
	 * @param under
	 */
	public void setUnder(Board under) {
		this.under = under;
	}

	/**
	 * Get the Board object previous.
	 */
	public Board getPrevious() {
		return this.previous;
	}

	/**
	 * Change the previous Board object.
	 * @param previous
	 */
	public void setPrevious(Board previous) {
		this.previous = previous;
	}


	/**
	 * Get the indicator on the object in the linked list.
	 */
	public int getIndicator() {
		return this.indicator;
	}

	/**
	 * Change the indicator.
	 * @param indicator
	 */
	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}

	/**
	 * Get the row.
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * Get the column.
	 */
	public int getColumn(){
		return column;
	}

	/**
	 * Get the pipe.
	 */
	public Pipe getPipe(){
		return pipe;
	}

	/**
	 * Change the pipe.
	 * @param pipe
	 */
	public void setPipe(Pipe pipe){
		this.pipe = pipe;
	}


	public String toString(){
		String out = "";
		
		if(pipe != null){
			if(pipe.getPipeType()== Type.HORIZONTAL_PIPE){
				out += "[=]";  
			}
		
			if(pipe.getPipeType()== Type.VERTICAL_PIPE){
				out += "[|]";  
			}
			if(pipe.getPipeType()== Type.CIRCULAR_PIPE){
				out += "[O]";  
			}
			if(pipe.getPipeType()== Type.FONT_PIPE){
				out += "[F]";  
			}
			if(pipe.getPipeType()== Type.SEWER_PIPE){
				out += "[S]";  
			}
		}else{
			out += "[X]";
		}
		return out;
	}

}