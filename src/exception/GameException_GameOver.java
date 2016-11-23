package exception;

public class GameException_GameOver extends GameException {

	private static final long serialVersionUID = 4888963251458682003L;

	/**
	 * Un constructeur de la classe
	 */
	public GameException_GameOver() {
		super("Game Over");
	}

	/**
	 * Un constructeur de la classe
	 * @param msg Le message de l'exception
	 */
	public GameException_GameOver(String msg) {
		super(msg);
	}

}
