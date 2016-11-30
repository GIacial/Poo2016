package npc;

import Game.Item;
import useableItem.Item_Nunchakus;

public class Npc_Michelangelo extends ImmortalNPC{

	private static final long serialVersionUID = -2713588134614598222L;
	private boolean donne;

	public Npc_Michelangelo() {
		super("Michelangelo", 42, 42, 42);
		this.donne = false;
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue g�ante portant un bandeau orange");
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		System.out.println("[" + this.getName() + "] : " + "Il faut sauver Spliffer !");
		if (this.donne){
			System.out.println(" D�peches toi il est en danger !");
		}else{
			System.out.println(" Prends �a tu pourrais en avoir besoin !");
			i = new Item_Nunchakus();
			System.out.println(this.getName()+" te tends un nunchakus");
			this.donne = true;
		}
		return i;
	}

}

