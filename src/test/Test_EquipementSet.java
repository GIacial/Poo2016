package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.EquipmentSet;
import Game.Hero;
import Item.Equipment;
import Item.Weapon;
import weapon.Weapon_BasicSword;

public class Test_EquipementSet {
	private EquipmentSet 	set;
	private Equipment 		sword;
	private Hero 			hero;

	@Before
	public void setUp() throws Exception {
		this.hero = new Hero("cc");
		this.set = new EquipmentSet(hero);
		this.sword = new Weapon_BasicSword();
	}

	@Test
	public void getNbEquip() {
		assertSame(this.set.getNbEquipement(), 0);
	}
	
	@Test
	public void equip() {
		this.set.equip(sword);
		assertSame(this.set.getNbEquipement(), 1);
	}

	
	@Test
	public void unequip() {
		this.set.equip(sword);
		Equipment s = this.set.unequip(sword.getTypeName());
		assertSame(this.set.getNbEquipement(), 0);
		assertSame(this.sword, s);
	}
	
	@Test
	public void getDmgWeapon() {
		this.set.equip(sword);
		int dmg = this.set.getDmgWeapon();
		Weapon swords = (Weapon)this.sword;
		assertTrue(dmg >= swords.getAtkMin() && dmg <= swords.getAtkMax());
	}

}
