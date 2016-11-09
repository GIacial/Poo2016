package exit;

import Game.Exit;
import Game.Place;
import Item.UseableItem;


public class LockedExit extends Exit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1902235641184575453L;
	private boolean isLocked;
	
	public LockedExit(Place nextPlace) {
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
	
	public void open(UseableItem i){
		this.isLocked=false;
		// TODO Verifier que c'est une clé pour ouvrir la porte
	}

	@Override
	public Place crossing() {
		Place p = null;
		if(this.isLocked){
			System.out.println("Ahah tu t'es pris la porte mdr");
		}
		else{
			p=super.crossing();
		}
		return p;
	}
	
	

}
