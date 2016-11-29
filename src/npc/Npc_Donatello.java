package npc;

import Game.Item;
import useableItem.Item_Bo;

public class Npc_Donatello extends ImmortalNPC{

	private static final long serialVersionUID = 4189466941690777505L;
	private boolean donne;

	public Npc_Donatello() {
		super("Donatello", 42, 42, 42);
		this.donne=false;
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue géante portant un bandeau violet");
		// TODO Auto-generated method stub	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		System.out.println("[" + this.getName() + "] : " + "Il faut sauver Spliffer !");
		if (this.donne){
			System.out.println(" Dépeches toi il est en danger !");
		}else{
			System.out.println(" Prends ça tu pourrais en avoir besoin !");
			i = new Item_Bo();
			System.out.println(this.getName()+" te tends un Bo");
			this.donne = true;
		}
		return i;
	}

}