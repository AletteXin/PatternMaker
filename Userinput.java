package userinterface;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {	

	/**
	 * Function to get input on type of bodice from user 
	 * @param scanner
	 * @return typeOfBodice in the form of an integer 
	 */
	private static int getUserTypeOfBodice(Scanner scanner) {

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
						//clear scanner 
						scanner.next();
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
	private static int getUserTypeOfSleeve(Scanner scanner) {

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
						scanner.next();
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
	private static int[] getUserMeasurements(Scanner scanner) {

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

		//while loop is not broken 
		while(true) {	

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
	private static boolean checkIfUserIsDone(Scanner scanner)
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
	private static String checkHipWaistShoulderInput (int hipWaistShoulder) {

		//if hipWaistShoulder input is less than or equal to zero
		if (hipWaistShoulder <= 0) {
			//return error message
			return "Please input a figure that is more than zero for hip and/or shoulder and/or waist measurements";
		} else {
			//else return "OK"
			return "OK";
		}
	}

	/**
	 * Function for data validation of neck depth and nape to waist measurements 
	 * @param neck depth, nape to waist 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	private static String checkNeckDepthAndNapeToWaist (int napeDepth, int napeToWaist) {

		//if neck depth or nape to waist measurements are less than or equal to zero 
		if (napeDepth  <= 0 || napeToWaist <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for neck depth and/or nape to waist measurement";

			//if neck depth is more than or equal to nape to waist measurement 
		} else if (napeDepth >= napeToWaist) {
			//return error message 
			return "Please input a neck depth that is shorter than the Nape to waist measurement";
			//if no errors return "OK"
		} else {
			return "OK";
		}
	}

	/**
	 * Function for data validation of arm hole depth measurements 
	 * @param arm hole depth, nape to waist 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	private static String checkArmHoleDepth (int armHoleDepth, int napeToWaist) {

		//if arm hole depth is less than or equal to zero
		if (armHoleDepth <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for arm hole depth";
			//if arm hole depth is more than or equal to nape to waist 
		} else if (armHoleDepth >= napeToWaist) {
			//return error message 
			return "Please input an arm hole depth measurement that is less than nape to waist measurement";
			//else, if no errors, return "OK"
		} else {
			return "OK";
		}

	}

	/**
	 * Function for data validation of neck circumference measurements 
	 * @param neck circumference, shoulder 
	 * @return String "OK" if no errors, or others describing errors 
	 */
	private static String checkNeckCir (int neckCir, int shoulder) {

		//if neck circumference is less than or equal to zero 
		if (neckCir <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for neck circumference measurement";
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
	private static String checkSleeveLength (int sleeveLength) {

		//if sleeveLength is less than or equal to zero
		if (sleeveLength <= 0) {
			//return error message 
			return "Please input a figure that is more than zero for sleeve length measurement";
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
	private static String checkArmCir (int armCir, int armHoleDepth) {

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
	private static boolean checkInputMeasurements(int hip, int waist, int neckDepth, 
			int shoulder, int armHoleDepth, int napeToWaist, int neckCir, int sleeveLength, int armCir) {
		
//		//initialise an array list to store OK measurements 
//		ArrayList <String> okList = new ArrayList <String> ();
//		
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
		String neckCirCheck = checkNeckCir (neckCir, shoulder);
		
		//perform data validation on sleeve length measurement
		String sleeveLengthCheck = checkSleeveLength(sleeveLength);
		
		//perform data validation on arm circumference measurement
		String armCirCheck = checkArmCir(armCir, armHoleDepth);

		//assign errors from hipCheck to errorList 
		if (!hipCheck.equals("OK")) {
			errorList.add("Please input a figure that is more than zero for hip measurement");
		}

		//assign errors from waistCheck to errorList 
		if (!waistCheck.equals("OK")) {
			errorList.add("Please input a figure that is more than zero for waist measurement");
		}

		//assign errors from shoulderCheck to errorList  
		if (!shoulderCheck.equals("OK")) {
			errorList.add("Please input a figure that is more than zero for shoulder measurement");
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
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialise a scanner to receive user inputs 
		Scanner scan = new Scanner(System.in);

		//initialise a inputMeasurementsValid boolean as false 
		boolean inputMeasurementsValid = false;

		//initialise int for hip
		int hip = 0; 
		
		//initialise int for waist
		int waist = 0; 
		
		//initialise int for neck depth
		int neckDepth = 0; 
		
		//initialise int for shoulder
		int shoulder = 0;
		
		//initialise int for arm hole depth
		int armHoleDepth = 0; 
		
		//initialise int for nape to waist 
		int napeToWaist = 0;
		
		//initialise int for neck circumference 
		int neckCir = 0; 
		
		//initialise int for sleeve length
		int sleeveLength = 0;
		
		//initialise int for arm circumference 
		int armCir = 0;

		//while input measuremetns are not valid 
		while (!inputMeasurementsValid) {

			//prompt user to input measurements 
			int bodiceMeasurements[] = getUserMeasurements(scan);

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
			inputMeasurementsValid = checkInputMeasurements(hip, waist, neckDepth, 
					shoulder, armHoleDepth, napeToWaist, neckCir, sleeveLength, armCir);

		}


		//while user is not done with the service 
		while (!checkIfUserIsDone(scan)) {
			
			//prompt user for type of bodice 
			int typeOfBodice = getUserTypeOfBodice(scan);
			
			//prompt user for type of sleeve
			int typeOfSleeve = getUserTypeOfSleeve(scan);
			
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
			//initialise an InterfaceUI for sleeves
			InterfaceUI uiSleeves = new InterfaceUI(sleeveToShow);
			//set UI as visible 
			uiSleeves.setVisible(true);	
			continue;

		}
		
		//show thank you message to user 
		System.out.println("Thank you for using our service today!");
		
		//close scanner 
		scan.close();

	}

}
