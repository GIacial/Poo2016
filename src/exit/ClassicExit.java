package exit;


import Game.*;

/**
 * Un sortie sans protection
 *
 */
public class ClassicExit extends Exit{


	private static final long serialVersionUID = -6683559394666117511L;

	/**
	 * Un constructeur d'une sortie classique
	 * @param nextPlace Le lieu où l'on arrive quand on traverse la sortie
	 */
	public ClassicExit(Place nextPlace) {
		super(nextPlace);
	}

	@Override
	public void description() {
		System.out.println("Une sortie classique");
		
	}

}
