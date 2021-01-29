package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.Main;

public class GraphicsController {
	
	private Content content;
	
	private BufferedImage staticImage, drawImage;
	private double scalingFactor = 0;
	private int scaledWidth, scaledHeight;
	
	public GraphicsController(BufferedImage staticImage) {
		content = new Content();
		this.staticImage = staticImage;
		this.drawImage = new BufferedImage(staticImage.getWidth(), staticImage.getHeight(), staticImage.getType());
		this.scalingFactor = Math.max((double) staticImage.getWidth() / Main.FRAME_WIDTH, (double) staticImage.getHeight() / Main.FRAME_HEIGHT);
		this.scaledWidth = (int) (staticImage.getWidth() / scalingFactor);
		this.scaledHeight = (int) (staticImage.getHeight() / scalingFactor);
		System.out.println(scalingFactor);
	}

	public Component getContent() {
		return content;
	}
	
	private class Content extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public Dimension getPreferredSize() {
	        return new Dimension(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);
	    }
		
		public void paintComponent(Graphics graphics) {
			drawImage.setData(staticImage.getData());
			Graphics2D g = drawImage.createGraphics();
			
			g.setColor(Color.red);
			g.fillRect(0, 0, 100, 100);
			
			graphics.drawImage(drawImage, 0, 0, scaledWidth, scaledHeight, null);
		}
	}
	
}
