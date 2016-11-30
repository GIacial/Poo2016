package npc;

import Game.Item;

public class Npc_Spliffer extends ImmortalNPC{

	private static final long serialVersionUID = -5663581202288857028L;
	
	public Npc_Spliffer() {
		super("Spliffer", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Un rat g�ant se tenant sur ses pattes arri�res et portant un kimono");	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		System.out.println("Merci de m'avoir sauv� mon amis, un grand guerrier tu es. ");
		return i;
	}

}
