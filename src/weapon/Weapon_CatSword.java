package weapon;

import Item.Weapon;

public class Weapon_CatSword extends Weapon {


	private static final long serialVersionUID = 258606611313856509L;

	public Weapon_CatSword() {
		super("Epee_chat", 25, 100, 50, 0, 0);
	}

	@Override
	public void description() {
		System.out.println("Une épée avec des chats gravés sur la lame");
		
	}

}
