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
		
		int quarterWaist = 24;
		int neckDepth = 5;
		int halfShoulder = 20;
		int armHoleHalfCir = 12;
		int torsoHeight = 30;
		
		int startPointX = 10;
		int startPointY = 5;
		
		
		int startFrontBodiceX = startPointX;
		int startFrontBodiceY = startPointY + neckDepth;
		int frontShoulderX = startPointX + halfShoulder;
		int frontNeckXOne = startFrontBodiceX + ((frontShoulderX - startFrontBodiceX) / 3);
		int frontNeckYOne = startFrontBodiceY + 1;
		int frontNeckXThree = frontShoulderX - ((frontShoulderX - startFrontBodiceX) / 3);
		int frontNeckYThree = startPointY;
		int frontNeckXTwo = startFrontBodiceX + (2*((frontShoulderX - startFrontBodiceX) / 3));
		int frontNeckYTwo = frontNeckYThree + ((frontNeckYOne - frontNeckYThree - startPointY) / 2);
		int frontShoulderY = frontNeckYTwo - 3;
		int frontArmHoleXOne = frontShoulderX - 5;
		int frontArmHoleXThree = startFrontBodiceX + quarterWaist;
		int frontArmHoleYThree = armHoleHalfCir + startPointY;
		int frontArmHoleYTwo = frontArmHoleYThree - 2;
		int frontArmHoleYOne = frontArmHoleYTwo - 2;
		int frontArmHoleXTwo = frontArmHoleXOne + ((frontArmHoleXThree - frontArmHoleXOne) / 2);
		int frontBottomX = startFrontBodiceX + quarterWaist; 
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
		
		int offsetFromFrontBodice = quarterWaist + 30;
		
		int startBackBodiceX = startFrontBodiceX + offsetFromFrontBodice;
		int startBackBodiceY = frontArmHoleYThree;
		int backShoulderX = frontShoulderX + offsetFromFrontBodice;
		int backShoulderY = startPointY;
		int backArmHoleXOne = startBackBodiceX + (halfShoulder/2);
		int backArmHoleYOne = startBackBodiceY + 1;
		int backArmHoleXTwo = backArmHoleXOne + (halfShoulder/20);
		int backArmHoleXThree = backArmHoleXTwo + (halfShoulder/20);
		int backArmHoleYThree = backShoulderY + 5;
		int backArmHoleYTwo = backArmHoleYThree + ((startBackBodiceY - backArmHoleYThree) / 2);
		int backNeckXOne = backShoulderX;
		int backNeckYOne = backArmHoleYThree;
		int backNeckXTwo = backNeckXOne + 5;
		int backNeckYTwo = backNeckYOne + 5;
		int backNeckXThree = startBackBodiceX + quarterWaist; 
		int backNeckYThree = neckDepth - (neckDepth / 5) + startPointY;
		int backBottomX = startBackBodiceX + quarterWaist; 
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
	
	
	
