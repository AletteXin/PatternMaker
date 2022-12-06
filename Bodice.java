package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;


public abstract class Bodice extends JPanel{
	
	//instances for body measurements 
	
	//initialise integer for hip 
	private int hip; 
	
	//initialise integer for waist 
	private int waist; 
	
	//initialise integer for quarter mid body   
	private int quarterMidBody; 
	
	//initialise integer for neckDepth  
	private int neckDepth; 

	//initialise integer for shoulder
	private int shoulder;
	
	//initialise integer for arm hole depth 
	private int armHoleDepth; 
	
	//initialise integer for nape to waist measurement 
	private int napeToWaist;
	
	//initialise integer for quarter of neck circumference measurement 
	private int quarterNeckCir; 
	
	//initialise integer expansion of all 
	private int expand = 5;
	
	//instances for drawing bodice 
	
	//initialise integer for front shoulder X-axis 
	private int frontShoulderX;
	
	//initialise integer for front neck X-axis first value on curve
	private int frontNeckXOne;

	//initialise integer for front neck Y-axis first value on curve
	private int frontNeckYOne;

	//initialise integer for front neck X-axis third value on curve 
	private int frontNeckXThree;
	
	//initialise integer for front neck Y-axis third value on curve  
	private int frontNeckYThree;
	
	//initialise integer for front neck X-axis second value on curve  
	private int frontNeckXTwo;
	
	//initialise integer for front neck Y-axis second value on curve  
	private int frontNeckYTwo;
	
	//initialise integer for front shoulder Y-axis   
	private int frontShoulderY;
	
	//initialise integer for front armhole depth X-axis first value on curve  
	private int frontArmHoleXOne;

	//initialise integer for front armhole depth X-axis third value on curve  
	private int frontArmHoleXThree;
	
	//initialise integer for front armhole depth Y-axis third value on curve  
	private int frontArmHoleYThree;
	
	//initialise integer for front armhole depth Y-axis second value on curve  
	private int frontArmHoleYTwo;
	
	//initialise integer for front armhole depth Y-axis first value on curve  
	private int frontArmHoleYOne;
	
	//initialise integer for front armhole depth X-axis second value on curve  
	private int frontArmHoleXTwo;
	
	//initialise integer for front bottom X-axis  
	private int frontBottomX; 

	//initialise integer for front bottom Y-axis
	private int frontBottomY;
	
	//initialise integer for front end point X-axis
	private int frontEndX;

	//initialise integer for front end point Y-axis
	private int frontEndY;
	
	//initialise integer for front starting point X-axis
	private int startFrontBodiceX;

	//initialise integer for front starting point Y-axis
	private int startFrontBodiceY;
	
	//initialise integer for offset from front bodice 
	private int offsetFromFrontBodice;

	//initialise integer for back starting point X-axis  
	private int startBackBodiceX;

	//initialise integer for back starting point Y-axis 
	private int startBackBodiceY;

	//initialise integer for back armhole depth X-axis first value on curve  
	private int backArmHoleXOne;

	//initialise integer for back armhole depth Y-axis first value on curve  
	private int backArmHoleYOne;
	
	//initialise integer for back armhole depth X-axis second value on curve  
	private int backArmHoleXTwo;
	
	//initialise integer for back armhole depth X-axis third value on curve  
	private int backArmHoleXThree;
	
	//initialise integer for back armhole depth Y-axis third value on curve  
	private int backArmHoleYThree;
	
	//initialise integer for back armhole depth Y-axis second value on curve  
	private int backArmHoleYTwo;
	
	//initialise integer for back shoulder X-axis 
	private int backShoulderX;

	//initialise integer for back shoulder Y-axis 
	private int backShoulderY;
	
	//initialise integer for back neck X-axis first value on curve  
	private int backNeckXOne;

	//initialise integer for back neck Y-axis first value on curve 
	private int backNeckYOne;
	
