package Item;

public abstract class Weapon extends Equipement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3325955821692423257L;

	public Weapon(String name, int defB, int atkB, int healB,int minAtk,int maxAtk) {
		super(name, defB, atkB, healB);
		this.atkMax=maxAtk;
		this.atkMin=minAtk;
	}

	private int atkMax;
	private int atkMin;

	public int getAtkMax() {
		return this.atkMax;
	}

	public int getAtkMin() {
		return this.atkMin;
	}
}
