package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.*;
import exit.*;
import place.*;
import useableItem.Item_Key;

public class Test_Exit {
	private Exit 		exit;
	private Place 		place;
	private LockedExit 	lockedExit;

	@Before
	public void setUp() throws Exception {
		place = new ClassicPlace("Néant");	  
		exit = new ClassicExit(place); 
		lockedExit = new LockedExit(place);
		
	}

	@Test
	public void haveNextPlace_1() {	
		assertTrue(exit.haveNextPlace());
	}
	
	@Test
	public void haveNextPlace_2() {
		exit = new ClassicExit(null);
		assertFalse(exit.haveNextPlace());
	}
	
	@Test
	public void crossing_1() {
		assertSame(exit.crossing(), place);
	}
	
	@Test
	public void crossing_2() {
		exit = new ClassicExit(null);
		assertNull(exit.crossing());
	}

	@Test
	public void crossing_3() {
		assertNull(lockedExit.crossing());
	}
	
	@Test
	public void crossing_4() {
		lockedExit.open(null);
		assertNull(lockedExit.crossing());
	}
	
	@Test
	public void crossing_5() {
		lockedExit.open(new Item_Key());
		assertSame(lockedExit.crossing(), place);
	}
	
	@Test
	public void useKey() {
		Item_Key key = new Item_Key();
		key.use(lockedExit);
		assertSame(lockedExit.crossing(), place);
	}
}
