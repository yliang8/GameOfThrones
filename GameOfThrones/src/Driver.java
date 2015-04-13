import java.io.IOException;

import jxl.read.biff.BiffException;


public class Driver {
	
	public static void main (String[] args) throws BiffException, IOException {
		int lannister = 0;
		int baratheon = 0;
		int stark = 0; 
		int greyjoy = 0;
		int tyrell = 0; 
		int martell = 0;
		for (int i = 0; i<1000; i++){
			Game game = new Game();
			game.play();
			String name = game.getWinner();
			if (name.equals("lannister")) lannister +=1;
			if (name.equals("baratheon")) baratheon +=1;
			if (name.equals("stark")) stark +=1;
			if (name.equals("greyjoy")) greyjoy +=1;
			if (name.equals("tyrell")) tyrell +=1;
			if (name.equals("martell")) martell +=1;
		}
		System.out.printf("%d, %d, %d, %d, %d ,%d", lannister,baratheon, stark, greyjoy, tyrell, martell);
	}
}
