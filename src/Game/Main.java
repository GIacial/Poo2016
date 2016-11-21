package Game;


public class Main {

	public static void main(String[] args){
		CommandReader cr= new CommandReader();
		while(cr.isActif()){
			cr.interpretation();
		}

	}

}
