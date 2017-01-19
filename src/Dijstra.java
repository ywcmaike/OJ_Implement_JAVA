
public class Dijstra {

	public void dijkstra(int v, float[][] a, float[] dist, int [] prev) {
		int n = dist.length - 1;
		if (v < 0 || v > n - 1) 
			return;
		boolean [] s = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			dist[i] = a[v][i];
			s[i] = false;
			if (dist[i] == Float.MAX_VALUE) {
				prev[i] = 0;
			} else {
				prev[i] = v;
			}
		}
		dist[v] = 0;
		s[v] = true;
		int u = 0;
		for (int i = 1; i < n; i++) {
			float temp = Float.MAX_VALUE;
			u = v;
			for (int j = 1; j <= n; j++) {
				if ((!s[j]) && (dist[j] < temp)) {
					u = j;
					temp = dist[j];
				}
			}
		}
		s[u] = true;
		for (int j = 1; j <= n; j++) {
			if ((!s[j]) && a[u][j] < Float.MAX_VALUE) {
				float newdist = dist[u] + a[u][j];
				if (newdist < dist[j]) {
					dist[j] = newdist;
					prev[j] = u;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
