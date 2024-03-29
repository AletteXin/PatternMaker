package userinterface;

import java.awt.print.PrinterException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.print.DocPrintJob;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.awt.geom.Dimension;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * This is the "main" class and entry point of the Pattern Maker program.
 * It includes the I/O for the user.<br><br>
 * 
 * How to use: <br><br>
 * 
 * Run this program. The program will prompt you to input your measurements in cm.
 * <br><br>
 * 
 * Sample display: 
 * Please input your measurements in cm in the following order
 *	in a single line, separated with a comma:
 *	1 - hip circumference
 *	2 - waist circumference
 *	3 - nape depth
 *	4 - shoulder width (one side - neck to edge of shoulder)
 *	5 - arm hole depth
 *	6 - nape to waist
 *	7 - neck circumference
 *	8 - sleeve length
 *	9 - arm circumference
 * <br><br>
 * Note: Sleeve lengths are determined here, as input 8.  
 * 
 * For your ease of trying the program out, you can use these predetermined measurements:
 * 132, 107, 10, 15, 26, 54, 40, 20, 50
 *  <br><br>
 * 
 * The program will then prompt you to choose the type of clothing pattern you 
 * want as an output - both for the bodice and sleeve type. Once chosen, you will 
 * see two new windows pop up with your picture. The program will then prompt if you
 * would like to get another drawing. This time, if yes, a new window will pop up 
 * (however unlike the first time, it will not pop up in front of eclipse, but at the tab
 * that you got your first drawing, so be sure to check that!). 
 *  <br><br>
 * 
 * Once you are satisfied with the drawings received, you can exit the program. 
 * 
 * 
 * -------------------------------------------------------------------<br><br>
 * 
 * For a deeper understanding of the implementation of this Pattern Maker program,
 * Check the documentation of the following classes under 'See Also':<br><br>
 * 
 * 
 * The 'UserInput' class can be described primarily as the 'Controller'
 *   as it is responsible for controlling the input and output of 
 *   for the user such as user measurements inputs, type of bodice inputs, 
 *   type of sleeve inputs, and if user wants an additional drawing. 
 *   It also performs data validation of user measurement inputs.<br><br>
 *   
 * The 'Bodice' class can be described primarily as the 'Draw' as it is
 * 	 responsible for taking in user measurement inputs and drawing 
 * 	 the Bodice pattern using lineTo and curveTo. The two different Bodice 
 * 	 subclasses, CNeckBodice and VNeckBodice, refer to different neck lines.<br><br> 
 *   
 * The 'Sleeves' class can be considered primarily as another 'Draw', as it is
 * 	 responsible for taking in user measurement inputs and drawing 
 * 	 the Sleeve pattern using lineTo and curveTo. The two different Sleeves
 *   subclasses, StraightSleeve and TaperedSleeve, refer to different sleeve types.<br><br>
 * 
 * The 'InterfaceUI' class can be considered primarily the 'Display', as it is
 * 	 responsible for displaying the completed Bodice and Sleeves. <br><br>
 * 
 * @author Alette Ng Xin Ling 
 *
 */




public class UserInput {	

	/**
	 * Function to get input on type of bodice from user 
	 * @param scanner
	 * @return typeOfBodice in the form of an integer 
	 */
	public int getUserTypeOfBodice(Scanner scanner) {

		//initialise typeOfBodice as 0 
		int typeOfBodice = 0; 

		//while while loop is not broken 
		while(true) {	

			//Request input from user of type of bodice to draw 
			System.out.println("Which pattern do you want to draw? (input number)");
			System.out.println("1 - V-neck shirt, 2 - C-neck shirt");


			//if user inputs an integer 
			if (scanner.hasNextInt()) {

				try {
					//store user's input integer into typeOfBodice 
					typeOfBodice = scanner.nextInt(); 

					//if typeOfBodice is 1 or 2
					if ((typeOfBodice == 1) || (typeOfBodice == 2)) {
						//break 
						break;
						//otherwise
					} else {
						//Remind user to choose 1 or 2 only 
						System.out.println("Please choose 1 or 2");
						continue;
					}
				}

				//if user inputs a non-integer 
				catch (NumberFormatException e) {
					//Remind user to choose 1 or 2 only 
					System.out.println("Please choose 1 or 2");
					//clear scanner 
					scanner.next();
					continue;
				}
			} 

			//if user inputs a non-integer
			else {
				//Remind user to choose 1 or 2 only 
				System.out.println("Please choose 1 or 2");
				//clear scanner 
				scanner.next();
				continue;
			}
		}

		return typeOfBodice;
	}


