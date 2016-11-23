package Game;

import java.util.*;
import Item.*;

import java.io.*;

/**
 * Permet de gérer les équipement d'un Hero
 *
 */
public class EquipmentSet implements Serializable {


	private static final long serialVersionUID = -3005502569148491723L;
	
	private Map<String,Equipment> 	listEquip;
	private Hero 					hero;
	
	
	/**
	 * Un constructeur de EquipementSet
	 * @param hero Le hero qui va être équipé des équipement
	 */
	public EquipmentSet(Hero hero){
		this.listEquip = new HashMap<String,Equipment>();
		this.listEquip.put("Weapon", null);
		this.listEquip.put("Boots", null);
		this.listEquip.put("Chest", null);
		this.listEquip.put("Glove", null);
		this.listEquip.put("Head", null);
		this.listEquip.put("Trouser", null);
		this.hero = hero;
	}

	/**
	 * Equip the equipement
	 * @param equip  The equipement that you want equip equip only if pas d'ancien equipement
	 */
	public boolean equip(Equipment equip) {
		boolean ok = false;
		if(this.listEquip.containsKey(equip.getTypeName())){
			Equipment target = this.listEquip.get(equip.getTypeName());
			if(target == null){
				ok = true;
				this.listEquip.put(equip.getTypeName(), equip);
	
				this.hero.addAtk(equip.getAttackBonus());
				this.hero.addDef(equip.getDefenseBonus());
				this.hero.addHp(equip.getHealthBonus());
			}
			else{
				System.out.println("Vous avez déjà un " + equip.getTypeName());
			}
		}
		else{
			System.err.println(equip.getTypeName() + " n'est pas reconnu");
		}
		return ok;
	}

	/**
	 * Unequip the equipement zone choosen
	 * @param zone  The zone that you want unequip
	 */
	public Equipment unequip(String zone) {
		Equipment r = null;
		if(this.listEquip.containsKey(zone)){
			r = this.listEquip.get(zone);
			if(r != null){
				this.hero.addAtk(-r.getAttackBonus());
				this.hero.addDef(-r.getDefenseBonus());
				this.hero.addHp(-r.getHealthBonus());
			}
			this.listEquip.put(zone, null);
		}
		return r;
	}

	/**
	 * Print the stat of the equipement zone on the screen
	 * @param zone  the equipement's zone that you want show the stat
	 */
	public boolean showStat(String zone) {
		boolean zoneOk = false;
		if(this.listEquip.containsKey(zone)){
			zoneOk = true;
			Equipment r = this.listEquip.get(zone);
			if(r != null){
				r.EquipementDescription();
				
			}
			else{
				System.out.println("Vous n'avez pas de " + zone);
			}
		}
		return zoneOk;
	}
	
	/**
	 * Renvoie une valeur entre le MinAtk  et le MaxAtk de l'arme
	 * @return les dommages de l'arme
	 */
	public int getDmgWeapon(){
		int dmg = 0;
		Weapon w = (Weapon)this.listEquip.get("Weapon");
		if(w != null){
			dmg = (int) (Math.random() * (w.getAtkMax()-w.getAtkMin()));
			dmg += w.getAtkMin();
		}
		return dmg;
	}
	
	/**
	 * 
	 * @return le nombre d'équipement actuellement équiper
	 */
	public int getNbEquipement(){
		int nb = 0;
		for(String type : this.listEquip.keySet()){
			Equipment e = this.listEquip.get(type);
			if(e != null){
				nb++;
			}
			
		}
		return nb;
	}

	@Override
	public String toString() {
		String r = "";
		for(String s : this.listEquip.keySet()){
			Equipment e = this.listEquip.get(s);
			if(e != null){
				r += (s + " : " + e.getName() + "\n");
			}
		}
		if(r.equals("")){
			r = "Vous ne portez rien";
		}
		return r;
	}
	
	
}
