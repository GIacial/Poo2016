package Item;

import exit.LockedExit;

public class Item_Key extends UseableItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6435067717372497868L;

	public Item_Key() {
		super("Cl�");
	}

	@Override
	public void description() {
		System.out.println("Ceci est une cl� , elle sert surement � ouvrir quelque-chose");

	}

	@Override
	public boolean use(Object target) {
		boolean use=false;
		if(target instanceof LockedExit){
			LockedExit door= (LockedExit)target;
			door.open(this);
			use=true;		
		}
		return use;
	}

}
