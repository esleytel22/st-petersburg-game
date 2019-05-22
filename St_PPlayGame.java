import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class St_PPlayGame {		
	public static void main(String[] args) {
		double starting_balance = 2.00; //Game starts with 2 dollars
		int n = 10000; //How many iterations to run
		String append = "";
		String append2 = "Outcome	Frequency";
		double[] wins = new double[n];
		double total_wins = 0;
		
		for(int i = 0; i < n; i++) {
			int times = 0;
			double flip = 0;
			while(flip < 0.5) {
				flip = Math.random();
				times++;
			}
			starting_balance = Math.pow(2, times);
			wins[i] = starting_balance;
			total_wins += wins[i];
			append += "GAME" + " " + (i + 1) + ": " + " " + wins[i] + "\n";
			starting_balance = 2.00;
		}
			
		double avg = total_wins / n;
		double[] avg1 = new double[1];
		avg1[0] = avg;
		
		int x = 2;
		double[] avg2 = new double[n];
		for(int i = 0; i < n; i++) {
			avg2[i] = x++;
		}
		
		Arrays.sort(wins);
		ArrayList<Double> freq = new ArrayList<Double>();
		
		for(int i = 0; i < wins.length - 1; i++) {
			freq.add(wins[i]);		
			}		
		for(int j = 2; j < Collections.max(freq); j*=2) {
			append2 += "\n" + (double)j + "                        " + Collections.frequency(freq, (double)j);
		}

		for(int l = 0, r = wins.length - 1; l < r; l++, r--) {
			double temp = wins[l];
			wins[l] = wins[r];
			wins[r] = temp;
		}
		
		St_PGame.generateGraph(wins, avg, avg1, avg2, append, append2);
		
	}
			
}






