package place;

import Game.Place;
import boots.Boots_LeatherBoots;
import head.Head_LeatherHead;
import monster.Monster_Alien;
import npc.Entity_Cat;
import useableItem.Item_Potion;

public class CrossRoad_Sewer extends Place {


	private static final long serialVersionUID = 2814370318508051540L;

	public CrossRoad_Sewer() {
		super("Carrefour");
		//les item
		if(Math.random() < 0.5){
			this.addItem(new Boots_LeatherBoots());
		}
		if(Math.random() < 0.4){
			this.addItem(new Head_LeatherHead());
		}
		if(Math.random() < 0.15){
			this.addEntity(new Entity_Cat());
		}
		if(Math.random() < 0.4){
			this.addItem(new Item_Potion());
		}
		if(Math.random() < 0.65){
			this.addEntity(new Monster_Alien());
		}
		
		
	}
	
	@Override
	public void description() {
		System.out.println("Les égouts partent dans plusieurs directions");
		super.description();
	}

}
