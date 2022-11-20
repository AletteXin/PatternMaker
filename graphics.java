package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import javax.swing.*;

public class graphics extends JPanel{
	
	private void drawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(new Color (150, 150, 150));
		
		g2d.setRenderingHint(
				
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
				
				
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setPaint(Color.blue);
		g2d.translate(25, 5);

//		
//		GeneralPath frontBodice = new GeneralPath();
//		
//		frontBodice.moveTo(10, 20);
//		frontBodice.curveTo(15, 21, 25, 10, 30, 5);
//		frontBodice.lineTo(40, 10);
//		frontBodice.curveTo(35, 26, 45, 28, 50, 30);
//		frontBodice.lineTo(50,  80);
//		frontBodice.lineTo(10,  80);
//		
//		frontBodice.closePath();
//		
//		
//		GeneralPath backBodice = new GeneralPath();
//		
//		backBodice.moveTo(70, 30);
//		backBodice.curveTo(80, 31, 82, 20, 83, 10);
//		backBodice.lineTo(100, 5);
//		backBodice.curveTo(100, 10, 105, 15, 110, 20);
//		backBodice.lineTo(110,  80);
//		backBodice.lineTo(70,  80);
//		
//		backBodice.closePath();
		
		
		
		GeneralPath frontBodice = new GeneralPath();
		
		
		//in inches 
		
		int expand = 5;
		int hip = 132;
		int waist = 107;
		int quarterMidBody = (waist) / 4 * expand; 
		int neckDepth = 10 * expand;
		int shoulder = ( 15 ) * expand ;
		int armHoleHalfCir = ( 26 ) * expand;
		int torsoHeight = 54 * expand;
		int quarterNeckCir = 40 / 4 * expand;
		
		int startPointX = 10;
		int startPointY = 5;
		
		
		int startFrontBodiceX = startPointX;
		int startFrontBodiceY = startPointY + neckDepth;
		int frontShoulderX = startPointX + shoulder + (shoulder / 10);
		int frontNeckXOne = startFrontBodiceX + (quarterNeckCir/2);
		int frontNeckYOne = startFrontBodiceY;
		int frontNeckXThree = startFrontBodiceX + (quarterNeckCir);
		int frontNeckYThree = startPointY;
		int frontNeckXTwo = frontNeckXThree;
		int frontNeckYTwo = frontNeckYThree + ((frontNeckYOne - frontNeckYThree - startPointY) / 2);
		int frontShoulderY = frontNeckYThree + (neckDepth / 5);
		int frontArmHoleXOne = frontShoulderX - (shoulder / 4);
		int frontArmHoleXThree = startFrontBodiceX + quarterMidBody;
		int frontArmHoleYThree = armHoleHalfCir + startPointY;
		int frontArmHoleYTwo = frontArmHoleYThree - (armHoleHalfCir / 20);
		int frontArmHoleYOne = frontArmHoleYTwo - (armHoleHalfCir / 10);
		int frontArmHoleXTwo = frontArmHoleXOne + ((frontArmHoleXThree - frontArmHoleXOne) / 2);
		int frontBottomX = startFrontBodiceX + quarterMidBody; 
		int frontBottomY = torsoHeight + startPointY;
		int frontEndX = startFrontBodiceX;
		int frontEndY = frontBottomY;
		
		frontBodice.moveTo(startFrontBodiceX, startFrontBodiceY);
		frontBodice.curveTo(frontNeckXOne, frontNeckYOne, frontNeckXTwo, frontNeckYTwo, frontNeckXThree, frontNeckYThree);
		frontBodice.lineTo(frontShoulderX, frontShoulderY);
		frontBodice.curveTo(frontArmHoleXOne, frontArmHoleYOne, frontArmHoleXTwo, frontArmHoleYTwo, frontArmHoleXThree, frontArmHoleYThree);
		frontBodice.lineTo(frontBottomX, frontBottomY);
		frontBodice.lineTo(frontEndX, frontEndY);
		
		frontBodice.closePath();
		
		
		GeneralPath backBodice = new GeneralPath();
		
		int offsetFromFrontBodice = quarterMidBody + 30;
		
		int startBackBodiceX = startFrontBodiceX + offsetFromFrontBodice;
		int startBackBodiceY = frontArmHoleYThree;

		int backArmHoleXOne = startBackBodiceX + (shoulder/2);
		int backArmHoleYOne = startBackBodiceY + (armHoleHalfCir / 40);
		int backArmHoleXTwo = backArmHoleXOne + (shoulder / 5);
		int backArmHoleXThree = startPointX + offsetFromFrontBodice + (quarterMidBody - shoulder - (shoulder / 10)) - (quarterNeckCir/2);
		int backArmHoleYThree = startPointY + (neckDepth / 3);
		int backArmHoleYTwo = backArmHoleYThree + ((startBackBodiceY - backArmHoleYThree) / 2);
		int backShoulderX = backArmHoleXThree + (shoulder - (quarterNeckCir / 3 * 2));
		int backShoulderY = startPointY;
		int backNeckXOne = backShoulderX;
		int backNeckYOne = backArmHoleYThree;
		int backNeckXTwo = backNeckXOne + (quarterNeckCir / 6);
		int backNeckYTwo = backNeckYOne + (neckDepth / 3);
		int backNeckXThree = startBackBodiceX + quarterMidBody; 
		int backNeckYThree = neckDepth - (neckDepth / 5) + startPointY;
		int backBottomX = startBackBodiceX + quarterMidBody; 
		int backBottomY = frontEndY;
		int backEndX = startBackBodiceX;
		int backEndY = backBottomY;
		
		
		backBodice.moveTo(startBackBodiceX, startBackBodiceY);
		backBodice.curveTo(backArmHoleXOne, backArmHoleYOne, backArmHoleXTwo, backArmHoleYTwo, backArmHoleXThree, backArmHoleYThree);
		backBodice.lineTo(backShoulderX, backShoulderY);
		backBodice.curveTo(backNeckXOne, backNeckYOne, backNeckXTwo, backNeckYTwo, backNeckXThree, backNeckYThree);
		backBodice.lineTo(backBottomX, backBottomY);
		backBodice.lineTo(backEndX,  backEndY);
		
		backBodice.closePath();
		
		
		g2d.fill(frontBodice);
		g2d.fill(backBodice);
		
	}
	
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawing(g);
	}
	
}
	
	
	
