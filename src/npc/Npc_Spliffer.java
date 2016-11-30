package npc;

import Game.Item;

public class Npc_Spliffer extends ImmortalNPC{

	private static final long serialVersionUID = -5663581202288857028L;
	
	public Npc_Spliffer() {
		super("Spliffer", 42, 42, 42);
	}
	
	@Override
	public void description() {
		System.out.println("Un rat géant se tenant sur ses pattes arrières et portant un kimono");	
	}
	
	@Override
	public  Item speak(){
		Item i = null;
		System.out.println("Merci de m'avoir sauvé mon amis, un grand guerrier tu es. ");
		return i;
	}

}
