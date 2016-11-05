package Game;

/**
 * A Entity
 */
public abstract class Entity {

	/**
	 * The name of the entity
	 */
	private String name;
	/**
	 * The current life of the entity
	 */
	private int heal;
	/**
	 * the maximum value of the heal
	 */
	private int healMax;
	/**
	 * TODO (?) the base attack of the entity
	 */
	private int attack;
	/**
	 * TODO (?) the defense of the entity
	 */
	private int defense;
	/**
	 * TODO (?) the speed of the entity
	 */
	private int speed;
	/**
	 * The current level of the entity
	 */
	private int level;
	/**
	 * the amount of xp that the entity have
	 */
	private int xp;
	
	
	/**
	 * A builder of the Entity Class
	 * @param name  The name of the new Entity
	 * @param maxHeal  The maximun life of the new Entity
	 * @param attack  TODO (?) The attack of the new Entity
	 * @param defense  TODO (?) The defense of the new Entity
	 * @param speed  TODO (?) the speed of the new Entity
	 */
	public Entity(String name, int maxHeal, int attack, int defense, int speed) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  The name  of the entity
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Inflict the Dmg damage to a alive entity
	 * @param Dmg  The amount of damage inflict to the entity
	 */
	public void takeDmg(int Dmg) {
		throw new UnsupportedOperationException();
	}

	/**
	 * The Entity recovers nbHeal heal point
	 * @param nbHeal  The amount of heal that the Entity recovers
	 */
	public void takeHeal(int nbHeal) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param def  The amount of defense of the target
	 * @return  the amount of damage that the entity will do if the target have a defense value equals to def
	 */
	private int calcDmg(int def) {
		throw new UnsupportedOperationException();
	}

	/**
	 * The Entity attacks the target
	 * @param target  The target of the attack
	 */
	public void attack(Entity target) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  true if the entity is alive Else false
	 */
	public boolean isAlive() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Print the stat of the Entity on the standard exit
	 */
	public void entityDescription() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  the amount of xp that the Entity need to level up
	 */
	private int calcXpLevelUp() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Increase the level of the Entity Increase the stat of the Entity to
	 */
	private void levelUp() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add xpEarn to Entity's xp
	 * @param xpEarn  The amount of xp that the Entity wins
	 */
	public void increaseXp(int xpEarn) {
		throw new UnsupportedOperationException();
	}


}
