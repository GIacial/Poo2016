package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.Inventory;
import Game.Item;
import Item.*;
import exit.LockedExit;
import place.ClassicPlace;
import weapon.Weapon_BasicSword;

public class Test_Inventory {
	private Inventory inventory;
	private LockedExit door;
	private Item key;
	private Equipement sword;
	
	@Before
	public void setUp() throws Exception {
		this.inventory= new Inventory();
		this.key=new Item_Key();
		this.sword= new Weapon_BasicSword();
		this.inventory.add(this.key);
		this.inventory.add(this.sword);
		this.door= new LockedExit(new ClassicPlace("quelque part"));
	}

	@Test
	public void add() {
		assertSame(this.inventory.getListItem().size(),2);
	}
	
	@Test
	public void remove() {
		Item k=this.inventory.remove("Clé");
		assertSame(k,this.key);
		assertSame(this.inventory.getListItem().size(),1);
	}
	
	@Test
	public void use() {
		this.inventory.use("Clé",door);
		assertNotNull(door.crossing());
		assertSame(this.inventory.getListItem().size(),1);
	}
	
	@Test
	public void getListEquipement() {
		assertSame(this.inventory.getListEquipement().size(),1);
	}

}
