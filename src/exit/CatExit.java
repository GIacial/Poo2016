package exit;

import Game.Place;
import Item.UseableItem;
import useableItem.Item_CatKey;

public class CatExit extends LockedExit_A {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4877928983321235817L;

	public CatExit(Place nextPlace) {
		super(nextPlace);
	}

	@Override
	public void description() {
		System.out.println("Une porte avec des dessins de chatons");
		super.description();
	}

	@Override
	public boolean open(UseableItem i) {
		boolean use = false;
		if(i instanceof Item_CatKey){
			super.open(null);
			use = true;
			System.out.println("La clé ouvre la porte");
		}
		return use;
	}
	
	

}
