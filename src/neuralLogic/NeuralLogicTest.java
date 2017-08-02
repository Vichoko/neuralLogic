package neuralLogic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NeuralLogicTest {
	
	Perceptron and(){
		return new Perceptron(-3, 2, 2);
	}
	
	Perceptron nand(){
		return new Perceptron(3, -2, -2);
	}
	
	Perceptron or(){
		return new Perceptron(0, 1, 1);
	}
	
	Perceptron pAND;
	Perceptron pNAND;
	Perceptron pOR;

	@Before
	public void setUp() throws Exception {
		pAND = and();
		pOR = or();
		pNAND = nand();
	}

	@Test
	public void testAND() throws Exception {
		assertEquals(pAND.synapsis(0,0), 0);
		assertEquals(pAND.synapsis(0,1), 0);
		assertEquals(pAND.synapsis(1,0), 0);
		assertEquals(pAND.synapsis(1,1), 1);
	}	


	@Test
	public void testNAND() throws Exception {
		assertEquals(pNAND.synapsis(0,0), 1);
		assertEquals(pNAND.synapsis(0,1), 1);
		assertEquals(pNAND.synapsis(1,0), 1);
		assertEquals(pNAND.synapsis(1,1), 0);
	}	
	@Test
	public void testOR() throws Exception {
		assertEquals(pOR.synapsis(0,0), 0);
		assertEquals(pOR.synapsis(0,1), 1);
		assertEquals(pOR.synapsis(1,0), 1);
		assertEquals(pOR.synapsis(1,1), 1);
	}

}
