package weapon;

import Item.Weapon;

public class Weapon_BasicSword extends Weapon{

	private static final long serialVersionUID = 3628478379042329397L;

	public Weapon_BasicSword() {
		super("Ep�e_classique", 1, 1, 1, 2, 5);
	}

	@Override
	public void description() {
		System.out.println("Une �p�e classique");
	}



}
