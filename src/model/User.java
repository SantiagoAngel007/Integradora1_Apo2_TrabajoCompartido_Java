package model;


public class User {

	/**
	 * Description :Atribute of type User used to know the right object on the BST.
	 */
	private User right;

	/**
	 * Description :Atribute of type User used to know the left object on the BST.
	 */
	private User left;

	/**
	 * Description :Atribute of type int to define the score of a game.
	 */
	private int score;

	/**
	 * Description :Atribute that defines the name of every player.
	 */
	private String nickname;

	/**
	 * Construct of class User.
	 * @param score
	 * @param nickname
	 */
	public User(int score, String nickname) {
		
		this.score = score;

		this.nickname = nickname;

	}


	public double calculateScore(){

		double points = 0;

		return points;
	}

	/**
	 * Get the right object on the BST.
	 */
	public User getRight() {
		return this.right;
	}

	/**
	 * Set the right object on the BST.
	 * @param right
	 */
	public void setRight(User right) {
		this.right = right;
	}

	/**
	 * Get the left object on the BST.
	 */
	public User getLeft() {
		return this.left;
	}

	/**
	 * Set the left object on the BST.
	 * @param left
	 */
	public void setLeft(User left) {
		this.left = left;
	}

	/**
	 * Get the score on the object on the BST.
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 *  Set the score on the object on the BST.
	 * @param value
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Get the nickname on the object on the BST.
	 */
	public String getNickname() {
		return this.nickname;
	}

	/**
	 *  Set the name on object on the BST.
	 * @param value
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}