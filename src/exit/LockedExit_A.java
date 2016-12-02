package exit;

import Game.Exit;
import Game.Place;
import Item.UseableItem;

public abstract class LockedExit_A extends Exit {


	private static final long serialVersionUID = 2385960605454532568L;

	
private boolean 	isLocked;
	
	/**
	 * Un constructeur de porte fermé.
	 * Le verrou est fermé par défault
	 * @param nextPlace le lieu où l'on arrive en traversant la sortie
	 */
	public LockedExit_A(Place nextPlace) {
		super(nextPlace);
		this.isLocked = true ;
	}

	@Override
	public void description() {
		if(this.isLocked){
			System.out.println("Ceci est une porte verouillée");
		}else{
			System.out.println("Ceci est une porte franchissable");
		}
	}
	
	/**
	 * Permet d'ouvrir la porte
	 * @param i L'item qui deverouille la porte
	 * @return T si operation à réussi sinon F
	 */
	public  boolean open(UseableItem i){
		this.isLocked = false;
		return false;
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

	public boolean isLocked() {
		return this.isLocked;
	}
	
	

}
