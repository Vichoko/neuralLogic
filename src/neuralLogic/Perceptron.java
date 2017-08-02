package neuralLogic;

public class Perceptron {
	double bias;
	double wa;
	double wb;
	
	public Perceptron(double bias, double wa, double wb){
		this.bias = bias;
		this.wa = wa;
		this.wb = wb;
	}

	public int synapsis(int a, int b) throws Exception{
		if (a<0 || a>1 || b<0 || b>1){ // check for unsupported input
			throw new Exception();
		}
		if (wa*a+wb*b+bias > 0){
			return 1;
		}
		return 0;
	}

}
