package model;

public class Score {

	private Score right;
	private Score left;
	private int value;

	/**
	 * 
	 * @param value
	 */
	public Score(int value) {
		
		this.value = value;

	}


	public double calculateScore(){

		double points = 0;

		return points;
	}


	public Score getRight() {
		return this.right;
	}

	/**
	 * 
	 * @param right
	 */
	public void setRight(Score right) {
		this.right = right;
	}

	public Score getLeft() {
		return this.left;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeft(Score left) {
		this.left = left;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

}