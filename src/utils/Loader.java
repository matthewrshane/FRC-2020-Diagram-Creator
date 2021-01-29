package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	
	public static BufferedImage loadImageFromClasspath(String path) {
		try {
			return ImageIO.read(new FileInputStream(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage loadImageFromFile(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
