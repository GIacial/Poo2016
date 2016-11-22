package Item;



public abstract class Equipment extends RecoverableItem {

	private static final long serialVersionUID = 2631997706440494533L;

	private int 	defenseBonus;
	private int 	attackBonus;
	private int 	healthBonus;

	
	
	
	/**
	 * A builder of Equipement class
	 * @param name  The name of the Equipement
	 */
	public Equipment(String name, int defB, int atkB, int healB) {
		super(name);
		this.attackBonus = atkB;
		this.defenseBonus = defB;
		this.healthBonus = healB;
		if(this.attackBonus < 0){
			this.attackBonus = 0;
		}
		if(this.defenseBonus < 0){
			this.defenseBonus = 0;
		}
		if(this.healthBonus < 0){
			this.healthBonus = 0;
		}
		
	}

	public int getDefenseBonus() {
		return this.defenseBonus;
	}

	public int getAttackBonus() {
		return this.attackBonus;
	}

	public int getHealthBonus() {
		return this.healthBonus;
	}
	
	public abstract String getTypeName();
	
	public void EquipementDescription(){
		System.out.println(this.getTypeName() + " : " + this.getName());
		System.out.println("Atk : " + this.attackBonus);
		System.out.println("Def : " + this.defenseBonus);
		System.out.println("VieMax : " + this.healthBonus);
	}
}
