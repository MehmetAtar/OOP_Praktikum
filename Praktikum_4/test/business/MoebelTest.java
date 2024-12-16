package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;

class MoebelTest {

	private Moebelstueck moebel;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		moebel = new Moebelstueck("Moebelhaus Querenburg", 200, "Schön", 500.00f, new String[] {"Holz", "Metal"});
		assertTrue(moebel.getName() == "Moebelhaus Querenburg");
		
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			moebel = new Moebelstueck(null,0,null,0,null);
			throw new IllegalArgumentException("expected message");
		});
	
//		NullPointerException thrown2 = Assertions.assertThrows(NullPointerException.class, () -> {
//			moebel = new Moebelstueck(null,0,null,0,null);
//		    throw new IllegalArgumentException("expected message");
//		  });


		}
}
