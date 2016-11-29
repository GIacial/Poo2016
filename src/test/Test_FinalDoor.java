package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exit.*;
import place.ClassicPlace;
import useableItem.*;

public class Test_FinalDoor {
	private LockedExit_A door;
	@Before
	public void setUp() throws Exception {
		this.door = new FinalDoor(new ClassicPlace("Bidon"));
	}

	@Test
	public void open_1() {
		assertFalse(this.door.open(null));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_2() {
		assertTrue(this.door.open(new Item_Bo()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_3() {
		this.door.open(new Item_Bo());
		assertFalse(this.door.open(new Item_Bo()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_4() {
		this.door.open(new Item_Bo());
		assertTrue(this.door.open(new Item_Katana()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_5() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		assertFalse(this.door.open(new Item_Katana()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_6() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		assertFalse(this.door.open(new Item_Katana()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_7() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		assertTrue(this.door.open(new Item_Nunchakus()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_8() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		this.door.open(new Item_Nunchakus());
		assertFalse(this.door.open(new Item_Nunchakus()));
		assertTrue(this.door.isLocked());
	}
	
	@Test
	public void open_9() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		this.door.open(new Item_Nunchakus());
		assertTrue(this.door.open(new Item_Sais()));
		assertFalse(this.door.isLocked());
	}
	
	@Test
	public void open_10() {
		this.door.open(new Item_Bo());
		this.door.open(new Item_Katana());
		this.door.open(new Item_Nunchakus());
		this.door.open(new Item_Sais());
		assertFalse(this.door.open(new Item_Sais()));
		assertFalse(this.door.isLocked());
	}

}
