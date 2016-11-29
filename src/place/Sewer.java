package place;

import boots.Boots_LeatherBoots;
import chest.Chest_LeatherChest;
import furniture.Furniture_Fridge;
import glove.Glove_LeatherGlove;
import head.Head_LeatherHead;
import monster.*;
import trouser.Trouser_LeatherTrouser;
import useableItem.Item_Potion;
import weapon.*;

public class Sewer extends CommonPlace {


	private static final long serialVersionUID = 3722509936923424516L;

	public Sewer( String description) {
		super("Couloir d'égout", description);
		if(Math.random() < 0.6){
			this.addItem(new Furniture_Fridge());
		}
		if(Math.random() < 0.4){
			this.addItem(new Item_Potion());
		}
		if(Math.random() < 0.4){
			this.addEntity(new Monster_Bandit());
		}
		else{
			if(Math.random() < 0.3){
				this.addEntity(new Monster_Alien());
			}
		}
		if(Math.random() < 0.4){
			switch((int)(Math.random()*6)){
				case 0:this.addItem(new Chest_LeatherChest());
					break;
				case 1:this.addItem(new Glove_LeatherGlove());
					break;	
				case 2:this.addItem(new Boots_LeatherBoots());
					break;
				case 3:this.addItem(new Head_LeatherHead());
					break;
				case 4:this.addItem(new Trouser_LeatherTrouser());
					break;	
				default:this.addItem(new Weapon_IronSword());
					break;
			}
		}
	}

}
