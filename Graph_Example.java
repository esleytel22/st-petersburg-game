import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
public class Graph_Example extends JPanel{
	public Graph_Example() {
	
	}	
	public static void createGraph(double[] winnings, double average, double[] average1, double[] average2, String append) {
		XYChart chart = QuickChart.getChart("St. Petersburg Game", "WINNINGS", "", "y(x)",winnings,average2);
		chart.addSeries("Average = "+average, average1, average1);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Graph");
				JFrame frame2 = new JFrame("Winnings Per Game");
				JTextArea textArea = new JTextArea (16, 58);  
				textArea.setEditable(false);
				JPanel chartPanel = new XChartPanel<XYChart>(chart);
				JPanel panel2 = new JPanel();
				textArea.append(append);
				panel2.add(textArea);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
				frame2.getContentPane().add(panel2); 
				JScrollPane scroll = new JScrollPane(textArea);
				scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
				panel2.add(scroll);
				frame2.setSize(700,350);
				frame2.setLocation(650, 1);
				frame.pack();
				frame.setVisible(true);
				frame2.setVisible(true);
				}
			});
		}
	}

