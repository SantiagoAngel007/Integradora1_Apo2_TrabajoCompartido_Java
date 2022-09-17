package model;

public class Pipe {

	/**
	 * Description : Atribute that takes the enumeration Type to create a pipe.
	 */
	private Type pipeType;

	/**
	 * Description : Atribute that let us know if the pipe can be connected to the font or the sewer.
	 */
	private boolean isCircular;

	/**
	 * Constructor of class Pipe.
	 * @param pipeType
	 * @param outFallCapacity
	 */
	public Pipe(Type pipeType, boolean isCircular) {
		
		this.pipeType = pipeType;

		this.isCircular = isCircular;
	}

	/**
	 * Get the pipeType on the object pipe.
	 */
	public Type getPipeType() {
		return this.pipeType;
	}

	/**
	 * Set the pipeType on the object pipe.
	 * @param pipeType
	 */
	public void setPipeType(Type pipeType) {
		this.pipeType = pipeType;
	}

	/**
	 * Get the isCircular atribute on the object pipe.
	 */
	public boolean getisCircular() {
		return this.isCircular;
	}

	/**
	 * Set the isCircular atribute on the object pipe.
	 * @param isCircular
	 */
	public void setisCircular(boolean isCircular) {
		this.isCircular = isCircular;
	}

}