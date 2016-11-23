package exit;

import Game.Exit;
import Game.Place;
import Item.UseableItem;
import useableItem.Item_Key;

/**
 * 
 * Uns sortie garder par un verrou
 *
 */
public class LockedExit extends Exit {

	private static final long serialVersionUID = 1902235641184575453L;
	
	private boolean 	isLocked;
	
	/**
	 * Un constructeur de porte ferm�.
	 * Le verrou est ferm� par d�fault
	 * @param nextPlace le lieu o� l'on arrive en traversant la sortie
	 */
	public LockedExit(Place nextPlace) {
		super(nextPlace);
		this.isLocked = true ;
	}

	@Override
	public void description() {
		if(this.isLocked){
			System.out.println("Ceci est une porte verouill�e");
		}else{
			System.out.println("Ceci est une porte franchissable");
		}
	}
	
	/**
	 * Permet d'ouvrir la porte
	 * @param i L'item qui deverouille la porte
	 * @return T si operation � r�ussi sinon F
	 */
	public boolean open(UseableItem i){
		boolean use = false;
		if(i instanceof Item_Key){
			this.isLocked = false;
			use = true;
			System.out.println("La cl� ouvre la porte");
		}
		return use;
	}

	@Override
	public Place crossing() {
		Place p = null;
		if(this.isLocked){
			System.out.println("Ahah tu t'es pris la porte mdr");
		}
		else{
			p = super.crossing();
		}
		return p;
	}
	
	

}
