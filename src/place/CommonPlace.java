package place;

import Game.Place;

public abstract class CommonPlace extends Place {

	private final String description;
	private static final long serialVersionUID = 8262162113870110754L;

	public CommonPlace(String name,String description) {
		super(name);
		this.description = description;
	}

	@Override
	public void description() {
		System.out.println(this.description);
		super.description();
	}
	
	

}
