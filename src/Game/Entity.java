package Game;


import java.io.*;

import exception.GameException_GameOver;
import interfacePackage.HaveDescription;



/**
 * A Entity
 */
public abstract class Entity implements Serializable,HaveDescription {

	private static final long serialVersionUID = -3785660433437786906L;

	private String 		name; 		//Entity's name
	private int 		heal; 		//Entity's current life
	private int 		healMax; 	//Heal maximum value
	private int 		attack; 	//Entity bases attack
	private int 		defense; 	//Entity's defense (transformé en % par la suite)

	
	
	
	
	
	
	/**
	 * A builder of the Entity Class
	 * @param name  The name of the new Entity
	 * @param maxHeal  The maximun life of the new Entity
	 * @param attack   The attack of the new Entity
	 * @param defense   The defense of the new Entity
	 */
	public Entity(String name, int maxHeal, int attack, int defense) {
		this.name = name;
		this.healMax = maxHeal;
		this.heal = maxHeal;
		this.attack = attack;
		this.defense = defense;
		
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
	 * @throws GameException_GameOver 
	 */
	public void takeDmg(int Dmg) throws GameException_GameOver {
		this.heal -= Dmg;	
		
	}

	/**
	 * The Entity recovers nbHeal heal point
	 * @param nbHeal  The amount of heal that the Entity recovers
	 */
	public void takeHeal(int nbHeal) {
		this.heal += nbHeal;
		if(this.heal > this.healMax){
			this.heal = this.healMax;
		}
	}

	/**
	 * @param def  The amount of defense of the target
	 * @return  the amount of damage that the entity will do if the target have a defense value equals to def
	 */
	private int calcDmg(int def) {
		double protCap = 0.8;
		int a = 50;
		double protection = protCap * (1 - Math.exp(-(double)def/a));
		double dmg = (1 - protection) * this.getAttack();
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
	 * @throws GameException_GameOver 
	 */
	public void attack(Entity target) throws GameException_GameOver {
			target.takeDmg(this.calcDmg(target.defense));
	}

	/**
	 * @return  true if the entity is alive Else false
	 */
	public boolean isAlive() {
		return this.heal > 0;
	}

	/**
	 * Print the stat of the Entity on the standard exit
	 */
	public void entityDescription() {
		System.out.println("Vie : " + this.heal + "/"+this.healMax);
		System.out.println("Attack : " + this.attack);
		System.out.println("Defense : " + this.defense);
		System.out.println("Nom : " + this.name);
	}

	@Override
	public String toString() {
		return this.name  ;
	}
	
	/**
	 * Permet d'ajouter la valeur bonus à la vieMax
	 * Mettre une valeur négatif diminue la vie
	 * @param bonus la valeur à ajouter 
	 */
	public void addHp(int bonus){
		this.healMax += bonus;
		if(this.heal > this.healMax){
			this.heal = this.healMax;
		}
	}
	
	/**
	 * Permet d'ajouter la valeur bonus à l' attaque
	 * Mettre une valeur négatif diminue l' attaque
	 * @param bonus la valeur à ajouter 
	 */
	public void addAtk(int bonus){
		this.attack += bonus;

	}
	
	/**
	 * Permet d'ajouter la valeur bonus à la defense
	 * Mettre une valeur négatif diminue la defense
	 * @param bonus la valeur à ajouter 
	 */
	public void addDef(int bonus){
		this.defense += bonus;
	}
	
	
	
}
