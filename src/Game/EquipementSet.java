package Game;

import java.util.*;
import Item.*;

import java.io.*;


public class EquipementSet implements Serializable {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3005502569148491723L;
	private Map<String,Equipement> listEquip;
	private Hero hero;
	
	public EquipementSet(Hero hero){
		this.listEquip= new HashMap<String,Equipement>();
		this.listEquip.put("Weapon", null);
		this.listEquip.put("Boots", null);
		this.listEquip.put("Chest", null);
		this.listEquip.put("Glove", null);
		this.listEquip.put("Head", null);
		this.listEquip.put("Trouser", null);
		this.hero=hero;
	}

	/**
	 * Equip the equipement
	 * @param equip  The equipement that you want equip equip only if pas d'ancien equipement
	 */
	public void equip(Equipement equip) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unequip the equipement zone choosen
	 * @param zone  The zone that you want unequip
	 */
	public Equipement unequip(String zone) {
		Equipement r=null;
		if(this.listEquip.containsKey(zone)){
			r=this.listEquip.get(zone);
			this.listEquip.put(zone, null);
		}
		return r;
	}

	/**
	 * Print the stat of the equipement zone on the screen
	 * @param zone  the equipement's zone that you want show the stat
	 */
	public void showStat(String zone) {
		throw new UnsupportedOperationException();
	}
	
	public int getDmgWeapon(){
		int dmg=0;
		Weapon w =(Weapon)this.listEquip.get("Weapon");
		if(w!=null){
			dmg=(int) (Math.random()*(w.getAtkMax()-w.getAtkMin()));
			dmg+=w.getAtkMin();
		}
		return dmg;
	}
}
