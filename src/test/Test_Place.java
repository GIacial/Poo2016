package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Game.*;
import exit.*;
import interfacePackage.Recoverable;
import npc.Entity_Cat;
import place.*;
import useableItem.Item_Key;

public class Test_Place {
	private Place p;
	public final String EXIT_NAME="exit";
	private Place nextPlace;
	private Item_Key key;
	private Entity_Cat cat;
	
	@Before
	public void setUp() throws Exception {
		p= new ClassicPlace("Néant") ;
		nextPlace= new ClassicPlace("vide") ;
		p.setLink(EXIT_NAME, new ClassicExit(nextPlace));
		key=new Item_Key();
		p.addItem(key);
		cat= new Entity_Cat();
		p.addEntity(cat);
	}

	@Test
	public void setLink() {
		assertSame(p.getNbExit(),1);
	}
	
	@Test
	public void getNextPlace_1() {
		assertSame(p.getNextPlace(EXIT_NAME),nextPlace);
	}
	
	@Test
	public void getNextPlace_2() {
		assertNull(p.getNextPlace("Pas une sortie"));
	}
	
	@Test
	public void addItem() {
		assertSame(p.getNbItem(),1);
	}
	
	@Test
	public void removeItem() {	
		Item i=p.removeItem(key.getName());
		assertSame(p.getNbItem(),0);
		assertSame(i,key);
	}
	
	@Test
	public void addEntity() {
		assertSame(p.getNbEntity(),1);
	}
	
	@Test
	public void removeEntity() {	
		Entity e=p.removeEntity(cat.getName());
		assertSame(p.getNbEntity(),0);
		assertSame(e,cat);
	}
	
	@Test
	public void takeSomething() {	
		Recoverable catItem=p.takeSomething(cat.getName());
		
		assertSame(p.getNbEntity(),0);
		assertNotNull(catItem);
		
		Recoverable keyItem=p.takeSomething(key.getName());
		assertSame(p.getNbItem(),0);
		assertSame(keyItem,key);
	}
	
	@Test
	public void add() {
		p.addEntity(null);
		p.addItem(null);
		p.setLink("blabla", null);
		assertSame(p.getNbEntity(),1);
		assertSame(p.getNbItem(),1);
		assertSame(p.getNbExit(),1);
	}

	
	

}
