package Item;

public abstract class Weapon extends Equipment {


	private int atkMax;
	private int atkMin;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3325955821692423257L;

	public Weapon(String name, int defB, int atkB, int healB,int minAtk,int maxAtk) {
		super(name, defB, atkB, healB);
		this.atkMax=maxAtk;
		this.atkMin=minAtk;
		if(this.atkMin<0){
			this.atkMin=0;
		}
		if(this.atkMax<this.atkMin){
			this.atkMax=this.atkMin;
		}
	}


	public int getAtkMax() {
		return this.atkMax;
	}

	public int getAtkMin() {
		return this.atkMin;
	}
	
	@Override
	public String getTypeName() {
		return "Weapon";
	}


	@Override
	public void EquipementDescription() {
		super.EquipementDescription();
		System.out.println("Atk : "+this.atkMin+"-"+this.atkMax);
	}
	
	
}
