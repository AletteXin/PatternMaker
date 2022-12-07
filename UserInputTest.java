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
		
		assertEquals("OK", ut.checkHipWaistShoulderInput(shoulder));
		assertEquals("Please input a figure that is more than zero for hip and/or "
				+ "shoulder and/or waist measurements", ut.checkHipWaistShoulderInput(hipError));		
		assertEquals("Please input a figure that is more than zero for hip and/or "
				+ "shoulder and/or waist measurements", ut.checkHipWaistShoulderInput(waistError));			
		assertEquals("Please input a figure that is less than 300cm for hip and/or shoulder and/or waist "
				+ "measurements", ut.checkHipWaistShoulderInput(shoulderError));
		
		
	}

	@Test
	void testCheckNeckDepthAndNapeToWaist() {
		
		int napeDepth = 11;
		int napeToWaist = 60;
		int napeDepthError = 60;

		
		assertEquals("OK", ut.checkNeckDepthAndNapeToWaist(napeDepth, napeToWaist));
		
		assertEquals("Please input a nape depth that is shorter than the Nape to Waist "
				+ "measurement", ut.checkNeckDepthAndNapeToWaist(napeDepthError, napeToWaist));

		assertEquals("Please input a figure that is more than zero for nape depth and/or nape "
				+ "to waist measurement", ut.checkNeckDepthAndNapeToWaist(napeDepth, 0));

		assertEquals("Please input a figure that is more than zero for nape depth and/or nape "
				+ "to waist measurement", ut.checkNeckDepthAndNapeToWaist(0, napeToWaist));	
		
		assertEquals("Please input nape depth that is less than 200cm and/or nape to waist measurement "
				+ "that is less than 272cm", ut.checkNeckDepthAndNapeToWaist(201, 60));

		assertEquals("Please input nape depth that is less than 200cm and/or nape to waist measurement "
				+ "that is less than 272cm", ut.checkNeckDepthAndNapeToWaist(11, 273));
	}

	@Test
	void testCheckArmHoleDepth() {
		
		int armHoleDepth = 30;
		int napeToWaist = 80;
		int armHoleLongerThanNape = 90;
		int armHoleLong = 100;
		
		assertEquals("OK", ut.checkArmHoleDepth(armHoleDepth, napeToWaist));

		assertEquals("Please input a figure that is more than zero for arm "
				+ "hole depth", ut.checkArmHoleDepth(0, napeToWaist));
		
		assertEquals("Please input an arm hole depth measurement that is less "
				+ "than nape to waist measurement", ut.checkArmHoleDepth(armHoleLongerThanNape, napeToWaist));
		
		assertEquals("Please input an arm hole depth measurement that is less 100cm", 
				ut.checkArmHoleDepth(armHoleLong, napeToWaist));
				
		
	}

	@Test
	void testCheckNeckCir() {
		
		int neckCir = 25;
		int neckCirLong = 100;
		
		assertEquals("OK", ut.checkNeckCir(neckCir));
		
		assertEquals("Please input a figure that is more than zero for "
				+ "neck circumference measurement", ut.checkNeckCir(0));
		
		assertEquals("Please input a figure that is less than 52cm for neck "
				+ "circumference measurement", ut.checkNeckCir(neckCirLong));
		
		
	}

	@Test
	void testCheckSleeveLength() {
		
		int sleeveLength = 30;
		int sleeveLengthLong = 300;
		
		assertEquals("OK", ut.checkSleeveLength(sleeveLength));
		
		assertEquals("Please input a sleeveLength figure that is less than 190cm", 
				ut.checkSleeveLength(sleeveLengthLong));
		
		assertEquals("Please input a figure that is more than zero for sleeve "
				+ "length measurement", ut.checkSleeveLength(0));
		
		
	}

	@Test
	void testCheckArmCir() {
		
		int armCir = 50;
		int armHoleDepth = 26;
		int armCirLong = 60;
		
		assertEquals("OK", ut.checkArmCir(armCir, armHoleDepth));
		
		assertEquals("Please input a figure that is more than zero for arm circumference measurement", 
				ut.checkArmCir(0, armHoleDepth));
		
		assertEquals("Please input a arm circumference measurement that is less than twice "
				+ "arm hole depth measurement", ut.checkArmCir(armCirLong, armHoleDepth));
		
		
	}

	@Test
	void testCheckInputMeasurements() {
		
		assertTrue(ut.checkInputMeasurements(132, 107, 10, 15, 26, 54, 40, 20, 50));
		assertFalse(ut.checkInputMeasurements(0, 0, 0, 0, 0, 0, 0, 0, 0));
		assertFalse(ut.checkInputMeasurements(-1, 107, 10, 15, 26, 50, 40, 20, 50));
		
	}

}
