package exit;

import Game.Exit;
import Game.Place;
import Game.*;

public class ClassicExit extends Exit{

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -6683559394666117511L;

	public ClassicExit(Place nextPlace) {
		super(nextPlace);
	}

	@Override
	public void description() {
		System.out.println("Une description de sortie");
		
	}

}
