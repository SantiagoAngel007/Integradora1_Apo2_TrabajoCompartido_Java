package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

	private User root;
	private ArrayList<User> listScores;
	private Board head;
	private Board tail;


	public Controller(){
		
	}
	public String  addUserScore(int score, String nickname) {
		return addUserScore(score, nickname,root);
	}

	/**
	 * 
	 * @param score
	 * @param current
	 */
	private String addUserScore(int score,String nickname, User current) {
		
		if(root== null){
			User newUser = new User(score, nickname);
			root = newUser;
			return "Se agrego el puntaje";
		}else{

			if(current.getScore()<score){
				
				if(current.getRight()==null){
					User user = new User(score, nickname);
					current.setRight(user);
				}else{
					addUserScore(score, nickname, current.getRight());
				}
			}else{
				
				if(current.getLeft() == null){
					User user = new User(score, nickname);
					current.setLeft(user);
					
				}else{
					addUserScore(score, nickname, current.getLeft());
				}
			}
			return "Se agrego el puntaje a la tabla";
		}
		
		
		
	}

	

	public ArrayList<User> scoreInOrder() {
		return scoreInOrder(root);
	}

	/**
	 * 
	 * @param score
	 */
	private ArrayList<User> scoreInOrder(User user) {
		if(user == null){
            return listScores;
        }

        scoreInOrder(user.getLeft());
        listScores.add(user);
        scoreInOrder(user.getRight());
        return listScores;
	}
	


	public String showLeaderBoard(){
		scoreInOrder();
		String out = "";
		int size = listScores.size();

		for(int i = 0; i<size;i++){
			out += "| " + listScores.get(i).getNickname() + " : " + listScores.get(i).getScore() + " |"; 
		}
		return out;
	}
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
	public String simulate(Board board) {
		// TODO - implement Controller.simulate
		throw new UnsupportedOperationException();
	}

}