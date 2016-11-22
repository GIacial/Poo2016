package exception;


public abstract class GameException extends Exception {

	private static final long serialVersionUID = 1055096584481319906L;

	public GameException() {
		super("Game Exception");
	}

	public GameException(String msg) {
		super(msg);
	}
	
	

}
