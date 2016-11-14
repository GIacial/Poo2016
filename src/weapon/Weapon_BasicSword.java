package weapon;

import Item.Weapon;

public class Weapon_BasicSword extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3628478379042329397L;

	public Weapon_BasicSword() {
		super("Epée_classique", 0, 0, 0, 1, 5);
	}

	@Override
	public void description() {
		System.out.println("Une épée classique");
	}



}
