package Game;

import java.io.Serializable;
import java.util.*;
import java.io.*;

public class EquipementSet implements Serializable {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3005502569148491723L;
	private Map<String,Equipement> listEquip;

	/**
	 * Equip the equipement
	 * @param equip  The equipement that you want equip
	 */
	public void equip(Equipement equip) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unequip the equipement zone choosen
	 * @param zone  The zone that you want unequip
	 */
	public Equipement unequip(int zone) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Print the stat of the equipement zone on the screen
	 * @param zone  the equipement's zone that you want show the stat
	 */
	public void showStat(String zone) {
		throw new UnsupportedOperationException();
	}
}
