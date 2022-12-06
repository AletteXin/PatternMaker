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
	public VNeckBodice(int hip, int waist, int neckDepth, int shoulder, int armHoleDepth, 
			int napeToWaist, int neckCir) {
		//use constructor formula from Bodice class 
		super(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
	}
	
	/**
	 * Draw front neck 
	 */
	@Override 
	public void drawFrontNeck(GeneralPath typeOfBodice, int frontNeckXOne, int frontNeckYOne, 
			int frontNeckXTwo, int frontNeckYTwo, int frontNeckXThree, int frontNeckYThree) {
		typeOfBodice.lineTo(frontNeckXThree, frontNeckYThree);	
	}

	/**
	 * Provides a string which describes the bodice type 
	 * @return String with bodice type description
	 */
	@Override
	public String getBodiceType() {
		return "V Neck Bodice";
	}


}
