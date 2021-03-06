
// Version 1 Sample need coordinate and value with display info 

import java.awt.*;
import javax.swing.*;
//Scatter plot Graph
public class St_PGraph extends JPanel {
	public St_PGraph() {
		
	}
    int[] data = { 25, 60, 42, 75 };
    final int PAD = 20;
  
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.drawLine(PAD, PAD, PAD, height-PAD);
        g2.drawLine(PAD, height-PAD, width-PAD, height-PAD);
        
        //x and y 
        double xScale = (width - 2*PAD)/(data.length + 1);
        double maxValue = 100.0;
        double yScale = (height - 2*PAD)/maxValue;
        
        // The origin location.
        int x0 = PAD;
        int y0 = height-PAD;
   
        g2.setPaint(Color.red);  // color of the dot 
        
        //how to put info 
        for(int j = 0; j < data.length; j++) {
            int x = x0 + (int)(xScale * (j+1));
            int y = y0 - (int)(yScale * data[j]);
            g2.fillOval(x-2, y-2, 4, 4);
        }
    }
  
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new St_PGraph());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}