package neocognitron;

public class RunTest {

	public static void main(String[] args)
	{
		System.out.println("Starting Test!");
		
		testMonotonicC();
	}
	
	public static void testMonotonicC() {
		NeocognitronStructure s = new NeocognitronStructure();
		double[] c;
		for (int l = 0; l < s.numLayers; l++) {
			c = s.getC(l);
			System.out.println("C weight matrix for layer " + l + ":");
			for (int w = 0; w < c.length; w++) {
				System.out.print(c[w] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void testOutputConnections() {
		int K = 2;
		int size = 4;
		int count = 0;
		double[][][] values = new double[K][size][size];
		for(int k = 0; k < K; k++) {
			System.out.println("Plane " + k);
			for(int n = 0; n < size; n++) {
				for(int m = 0; m < size; m++) {
					count++;
					values[k][n][m] = count;
					System.out.print(count + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		OutputConnections outputs = new OutputConnections(K, size);
		for (int k = 0; k < K; k++) {
			outputs.setPlaneOutput(k, values[k]);
		}
		
		System.out.println(outputs.toString());
	}
	
	public static void testMethods(OutputConnections outputs, int K) {
		
		System.out.println("Single plane window test:");
		double[] temp = outputs.getWindowInPlane(0, 1, 1, 4);
		for (int i = 0; i < temp.length; i++)
			System.out.print(temp[i] + "\t");
		System.out.println();

		System.out.println("Multiple plane window test:");
		double[][] temp1 = outputs.getWindows(1, 1, 4);
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp1[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
		
		
		
		
//		for (int k = 0; k < K; k++) {
//			System.out.println("Object Plane " + k);
//			double plane[][] = outputs.getPlane(k);
//			for(int n = 0; n < size; n++) {
//				for(int m = 0; m < size; m++) {
//					System.out.print(plane[n][m] + "\t");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("Location Test at (3, 3)!");
//		double[] temp = outputs.getPointsOnPlanes(3, 3);
//		for (int k = 0; k < K; k++)
//			System.out.println(temp[k] + "\t");
}