package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.EquipementSet;
import Game.Hero;
import Item.Equipement;
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
	public void test() {
		fail("Not yet implemented");
	}

}
