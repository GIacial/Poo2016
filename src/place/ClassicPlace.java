package place;

import Game.*;

/**
 * 
 * A test class for a place
 *
 */
public class ClassicPlace extends Place {
	

	private static final long serialVersionUID = 6407385226430510446L;

	/**
	 * Un constructeur de la classe
	 */
	public ClassicPlace(String name) {
		super(name);
	}

	@Override
	public void description() {
		System.out.println("Une description d'un lieu bidon :" + this.getName());
		super.description();
		
	}


}
