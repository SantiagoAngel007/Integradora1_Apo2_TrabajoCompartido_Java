package model;


public class User {

	private User right;
	private User left;
	private int score;
	private String nickname;

	/**
	 * 
	 * @param value
	 */
	public User(int score, String nickname) {
		
		this.score = score;

		this.nickname = nickname;

	}


	public double calculateScore(){

		double points = 0;

		return points;
	}


	public User getRight() {
		return this.right;
	}

	/**
	 * 
	 * @param right
	 */
	public void setRight(User right) {
		this.right = right;
	}

	public User getLeft() {
		return this.left;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeft(User left) {
		this.left = left;
	}

	public int getScore() {
		return this.score;
	}

	/**
	 * 
	 * @param value
	 */
	public void setScore(int score) {
		this.score = score;
	}


	public String getNickname() {
		return this.nickname;
	}

	/**
	 * 
	 * @param value
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}