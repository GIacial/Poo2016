package monster;

import Game.Monster;

public class Monster_Kankrelat extends Monster {

	private static final long serialVersionUID = -5474551312292110115L;

	public Monster_Kankrelat() {
		super("Kankrelat", 25, 3, 4);
	}

	@Override
	public void description() {
		System.out.println("On dirait une sorte de pou sur pattes");

	}

	@Override
	public int lootXp() {
		return 5;
	}

}
