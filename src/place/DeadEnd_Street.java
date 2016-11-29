package place;

import Game.Place;
import boots.Boots_LeatherBoots;
import furniture.Furniture_Car;
import head.Head_LeatherHead;
import npc.Entity_Cat;
import useableItem.Item_Potion;

public class DeadEnd_Street extends Place {


	private static final long serialVersionUID = -3281795312858195131L;

	public DeadEnd_Street() {
		super("Rue impasse");
		//les truc a mettre dedans
		if(Math.random() < 0.3){
			this.addItem(new Boots_LeatherBoots());
		}
		if(Math.random() < 0.2){
			this.addItem(new Head_LeatherHead());
		}
		if(Math.random() < 0.4){
			this.addEntity(new Entity_Cat());
		}
		if(Math.random() < 0.4){
			this.addItem(new Item_Potion());
		}
		if(Math.random() < 0.5){
			this.addItem(new Furniture_Car());
		}
	}

	@Override
	public void description() {
		System.out.println("Cette rue est un cul de sac");
		super.description();
	}
	
	

}
