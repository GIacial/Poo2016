package Game;

public abstract class Exit {

	private Place nextPlace;

	/**
	 * A builder of Exit
	 * @param nextPlace  the place where you are when you cross the exit
	 */
	public Exit(Place nextPlace) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  Return true if the nextPlace!=null else false
	 */
	public boolean haveNextPlace() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  the place where you go when you crossing the exit
	 */
	public Place crossing() {
		throw new UnsupportedOperationException();
	}
}
