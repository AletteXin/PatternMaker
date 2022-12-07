package userinterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BodiceTest {
	
	Bodice bodice;
	
	@BeforeEach
	void setUp() throws Exception {
		

	}


	@Test
	void testGetBodiceType() {
		
		//test 1: c neck bodice 
		CNeckBodice testCBodice = new CNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals("C Neck Bodice", testCBodice.getBodiceType());
		
		//test 2: v neck bodice 
		VNeckBodice testVBodice = new VNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals("V Neck Bodice", testVBodice.getBodiceType());
		
	}

	@Test
	void testGetArmHoleDepth() {
		
		int expand = 5;
	
		//test 1: when arm hole depth measurement is 26cm
		CNeckBodice testCBodice = new CNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals(26 * expand, testCBodice.getArmHoleDepth());
		
		//test 2: when arm hole depth measurement is 24cm 
		VNeckBodice testVBodice = new VNeckBodice(132, 107, 10, 15, 24, 54, 40);
		assertEquals(24 * expand, testVBodice.getArmHoleDepth());
		
	}


}
