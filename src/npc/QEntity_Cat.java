package npc;

import Game.Item;
import useableItem.Item_CatKey;

public class QEntity_Cat extends Entity_Cat {


	private static final long serialVersionUID = -1337781454844307614L;
	private boolean donnerCle;

	public QEntity_Cat() {
		this.donnerCle=false;
	}

	@Override
	public Item speak() {
		Item i=super.speak();
		if(!this.donnerCle){
			i=new Item_CatKey();
			System.out.println("Une belle clé est entre ses pattes ");
		}
		return i;
	}
	
	

}
