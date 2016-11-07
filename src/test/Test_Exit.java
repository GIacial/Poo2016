package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.*;
import exit.*;
import place.*;

public class Test_Exit {
	private Exit e;
	private Place p;

	@Before
	public void setUp() throws Exception {
		p= new ClassicPlace("Néant");	  
		e= new ClassicExit(p); 
		
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

}
