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
		
		CNeckBodice testCBodice = new CNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals("C Neck Bodice", testCBodice.getBodiceType());
		
		VNeckBodice testVBodice = new VNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals("V Neck Bodice", testVBodice.getBodiceType());
		
	}

	@Test
	void testGetArmHoleDepth() {
		
		int expand = 5;
		CNeckBodice testCBodice = new CNeckBodice(132, 107, 10, 15, 26, 54, 40);
		assertEquals(26 * expand, testCBodice.getArmHoleDepth());
		
		VNeckBodice testVBodice = new VNeckBodice(132, 107, 10, 15, 24, 54, 40);
		assertEquals(24 * expand, testVBodice.getArmHoleDepth());
		
	}


}
