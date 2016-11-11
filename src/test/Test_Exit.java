package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.*;
import Item.*;
import exit.*;
import place.*;

public class Test_Exit {
	private Exit e;
	private Place p;
	private LockedExit lockedExit;

	@Before
	public void setUp() throws Exception {
		p= new ClassicPlace("Néant");	  
		e= new ClassicExit(p); 
		lockedExit = new LockedExit(p);
		
	}

	@Test
	public void haveNextPlace_1() {	
		assertTrue(e.haveNextPlace());
	}
	
	@Test
	public void haveNextPlace_2() {
		e= new ClassicExit(null);
		assertFalse(e.haveNextPlace());
	}
	
	@Test
	public void crossing_1() {
		assertSame(e.crossing(),p);
	}
	
	@Test
	public void crossing_2() {
		e= new ClassicExit(null);
		assertNull(e.crossing());
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
		assertSame(lockedExit.crossing(),p);
	}
	
	@Test
	public void useKey() {
		Item_Key key=new Item_Key();
		key.use(lockedExit);
		assertSame(lockedExit.crossing(),p);
	}
}
