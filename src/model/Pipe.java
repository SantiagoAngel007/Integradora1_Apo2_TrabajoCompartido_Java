package model;

public class Pipe {

	private Type pipeType;
	private boolean outFallCapacity;

	/**
	 * 
	 * @param pipeType
	 * @param outFallCapacity
	 */
	public Pipe(Type pipeType, int outFallCapacity) {
		// TODO - implement Pipe.Pipe
		throw new UnsupportedOperationException();
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

	public boolean getOutFallCapacity() {
		return this.outFallCapacity;
	}

	/**
	 * 
	 * @param outFallCapacity
	 */
	public void setOutFallCapacity(boolean outFallCapacity) {
		this.outFallCapacity = outFallCapacity;
	}

}