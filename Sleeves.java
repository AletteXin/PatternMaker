package userinterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public abstract class Sleeves extends JPanel{

	//instances 
	
	//initialise int for sleeveLength 
	private int sleeveLength; 
	
	//initialise int for arm circumference 
	private int armCir; 
	
	//initialise Bodice for userBodice 
	private Bodice userBodice;
	
	//initialise int for startPointX
	private int startPointX = 10;
	
	//initialise int for startPointY
	private int startPointY = 5;
	
	//initialise int for expansion dimensions 
	private int expand = 5;
	
	//constructors 
	
	/**
	 * Set constructor for sleeves 
	 * @param userBodice
	 * @param sleeveLength
	 * @param armCir
	 */
	public Sleeves (Bodice userBodice, int sleeveLength, int armCir) {
		
		//set userBodice 
		this.userBodice = userBodice;
		
		//set sleeve length and apply expansion (for graphical purposes)
		this.sleeveLength = sleeveLength * expand;
		
		//set arm circumference and apply expansion (for graphical purposes)
		this.armCir = armCir * expand;
	}
	
	//methods 
	
	/**
	 * Provides a string on type of sleeve
	 * @return "Standard sleeves"
	 */
	public String getSleeveType() {
		return "Standard sleeves";
	}
	
	/**
	 * Function to draw end of sleeve 
	 * @param sleeves
	 * @param startSleeveX
	 * @param startSleeveY
	 * @param armCir
	 * @param sleeveLength
	 */
	public void drawEndSleeve(GeneralPath sleeves, int startSleeveX, int startSleeveY, int armCir, int sleeveLength) {
		
		//draw second point on end of sleeve
		sleeves.lineTo(startSleeveX + (armCir / 6 * 5), startSleeveY + sleeveLength);
		
		//draw third point on end of sleeve 
		sleeves.lineTo(startSleeveX + (armCir / 6 ), startSleeveY + sleeveLength);
		
		//draw fourth point on end of sleeve 
		sleeves.lineTo(startSleeveX, startSleeveY);
}
	
	/**
	 * Function to draw sleeves 
	 * @param g
	 */
	private void drawSleeve(Graphics g) {

		//initialise a Graphics2D g2d
		Graphics2D g2d = (Graphics2D) g;

		//set paint for g2d
		g2d.setPaint(new Color (150, 150, 150));

		//set rendering hint 
		g2d.setRenderingHint(

				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		//set rendering hint 
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		//set paint colour
		g2d.setPaint(Color.blue);
		
		//set translate 
		g2d.translate(25, 5);

		//initialise a general path for sleeves 
		GeneralPath sleeves = new GeneralPath();
		
		//get armhole depth from userBodice 
		int armHoleDepth = this.userBodice.getArmHoleDepth();
		
		//set start sleeve X 
		int startSleeveX = this.startPointX;
		
		//set start sleeve Y 
		int startSleeveY = this.startPointY + (armHoleDepth / 3 * 2);
		
		//move first point to startSleeveX and startSleeveY
		sleeves.moveTo(startSleeveX, startSleeveY);
		
		//draw first half of curve on sleeve 
		sleeves.curveTo(startSleeveX + (this.armCir / 6), startSleeveY + 5, 
				startSleeveX + (this.armCir / 6 * 2), this.startPointY + 5, 
				startSleeveX + (this.armCir / 6 * 3), this.startPointY);
		
		//draw second half of curve on sleeve 
		sleeves.curveTo(startSleeveX + (this.armCir / 6 * 4), this.startPointY, 
				startSleeveX + (this.armCir / 6 * 5), startSleeveY - 10, 
				startSleeveX + (this.armCir), startSleeveY);
		
		//draw end of sleeve 
		drawEndSleeve(sleeves, startSleeveX, startSleeveY, this.armCir, this.sleeveLength);
				
		//close sleeves path 
		sleeves.closePath();

		//fill sleeves with color 
		g2d.fill(sleeves);
	}

	/**
	 * Function to draw sleeve using paint component 
	 */
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSleeve(g);
	}


}
