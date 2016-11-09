package Game;

import java.io.*;

import interfacePackage.HaveDescription;



public abstract class Exit implements Serializable,HaveDescription {


	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = 2526207353620348544L;
	
	private Place nextPlace;

	/**
	 * A builder of Exit
	 * @param nextPlace  the place where you are when you cross the exit
	 */
	public Exit(Place nextPlace) {
		this.nextPlace=nextPlace;
	}

	/**
	 * @return  Return true if the nextPlace!=null else false
	 */
	public boolean haveNextPlace() {
		return this.nextPlace!=null;
	}

	/**
	 * @return  the place where you're going when you're exiting the room
	 */
	public Place crossing() {
		return this.nextPlace;
	}
}
