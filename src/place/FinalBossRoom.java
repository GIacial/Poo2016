package place;

import Game.Place;
import monster.Monster_Schredder;
import useableItem.Item_BigPotion;

public class FinalBossRoom extends Place {


	private static final long serialVersionUID = -9206927899811765324L;

	public FinalBossRoom() {
		super("Salle de Schredder");
		this.addEntity(new Monster_Schredder());
		for (int i=0 ; i<2 ;i++){
			this.addItem(new Item_BigPotion());
		}
	}

	@Override
	public void description() {
		System.out.println("Il vous attendez");
		super.description();
	}
	
	

}
