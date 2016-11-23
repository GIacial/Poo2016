package Item;



public abstract class Equipment extends RecoverableItem {

	private static final long serialVersionUID = 2631997706440494533L;

	private int 	defenseBonus;
	private int 	attackBonus;
	private int 	healthBonus;

	
	
	
	/**
	 * Un constructeur d'Equipement
	 * @param name  Le nom de l'équipement
	 * @param defB  La defense donné par l'equipement
	 * @param atkB  L'attaque donné par l'equipement
	 * @param healB La vie donné par l'equipement
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

	/**
	 * 
	 * @return La defense donné par cette équipement
	 */
	public int getDefenseBonus() {
		return this.defenseBonus;
	}
	
	/**
	 * 
	 * @return L'attaque donné par cette équipement
	 */
	public int getAttackBonus() {
		return this.attackBonus;
	}

	/**
	 * 
	 * @return La vie donné par cette équipement
	 */
	public int getHealthBonus() {
		return this.healthBonus;
	}
	
	/**
	 * 
	 * @return Le nom du type de l'équipement
	 */
	public abstract String getTypeName();
	
	/**
	 * Affiche les stats de l'équipement
	 */
	public void EquipementDescription(){
		System.out.println(this.getTypeName() + " : " + this.getName());
		System.out.println("Atk : " + this.attackBonus);
		System.out.println("Def : " + this.defenseBonus);
		System.out.println("VieMax : " + this.healthBonus);
	}
}
