package exception;

public class GameException_GameOver extends GameException {

	private static final long serialVersionUID = 4888963251458682003L;

	public GameException_GameOver() {
		super("Game Over");
	}

	public GameException_GameOver(String msg) {
		super(msg);
	}

}
