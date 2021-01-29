package utils;

public class Maths {
	
	/**
	 * Calculates the slope of the lines which defines the boundry as to where a robot can fire from
	 * @return the slope of the top line (the bottom is -top)
	 */
	public static double getSlope(double widthInner, double widthOuter, double ballDiameter, int xInner, int xOuter, int yCenter) {
		// Y coordinate, in pixels, of the top edge of the inner goal
		double yInner = yCenter - ((widthInner - ballDiameter) / 2);
		// Y coordinate, in pixels, of the top edge of the outer goal
		double yOuter = yCenter - ((widthOuter - ballDiameter) / 2);
		// The slope of the line; m = (y2 - y1)/(x2 - x1)
		double slope = (yOuter - yInner) / (xOuter - xInner);
		return slope;
	}
	
	/**
	 * Calculates the y-intercept of one of the bounding lines given its slope
	 * @return the y-intercept of the line
	 */
	public static double getYIntercept(double widthInner, double ballDiameter, int xInner, int yCenter, double slope) {
		// Y coordinate, in pixels, of the top edge of the inner goal
		double yInner = yCenter - ((widthInner - ballDiameter) / 2);
		// [y = mx + b] can be manipulated to form the equation [b = y - mx]
		double b = yInner - (slope * xInner);
		return b;
	}
	
}
