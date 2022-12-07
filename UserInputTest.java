package userinterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputTest {
	
	
	UserInput ut;

	@BeforeEach
	void setUp() throws Exception {
		
		ut = new UserInput();
		
	}

	@Test
	void testCheckHipWaistShoulderInput() {
		
		int shoulder = 17;
		int hipError = -10;
		int waistError = 0;
		int shoulderError = 301;
		
		//test case 1: OK 
		assertEquals("OK", ut.checkHipWaistShoulderInput(shoulder));
		
		//test case 2: when hip measurement is less than 0
		assertEquals("Please input a figure that is more than zero for hip and/or "
				+ "shoulder and/or waist measurements", ut.checkHipWaistShoulderInput(hipError));	
		
		//test case 3: when waist measurement is zero 
		assertEquals("Please input a figure that is more than zero for hip and/or "
				+ "shoulder and/or waist measurements", ut.checkHipWaistShoulderInput(waistError));		
		
		//test case 4: when shoulder measurement is more than or equal to 300
		assertEquals("Please input a figure that is less than 300cm for hip and/or shoulder and/or waist "
				+ "measurements", ut.checkHipWaistShoulderInput(shoulderError));
		
		
	}

	@Test
	void testCheckNeckDepthAndNapeToWaist() {
		
		int napeDepth = 11;
		int napeToWaist = 60;
		int napeDepthError = 60;

		//test case 1: when OK 
		assertEquals("OK", ut.checkNeckDepthAndNapeToWaist(napeDepth, napeToWaist));
		
		//test case 2: when nape depth is longer or equal to nape to waist 
		assertEquals("Please input a nape depth that is shorter than the Nape to Waist "
				+ "measurement", ut.checkNeckDepthAndNapeToWaist(napeDepthError, napeToWaist));

		//test case 3: when nape to waist is zero 
		assertEquals("Please input a figure that is more than zero for nape depth and/or nape "
				+ "to waist measurement", ut.checkNeckDepthAndNapeToWaist(napeDepth, 0));

		//test case 4: when nape depth is 0 
		assertEquals("Please input a figure that is more than zero for nape depth and/or nape "
				+ "to waist measurement", ut.checkNeckDepthAndNapeToWaist(0, napeToWaist));	
		
		//test case 5: when nape depth is more than 200cm
		assertEquals("Please input nape depth that is less than 200cm and/or nape to waist measurement "
				+ "that is less than 272cm", ut.checkNeckDepthAndNapeToWaist(201, 60));

		//test case 6: when nape to waist is more than 272cm
		assertEquals("Please input nape depth that is less than 200cm and/or nape to waist measurement "
				+ "that is less than 272cm", ut.checkNeckDepthAndNapeToWaist(11, 273));
	}

	@Test
	void testCheckArmHoleDepth() {
		
		int armHoleDepth = 30;
		int napeToWaist = 80;
		int armHoleLongerThanNape = 90;
		int armHoleLong = 100;
		
		//test case 1: when OK 
		assertEquals("OK", ut.checkArmHoleDepth(armHoleDepth, napeToWaist));

		//test case 2: when arm hole depth is zero 
		assertEquals("Please input a figure that is more than zero for arm "
				+ "hole depth", ut.checkArmHoleDepth(0, napeToWaist));
		
		//test case 3: when arm hole depth is longer than nape to waist 
		assertEquals("Please input an arm hole depth measurement that is less "
				+ "than nape to waist measurement", ut.checkArmHoleDepth(armHoleLongerThanNape, napeToWaist));
		
		//test case 4: when arm hole depth is more than 100cm 
		assertEquals("Please input an arm hole depth measurement that is less 100cm", 
				ut.checkArmHoleDepth(armHoleLong, napeToWaist));

	}

	@Test
	void testCheckNeckCir() {
		
		int neckCir = 25;
		int neckCirLong = 100;
		
		//test case 1: when OK 
		assertEquals("OK", ut.checkNeckCir(neckCir));
		
		//test case 2: when neck circumference is zero 
		assertEquals("Please input a figure that is more than zero for "
				+ "neck circumference measurement", ut.checkNeckCir(0));
		
		//test case 3: when neck circumference is longer than 52cm 
		assertEquals("Please input a figure that is less than 52cm for neck "
				+ "circumference measurement", ut.checkNeckCir(neckCirLong));
		
		
	}

	@Test
	void testCheckSleeveLength() {
		
		int sleeveLength = 30;
		int sleeveLengthLong = 300;
		
		//test case 1: when OK
		assertEquals("OK", ut.checkSleeveLength(sleeveLength));
		
		//test case 2: when sleeve length is more than 190cm
		assertEquals("Please input a sleeveLength figure that is less than 190cm", 
				ut.checkSleeveLength(sleeveLengthLong));
		
		//test case 3: when sleeve length is zero 
		assertEquals("Please input a figure that is more than zero for sleeve "
				+ "length measurement", ut.checkSleeveLength(0));
		
	}

	@Test
	void testCheckArmCir() {
		
		int armCir = 50;
		int armHoleDepth = 26;
		int armCirLong = 60;
		
		//test case 1: when OK 
		assertEquals("OK", ut.checkArmCir(armCir, armHoleDepth));
		
		//test case 2: when arm circumference is zero 
		assertEquals("Please input a figure that is more than zero for arm circumference measurement", 
				ut.checkArmCir(0, armHoleDepth));
		
		//test case 3: when arm circumference is less than twice arm hole depth 
		assertEquals("Please input a arm circumference measurement that is less than twice "
				+ "arm hole depth measurement", ut.checkArmCir(armCirLong, armHoleDepth));
		
		
	}

	@Test
	void testCheckInputMeasurements() {
		
		//test case 1: when OK 
		assertTrue(ut.checkInputMeasurements(132, 107, 10, 15, 26, 54, 40, 20, 50));
		
		//test case 2: when inputs are zero 
		assertFalse(ut.checkInputMeasurements(0, 0, 0, 0, 0, 0, 0, 0, 0));
		
		//test case 3: when inputs are negative and some out of proportion 
		assertFalse(ut.checkInputMeasurements(-1, 107, 10, 15, 26, 50, 40, 20, 50));
		
	}

}
