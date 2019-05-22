/*
 * this is still in working progress but 
 * almost complete since we just have to call 
 * the graph and game and it will display it in a 
 * a TextArea
 */
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

public class St_PGame extends JPanel{
	public static void generateGraph(double[] wins, double avg, double[] avg1, double[] avg2, String append, String append2) {
		
		

     XYChart chart = QuickChart.getChart("St. Petersburg Game", "WINNINGS", "", "y(x)",wins,avg2);
	 chart.addSeries("Average = "+avg, avg1, avg1);
	 
	 chart.getStyler().setPlotBackgroundColor(Color.BLACK);
	 chart.getStyler().setChartBackgroundColor(Color.BLACK);
	 chart.getStyler().setChartFontColor(Color.GREEN);
	 chart.getStyler().setLegendBackgroundColor(Color.BLACK);
	 chart.getStyler().setLegendBorderColor(Color.GREEN);
	 chart.getStyler().setPlotGridLinesColor(Color.GREEN);
	 chart.getStyler().setAxisTickLabelsColor(Color.GREEN);
	 chart.getStyler().setAxisTickMarksColor(Color.GREEN);
	 chart.getStyler().setPlotBorderColor(Color.GREEN);
		    
     javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			JFrame frame = new JFrame("Graph");
			JFrame frame2 = new JFrame("Winnings Per Game");
			JFrame frame3 = new JFrame("Frequency of each Outcome");
			JTextArea textArea = new JTextArea (16, 58);  
			textArea.setEditable(false);
			JTextArea textArea2 = new JTextArea (16, 58);
			textArea.setEditable(false);
		    JPanel chartPanel = new XChartPanel<XYChart>(chart);
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			
			textArea.append(append);
			textArea.setBackground(Color.BLACK);
			textArea.setForeground(Color.GREEN);
			panel2.setBackground(Color.BLACK);
			panel2.setLayout(new BorderLayout());
			panel2.add(textArea);
			
			textArea2.append(append2);
			textArea2.setBackground(Color.BLACK);
			textArea2.setForeground(Color.GREEN);
			panel3.setBackground(Color.BLACK);
			panel3.setLayout(new BorderLayout());
			panel3.add(textArea2);
			
			frame.getContentPane().setLayout(new BorderLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JScrollPane scroll = new JScrollPane(textArea);
			scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
			panel2.add(scroll, BorderLayout.CENTER);
		    frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
		    frame2.getContentPane().setLayout(new BorderLayout());
			frame2.getContentPane().add(panel2, BorderLayout.CENTER); 
			frame3.getContentPane().setLayout(new BorderLayout());
			frame3.getContentPane().add(panel3, BorderLayout.CENTER);
			
			
			frame2.setSize(700,300);
			frame2.setLocation(650, 1);
			frame3.setSize(600, 250);
			frame3.setLocation(1250, 500);
			frame.pack();
			frame.setVisible(true);
			frame2.setVisible(true);
			frame3.setVisible(true);
			}
		});
	}
}
  