	//initialise integer for back neck X-axis second value on curve 
	private int backNeckXTwo;
	
	//initialise integer for back neck Y-axis second value on curve 
	private int backNeckYTwo;
	
	//initialise integer for back neck X-axis third value on curve 
	private int backNeckXThree; 
	
	//initialise integer for back neck Y-axis third value on curve 
	private int backNeckYThree;
	
	//initialise integer for back bottom X-axis  
	private int backBottomX; 

	//initialise integer for back bottom Y-axis 
	private int backBottomY;

	//initialise integer for back ending point X-axis 
	private int backEndX;

	//initialise integer for back ending point Y-axis
	private int backEndY;
	
	//initialise integer for start point X-axis 
	private int startPointX = 10;
	
	//initialise integer for start point Y-axis  
	private int startPointY = 5;
	
	//constructors 
	
	public Bodice (int hip, int waist, int neckDepth, int shoulder, int armHoleDepth, int napeToWaist, int neckCir) {
		
		//set hip 
		this.hip = hip; 
		
		//set waist 
		this.waist = waist; 
		
		//set quarter mid body by dividing waist by four and expand by a magnitude (for graphical purposes)
		this.quarterMidBody = (waist) / 4 * expand; 
		
		//set neck depth and expand by a magnitude (for graphical purposes)
		this.neckDepth = neckDepth * expand;
		
		//set shoulder and expand by a magnitude (for graphical purposes)
		this.shoulder = shoulder * expand;
		
		//set arm hole depth and expand by a magnitude (for graphical purposes)
		this.armHoleDepth = armHoleDepth * expand;
		
		//set nape to waist measurement and expand by a magnitude (for graphical purposes)
		this.napeToWaist = napeToWaist * expand;
		
		//set quarter neck circumference by dividing neck circumference by four and expand by a magnitude (for graphical purposes)
		this.quarterNeckCir = neckCir / 4 * expand;
		
		//set start of front bodice X-axis
		this.startFrontBodiceX = this.startPointX;

		//set start of front bodice Y-axis 
		this.startFrontBodiceY = this.startPointY + this.neckDepth;
		
		//set front shoulder X
		this.frontShoulderX = this.startPointX + this.shoulder + (this.shoulder / 10);
		
		//set front neck X-axis first point on curve 
		this.frontNeckXOne = this.startFrontBodiceX + (this.quarterNeckCir/2);
		
		//set front neck Y-axis first point on curve
		this.frontNeckYOne = this.startFrontBodiceY;
		
		//set front neck X-axis third point on curve
		this.frontNeckXThree = this.startFrontBodiceX + (this.quarterNeckCir);
		
		//set front neck Y-axis third point on curve
		this.frontNeckYThree = this.startPointY;
		
		//set front neck X-axis second point on curve
		this.frontNeckXTwo = this.frontNeckXThree;
		
		//set front neck Y-axis second point on curve
		this.frontNeckYTwo = this.frontNeckYThree + ((this.frontNeckYOne - this.frontNeckYThree) / 2);
		
		//set front shoulder Y-axis 
		this.frontShoulderY = this.frontNeckYThree + (this.neckDepth / 5);
		
		//set front armhole depth X-axis first point on curve  
		this.frontArmHoleXOne = this.frontShoulderX - (this.shoulder / 4);

		//set front armhole depth X-axis third point on curve 
		this.frontArmHoleXThree = this.startFrontBodiceX + this.quarterMidBody;
		
		//set front armhole depth Y-axis third point on curve 
		this.frontArmHoleYThree = this.armHoleDepth + this.startPointY;
		
		//set front armhole depth Y-axis second point on curve 
		this.frontArmHoleYTwo = this.frontArmHoleYThree - (this.armHoleDepth / 20);
		
		//set front armhole depth Y-axis first point on curve 
		this.frontArmHoleYOne = this.frontArmHoleYTwo - (this.armHoleDepth / 10);
		
		//set front armhole depth X-axis second point on curve 
		this.frontArmHoleXTwo = this.frontArmHoleXOne + ((this.frontArmHoleXThree - this.frontArmHoleXOne) / 2);
		
		//set front bottom X-axis
		this.frontBottomX = this.startFrontBodiceX + this.quarterMidBody; 

		//set front bottom Y-axis
		this.frontBottomY = this.napeToWaist + this.startPointY;
		
		//set front ending point X-axis
		this.frontEndX = this.startFrontBodiceX;
		
		//set front ending point Y-axis
		this.frontEndY = this.frontBottomY;
		
		//set offset from front bodice 
		this.offsetFromFrontBodice = this.quarterMidBody + 30;

		
		//set start back bodice X-axis 
		this.startBackBodiceX = this.startFrontBodiceX + this.offsetFromFrontBodice;
		
		//set start back bodice Y-axis 
		this.startBackBodiceY = this.frontArmHoleYThree;

		//set back armhole depth X-axis first point on curve 
		this.backArmHoleXOne = this.startBackBodiceX + (this.shoulder/2);

		//set back armhole depth Y-axis first point on curve 
		this.backArmHoleYOne = this.startBackBodiceY + (this.armHoleDepth / 40);
		
		//set back armhole depth X-axis second point on curve 
		this.backArmHoleXTwo = this.backArmHoleXOne + (this.shoulder / 5);
		
		//set back armhole depth X-axis third point on curve 
		this.backArmHoleXThree = this.startPointX + this.offsetFromFrontBodice + (this.quarterMidBody - this.shoulder - (this.shoulder / 10)) - (this.quarterNeckCir/2);
		
		//set back armhole depth Y-axis third point on curve 
		this.backArmHoleYThree = this.startPointY + (this.neckDepth / 3);
		
		//set back armhole depth Y-axis second point on curve 
		this.backArmHoleYTwo = this.backArmHoleYThree + ((this.startBackBodiceY - this.backArmHoleYThree) / 2);
		
		//set back shoulder X-axis 
		this.backShoulderX = this.backArmHoleXThree + (this.shoulder - (this.quarterNeckCir / 3 * 2));

		//set back shoulder Y-axis 
		this.backShoulderY = this.startPointY;
		
		//set back neck X-axis first point on curve  
		this.backNeckXOne = this.backShoulderX;

		//set back neck Y-axis first point on curve 
		this.backNeckYOne = this.backArmHoleYThree;
		
		//set back neck X-axis second point on curve 
		this.backNeckXTwo = this.backNeckXOne + (this.quarterNeckCir / 6);
		
		//set back neck Y-axis second point on curve 
		this.backNeckYTwo = this.backNeckYOne + (this.neckDepth / 3);
		
		//set back neck X-axis third point on curve 
		this.backNeckXThree = startBackBodiceX + this.quarterMidBody; 
		
		//set back neck Y-axis third point on curve 
		this.backNeckYThree = this.neckDepth - (this.neckDepth / 5) + this.startPointY;
		
		//set back bottom X-axis 
		this.backBottomX = this.startBackBodiceX + this.quarterMidBody; 

		//set back bottom Y-axis 
		this.backBottomY = this.frontEndY;
	
		//set back ending point X-axis 
		this.backEndX = this.startBackBodiceX;

		//set back ending point Y-axis 
		this.backEndY = this.backBottomY;

	}

	
	//methods 
	