	/**
	 * Function to get input on type of sleeve 
	 * @param scanner
	 * @return typeOfSleeve in the form of an integer 
	 */
	public int getUserTypeOfSleeve(Scanner scanner) {

		//initialise typeOfBodice as 0 
		int typeOfSleeve = 0; 

		//while loop is not broken 
		while(true) {	

			//Request input from user of type of sleeve to draw 
			System.out.println("What type of sleeve do you want to draw? (input number)");
			System.out.println("1 - Straight Sleeve, 2 - Tapered Sleeve");

			//if user inputs an integer 
			if (scanner.hasNextInt()) {

				try {
					//store user's input integer into typeOfSleeve
					typeOfSleeve = scanner.nextInt(); 
					//if typeOfSleeve is 1 or 2
					if ((typeOfSleeve == 1) || (typeOfSleeve == 2)) {
						break;
					} 

					//otherwise
					else {
						//Remind user to choose 1 or 2 only 
						System.out.println("Please choose 1 or 2");
						continue;
					}
				}

				//if user inputs a non-integer 
				catch (NumberFormatException e) {
					//Remind user to choose 1 or 2 only 
					System.out.println("Please choose 1 or 2");
					//clear scanner input 
					scanner.next();
					continue;
				}
			} 

			//if user inputs a non-integer 
			else {
				//Remind user to choose 1 or 2 only 
				System.out.println("Please choose 1 or 2");
				//clear scanner input 
				scanner.next();
				continue;
			}
		}
		return typeOfSleeve;
	}


	/**
	 * Get user measurements input from user
	 * @param scanner
	 * @return an array of integers with user measurements input 
	 */	
	public int[] getUserMeasurements(Scanner scanner) {

		//initialise an integer for hip
		int hip;

		//initialise an integer for waist 
		int waist; 

		//initialise an integer for nape depth 
		int napeDepth; 

		//initialise an integer for shoulder 
		int shoulder;

		//initialise an integer for arm hole depth 
		int armHoleDepth;

		//initialise an integer for nape to waist 
		int napeToWaist;

		//initialise an integer for neck circumference 
		int neckCir;

		//initialise an integer for sleeve length 
		int sleeveLength;

		//initialise an integer for arm circumference 
		int armCir;

		//Print statement to request user measurements from user 
		System.out.println("Please input your measurements in cm in the following order");
		System.out.println("in a single line, separated with a comma:");
		System.out.println("1 - hip circumference");
		System.out.println("2 - waist circumference");
		System.out.println("3 - nape depth");
		System.out.println("4 - shoulder width (one side - neck to edge of shoulder)");
		System.out.println("5 - arm hole depth");
		System.out.println("6 - nape to waist");
		System.out.println("7 - neck circumference");	
		System.out.println("8 - sleeve length");	
		System.out.println("9 - arm circumference");	
		System.out.println("Example: 132, 107, 10, 15, 26, 54, 40, 20, 50");


		//while loop is not broken 
		while(true) {	

			//Once user has inputed 
			if (scanner.hasNextLine()) {
				try {
					//split input by ','
					String input[] = scanner.nextLine().strip().split(",");
					//if length of array does not have exactly 9 items 
					if (input.length != 9) {
						//Prompt user to input 9 valid inputs 
						System.out.println("Please enter 9 valid inputs in a single line, separated with a comma.");	
						System.out.println("Example: 132, 107, 10, 15, 26, 54, 40, 20, 50");
						continue;

						//otherwise if array has exactly 9 items 
					} else {
						//set hip
						hip = Integer.parseInt(input[0].strip());
						//set waist 
						waist = Integer.parseInt(input[1].strip());
						//set nape depth 
						napeDepth = Integer.parseInt(input[2].strip());
						//set shoulder 
						shoulder = Integer.parseInt(input[3].strip());
						//set arm hole depth 
						armHoleDepth = Integer.parseInt(input[4].strip());
						//set nape to waist 
						napeToWaist = Integer.parseInt(input[5].strip());
						//set neck circumference 
						neckCir = Integer.parseInt(input[6].strip());					
						//set sleeve length 
						sleeveLength = Integer.parseInt(input[7].strip());		
						//set arm circumference 
						armCir = Integer.parseInt(input[8].strip());

					}

				}

				//if user inputs fields other than integers 
				catch (NumberFormatException e) {
					// print prompt for user to input valid inputs 
					System.out.println("Please enter valid input in a single line, separated with a comma.");	
					System.out.println("Example: 132, 107, 10, 15, 26, 54, 40, 20, 50");
					continue;
				} 

				//return array of integers with user input measurements 
				return new int[] {hip, waist, napeDepth, shoulder, armHoleDepth, 
						napeToWaist, neckCir, sleeveLength, armCir};

			}
		}
	}

