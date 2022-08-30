package model;

public class Board {

	Controller boxes;
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
	public Board(Pipe font, Pipe sewer) {
		// TODO - implement Board.Board
		throw new UnsupportedOperationException();
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

}