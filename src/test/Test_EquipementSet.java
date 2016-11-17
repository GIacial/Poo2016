package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.EquipementSet;
import Game.Hero;
import Item.Equipement;
import Item.Weapon;
import weapon.Weapon_BasicSword;

public class Test_EquipementSet {
	private EquipementSet set;
	private Equipement sword;
	private Hero hero;

	@Before
	public void setUp() throws Exception {
		this.hero= new Hero("cc");
		this.set= new EquipementSet(hero);
		this.sword= new Weapon_BasicSword();
	}

	@Test
	public void getNbEquip() {
		assertSame(this.set.getNbEquipement(),0);
	}
	
	@Test
	public void equip() {
		this.set.equip(sword);
		assertSame(this.set.getNbEquipement(),1);
	}

	
	@Test
	public void unequip() {
		this.set.equip(sword);
		Equipement s=this.set.unequip(sword.getTypeName());
		assertSame(this.set.getNbEquipement(),0);
		assertSame(this.sword,s);
	}
	
	@Test
	public void getDmgWeapon() {
		this.set.equip(sword);
		int dmg=this.set.getDmgWeapon();
		Weapon swords=(Weapon)this.sword;
		assertTrue(dmg>=swords.getAtkMin() && dmg<=swords.getAtkMax());
	}

}
