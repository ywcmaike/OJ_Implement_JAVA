
public class Prim {

	public static void prim(int num, float[][] weight) {
		float [] lowcost = new float[num + 1];
		int [] closest = new int [num + 1];
		boolean [] s = new boolean[num + 1];
		s[1] = true;
		for (int i = 2; i <= num; i++) {
			lowcost[i] = weight[1][i];
			closest[i] = 1;
			s[i] = false;
		}
		for (int i = 1; i < num; i++) {
			float min = Float.MAX_VALUE;
			int j = 1;
			for (int k = 2; k <= num; k++) {
				if ((lowcost[k] < min) && (!s[k])) {
					min = lowcost[k];
					j = k;
				}
					 
			}
			System.out.println("加入点" + j + "." + j + "---" + closest[j]);
			s[j] = true;
			for (int k = 2; k <= num; k++) {
				if ((weight[j][k] < lowcost[k]) && !s[k]) {
					lowcost[k] = weight[j][k];
					closest[k] = j;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float m = Float.MAX_VALUE;
		float[][] weight = {{0, 0, 0, 0, 0, 0, 0},  
                {0, m, 6, 1, 5, m, m},  
                {0, 6, m, 5, m, 3, m},  
                {0, 1, 5, m, 5, 6, 4},  
                {0, 5, m, 5, m, m, 2},  
                {0, m, 3, 6, m, m, 6},  
                {0, m, m, 4, 2, 6, m}};
		prim(weight.length - 1, weight);
	}

}
