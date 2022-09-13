package model;

public class Board {

	Controller boxes;

	//Ints
	private int column;
	private int row;
	private int indicator;

	//Board
	private Board next;
	private Board above;
	private Board under;
	private Board previous;

	//Pipes
	//public  Pipe font;
	//public Pipe sewer;
	private Pipe pipe;


	/**
	 * 
	 * @param font
	 * @param sewer
	 */
	public Board(int indicator, int row, int column, Pipe pipe) {

		this.indicator = indicator;

		this.row = row;

		this.column = column;

	}

	public Board getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 */
	public void setNext(Board next) {
		this.next = next;
	}

	public Board getAbove() {
		return this.above;
	}

	/**
	 * 
	 * @param above
	 */
	public void setAbove(Board above) {
		this.above = above;
	}

	public Board getUnder() {
		return this.under;
	}

	/**
	 * 
	 * @param under
	 */
	public void setUnder(Board under) {
		this.under = under;
	}

	public Board getPrevious() {
		return this.previous;
	}

	/**
	 * 
	 * @param previous
	 */
	public void setPrevious(Board previous) {
		this.previous = previous;
	}


	 
	public int getIndicator() {
		return this.indicator;
	}

	/**
	 * 
	 * @param previous
	 */
	
	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}


	public int getRow(){
		return row;
	}
	

	public int getColumn(){
		return column;
	}


	public Pipe getPipe(){
		return pipe;
	}


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
				out += "[||]";  
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