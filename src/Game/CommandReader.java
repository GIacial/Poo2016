package Game;

import java.util.Scanner;


public class CommandReader {
	private Scanner s;
	private boolean actif;
	private Game game;

	public CommandReader(Game game) {
		this.s=new Scanner(System.in);
		this.actif=true;
		this.game=game;
	}
	
	public void interpretation(){
		String[] sCommand= this.s.nextLine().split(" ");
		if(sCommand.length>0 && !sCommand[0].equals("")){
			
			try{
				Command t=Command.valueOf(sCommand[0].toLowerCase());//lower cas pour que Bonjour=bonjour
				
				switch(t){
					case look:this.look(sCommand);
						break;
						
					case quit:this.quit();
						break;
						
					case go:this.go(sCommand);
						break;
						
					case help:this.help(sCommand);
						break;
						
					case take:this.take(sCommand);
						break;
					case use : this.use(sCommand);
						break;
					case attack:this.attack(sCommand);
						break;
					case equip:this.equip(sCommand);
						break;
					case unequip:this.unequip(sCommand);
						break;
					case discard:this.discard(sCommand);
						break;
					case analyse:this.analyse(sCommand);
						break;
					case speak: this.speak(sCommand);
						break;
						
					default:System.err.println("Pas encore fait");
							break;
				}
			}
			catch(Exception e){
				if(!(e instanceof IllegalArgumentException)){
					System.err.println(e);
					throw e;
				}
				System.out.println(sCommand[0] + " n'est pas une commande");
			}
		}
		
	}

	public boolean isActif() {
		return this.actif;
	}
	
	private void go(String[] sCommand){
		if(sCommand.length>=2){
			game.go(sCommand[1]);
		}
		else{
			Command.go.description();
		}
	}
	
	private void look(String[] sCommand){
		if(sCommand.length>=2){
			this.game.look(sCommand[1]);
		}
		else{
			this.game.look();
		}
	}
	
	private void help(String[] sCommand){
		if(sCommand.length>=2){
			Command.description(sCommand[1]);
		}
		else{
			Command listCommand[]=Command.values();
			for(int i=0; i<listCommand.length;i++){
				System.out.println(listCommand[i]);
			}
		}
	}
	
	private void quit(){
		System.out.println("Au revoir");
		//insere sauvegarde ici
		this.actif=false;
		s.close();								//fin du scanner principal
	}
	
	private void take(String[] sCommand){
		if(sCommand.length>=2){
			this.game.take(sCommand[1]);
		}
		else{
			Command.take.description();
		}
	}
	
	private void use(String[] sCommand){
		if(sCommand.length>=3){
			this.game.use(sCommand[1], sCommand[2]);
		}
		else{
			Command.use.description();
		}
	}
	
	private void attack(String[] sCommand){
		if(sCommand.length>=2){
			this.game.attack(sCommand[1]);
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
	
	

}
