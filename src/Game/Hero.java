package Game;

import java.util.ArrayList;
import java.util.List;

import Item.Equipment;
import Item.Weapon;
import exception.GameException_GameOver;
import interfacePackage.Recoverable;

/**
 * A Hero
 */
public class Hero extends Entity {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -8480399582238471911L;

	private EquipmentSet 		equipment;		//Hero's equipment
	private Inventory 			inventory;		//Hero's inventory
	private int 				level; 			//Hero's current level
	private int 				xp; 			//Hero's amount xp

	
	/**
	 * A builder of Hero Class
	 * @param name  The name of the new Hero
	 */
	public Hero(String name) {
		super(name,30,5,5);	
		this.equipment = new EquipmentSet(this);
		this.inventory = new Inventory();
		this.level = 1;
		this.xp = 0;
	}

	
	
	
	
	/**
	 * Equip the equipement called as nameEquip
	 * @param nameEquip  The name of the equipement that you want equip
	 */
	public void equip(String nameEquip) {
		Recoverable e = this.inventory.remove(nameEquip);
		if(e != null){
			if(e instanceof Equipment){
				Equipment equip = (Equipment)e;
				boolean ok = this.equipment.equip(equip);
				if(!ok){
					this.inventory.add(e);
				}
				else{
					System.out.println("Vous vous �quipez de " + equip.getName());
					System.out.println("Attack +" + equip.getAttackBonus());
					System.out.println("Defence +" + equip.getDefenseBonus());
					System.out.println("Hp +" + equip.getHealthBonus());
					if(equip instanceof Weapon){
						Weapon w = (Weapon)equip;
						System.out.println("attack range:" + w.getAtkMin() + "-" + w.getAtkMax());
					}
				}
			}
			else{
				System.out.println(nameEquip + " n'est pas un equipement");
				this.inventory.add(e);
			}
		}
		else{
			System.out.println("Vous ne possedez pas " + nameEquip);
		}
	}

	/**
	 * Add the item to the hero's inventory
	 * @param item  The item that the hero want add to his inventory
	 */
	public void takeItem(Recoverable item) {
		this.inventory.add(item);
	}

	/**
	 * Throw a item from your inventory
	 * @param nameItem  The name of the item that you want throw
	 * @return  the item that you throw
	 */
	public Recoverable throwItem(String nameItem) {
		return this.inventory.remove(nameItem);
	}

	/**
	 * Unequip the equipement'zone that you choose
	 * @param name  the name of the equipement'zone that you want unequip
	 */
	public void unequip(String name) {
		Equipment e = this.equipment.unequip(name);
		if(e != null){
			this.inventory.add(e);
			System.out.println("Vous enlevez votre " + e.getName());
			System.out.println("Attack -" + e.getAttackBonus());
			System.out.println("Defence -" + e.getDefenseBonus());
			System.out.println("Hp -" + e.getHealthBonus());
		}
		else{
			System.out.println("Vous n'avez pas de "+name+" �quip�");
		}
	}

	/**
	 * Use a item from your inventory
	 * @param nameItem  the name of the item that you want use
	 */
	public void useItem(String nameItem,Object target) {
		this.inventory.use(nameItem, target);
	}

	/**
	 * Print all the item of the type typeItem in your inventory
	 * @param typeItem  the item's type that you want print on the screen
	 */
	public void lookInventory(String typeItem) {
		List<Recoverable> l = new ArrayList<Recoverable>();
		switch(typeItem.toLowerCase()){
			case "equipement" : l.addAll(this.inventory.getListEquipement());
				break;
			default : l = this.inventory.getListItem();
				break;
		}
		if(l.isEmpty()){
			System.out.println("Votre sac ne contient pas " + typeItem);
		}
		for(Recoverable i: l){
			String name = "";
			if(i instanceof Item){
				name = ((Item)i).getName();
			}
			else{if(i instanceof Entity ){
				name = ((Entity)i).getName();
				}
				else{
					System.err.println("Impossible de recup le nom du recuperable");
				}
			}
			System.out.println(name);
		}
	}

	@Override
	public void description() {
		this.entityDescription();
		
	}

	@Override
	public int getAttack() {
		return super.getAttack()+this.equipment.getDmgWeapon();
	}
	
	@Override
	public void takeDmg(int Dmg) throws GameException_GameOver {
		super.takeDmg(Dmg);
		System.out.println("Dommages re�us : " + Dmg);
		if(!this.isAlive()){
			System.out.println("Vous �tes mort. Game over");
			// Si c'est le h�ro on a perdu 

			throw new GameException_GameOver("Vous �tes mort");
		}			
		
	}
	
	public void lookSet(){
		System.out.println(this.equipment);
	}

	/**
	 * @return  the amount of xp that the Entity need to level up
	 */
	private int calcXpLevelUp() {
		double xpNeed = 0.75*(this.level*this.level)+this.level+12;
		return (int) Math.round(xpNeed);
	}

	/**
	 * Increase the level of the Entity Increase the stat of the Entity to
	 */
	private void levelUp() {
		this.level++;
		this.xp = 0;
		int earnHp = (this.level%3+1)*10;
		int earnDef = (this.level+1)%3+1;
		int earnAtk = (this.level+2)%3+1;
		this.addHp(earnHp);
		this.addDef(earnDef);
		this.addAtk(earnAtk);
		System.out.println("Vous gagnez un niveau");
		System.out.println("Hp +"+earnHp);
		System.out.println("Defence +"+earnDef);
		System.out.println("Atk +"+earnAtk);
	}

	/**
	 * Add xpEarn to Entity's xp
	 * @param xpEarn  The amount of xp that the Entity wins
	 */
	public void increaseXp(int xpEarn) {
		this.xp += xpEarn;
		if(this.xp > this.calcXpLevelUp()){
			this.levelUp();
		}
	}

	@Override
	public void entityDescription() {
		System.out.println("Niveau "+this.level);
		super.entityDescription();
	}


	
	
	
	
}
