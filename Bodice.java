package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;


public abstract class Bodice extends JPanel{
	
	//instances 
	
	private int hip; 
	private int waist; 
	private int quarterMidBody; 
	private int neckDepth; 
	private int shoulder;
	private int armHoleDepth; 
	private int napeToWaist;
	private int quarterNeckCir; 
	private int expand = 5;
	private String neckLine;
	
	private int startPointX = 10;
	private int startPointY = 5;
	
	//constructors 
	
	public Bodice (int hip, int waist, int neckDepth, int shoulder, int armHoleDepth, int napeToWaist, int neckCir) {
		
		this.hip = hip; 
		this.waist = waist; 
		this.quarterMidBody = (waist) / 4 * expand; 
		this.neckDepth = neckDepth * expand;
		this.shoulder = shoulder * expand;
		this.armHoleDepth = armHoleDepth * expand;
		this.napeToWaist = napeToWaist * expand;
		this.quarterNeckCir = neckCir / 4 * expand;
		
	}
	
//	
//	int expand = 5;
//	int hip = 132;
//	int waist = 107;
//	int quarterMidBody = 
//	int neckDepth = 10 * expand;
//	int shoulder = ( 15 ) * expand ;
//	int armHoleHalfCir = ( 26 ) * expand;
//	int torsoHeight = 54 * expand;
//	int quarterNeckCir = 40 / 4 * expand;
//	
	
	//methods 
	
	public void drawFrontNeck(GeneralPath typeOfBodice, int frontNeckXOne, int frontNeckYOne, int frontNeckXTwo, int frontNeckYTwo, int frontNeckXThree, int frontNeckYThree) {
			typeOfBodice.curveTo(frontNeckXOne, frontNeckYOne, frontNeckXTwo, frontNeckYTwo, frontNeckXThree, frontNeckYThree);	
		
	}
	
	
	public String getBodiceType() {
		return "Standard Bodice";
	}
	

	private void drawBodice(Graphics g) {

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


		//in cm

//		int expand = 5;
//		int hip = 132;
//		int waist = 107;
//		int quarterMidBody = (waist) / 4 * expand; 
//		int neckDepth = 10 * expand;
//		int shoulder = ( 15 ) * expand ;
//		int armHoleHalfCir = ( 26 ) * expand;
//		int torsoHeight = 54 * expand;
//		int quarterNeckCir = 40 / 4 * expand;
//
//		int startPointX = 10;
//		int startPointY = 5;


		int startFrontBodiceX = this.startPointX;
		int startFrontBodiceY = this.startPointY + this.neckDepth;
		int frontShoulderX = this.startPointX + this.shoulder + (this.shoulder / 10);
		int frontNeckXOne = startFrontBodiceX + (this.quarterNeckCir/2);
		int frontNeckYOne = startFrontBodiceY;
		int frontNeckXThree = startFrontBodiceX + (this.quarterNeckCir);
		int frontNeckYThree = this.startPointY;
		int frontNeckXTwo = frontNeckXThree;
		int frontNeckYTwo = frontNeckYThree + ((frontNeckYOne - frontNeckYThree) / 2);
		int frontShoulderY = frontNeckYThree + (this.neckDepth / 5);
		int frontArmHoleXOne = frontShoulderX - (this.shoulder / 4);
		int frontArmHoleXThree = startFrontBodiceX + this.quarterMidBody;
		int frontArmHoleYThree = this.armHoleDepth + startPointY;
		int frontArmHoleYTwo = frontArmHoleYThree - (this.armHoleDepth / 20);
		int frontArmHoleYOne = frontArmHoleYTwo - (this.armHoleDepth / 10);
		int frontArmHoleXTwo = frontArmHoleXOne + ((frontArmHoleXThree - frontArmHoleXOne) / 2);
		int frontBottomX = startFrontBodiceX + this.quarterMidBody; 
		int frontBottomY = this.napeToWaist + this.startPointY;
		int frontEndX = startFrontBodiceX;
		int frontEndY = frontBottomY;

		frontBodice.moveTo(startFrontBodiceX, startFrontBodiceY);
		
		this.drawFrontNeck(frontBodice, frontNeckXOne, frontNeckYOne, frontNeckXTwo, frontNeckYTwo, frontNeckXThree, frontNeckYThree);
		
		frontBodice.lineTo(frontShoulderX, frontShoulderY);
		frontBodice.curveTo(frontArmHoleXOne, frontArmHoleYOne, frontArmHoleXTwo, frontArmHoleYTwo, frontArmHoleXThree, frontArmHoleYThree);
		frontBodice.lineTo(frontBottomX, frontBottomY);
		frontBodice.lineTo(frontEndX, frontEndY);

		frontBodice.closePath();


		GeneralPath backBodice = new GeneralPath();

		int offsetFromFrontBodice = this.quarterMidBody + 30;

		int startBackBodiceX = startFrontBodiceX + offsetFromFrontBodice;
		int startBackBodiceY = frontArmHoleYThree;

		int backArmHoleXOne = startBackBodiceX + (this.shoulder/2);
		int backArmHoleYOne = startBackBodiceY + (this.armHoleDepth / 40);
		int backArmHoleXTwo = backArmHoleXOne + (this.shoulder / 5);
		int backArmHoleXThree = this.startPointX + offsetFromFrontBodice + (this.quarterMidBody - this.shoulder - (this.shoulder / 10)) - (quarterNeckCir/2);
		int backArmHoleYThree = this.startPointY + (this.neckDepth / 3);
		int backArmHoleYTwo = backArmHoleYThree + ((startBackBodiceY - backArmHoleYThree) / 2);
		int backShoulderX = backArmHoleXThree + (this.shoulder - (this.quarterNeckCir / 3 * 2));
		int backShoulderY = this.startPointY;
		int backNeckXOne = backShoulderX;
		int backNeckYOne = backArmHoleYThree;
		int backNeckXTwo = backNeckXOne + (this.quarterNeckCir / 6);
		int backNeckYTwo = backNeckYOne + (this.neckDepth / 3);
		int backNeckXThree = startBackBodiceX + this.quarterMidBody; 
		int backNeckYThree = this.neckDepth - (this.neckDepth / 5) + this.startPointY;
		int backBottomX = startBackBodiceX + this.quarterMidBody; 
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
		drawBodice(g);
	}

}





