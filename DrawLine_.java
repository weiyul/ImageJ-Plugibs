/*
Author: Sophia Liao
This is a simple plug-in to draw lines over an image.
Please open an image first, before run this plug-in, File->open

*/

import ij.ImagePlus;
import ij.IJ;
import ij.plugin.PlugIn;
import ij.gui.Overlay;
import ij.gui.Roi;
import ij.gui.Line;


public class DrawLine_ implements PlugIn {
	final int lineNumber = 10;// decide how many lines you want here!!
	Overlay overlay = new Overlay();
	ImagePlus imp = IJ.getImage();
	final int impWidth = imp.getWidth();// get image width in int but in double type
	final int impHeight = imp.getHeight();
	
	@Override
	public void run(String arg) {
		
		
		for(int i=0; i<lineNumber; i++ ){

			
			int[] points = generatePoints() ;//decide where the line to start and to end

			drawLines(points);
		}

		imp.setOverlay(overlay);// put the resulting overlay on the image
		
		
	}

	int[] generatePoints (){

		int[] points={0,0,0,0};
		points[0] = (int)(Math.random()*impWidth);//get a random xStart
		points[1] = (int)(Math.random()*impHeight);//get a random yStart
		points[2] = (int)(Math.random()*impWidth);//get a random xEnd
		points[3] = (int)(Math.random()*impHeight);//get a random yEnd

		//IJ.error("impWidth: "+String.valueOf(impWidth)+ "\nimpHeight: "+String.valueOf(impHeight)+"\nxStart: "+points[0]+"\nyStart: "+points[1]+"\nxEnd: "+points[2]+"\nxEnd: "+points[3]);//for testing
		
		return points;	
		 
	}

	void drawLines(int[] points){
		Roi roi = new Line(points[0], points[1], points[2], points[3]);// points[0] is startX, points[1] is startY, points[2] is endX, points[3] is endY
		overlay.add(roi); //add roi over overlay
		
	}
}


