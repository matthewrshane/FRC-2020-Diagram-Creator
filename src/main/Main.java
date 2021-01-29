package main;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import graphics.GraphicsController;
import utils.Loader;

public class Main {
	
	// FRAME CONSTANTS
	public static final String FRAME_NAME = "FRC 2020 Diagram Creator";
	public static final int FRAME_WIDTH = 1200, FRAME_HEIGHT = 875;
	
	// JFRAME
	private JFrame frame;
	
	// IMAGE
	private BufferedImage image = null;
	
	// USER VARIABLES (DEFAULTS BASED ON DEFAULT IMAGE, SIZES IN INCHES)
	private double widthInner = 13, widthOuter = 39.25;
	private double ballDiameter = 7;
	private int xInner = 519, xOuter = 636;
	private int yCenter = 826;
	private double pixelsPerInch = 4.042;
	
	// MANAGERS/CONTROLLERS
	private GraphicsController graphicsController;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		frame = new JFrame(FRAME_NAME);
		if(!init()) {
			System.out.println("[ERROR | FATAL] variable failed to initialize correctly. Check for stacktrace.");
			System.exit(-1);
		}
		frame.add(graphicsController.getContent());
		frame.pack(); // Resizes JFrame to fit components
		frame.setLocationRelativeTo(null); // Centers the JFrame on the display
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		// inner width, outer width, ball diameter, outside x val, inside x val, middle goal y value, pxPerIn
		
		frame.setVisible(true);
	}
	
	private boolean init() {
		image = Loader.loadImageFromClasspath("res/field_map.png");
		
		graphicsController = new GraphicsController(image);
		
		return true;
	}
	
}
