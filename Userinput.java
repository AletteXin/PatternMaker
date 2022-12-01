package userinterface;

import java.util.Scanner;

public class UserInput {	
	
	private static int getUserTypeOfBodice(Scanner scanner) {
		
		int typeOfBodice; 
		boolean userDoneWithDrawings = false;
		
		while(true) {	
			
			System.out.println("Which pattern do you want to draw? (input number)");
	        System.out.println("1 - V-neck shirt, 2 - C-neck shirt");
	        
			
			if (scanner.hasNextInt()) {
				try {

					typeOfBodice = scanner.nextInt(); 	
				}
				
				catch (NumberFormatException e) {
					// if user doesn't write input in correct format
					System.out.println("Please choose 1 or 2");
					continue;
				} 
				
				return typeOfBodice;
				
			}
		}
		
	}
	
	
	/**
	 * Get input from user.
	 * @param scanner
	 * @param pause message
	 */	
	
	private static int[] getUserMeasurements(Scanner scanner) {
		
		int hip;
		int waist; 
		int napeDepth; 
		int shoulder;
		int armHoleDepth;
		int napeToWaist;
		int neckCir;
		
		while(true) {	
			
			System.out.println("Please input your measurements in cm in the following order");
			System.out.println("in a single line, separated with a comma:");
			System.out.println("1 - hip circumference");
			System.out.println("2 - waist circumference");
			System.out.println("3 - nape depth");
			System.out.println("4 - shoulder width");
			System.out.println("5 - arm hole depth");
			System.out.println("6 - nape to waist");
			System.out.println("7 - neck circumference");	
			System.out.println("Example: 132, 107, 10, 15, 26, 54, 40");
			
			if (scanner.hasNextLine()) {
				try {
					String input[] = scanner.nextLine().strip().split(",", 7);
					hip = Integer.parseInt(input[0].strip());
					waist = Integer.parseInt(input[1].strip());
					napeDepth = Integer.parseInt(input[2].strip());
					shoulder = Integer.parseInt(input[3].strip());
					armHoleDepth = Integer.parseInt(input[4].strip());
					napeToWaist = Integer.parseInt(input[5].strip());
					neckCir = Integer.parseInt(input[6].strip());					
					
				}
				
				catch (NumberFormatException e) {
					// if user doesn't write input in correct format
					System.out.println("Please enter valid input in a single line, separated with a comma.");	
					System.out.println("Example: 132, 107, 10, 15, 26, 54, 40");
					continue;
				} 
				
				return new int[] {hip, waist, napeDepth, shoulder, armHoleDepth, napeToWaist, neckCir};
				
			}
		}
	}
	
	private static boolean checkIfUserIsDone(Scanner scanner)
	 { 
	        
		System.out.println("Would you like to get a drawing? (y/n)");
		
		while (true) {
		
			
	        try
	        {
	            String input = scanner.nextLine();
	            if (input.strip().charAt(0) == 'y' || input.strip().charAt(0) == 'Y')
	            {
	            	return false;
	            } else if (input.strip().charAt(0) == 'n' || input.strip().charAt(0) == 'N') {
	            	return true;
	            }
	            
	            else {
	            	System.out.println("Please enter yes or no");
	            	continue;
	            }
	            
	        }  
	        catch(Exception e)
	        {}  
			
		}
		
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
	
	    int bodiceMeasurements[] = getUserMeasurements(scan);
		
		int hip = bodiceMeasurements[0]; 
		int waist = bodiceMeasurements[1]; 
		int neckDepth = bodiceMeasurements[2]; 
		int shoulder = bodiceMeasurements[3];
		int armHoleDepth = bodiceMeasurements[4]; 
		int napeToWaist = bodiceMeasurements[5];
		int neckCir = bodiceMeasurements[6]; 
	    
		
		while (!checkIfUserIsDone(scan)) {
			
			int typeOfBodice = getUserTypeOfBodice(scan);
		    
		    if (typeOfBodice == 1) {
			    System.out.println("The pattern for your V-neck shirt will pop-up in a separate window.");
				VNeckBodice vNeckToShow = new VNeckBodice(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
				InterfaceUI ui1 = new InterfaceUI(vNeckToShow);
				ui1.setVisible(true);
				continue;

		    	
		    } else {
			    System.out.println("The pattern for your C-neck shirt will pop-up in a separate window.");
				CNeckBodice cNeckToShow = new CNeckBodice(hip, waist, neckDepth, shoulder, armHoleDepth, napeToWaist, neckCir);
				InterfaceUI ui2 = new InterfaceUI(cNeckToShow);
				ui2.setVisible(true);		
				continue;
				
		    }
			
		}
	    
	    System.out.println("Thank you for using our service today!");
	    
	    scan.close();
		
	}

}
