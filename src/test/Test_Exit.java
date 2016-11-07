package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.Exit;
import Game.Place;
import Game.*;

public class Test_Exit {
	private Exit e;
	private Place p;

	@Before
	public void setUp() throws Exception {
		//p= new ;	  //TODO metre un lieu non abstract
		//e= new (p); //TODO metre ici une exit non abstract
		
	}

	@Test
	public void haveNextPlace_1() {	
		assertTrue(e.haveNextPlace());
	}
	
	@Test
	public void haveNextPlace_2() {
		//e= new (null);	//TODO Constructeur non abstract
		assertFalse(e.haveNextPlace());
	}
	
	@Test
	public void crossing_1() {
		assertSame(e.crossing(),p);
	}
	
	@Test
	public void crossing_2() {
		//e= new (null);	//TODO Constructeur non abstract
		assertSame(e.crossing(),p);
	}

}
