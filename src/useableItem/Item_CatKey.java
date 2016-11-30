package useableItem;

import Item.UseableItem;
import exit.CatExit;

public class Item_CatKey extends UseableItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4929364442582306878L;

	public Item_CatKey() {
		super("Cle_chat");
	}

	@Override
	public void description() {
		super.description();
		System.out.println("Une clé en forme de patte de chat");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof CatExit){
			CatExit door = (CatExit)target;
			use = door.open(this);		
		}
		else{
			System.out.println("Impossible d'utiliser la clé sur cette cible");
		}
		return use;
	}
	
	

}
