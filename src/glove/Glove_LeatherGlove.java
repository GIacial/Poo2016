package glove;

import Item.Glove;

public class Glove_LeatherGlove extends Glove {

	private static final long serialVersionUID = -14623349668282085L;

	public Glove_LeatherGlove() {
		super("Gant_en_cuir", 1, 1, 0);
	}

	@Override
	public void description() {
		System.out.println("Des gants en cuir");

	}

}
