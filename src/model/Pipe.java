package model;

public class Pipe {

	private Type pipeType;
	private boolean outFallCapacity;

	/**
	 * 
	 * @param pipeType
	 * @param outFallCapacity
	 */
	
	public Pipe(Type pipeType, boolean outFallCapacity) {
		
		this.pipeType = pipeType;

		this.outFallCapacity = outFallCapacity;
	}

	public Type getPipeType() {
		return this.pipeType;
	}

	public void setPipeType(Type pipeType) {
		this.pipeType = pipeType;
	}

	public boolean getOutFallCapacity() {
		return this.outFallCapacity;
	}

	public void setOutFallCapacity(boolean outFallCapacity) {
		this.outFallCapacity = outFallCapacity;
	}

}