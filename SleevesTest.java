package userinterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SleevesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetSleeveType() {
		
		VNeckBodice testVBodice = new VNeckBodice(132, 107, 10, 15, 26, 54, 40);

		//test 1: test straight sleeve on v neck bodice 
		StraightSleeve testSSleeve = new StraightSleeve(testVBodice, 20, 50);
		assertEquals("Straight Sleeve", testSSleeve.getSleeveType());

		//test 2: test tapered sleeve on v neck bodice 
		TaperedSleeve testTSleeve = new TaperedSleeve(testVBodice, 20, 50);
		assertEquals("Tapered Sleeve", testTSleeve.getSleeveType());
		
		CNeckBodice testCBodice = new CNeckBodice(132, 107, 10, 15, 24, 54, 20);

		//test 3: test straight sleeve on c neck bodice 
		StraightSleeve testSSleeve2 = new StraightSleeve(testCBodice, 20, 50);
		assertEquals("Straight Sleeve", testSSleeve2.getSleeveType());

		//test 4: test tapered sleeve on c neck bodice 
		TaperedSleeve testTSleeve2 = new TaperedSleeve(testCBodice, 20, 50);
		assertEquals("Tapered Sleeve", testTSleeve2.getSleeveType());
			
		
	}


}
