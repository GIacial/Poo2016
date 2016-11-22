package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import exception.GameException_GameOver;


public class CommandReader {
	private static final String CHECKPOINT="Save/checkpoint.sav";
	private boolean 	checkpointCreate;
	private Scanner 	s;
	private boolean 	actif;
	private Game 		game;
	private String 		fichier;


	public CommandReader() {
		this.s = new Scanner(System.in);
		this.actif = true;
		this.checkpointCreate = false;
		
		//chargement ou création du jeu
		System.out.println("Donnez le nom de votre sauvegarde");
		this.fichier = "Save/".concat(this.s.next().concat(".sav"));
		this.s.nextLine();//fin la ligne
		
		boolean newGame = true;
		if(new File(this.fichier).exists()){
			System.out.println("Voulez vous continuer ?");
			if(this.s.next().toLowerCase().equals("oui")){
				this.loadGame(this.fichier);
				newGame = false;
			}
		}
		if(newGame){
			this.game = new Game();
		}
	}
	
	private void loadGame(String file) {
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			this.game = (Game)ois.readObject();
			ois.close();
			System.out.println("Chargement effectué");
		}
		catch(Exception e){
			System.out.println("Impossible de charger");
			this.game = new Game();
			System.err.println(e);
		}
		
	}
	
	private boolean saveGame(String file) {
		boolean ok=true;
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this.game);
			oos.close();
		}
		catch(Exception e){
			System.out.println("La sauvegarde a echoué");
			System.err.println(e);
			ok = false;
		}
		return ok;
		
	}

	public void interpretation(){
		String[] sCommand = this.s.nextLine().split(" ");
		if(sCommand.length>0 && !sCommand[0].equals("")){
			
			try{
				Command t = Command.valueOf(sCommand[0].toLowerCase());//lower cas pour que Bonjour=bonjour
				
				switch(t){
					case look : this.look(sCommand);
						break;						
					case quit : this.quit();
						break;
					case go : this.go(sCommand);
						break;
					case help : this.help(sCommand);
						break;
					case take : this.take(sCommand);
						break;
					case use : this.use(sCommand);
						break;
					case attack : this.attack(sCommand);
						break;
					case equip : this.equip(sCommand);
						break;
					case unequip : this.unequip(sCommand);
						break;
					case discard : this.discard(sCommand);
						break;
					case analyse : this.analyse(sCommand);
						break;
					case speak : this.speak(sCommand);
						break;
						
					default:System.err.println("Pas encore fait");
							break;
				}
			}
			catch(IllegalArgumentException e){
				System.out.println(sCommand[0] + " n'est pas une commande");
			}
		}
		
	}

	public boolean isActif() {
		return this.actif;
	}
	
	private void go(String[] sCommand){
		if(sCommand.length >= 2){
			this.createCheckpoint();
			game.go(sCommand[1]);
		}
		else{
			Command.go.description();
		}
	}
	
	private void look(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.look(sCommand[1]);
		}
		else{
			this.game.look();
		}
	}
	
	private void help(String[] sCommand){
		if(sCommand.length >= 2){
			Command.description(sCommand[1]);
		}
		else{
			Command listCommand[] = Command.values();
			for(int i=0 ; i<listCommand.length ; i++){
				System.out.println(listCommand[i]);
			}
		}
	}
	
	private void quit(){
		System.out.println("Au revoir");
		this.saveGame(this.fichier);
		this.actif = false;
		s.close();								//fin du scanner principal
	}
	
	private void take(String[] sCommand){
		if(sCommand.length >= 2){
			try {
				this.game.take(sCommand[1]);
			} catch (GameException_GameOver e) {
				this.GameOver();
			}
		}
		else{
			Command.take.description();
		}
	}
	
	private void use(String[] sCommand){
		if(sCommand.length >= 3){
			try {
				this.game.use(sCommand[1], sCommand[2]);
			} catch (GameException_GameOver e) {
				this.GameOver();
			}
		}
		else{
			Command.use.description();
		}
	}
	
	private void attack(String[] sCommand){
		if(sCommand.length>=2){
			try {
				this.game.attack(sCommand[1]);
			} catch (GameException_GameOver e) {
				this.GameOver();
			}
		}
		else{
			Command.attack.description();
		}
	}
	
	private void equip(String[] sCommand){
		if(sCommand.length>=2){
			this.game.equip(sCommand[1]);
		}
		else{
			Command.equip.description();
		}
	}
	
	private void unequip(String[] sCommand){
		if(sCommand.length>=2){
			this.game.unequip(sCommand[1]);
		}
		else{
			Command.unequip.description();
		}
	}
	
	private void discard(String[] sCommand){
		if(sCommand.length>=2){
			this.game.discard(sCommand[1]);
		}
		else{
			Command.discard.description();
		}
	}
	
	private void analyse(String[] sCommand){
		if(sCommand.length>=2){
			this.game.analyse(sCommand[1]);
		}
		else{
			Command.analyse.description();
		}
	}
	
	private void speak(String[] sCommand){
		if(sCommand.length>=2){
			this.game.speak(sCommand[1]);
		}
		else{
			Command.speak.description();
		}
	}
	
	private void GameOver(){
		System.out.println("\n[La Déesse] Cherchons dans le temps, le dernier point d'ancrage");
		if(this.checkpointCreate){
			System.out.println("Retour au checkpoint");
			this.loadGame(CommandReader.CHECKPOINT);
		}
		else{
			if(new File(this.fichier).exists()){
				System.out.println("Retour au début de ta session");
				this.loadGame(this.fichier);
			}
			else{
				System.out.println("\n[La Déesse] je suis désolée tu es trop discret mon enfant , le temps ne se souvient pas de toi");
				this.game= new Game();
			}
		}
	}
	
	private void createCheckpoint(){
		this.checkpointCreate=this.checkpointCreate || this.saveGame(CommandReader.CHECKPOINT);
	}
	

}
