package trouser;

import Item.Trouser;

public class Trouser_LeatherTrouser extends Trouser {

	private static final long serialVersionUID = -4837141162037086395L;

	/**
	 * Un constructeur de la classe
	 */
	public Trouser_LeatherTrouser() {
		super("Pantalon_en_cuir", 2, 0, 2);
	}

	@Override
	public void description() {
		System.out.println("Un pantalon en cuir");

	}

}
