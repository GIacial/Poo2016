package npc;

import Game.Item;
import useableItem.Item_Bo;

public class Npc_Donatello extends ImmortalNPC{

	private static final long serialVersionUID = 4189466941690777505L;

	public Npc_Donatello() {
		super("Donatello", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue g�ante portant un bandeau violet");
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
			i = new Item_Bo();
			System.out.println(this.getName()+" te tends un Bo");
			donne = true;
		}
		return i;
	}

}