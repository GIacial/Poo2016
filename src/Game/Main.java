package Game;

public class Main {

	public static void main(String[] args) {
		Game game= new Game();
		System.out.println("Bienvenue Aventurier");
		CommandReader cr= new CommandReader(game);
		while(cr.isActif()){
			cr.interpretation();
		}

	}

}