	/**
	 * drawFrontNeck draws the path for the front neck of a bodice
	 * @param typeOfBodice
	 * @param frontNeckXOne
	 * @param frontNeckYOne
	 * @param frontNeckXTwo
	 * @param frontNeckYTwo
	 * @param frontNeckXThree
	 * @param frontNeckYThree
	 */
	public void drawFrontNeck(GeneralPath typeOfBodice, int frontNeckXOne, int frontNeckYOne, 
			int frontNeckXTwo, int frontNeckYTwo, int frontNeckXThree, int frontNeckYThree) {
		
			//use curveTo to draw the curve for the neckline 
			typeOfBodice.curveTo(frontNeckXOne, frontNeckYOne, frontNeckXTwo, 
					frontNeckYTwo, frontNeckXThree, frontNeckYThree);	
		
	}
	
	/**
	 * getBodiceType returns a String describing the type of bodice 
	 * @return
	 */
	public String getBodiceType() {
		return "Standard Bodice";
	}
	

	/**
	 * drawBodice draws the bodice based on user measurements 
	 * @param g
	 */
	private void drawBodice(Graphics g) {

		
		//initialise a new Graphics2D 
		Graphics2D g2d = (Graphics2D) g;

		//set colour for g2d
		g2d.setPaint(new Color (150, 150, 150));

		//set rendering hint 
		g2d.setRenderingHint(

				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		//set rendering hint 
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		//set paint colour to blue 
		g2d.setPaint(Color.blue);
		
		//translate g2d
		g2d.translate(25, 5);

		//initialise a general path object for front bodice 
		GeneralPath frontBodice = new GeneralPath();

		//move point of general path front bodice to start front bodice X and start front bodice Y 
		frontBodice.moveTo(this.startFrontBodiceX, this.startFrontBodiceY);
		
		//use drawFrontNeck formula to draw front neck 
		this.drawFrontNeck(frontBodice, this.frontNeckXOne, this.frontNeckYOne, this.frontNeckXTwo, 
				this.frontNeckYTwo, this.frontNeckXThree, this.frontNeckYThree);
		
		//draw shoulder of front bodice 
		frontBodice.lineTo(this.frontShoulderX, this.frontShoulderY);
		
		//draw arm hole of front bodice 
		frontBodice.curveTo(this.frontArmHoleXOne, this.frontArmHoleYOne, this.frontArmHoleXTwo, 
				this.frontArmHoleYTwo, this.frontArmHoleXThree, this.frontArmHoleYThree);
		
		//draw bottom line of front bodice 
		frontBodice.lineTo(this.frontBottomX, this.frontBottomY);
		
		//complete the front bodice drawing with ending point 
		frontBodice.lineTo(this.frontEndX, this.frontEndY);

		//close front bodice path 
		frontBodice.closePath();

		//initialise a general path for back bodice 
		GeneralPath backBodice = new GeneralPath();

		//move start point of back bodice to start back bodice coordinates 
		backBodice.moveTo(this.startBackBodiceX, this.startBackBodiceY);
		
		//draw arm hole for back bodice 
		backBodice.curveTo(this.backArmHoleXOne, this.backArmHoleYOne, this.backArmHoleXTwo, 
				this.backArmHoleYTwo, this.backArmHoleXThree, this.backArmHoleYThree);
		
		//draw shoulder for back bodice 
		backBodice.lineTo(this.backShoulderX, this.backShoulderY);
		
		//draw neck hole for back bodice 
		backBodice.curveTo(this.backNeckXOne, this.backNeckYOne, this.backNeckXTwo, 
				this.backNeckYTwo, this.backNeckXThree, this.backNeckYThree);
		
		//draw bottom for back bodice 
		backBodice.lineTo(this.backBottomX, this.backBottomY);
		
		//complete back bodice drawing with ending point 
		backBodice.lineTo(this.backEndX,  this.backEndY);

		//close back bodice path 
		backBodice.closePath();

		//fill front bodice 
		g2d.fill(frontBodice);
		
		//fill back bodice 
		g2d.fill(backBodice);

	}

	/**
	 * Get back arm hole X-axis first point on curve 
	 * @return back arm hole X-axis first point on curve (integer)
	 */
	public int getBackArmHoleXOne() {
		return backArmHoleXOne;
	}

	/**
	 * Get back arm hole Y-axis first point on curve 
	 * @return back arm hole Y-axis first point on curve (integer)
	 */
	public int getBackArmHoleYOne() {
		return backArmHoleYOne;
	}

	/**
	 * Get back arm hole X-axis second point on curve 
	 * @return back arm hole X-axis second point on curve (integer)
	 */
	public int getBackArmHoleXTwo() {
		return backArmHoleXTwo;
	}

	/**
	 * Get back arm hole X-axis third point on curve 
	 * @return back arm hole X-axis third point on curve (integer)
	 */
	public int getBackArmHoleXThree() {
		return backArmHoleXThree;
	}

	/**
	 * Get back arm hole Y-axis third point on curve 
	 * @return back arm hole Y-axis third point on curve (integer)
	 */
	public int getBackArmHoleYThree() {
		return backArmHoleYThree;
	}

	/**
	 * Get back arm hole Y-axis second point on curve 
	 * @return back arm hole Y-axis second point on curve (integer)
	 */
	public int getBackArmHoleYTwo() {
		return backArmHoleYTwo;
	}

	/**
	 * Get back arm hole depth
	 * @return back arm hole depth
	 */
	public int getArmHoleDepth() {
		return armHoleDepth;
	}

	/**
	 * Get front arm hole X-axis first point on curve 
	 * @return front arm hole X-axis first point on curve (integer)
	 */
	public int getFrontArmHoleXOne() {
		return frontArmHoleXOne;
	}

	/**
	 * Get front arm hole X-axis third point on curve 
	 * @return front arm hole X-axis third point on curve (integer)
	 */
	public int getFrontArmHoleXThree() {
		return frontArmHoleXThree;
	}

	/**
	 * Get front arm hole Y-axis third point on curve 
	 * @return front arm hole Y-axis third point on curve (integer)
	 */
	public int getFrontArmHoleYThree() {
		return frontArmHoleYThree;
	}

	/**
	 * Get front arm hole Y-axis second point on curve 
	 * @return front arm hole Y-axis second point on curve (integer)
	 */
	public int getFrontArmHoleYTwo() {
		return frontArmHoleYTwo;
	}

	/**
	 * Get front arm hole Y-axis first point on curve 
	 * @return front arm hole Y-axis first point on curve (integer)
	 */
	public int getFrontArmHoleYOne() {
		return frontArmHoleYOne;
	}

	/**
	 * Get front arm hole X-axis second point on curve 
	 * @return front arm hole X-axis second point on curve (integer)
	 */
	public int getFrontArmHoleXTwo() {
		return frontArmHoleXTwo;
	}
	
	/**
	 * Get start of back bodice X-axis
	 * @return start of back bodice X-axis (integer)
	 */
	public int getStartBackBodiceX() {
		return startBackBodiceX;
	}

	/**
	 * Get start of back bodice Y-axis
	 * @return start of back bodice Y-axis (integer)
	 */
	public int getStartBackBodiceY() {
		return startBackBodiceY;
	}

	/**
	 * Get front shoulder X-axis
	 * @return front shoulder X-axis (integer)
	 */
	public int getFrontShoulderX() {
		return frontShoulderX;
	}

	/**
	 * Get shoulder measurement
	 * @return shoulder measurement (integer)
	 */
	public int getShoulder() {
		return shoulder;
	}

	/**
	 * Get front shoulder Y-axis
	 * @return front shoulder Y-axis (integer)
	 */
	public int getFrontShoulderY() {
		return frontShoulderY;
	}

	/**
	 * Get back shoulder X-axis
	 * @return back shoulder X-axis (integer)
	 */
	public int getBackShoulderX() {
		return backShoulderX;
	}

	/**
	 * Get back shoulder Y-axis
	 * @return back shoulder Y-axis (integer)
	 */
	public int getBackShoulderY() {
		return backShoulderY;
	}


	/**
	 * Draws bodice based on g 
	 */
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBodice(g);
	}

}





