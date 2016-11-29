package place;

import furniture.*;
import glove.*;
import monster.*;
import useableItem.*;
import weapon.*;

public class Street extends CommonPlace {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11349278303361875L;

	public Street( String description) {
		super("Rue", description);
		//les item random
		if(Math.random() < 0.3){
			this.addItem(new Weapon_BasicSword());
		}
		if(Math.random() < 0.2){
			this.addItem(new Glove_LeatherGlove());
		}
		if(Math.random() < 0.5){
			this.addEntity(new Monster_Bandit());
		}
		if(Math.random() < 0.6){
			this.addItem(new Item_Potion());
		}
		if(Math.random() < 0.7){
			this.addItem(new Furniture_Car());
		}
	}

}
