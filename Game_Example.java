import java.io.IOException;
import java.util.Arrays;
public class Game_Example {
/*
 *RULES OF THE GAME:  
 *Initial states: player bets 2 dollars
 *Doubles every time head appears
 *when tails appears the game ends :'(
 */
	public static boolean getRandomBoolean() { //coin flip method
		return Math.random() < 0.5;
		}
	public static void main(String[] args) throws IOException {
		String append = " "; 
		double starting_money = 2.00; //start with 2 dollars
		boolean coin;
		double total_winnings = 0;
		double[] winnings = new double[10000]; 
		for(int i=0; i<10000; i++){
			coin=getRandomBoolean();  //flip the coin 
			while(coin!=true){ //if coin is heads add 2 dollars and flip coin again
				starting_money*=2;
				coin = getRandomBoolean();

			}
			winnings[i]= starting_money; //when/if coin is tails end game
			total_winnings+=winnings[i]; 
			append+="\n       GAME "+i+": "+winnings[i]+"                         ";
			starting_money=2.00; //start game again
			}
		double average = total_winnings/10000;
		double[] average1  = new double[1];
		average1[0]=average;
		int x=2;
		double[] average2  = new double[10000];
		for(int i = 0; i<10000; i++){
			average2[i]=x++;
			}
		Arrays.sort(winnings);
		for (int left=0, right=winnings.length-1; left<right; left++, right--) 
		{
            // exchange the first and last
            double temp = winnings[left]; 
            winnings[left]  = winnings[right]; 
            winnings[right] = temp;
        }
		Graph_Example.createGraph(winnings,average,average1, average2, append);
		}
	} 