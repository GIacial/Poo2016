package npc;

import Game.Item;
import useableItem.Item_Katana;

public class Npc_Leonardo extends ImmortalNPC{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5054882055077354603L;
	
	public Npc_Leonardo() {
		super("Leonardo", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue géante portant un bandeau bleu");
		// TODO Auto-generated method stub	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		boolean donne = false;
		System.out.println("[" + this.getName() + "] : " + "Il faut sauver Spliffer !");
		if (donne){
			System.out.println(" Dépeches toi il est en danger !");
		}else{
			System.out.println(" Prends ça tu pourrais en avoir besoin !");
			i = new Item_Katana();
			System.out.println(this.getName()+" te tends un katana");
			donne = true;
		}
		return i;
	}

}
