package model;

public class Board {

	Controller boxes;
	private int column;
	private int row;
	private int indicator;
	private Board next;
	private Board above;
	private Board under;
	private Board previous;
	private Pipe font;
	private Pipe sewer;


	/**
	 * 
	 * @param font
	 * @param sewer
	 */
	public Board(int indicator, int row, int column) {

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

}