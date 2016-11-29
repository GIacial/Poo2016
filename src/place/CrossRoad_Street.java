package place;

import Game.Place;
import chest.Chest_LeatherChest;
import furniture.Furniture_Car;
import monster.Monster_Bandit;
import trouser.Trouser_LeatherTrouser;

public class CrossRoad_Street extends Place {

	private static final long serialVersionUID = 5459972386811262242L;

	public CrossRoad_Street() {
		super("Carrefour");
		//les item a mettre
		if(Math.random() < 0.2){
			this.addItem(new Trouser_LeatherTrouser());
		}
		if(Math.random() < 0.4){
			this.addItem(new Chest_LeatherChest());
		}
		if(Math.random() < 0.7){
			this.addEntity(new Monster_Bandit());
		}

		if(Math.random() < 0.9){
			this.addItem(new Furniture_Car());
		}
	}

	@Override
	public void description() {
		System.out.println("La rue part dans plusieurs directions");
		super.description();
	}
	
	

}
