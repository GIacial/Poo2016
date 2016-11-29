package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import exception.GameException_GameOver;



/**
 * Sert à lire ligne par ligne les commandes mise sur entrée standart
 * Elle charge un Game à partir d'un fichier ou avec le constructeur par défault.
 */
public class CommandReader {
	
	private static final String CHECKPOINT = "Save/checkpoint.sav";
	
	private boolean 	checkpointCreate;
	private Scanner 	s;
	private boolean 	actif;
	private Game 		game;
	private String 		fichier;
	private String[]    lastCommand;


	
	/**
	 * Un constructeur de CommandReader
	 * Elle a besoin qu'on entre sur stdin le nom de la sauvegarde
	 * et si la sauvegarde existe si on veux la charger ou non.
	 */
	public CommandReader() {
		this.s = new Scanner(System.in);
		this.actif = true;
		this.checkpointCreate = false;
		this.lastCommand = null;
		
		//chargement ou création du jeu
		/*System.out.println("Donnez le nom de votre sauvegarde");
		this.fichier = "Save/".concat(this.s.next().concat(".sav"));
		this.s.nextLine();	//fin la ligne
		*/
		this.fichier="Save/save.sav";
		
		boolean newGame = true;
		if(new File(this.fichier).exists()){
			System.out.println("Voulez vous continuer ?");
			if(this.s.next().toLowerCase().equals("oui")){
				this.s.nextLine();//fin la ligne
				this.loadGame(this.fichier);
				newGame = false;
			}
		}
		if(newGame){
			this.game = new Game();
		}
	}
	
	/**
	 * Permet de charger le Game à partir du fichier
	 * @param file :le chemin de la sauvegarde
	 */
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
	
	/**
	 * 
	 * @param file :le chemin de l'endroit ou l'on veux mettre la sauvegarde
	 * @return true si la sauvegarde a réussi sinon false
	 */
	private boolean saveGame(String file) {
		boolean ok = true;
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

	/**
	 * Lis la prochaine commande présente sur stdin et applique l'effect sur le Game
	 */
	public void interpretation(){
		String[] sCommand = this.s.nextLine().split(" ");
		if(sCommand.length > 0 && !sCommand[0].equals("")){//pour gerer les retour à la ligne abusif
					this.detectCommand(sCommand);
		}
		
	}

	/**
	 * Regarde si une commande est active 
	 *
	 * @return true, if is actif
	 */
	public boolean isActif() {
		return this.actif;
	}
	
	/**
	 * Permet de lancer l'action correspondant a la commande
	 * @param sCommand :La commande avec tous ses parametres
	 */
	private void detectCommand(String[] sCommand){
		try{
			Command t = Command.valueOf(sCommand[0].toLowerCase());
			//lower cas pour que Bonjour=bonjour
			
			switch(t){
				case look :	this.look(sCommand);
					break;						
				case quit :	this.quit();
					break;
				case go :	this.go(sCommand);
					break;
				case help :	this.help(sCommand);
					break;
				case take :	this.take(sCommand);
					break;
				case use : 	this.use(sCommand);
					break;
				case attack :	this.attack(sCommand);
					break;
				case equip :	this.equip(sCommand);
					break;
				case unequip :	this.unequip(sCommand);
					break;
				case discard :	this.discard(sCommand);
					break;
				case analyse :	this.analyse(sCommand);
					break;
				case speak :	this.speak(sCommand);
					break;
				case last : 	if(lastCommand!=null){
									this.detectCommand(lastCommand);
								}
								else{
									System.out.println("Il n'y a aucune commande precedente");
								}
					break;
				default : System.err.println("Pas encore fait");
						break;
			}
		}
		catch(IllegalArgumentException e){
			System.out.println(sCommand[0] + " n'est pas une commande");
		}
	}
	
	/**
	 * Permet d'essayer de changer de lieu
	 * Creation d'un checkpoint avant d'essayer de prendre une sortie
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void go(String[] sCommand){
		if(sCommand.length >= 2){
			this.createCheckpoint();
			game.go(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.go.description();
		}
	}
	
	/**
	 * Permet d'essayer de lire la description de quelque chose
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void look(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.look(sCommand[1]);
		}
		else{
			this.game.look();
		}
		this.lastCommand = sCommand;
	}
	
	/**
	 * Permet d'afficher toutes les commandes ou la description d'une commande
	 * @param  sCommand :La commande avec tous ses parametres
	 */
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
		this.lastCommand = sCommand;
	}
	
	/**
	 * Permet de quitter le jeu
	 * Creation de la sauvegarde
	 */
	private void quit(){
		System.out.println("Au revoir");
		this.saveGame(this.fichier);
		this.actif = false;
		s.close();								//fin du scanner principal
	}
	
	/**
	 * Permet d'essayer de prendre quelque chose dans le lieu courant
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void take(String[] sCommand){
		if(sCommand.length >= 2){
			try {
				this.game.take(sCommand[1]);
			} catch (GameException_GameOver e) {
				this.GameOver();
			}
			this.lastCommand = sCommand;
		}
		else{
			Command.take.description();
		}
	}
	
	/**
	 * Permet d'essayer d'utiliser un object de l'inventaire du hero sur quelque chose
	 *
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void use(String[] sCommand){

		if(sCommand.length >= 2){
			try{
				if(sCommand.length == 2){
					this.game.use(sCommand[1]);
				}
				else{
					this.game.use(sCommand[1], sCommand[2]);
				}
			}
			catch (GameException_GameOver e) {

				this.GameOver();
			}
			this.lastCommand = sCommand;
		}
		else{		
			Command.use.description();
		}

		
	}
	
	/**
	 * Permet d'essayer d'attaquer la cible
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void attack(String[] sCommand){
		if(sCommand.length >= 2){
			try {
				this.game.attack(sCommand[1]);
			} catch (GameException_GameOver e) {
				this.GameOver();
			}
			this.lastCommand = sCommand;
		}
		else{
			Command.attack.description();
		}
	}
	
	/**
	 * Permet d'essayer d'equiper un equipement depuis l'inventaire du hero
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void equip(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.equip(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.equip.description();
		}
	}
	
	/**
	 * Permet de déséquiper une zone équipable
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void unequip(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.unequip(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.unequip.description();
		}
	}
	
	/**
	 * Permet de jeter un object de l'inventaire de l'hero dans la pièce
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void discard(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.discard(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.discard.description();
		}
	}
	
	/**
	 * Permet d'afficher les stats d'une Entity ou d'un equipement de la Place actuel
	 * Permet aussi d'afficher les stat d'un equipement de l'inventaire  ou equipé
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void analyse(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.analyse(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.analyse.description();
		}
	}
	
	/**
	 * Permet d'ecouter les Npc parler
	 * @param  sCommand :La commande avec tous ses parametres
	 */
	private void speak(String[] sCommand){
		if(sCommand.length >= 2){
			this.game.speak(sCommand[1]);
			this.lastCommand = sCommand;
		}
		else{
			Command.speak.description();
		}
	}
	
	/**
	 * Permet de revenir à la sauvegarde/checkpoint la plus récente
	 */
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
				this.game = new Game();
			}
		}
	}
	
	
	/**
	 * Permet de créé un checkpoint
	 */
	private void createCheckpoint(){
		this.checkpointCreate= this.saveGame(CommandReader.CHECKPOINT) ||this.checkpointCreate;//dans ce sens sinin la save ne se fait pas
	}
	

}
