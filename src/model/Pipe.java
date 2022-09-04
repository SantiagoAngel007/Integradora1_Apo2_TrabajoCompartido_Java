package model;

public class Pipe {

	private Type pipeType;
	private boolean isCircular;

	/**
	 * 
	 * @param pipeType
	 * @param outFallCapacity
	 */
	public Pipe(Type pipeType, boolean isCircular) {
		this.pipeType = pipeType;
		this.isCircular = isCircular;
	}

	public Type getPipeType() {
		return this.pipeType;
	}

	/**
	 * 
	 * @param pipeType
	 */
	public void setPipeType(Type pipeType) {
		this.pipeType = pipeType;
	}

	public boolean getIsCircular() {
		return this.isCircular;
	}

	public void setIscircular(boolean isCircular){
		this.isCircular =isCircular;
	}

}