package npc;

import Game.Item;
import useableItem.Item_Sais;

public class Npc_Raphael extends ImmortalNPC{

	private static final long serialVersionUID = -2713588134614598222L;

	public Npc_Raphael() {
		super("Raphael", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Une tortue géante portant un bandeau rouge");
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
			i = new Item_Sais();
			System.out.println(this.getName()+" te tends un Saïs");
			donne = true;
		}
		return i;
	}

}

