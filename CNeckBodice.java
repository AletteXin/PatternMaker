package userinterface;

import java.awt.geom.GeneralPath;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class CNeckBodice extends Bodice {

	
	static final String neckLine = "C";
	
	/**
	 * Set constructor for VNeckBodice 
	 */
	public CNeckBodice(int hip, int waist, int neckDepth, int shoulder, int armHoleDepth, int napeToWaist, int neckCir) {
		super(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
	}
	
	
	@Override 
	public void drawFrontNeck(GeneralPath typeOfBodice, int frontNeckXOne, int frontNeckYOne, int frontNeckXTwo, int frontNeckYTwo, int frontNeckXThree, int frontNeckYThree) {
		
		typeOfBodice.curveTo(frontNeckXOne, frontNeckYOne, frontNeckXTwo, frontNeckYTwo, frontNeckXThree, frontNeckYThree);	
	
}

	@Override
	public String getBodiceType() {
		return "C Neck Bodice";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
