package userinterface;

import java.awt.geom.GeneralPath;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class VNeckBodice extends Bodice {

	
	static final String neckLine = "V";
	
	/**
	 * Set constructor for VNeckBodice 
	 */
	public VNeckBodice(int hip, int waist, int neckDepth, int shoulder, int armHoleDepth, int napeToWaist, int neckCir) {
		super(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
	}
	
	
	@Override 
	public void drawFrontNeck(GeneralPath typeOfBodice, int frontNeckXOne, int frontNeckYOne, int frontNeckXTwo, int frontNeckYTwo, int frontNeckXThree, int frontNeckYThree) {
		
		typeOfBodice.lineTo(frontNeckXThree, frontNeckYThree);	

	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
