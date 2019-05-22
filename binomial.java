
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.Random;
public class binomial {
	public static void main(String args[]){
		Random v = new Random();
		double val;
		double sum = 0;
		int bell[] = new int[10];
		for (int i = 0; i < 100; i++){
			val = v.nextGaussian();
			sum += val;
			double t = -2;
			for (int j = 0; j < 10; j++, t += 0.5 )
				if (val < t) {
					bell[j]++;
					break;
				}
			}
			System.out.println(sum/100);
			for (int k = 0; k < 10; k++){
				for (int l = bell[k]; l>0; l-- )
					System.out.print("*");
				System.out.println();
				}
			}
		
	}
	