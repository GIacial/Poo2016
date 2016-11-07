package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.*;
import exit.*;
import place.*;

public class Test_Place {
	private Place p;
	public final String EXIT_NAME="exit";
	private Place nextPlace;
	
	@Before
	public void setUp() throws Exception {
		p= new ClassicPlace("Néant") ;
		nextPlace= new ClassicPlace("vide") ;
		//p.setLink(EXIT_NAME, nextPlace, typeExit); //TODO
	}

	@Test
	public void setLink() {
		assertSame(p.getNameExit().size(),1);
	}
	
	@Test
	public void getNextPlace_1() {
		assertSame(p.getNextPlace(EXIT_NAME),nextPlace);
	}
	
	@Test
	public void getNextPlace_2() {
		assertNull(p.getNextPlace("Pas une sortie"));
	}
	


	
	

}
