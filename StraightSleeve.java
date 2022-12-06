package userinterface;

import java.awt.geom.GeneralPath;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class StraightSleeve extends Sleeves {

	
	/**
	 * Set constructor for StraightSleeve 
	 */
	public StraightSleeve(Bodice userBodice, int sleeveLength, int armCir) {
		//use constructor in Sleeves class to construct StraightSleeve 
		super(userBodice, sleeveLength, armCir);
	}
	
	/**
	 * Draw end of sleeves 
	 * @param GeneralPath sleeves
	 * @param int startSleeveX 
	 * @param int startSleeveY 
	 * @param int armCir
	 * @param int sleeveLength
	 */
	@Override 
	public void drawEndSleeve(GeneralPath sleeves, int startSleeveX, int startSleeveY, 
			int armCir, int sleeveLength) {
		
		//draw second point on end of sleeve 
		sleeves.lineTo(startSleeveX + armCir, startSleeveY + sleeveLength);
		
		//draw third point on end of sleeve
		sleeves.lineTo(startSleeveX, startSleeveY + sleeveLength);
		
		//draw fourth point on end of sleeve 
		sleeves.lineTo(startSleeveX, startSleeveY);
}
	
	/**
	 * Function to return the type of sleeve 
	 * @return "Straight Sleeve"
	 */
	@Override
	public String getSleeveType() {
		return "Straight Sleeve";
	}

}
