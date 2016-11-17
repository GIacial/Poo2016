package Game;


import java.io.*;

import interfacePackage.HaveDescription;



/**
 * A Entity
 */
public abstract class Entity implements Serializable,HaveDescription {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3785660433437786906L;
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
	 *  the base attack of the entity
	 */
	private int attack;
	/**
	 *  the defense of the entity
	 *  int puis tranform en %
	 */
	private int defense;

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
	 */
	public Entity(String name, int maxHeal, int attack, int defense) {
		this.name=name;
		this.healMax=maxHeal;
		this.heal=maxHeal;
		this.attack=attack;
		this.defense=defense;
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
		//Le calcul des dmg qu'on prend on le met ici ducoup ou on met directement le bon dmg en parametre ? 
		this.heal-=Dmg;			
		
	}

	/**
	 * The Entity recovers nbHeal heal point
	 * @param nbHeal  The amount of heal that the Entity recovers
	 */
	public void takeHeal(int nbHeal) {
		this.heal+=nbHeal;
		if(this.heal>this.healMax){
			this.heal=this.healMax;
		}
	}

	/**
	 * @param def  The amount of defense of the target
	 * @return  the amount of damage that the entity will do if the target have a defense value equals to def
	 */
	private int calcDmg(int def) {
		double protCap=0.8;
		int a=50;
		double protection=protCap*(1-Math.exp(-(double)def/a));
		double dmg=(1-protection)*this.getAttack();
		return (int)Math.round(dmg);//arrondis au 0.5 au dessus 
	}
	/**
	 * 
	 * @return the damage without target's defense
	 */
	public int getAttack(){
		return this.attack;
	}

	/**
	 * The Entity attacks the target
	 * @param target  The target of the attack
	 */
	public void attack(Entity target) {
		if (target instanceof Monster){
			target.takeDmg(this.calcDmg(target.defense));
		}else{
			System.out.println("Tu ne peux pas attaquer cette cible");
		}
		
	}

	/**
	 * @return  true if the entity is alive Else false
	 */
	public boolean isAlive() {
		return this.heal>0;
	}

	/**
	 * Print the stat of the Entity on the standard exit
	 */
	public void entityDescription() {
		System.out.println("Vie : "+ this.heal);
		System.out.println("Attack : " + this.attack);
		System.out.println("Defense : " + this.defense);
		System.out.println("Level : " + this.level);
		System.out.println("Nom : " + this.name);
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
		this.xp+=xpEarn;
		if(this.xp>this.calcXpLevelUp()){
			this.levelUp();
		}
	}

	@Override
	public String toString() {
		return this.name + "(nv " + this.level+")" ;
	}
	
	public void addHp(int bonus){
		this.healMax+=bonus;
	}
	
	public void addAtk(int bonus){
		this.attack+=bonus;

	}
	
	public void addDef(int bonus){
		this.defense+=bonus;
	}
	
}
