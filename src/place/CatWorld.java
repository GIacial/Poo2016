package place;

import Game.Entity;
import Game.Place;
import npc.Entity_Cat;
import npc.QEntity_Cat;
import weapon.Weapon_CatSword;

public class CatWorld extends Place {


	private static final long serialVersionUID = -9135256288529018533L;
	private boolean questComplete;

	public CatWorld() {
		super("Monde de Schr�dinger");
		this.questComplete=false;
		for(int i=0 ; i <  4 ; i++){
			this.addEntity(new Entity_Cat());
		}
	}

	@Override
	public void addEntity(Entity entity) {
		super.addEntity(entity);
		if (entity instanceof QEntity_Cat){
			if(!this.questComplete){
				this.questComplete = true;
				this.addItem(new Weapon_CatSword());
				System.out.println("[chats] Mierci");
				System.out.println("Une magnifique �p�e �tait cach�e � l'endroit o� se tenaient les chats.");
			}
		}
	}

	@Override
	public void description() {
		System.out.println("Un monde id�al pour les chats");
		super.description();
	}
	
	

}
