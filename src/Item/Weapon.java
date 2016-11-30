package Item;

public abstract class Weapon extends Equipment {

	private static final long serialVersionUID = -3325955821692423257L;
	public static final String TypeName = "weapon";
	
	
	private int 	atkMax;
	private int 	atkMin;
	
	
	
	/**
	 * Un constructeur de Weapon
	 * @param name Le nom de l'arme
	 * @param defB la defense donné par l'arme
	 * @param atkB l'attaque donné par l'arme
	 * @param healB la vie donné par l'arme
	 * @param minAtk l'attaque minimal de l'attaque
	 * @param maxAtk l'attaque maximal de l'arme
	 */
	public Weapon(String name, int defB, int atkB, int healB,int minAtk,int maxAtk) {
		super(name, defB, atkB, healB);
		this.atkMax = maxAtk;
		this.atkMin = minAtk;
		if(this.atkMin < 0){
			this.atkMin = 0;
		}
		if(this.atkMax < this.atkMin){
			this.atkMax = this.atkMin;
		}
	}

	/**
	 * 
	 * @return Le maximun de degat de l'arme
	 */
	public int getAtkMax() {
		return this.atkMax;
	}

	/**
	 * 
	 * @return Le minimun de degat de l'arme
	 */
	public int getAtkMin() {
		return this.atkMin;
	}
	
	@Override
	public String getTypeName() {
		return Weapon.TypeName;
	}


	@Override
	public void EquipementDescription() {
		super.EquipementDescription();
		System.out.println("Atk : "+this.atkMin+"-"+this.atkMax);
	}
	
	
}
