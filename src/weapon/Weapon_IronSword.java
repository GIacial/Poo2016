package weapon;

import Item.Weapon;

public class Weapon_IronSword extends Weapon {

	private static final long serialVersionUID = -1071729453900525663L;

	public Weapon_IronSword() {
		super("Epée_en_fer", 0, 3, 0, 2, 8);
	}

	@Override
	public void description() {
		System.out.println("Une épée classique en fer");

	}

}
