package exit;

import Game.Place;
import Item.UseableItem;
import useableItem.Item_Key;

/**
 * 
 * Uns sortie garder par un verrou
 *
 */
public class LockedExit extends LockedExit_A {

	private static final long serialVersionUID = 1902235641184575453L;
	

	/**
	 * Un constructeur de porte ferm�.
	 * Le verrou est ferm� par d�fault
	 * @param nextPlace le lieu o� l'on arrive en traversant la sortie
	 */
	public LockedExit(Place nextPlace) {
		super(nextPlace);
	}


	
	/**
	 * Permet d'ouvrir la porte
	 * @param i L'item qui deverouille la porte
	 * @return T si operation � r�ussi sinon F
	 */
	public boolean open(UseableItem i){
		boolean use = false;
		if(i instanceof Item_Key){
			super.open(null);
			use = true;
			System.out.println("La cl� ouvre la porte");
		}
		return use;
	}

	
	

}
