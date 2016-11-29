package exit;


import Game.Place;
import Item.UseableItem;
import useableItem.Item_Bo;
import useableItem.Item_Katana;
import useableItem.Item_Nunchakus;
import useableItem.Item_Sais;

/**
 * 
 * Une sortie gardée par un verrou
 *
 */
public class FinalDoor extends LockedExit_A {
	
	private static final long serialVersionUID = 1902235641184575453L;
	private boolean[] 	verrou ;
	private final int nbKey=4;
	
	public FinalDoor(Place nextPlace) {
		super(nextPlace);
		this.verrou= new boolean[this.nbKey];
		for (int i=0 ; i<4 ; i++){
			this.verrou[i]=false;
		}
	}
	@Override
	public void description() {
		System.out.println("Cette porte a 4 serrures inhabituelles");
		super.description();
		
	}
	@Override
	public boolean open(UseableItem i) {
		boolean use=false;
		if(i instanceof Item_Bo && !this.verrou[0]){
			use = true;
			this.verrou[0]=true;
		}
		else{
			if(i instanceof Item_Katana && !this.verrou[1]){
				use = true;
				this.verrou[1]=true;
			}
			else{
				if(i instanceof Item_Nunchakus && !this.verrou[2]){
					use = true;
					this.verrou[2]=true;
				}
				else{
					if(i instanceof Item_Sais && !this.verrou[3]){
						use = true;
						this.verrou[3]=true;
					}
				}
			}
		}
		if(use){
			System.out.println("Clic ,un verrou de moins");
			this.unlocked();
		}
		return  use;
	}


	private void unlocked(){
		boolean ok =true;
		for (boolean b : this.verrou){
			ok= ok && b;
		}
		if(ok){
			super.open(null);
			System.out.println("La porte s'ouvre");
		}
	}
	
	

}
