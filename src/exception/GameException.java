package exception;


public abstract class GameException extends Exception {

	private static final long serialVersionUID = 1055096584481319906L;

	/**
	 * Un constructeur de la classe
	 */
	public GameException() {
		super("Game Exception");
	}

	/**
	 * Un constructeur de la classe
	 * @param msg Le message de l'exception
	 */
	public GameException(String msg) {
		super(msg);
	}
	
	

}
