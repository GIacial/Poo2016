package Game;

import java.util.ArrayList;
import java.util.List;

import Item.Equipement;
import Item.Weapon;
import interfacePackage.Recoverable;

/**
 * A Hero
 */
public class Hero extends Entity {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -8480399582238471911L;

	private EquipementSet equipement;
	
	private Inventory inventory;

	/**
	 * A builder of Hero Class
	 * @param name  The name of the new Hero
	 */
	public Hero(String name) {
		super(name,30,5,5);	
		this.equipement= new EquipementSet(this);
		this.inventory= new Inventory();
	}

	/**
	 * Equip the equipement called as nameEquip
	 * @param nameEquip  The name of the equipement that you want equip
	 */
	public void equip(String nameEquip) {
		Recoverable e=this.inventory.remove(nameEquip);
		if(e!=null){
			if(e instanceof Equipement){
				Equipement equip=(Equipement)e;
				boolean ok=this.equipement.equip(equip);
				if(!ok){
					this.inventory.add(e);
				}
				else{
					System.out.println("Vous vous équipez de "+equip.getName());
					System.out.println("Attack +"+equip.getAttackBonus());
					System.out.println("Defence +"+equip.getDefenseBonus());
					System.out.println("Hp +"+equip.getHealthBonus());
					if(equip instanceof Weapon){
						Weapon w=(Weapon)equip;
						System.out.println("attack range:"+w.getAtkMin()+"-"+w.getAtkMax());
					}
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
		Equipement e=this.equipement.unequip(name);
		if(e!=null){
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
		List<Recoverable> l= new ArrayList<Recoverable>();
		switch(typeItem.toLowerCase()){
			case "equipement":l.addAll(this.inventory.getListEquipement());
				break;
			default:l=this.inventory.getListItem();
				break;
		}
		if(l.isEmpty()){
			System.out.println("Votre sac ne contient pas "+typeItem);
		}
		for(Recoverable i: l){
			String name="";
			if(i instanceof Item){
				name=((Item)i).getName();
			}
			else{if(i instanceof Entity ){
				name=((Entity)i).getName();
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
		return super.getAttack()+this.equipement.getDmgWeapon();
	}
	
	@Override
	public void takeDmg(int Dmg) {
		super.takeDmg(Dmg);
		System.out.println("Dommages reçus : " + Dmg);
		if(!this.isAlive()){
			System.out.println("Vous êtes mort. Game over");
			// Si c'est le héro on a perdu 
		}			
		
	}
	
	public void lookSet(){
		System.out.println(this.equipement);
	}

	@Override
	public void increaseXp(int xpEarn) {
		int lv=this.getLevel();
		super.increaseXp(xpEarn);
		if(this.getLevel()!=lv){
			System.out.println("Vous passez au lv"+this.getLevel());
		}
	}
	
	
	
}
