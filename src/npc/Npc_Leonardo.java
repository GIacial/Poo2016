package npc;

import Game.Item;
import useableItem.Item_Katana;

public class Npc_Leonardo extends ImmortalNPC{


	private static final long serialVersionUID = 5054882055077354603L;
	private boolean donne;
	
	public Npc_Leonardo() {
		super("Leonardo", 42, 42, 42);
		this.donne = false;
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue géante portant un bandeau bleu");	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		System.out.println("[" + this.getName() + "] : " + "Il faut sauver Spliffer !");
		if (this.donne){
			System.out.println(" Dépeches toi il est en danger !");
		}else{
			System.out.println(" Prends ça tu pourrais en avoir besoin !");
			i = new Item_Katana();
			System.out.println(this.getName()+" te tends un katana");
			this.donne = true;
		}
		return i;
	}

}
