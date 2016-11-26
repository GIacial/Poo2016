package weapon;

import Item.Weapon;

public class Weapon_BasicSword extends Weapon{

	private static final long serialVersionUID = 3628478379042329397L;

	/**
	 * Un constructeur de la classe
	 */
	public Weapon_BasicSword() {
		super("Epee_classique", 1, 1, 1, 2, 5);
	}

	@Override
	public void description() {
		System.out.println("Une épée classique");
	}



}