	/**
	 * Function to check if user is done with the service 
	 * @param scanner
	 * @return True if user does not want additional drawings; False if user wants more drawings 
	 */
	public boolean checkIfUserIsDone(Scanner scanner)
	{ 
		// message prompt if user would like another drawing 
		System.out.println("Would you like to get a drawing? (y/n)");


		//while loop is not broken 
		while (true) {

			try
			{
				//get next user input and store in input as a String 
				String input = scanner.nextLine();

				//if first alphabet of string after stripping blanks is y or Y 
				if (input.strip().charAt(0) == 'y' || input.strip().charAt(0) == 'Y')
				{
					//return false 
					return false;

					//if first alphabet of string after stripping blanks is n or N 
				} else if (input.strip().charAt(0) == 'n' || input.strip().charAt(0) == 'N') {

					//return true 
					return true;
				}

				//else if none of the above 
				else {
					//prompt user to enter a valid input 
					System.out.println("Please enter yes or no");
					continue;
				}

			}  

			catch(Exception e)
			{}  

		}

	}

	/**
	 * Function for data validation of hip, waist and shoulder measurements 
	 * @param hipWaistShoulder
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkHipWaistShoulderInput (int hipWaistShoulder) {

		//if hipWaistShoulder input is less than or equal to zero
		if (hipWaistShoulder <= 0) {
			//return error message
			return "Please input a figure that is more than zero for hip and/or shoulder and/or waist measurements";

		} 
		//if hipWaistShoulder is more than 300cm (based on world's largest waist of c.300cm)
		else if (hipWaistShoulder >= 300) {
			return "Please input a figure that is less than 300cm for hip and/or shoulder and/or waist measurements";
		}
		else {
			//else return "OK"
			return "OK";
		}
	}

	/**
	 * Function for data validation of neck depth and nape to waist measurements 
	 * @param neck depth, nape to waist 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkNeckDepthAndNapeToWaist (int napeDepth, int napeToWaist) {

		//if neck depth or nape to waist measurements are less than or equal to zero 
		if (napeDepth  <= 0 || napeToWaist <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for nape depth and/or nape to waist measurement";
			//if neck depth is more than or equal to nape to waist measurement 
		} 

		//if nape depth is more than 200cm or napeToWaist is more than 272cm
		//(based on the tallest man on earth of 272cm)
		else if (napeDepth >= 200 || napeToWaist >= 272) {
			return "Please input nape depth that is less than 200cm and/or nape to waist measurement that is less than 272cm";	
		} 

		else if (napeDepth >= napeToWaist) {
			//return error message 
			return "Please input a nape depth that is shorter than the Nape to Waist measurement";

		} 

		//else, if no errors, return "OK"
		else {
			return "OK";
		}
	}

	/**
	 * Function for data validation of arm hole depth measurements 
	 * @param arm hole depth, nape to waist 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkArmHoleDepth (int armHoleDepth, int napeToWaist) {

		//if arm hole depth is less than or equal to zero
		if (armHoleDepth <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for arm hole depth";
		} 

		//if arm hole depth is more than 100cm (based on about 1/3 of the tallest man on earth of 272cm)
		else if (armHoleDepth >= 100) {
			//return error message 
			return "Please input an arm hole depth measurement that is less 100cm";
		}

		//if arm hole depth is more than or equal to nape to waist 
		else if (armHoleDepth >= napeToWaist) {
			//return error message 
			return "Please input an arm hole depth measurement that is less than nape to waist measurement";

		}
		//else, if no errors, return "OK"
		else {
			return "OK";
		}

	}

	/**
	 * Function for data validation of neck circumference measurements 
	 * @param neck circumference, shoulder 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkNeckCir (int neckCir) {

		//if neck circumference is less than or equal to zero 
		if (neckCir <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for neck circumference measurement";
		} 
		//if neck circumference is more than 52cm (based on world's longest neck circumference of 40cm)
		else if (neckCir >= 52){
			return "Please input a figure that is less than 52cm for neck circumference measurement";
		}
		//if no errors, return "OK"
		else {
			return "OK";
		}
	}

	/**
	 * Function for data validation of sleeve length measurements 
	 * @param sleeve length 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkSleeveLength (int sleeveLength) {

		//if sleeveLength is less than or equal to zero
		if (sleeveLength <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for sleeve length measurement";
		} 
		//if arm hole depth is more than 190cm (based on about 2/3 of the tallest man on earth of 272cm)
		else if (sleeveLength >= 190) {
			return "Please input a sleeveLength figure that is less than 190cm";
		}
		//else if no errors 
		else {
			//return "OK"
			return "OK";
		}

	}

	/**
	 * Function for data validation of arm circumference measurements  
	 * @param arm circumference, arm hole depth 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	public String checkArmCir (int armCir, int armHoleDepth) {

		//if arm circumference is less than or equal to zero
		if (armCir <= 0) {
			//return error message
			return "Please input a figure that is more than zero for arm circumference measurement";
			//else if arm circumference measurement is more than two times of arm hole depth 
		} else if (armCir > (armHoleDepth * 2)) {
			//return error message
			return "Please input a arm circumference measurement that is less than twice arm hole depth measurement";
		}
		//else return "OK"
		else {
			return "OK";
		}

	}

	/**
	 * Function to check/data validation of user input measurements 
	 * @param hip
	 * @param waist
	 * @param neckDepth
	 * @param shoulder
	 * @param armHoleDepth
	 * @param napeToWaist
	 * @param neckCir
	 * @param sleeveLength
	 * @param armCir
	 * @return True if no errors, False if there are errors 
	 */
	public boolean checkInputMeasurements(int hip, int waist, int neckDepth, 
			int shoulder, int armHoleDepth, int napeToWaist, int neckCir, int sleeveLength, int armCir) {


		//initialise an array list to store errors 
		ArrayList <String> errorList = new ArrayList <String>();

		//perform data validation on hip measurement
		String hipCheck = checkHipWaistShoulderInput(hip);

		//perform data validation on waist measurement
		String waistCheck = checkHipWaistShoulderInput(waist);

		//perform data validation on shoulder measurement
		String shoulderCheck = checkHipWaistShoulderInput(shoulder);

		//perform data validation on neck depth and nape to waist measurement
		String neckDepthAndNapeToWaistCheck = checkNeckDepthAndNapeToWaist(neckDepth, napeToWaist);

		//perform data validation on arm hole depth measurement
		String armHoleDepthCheck = checkArmHoleDepth (armHoleDepth, napeToWaist);

		//perform data validation on neck circumference measurement
		String neckCirCheck = checkNeckCir (neckCir);

		//perform data validation on sleeve length measurement
		String sleeveLengthCheck = checkSleeveLength(sleeveLength);

		//perform data validation on arm circumference measurement
		String armCirCheck = checkArmCir(armCir, armHoleDepth);

		//assign errors from hipCheck to errorList 
		if (!hipCheck.equals("OK")) {
			errorList.add(hipCheck);
		}

		//assign errors from waistCheck to errorList 
		if (!waistCheck.equals("OK")) {
			errorList.add(waistCheck);
		}

		//assign errors from shoulderCheck to errorList  
		if (!shoulderCheck.equals("OK")) {
			errorList.add(shoulderCheck);
		}

		//assign errors from neckDepthAndNapeToWaistCheck to errorList 
		if (!neckDepthAndNapeToWaistCheck.equals("OK")) {
			errorList.add(neckDepthAndNapeToWaistCheck);
		}

		//assign errors from armHoleDepthCheck to errorList 
		if (!armHoleDepthCheck.equals("OK")) {
			errorList.add(armHoleDepthCheck);
		}

		//assign errors from neckCirCheck to errorList 
		if (!neckCirCheck.equals("OK")) {
			errorList.add(neckCirCheck);
		}

		//assign errors from sleeveLengthCheck to errorList 
		if (!sleeveLengthCheck.equals("OK")) {
			errorList.add(sleeveLengthCheck);
		}

		//assign errors from armCirCheck to errorList 
		if (!armCirCheck.equals("OK")) {
			errorList.add(armCirCheck);
		}

		//if errorList has no items
		if (errorList.size() == 0) {
			//return true 
			return true;

			//if errorList has items
		} else {

			//print out each item in the errorList 
			for (int i = 0; i < errorList.size(); i++) {
				System.out.println(errorList.get(i));
			}
			//return false 
			return false;
		}
	}

