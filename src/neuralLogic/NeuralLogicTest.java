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

	public int[] sum(int a, int b) throws Exception{
		int outa = pNAND.synapsis(a, b);
		int outb = pNAND.synapsis(a, outa);
		int outc = pNAND.synapsis(outa, b);
		int outd = pNAND.synapsis(outb, outc);
		int oute = pNAND.synapsis(outa, outa);
		return new int[] {outd, oute};
		
	}
	@Before
	public void setUp() throws Exception {
		pAND = and();
		pOR = or();
		pNAND = nand();
	}

	@Test
	public void testAND() throws Exception {
		// tabla de verdad
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
	@Test
	public void testSum() throws Exception {
		// primero es sum, segundo es carry
		assertEquals(sum(0,0)[0], 0);
		assertEquals(sum(0,0)[1], 0);
		
		assertEquals(sum(1,0)[0], 1);
		assertEquals(sum(1,0)[1], 0);
		
		assertEquals(sum(0,1)[0], 1);
		assertEquals(sum(0,1)[1], 0);
		
		assertEquals(sum(1,1)[0], 0);
		assertEquals(sum(1,1)[1], 1);
	}

}
