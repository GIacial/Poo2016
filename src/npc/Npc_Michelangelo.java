package npc;

import Game.Item;
import useableItem.Item_Nunchakus;

public class Npc_Michelangelo extends ImmortalNPC{

	private static final long serialVersionUID = -2713588134614598222L;

	public Npc_Michelangelo() {
		super("Michelangelo", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue g�ante portant un bandeau orange");
		// TODO Auto-generated method stub	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		boolean donne = false;
		System.out.println("[" + this.getName() + "] : " + "Il faut sauver Spliffer !");
		if (donne){
			System.out.println(" D�peches toi il est en danger !");
		}else{
			System.out.println(" Prends �a tu pourrais en avoir besoin !");
			i = new Item_Nunchakus();
			System.out.println(this.getName()+" te tends un nuchaku");
			donne = true;
		}
		return i;
	}

}