	/**
	 * Main function for the program 
	 * @param args
	 * @throws PrinterException 
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws PrinterException, FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub

		UserInput ut = new UserInput();

		//initialise a scanner to receive user inputs 
		Scanner scan = new Scanner(System.in);

		//initialise a inputMeasurementsValid boolean as false 
		boolean inputMeasurementsValid = false;

		//initialise integer for hip
		int hip = 0; 

		//initialise integer for waist
		int waist = 0; 

		//initialise integer for neck depth
		int neckDepth = 0; 

		//initialise integer for shoulder
		int shoulder = 0;

		//initialise integer for arm hole depth
		int armHoleDepth = 0; 

		//initialise integer for nape to waist 
		int napeToWaist = 0;

		//initialise integer for neck circumference 
		int neckCir = 0; 

		//initialise integer for sleeve length
		int sleeveLength = 0;

		//initialise integer for arm circumference 
		int armCir = 0;

		//while input measurements are not valid 
		while (!inputMeasurementsValid) {

			//prompt user to input measurements 
			int bodiceMeasurements[] = ut.getUserMeasurements(scan);

			//set hip 
			hip = bodiceMeasurements[0]; 
			//set waist 
			waist = bodiceMeasurements[1]; 
			//set neck depth 
			neckDepth = bodiceMeasurements[2]; 
			//set shoulder 
			shoulder = bodiceMeasurements[3];
			//set arm hole depth 
			armHoleDepth = bodiceMeasurements[4]; 
			//set nape to waist 
			napeToWaist = bodiceMeasurements[5];
			//set neck circumference 
			neckCir = bodiceMeasurements[6]; 
			//set sleeve length 
			sleeveLength =  bodiceMeasurements[7]; 
			//set arm circumference 
			armCir = bodiceMeasurements[8];

			//check input measurements if valid 
			inputMeasurementsValid = ut.checkInputMeasurements(hip, waist, neckDepth, 
					shoulder, armHoleDepth, napeToWaist, neckCir, sleeveLength, armCir);

		}


		//while user is not done with the service 
		while (!ut.checkIfUserIsDone(scan)) {

			//prompt user for type of bodice 
			int typeOfBodice = ut.getUserTypeOfBodice(scan);

			//prompt user for type of sleeve
			int typeOfSleeve = ut.getUserTypeOfSleeve(scan);

			//initialise a Bodice object 
			Bodice bodiceToShow; 

			//initialise a Sleeves object 
			Sleeves sleeveToShow;

			//if typeOfBodice chosen is 1 
			if (typeOfBodice == 1) {
				//message to user 
				System.out.println("The pattern for your V-neck shirt will pop-up in a separate window.");
				//set Bodice to Show as VNeckBodice 
				bodiceToShow = new VNeckBodice(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
				//else if typeOfBodice is 2
			} else {
				//message to user 
				System.out.println("The pattern for your C-neck shirt will pop-up in a separate window.");
				//set Bodice to Show as CNeckBodice
				bodiceToShow = new CNeckBodice(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
			}

			//if typeOfSleeve chosen is 1
			if (typeOfSleeve == 1) {
				//message to user 
				System.out.println("The pattern for your straight sleeve will pop-up in a separate window.");
				//set Sleeve to Show as StraightSleeve 
				sleeveToShow = new StraightSleeve(bodiceToShow, sleeveLength, armCir);
				//else if typeOfSleeve is 2 
			} else {
				//message to user 
				System.out.println("The pattern for your straight sleeve will pop-up in a separate window.");
				//set Sleeve to Show as TaperedSleeve
				sleeveToShow = new TaperedSleeve(bodiceToShow, sleeveLength, armCir);		    	
			}

			//initialise an InterfaceUI for bodice 
			InterfaceUI uiBodice = new InterfaceUI(bodiceToShow);

			//set UI as visible 
			uiBodice.setVisible(true);
			
//			JPanel P = new JPanel();
//			P.setLayout(new BorderLayout());
//			JScrollPane scrollPane = new JScrollPane(P);
////			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
////	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
////
////			
//			uiBodice.add(scrollPane);
//			uiBodice.pack();
			

			
			//initialise an InterfaceUI for sleeves
			InterfaceUI uiSleeves = new InterfaceUI(sleeveToShow);
			//set UI as visible 
			uiSleeves.setVisible(true);	

			int widthSleeves = uiSleeves.getWidth();
			int heightSleeves = uiSleeves.getHeight();

			int widthBodice = uiBodice.getWidth();
			int heightBodice = uiBodice.getHeight();
			
			int templateWidth = 200;
			int templateHeight = 200;
			
			int widthTranslate = -550;
			int heightTranslate = -550;
			
			System.out.println(widthBodice);
			System.out.println(heightBodice);
			System.out.println(templateWidth);
			System.out.println(templateHeight);			
			
			Document document = new Document();
			PdfWriter writer;
			try {
				writer = PdfWriter.getInstance(document, new FileOutputStream("new_pattern_2.pdf"));
				document.open();
				PdfContentByte contentByte = writer.getDirectContent();
				
				PdfTemplate template = contentByte.createTemplate(templateWidth, templateHeight);
//
//				int pagesRequired = width/templateWidth;
				
//				Graphics2D g2Sleeves = new PdfGraphics2D(contentByte, widthSleeves, heightSleeves, new DefaultFontMapper());
//				
//				uiSleeves.print(g2Sleeves);
//				g2Sleeves.dispose();
//				
				int newWidthSleeves = widthSleeves;
				int newHeightSleeves = heightSleeves;
				int widthCount = 0;
				int heightCount = 0;
				
				while (newHeightSleeves > 0) {
					while (newWidthSleeves > 0) {
						document.newPage();
						Graphics2D g2Sleeves2 = new PdfGraphics2D(contentByte, widthSleeves, heightSleeves, new DefaultFontMapper());
						((Graphics2D)g2Sleeves2).translate(widthTranslate * widthCount, heightCount * heightTranslate);
						uiSleeves.print(g2Sleeves2);
						g2Sleeves2.dispose();
						newWidthSleeves += widthTranslate;
						widthCount++;
					}
					
					newHeightSleeves += heightTranslate;
					heightCount ++;
					newWidthSleeves = widthSleeves;
					widthCount = 0;
				
				}
					
//				count = 0;
//				
//				while (newHeightSleeves > 0) {
//					document.newPage();
//					Graphics2D g2Sleeves2 = new PdfGraphics2D(contentByte, widthSleeves, heightSleeves, new DefaultFontMapper());
//					((Graphics2D)g2Sleeves2).translate(0, count * heightTranslate);
//					uiSleeves.print(g2Sleeves2);
//					g2Sleeves2.dispose();
//					newWidthSleeves += widthTranslate;
//					count++;
//				}

				
				int newWidthBodice = widthBodice;
				int newHeightBodice = heightBodice;
				widthCount = 0;
				heightCount = 0;
				
				while (newHeightBodice > 0) {
					while (newWidthBodice > 0) {
						document.newPage();
						Graphics2D g2Bodice = new PdfGraphics2D(contentByte, widthBodice, heightBodice, new DefaultFontMapper());
						((Graphics2D)g2Bodice).translate(widthTranslate * widthCount, heightCount * heightTranslate);
						uiBodice.print(g2Bodice);
						g2Bodice.dispose();
						newWidthBodice += widthTranslate;
						widthCount++;
					}
					
					newHeightBodice += heightTranslate;
					heightCount ++;
					newWidthBodice = widthBodice;
					widthCount = 0;
				
				}
				
//				document.newPage();
//				Graphics2D g2Bodice = new PdfGraphics2D(contentByte, widthBodice, heightBodice, new DefaultFontMapper());
//				uiBodice.print(g2Bodice);
//				g2Bodice.dispose();
				
//				document.newPage();
//				Graphics2D g2Bodice = new PdfGraphics2D(contentByte, width, height, new DefaultFontMapper());
//				uiBodice.print(g2Bodice);
//				g2Bodice.dispose();

				contentByte.addTemplate(template, 0, 0);
				document.close();
				System.out.println("PDF created");

			} finally {
				if (document.isOpen()) {
					document.close();
				}
			}

						  
//			PrinterJob pjob = PrinterJob.getPrinterJob();
//
//			pjob.setPrintable(new PatternMakerPrinter(uiBodice));
//			
//						
//			if (pjob.printDialog()) {
//				pjob.print();
//			}
			
//			
//			int sleevesWidth = uiSleeves.getWidth();
//			int sleevesHeight = uiSleeves.getHeight();
//
//			int bodiceWidth = uiBodice.getWidth();
//			int bodiceHeight = uiBodice.getHeight();
//
//			
//			JFrame jFrameToPrint = uiBodice;
//			PrinterJob printJob = PrinterJob.getPrinterJob();
//
//			Book pBook = new Book();
//			
//			int moveToTheRight = 0;
//			int moveToTheBottom = 0;
//			
//			
//
//			while (bodiceWidth > 0) {
//				PageFormat pageFormat = new PageFormat();				 
//				pBook.append(new ComponentPrinter(jFrameToPrint, moveToTheRight, moveToTheBottom), pageFormat);
////				
////				printJob.setPrintable(new ComponentPrinter(jFrameToPrint, moveToTheRight, moveToTheBottom));
//				moveToTheRight = moveToTheRight - 500;		
//				bodiceWidth = bodiceWidth - 500;
//
//			}
//			
//			printJob.setPageable(pBook);
//			
//			 if (printJob.printDialog()) {
//				   try { 
//					 System.out.println(pBook.getNumberOfPages());
//					 
//				     printJob.print();
//				   } catch(PrinterException pe) {
//				     System.out.println("Error printing: " + pe);
//				   }
//				 }

//			
//
//			PrintMultiPageUtil printJob = new PrintMultiPageUtil(uiBodice);
//			PageFormat pageFormat = new PageFormat();
//			
//			printJob.print(g2Bodice, pageFormat, 1);
			

			//show thank you message to user 
			System.out.println("Thank you for using our service today!");

			//close scanner 
			scan.close();

		}
	}

}
