package model;

public class Board {

	Controller boxes;
	private Board next;
	private Board above;
	private Board under;
	private Board previous;
	private Pipe font;
	private Pipe sewer;
	private Pipe pipe;
	private int indicator;
	private int row;
	private int column;
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
		return this.next;
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

	public int getIndicator(){
		return this.indicator;
	}

	public Pipe getPipe(){
		return this.pipe;
	}
	public void setPipe(Pipe pipe){
		this.pipe = pipe;
	}
}