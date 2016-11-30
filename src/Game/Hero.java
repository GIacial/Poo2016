package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Item.Equipment;
import exception.GameException_GameOver;
import interfacePackage.Recoverable;

/**
 * A Hero
 */
public class Hero extends Entity {

	private static final long serialVersionUID = -8480399582238471911L;

	private EquipmentSet 	equipment;
	private Inventory 		inventory;
	private int 			level;
	private int 			xp;

	
	
	
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
	 * Equip the equipment called as nameEquip
	 * @param nameEquip  The name of the equipment that you want equip
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
					equip.EquipementDescription();
				}
			}
			else{
				System.out.println(nameEquip+" n'est pas un equipement");
				this.inventory.add(e);
			}
		}
		else{
			System.out.println("Vous ne possedez pas "+nameEquip);
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
			System.out.println("Vous enlevez votre "+e.getName());
			System.out.println("Attack -"+e.getAttackBonus());
			System.out.println("Defence -"+e.getDefenseBonus());
			System.out.println("Hp -"+e.getHealthBonus());
		}
		else{
			System.out.println("Vous n'avez pas de "+name+" équipé");
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
			case "equipement":l.addAll(this.inventory.getListEquipement());
				break;
			default:l = this.inventory.getListItem();
				break;
		}
		if(l.isEmpty()){
			System.out.println("Votre sac ne contient pas "+typeItem);
		}
		
		HashMap<String,Integer> listInventory = new HashMap<String,Integer>();
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
			if(listInventory.containsKey(name)){
				listInventory.put(name, new Integer(listInventory.get(name).intValue()+1));
			}
			else{
				listInventory.put(name, new Integer(1));
			}
		}
		//affichage
		for(String names : listInventory.keySet()){
			System.out.println(names+" x"+listInventory.get(names));
		}
	}

	@Override
	public void description() {
		System.out.println("description du hero");
		
	}

	@Override
	public int getAttack() {
		return super.getAttack() + this.equipment.getDmgWeapon();
	}
	
	@Override
	public void takeDmg(int Dmg) throws GameException_GameOver {
		super.takeDmg(Dmg);
		System.out.println("Dommages reçus : " + Dmg);
		System.out.println("Il vous reste "+this.getHeal()+" HP" );
		
		if(!this.isAlive()){
			System.out.println("Vous êtes mort. Game over");
			
			throw new GameException_GameOver("Vous êtes mort");// Si c'est le héro on a perdu 
		}			
		
	}
	
	/**
	 * Permet d'afficher tout se qui est equipé au hero
	 */
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
	 * Increase the level of the Entity. Increase the stat of the Entity to
	 */
	private void levelUp() {
		this.level++;
		this.xp = 0;
		int earnHp  = (this.level%3+1)*10;
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
		System.out.println("Vous gagnez " + xpEarn + " morceaux de pizza");
		if(this.xp > this.calcXpLevelUp()){
			this.levelUp();
			System.out.println("Cowabunga ! Mon apprentissage à été bénéfique, j'ai gagné un level !");
		}
	}

	@Override
	public void entityDescription() {
		System.out.println("Niveau " + this.level);
		super.entityDescription();
	}

	@Override
	public void takeHeal(int nbHeal) {
		super.takeHeal(nbHeal);
		System.out.println("Vous recevez " + nbHeal + " Hp");
	}

	/**
	 * Affiche les stat d'un equipement du hero
	 * @param name Le nom de la zone equipable analysé
	 * @return T si analyse a réussi sinon F
	 */
	public boolean analyseSet(String name){
		return this.equipment.showStat(name);
	}
	
	
}
