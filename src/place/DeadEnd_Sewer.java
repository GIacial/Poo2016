package place;

import Game.Place;
import chest.Chest_LeatherChest;
import furniture.Furniture_Fridge;
import monster.*;
import npc.Entity_Cat;

public class DeadEnd_Sewer extends Place {


	private static final long serialVersionUID = -2405306234161724999L;

	public DeadEnd_Sewer() {
		super("égouts impasse");
		//les item
		if(Math.random() < 0.4){
			this.addItem(new Furniture_Fridge());
		}
		if(Math.random() < 0.1){
			this.addEntity(new Entity_Cat());
		}
		if(Math.random() < 0.2){
			this.addEntity(new Monster_Alien());
		}
		else{
			if(Math.random() < 0.8){
				this.addEntity(new Monster_Sbire());
			}
		}
		if(Math.random() < 0.4){
			this.addItem(new Chest_LeatherChest());
		}
	}

	@Override
	public void description() {
		System.out.println("Ce Couloir d'égouts fini en cul de sac");
		super.description();
	}
	
	

}
