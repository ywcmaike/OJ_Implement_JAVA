package BigData;

import java.util.HashMap;

public class WorldMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "a1,b2,3c,d4d,a1,b2,a1";
		String[] ws = input.split(",");
		HashMap<String, Integer> hm = new HashMap<String, Integer> ();
		
		for (String s : ws) {
			if (s.matches("[a-zA-Z]\\w+")) {
				Integer cou = hm.get(s);
				hm.put(s, cou == null? 1 : cou+1);
			}
			
		}
		System.out.println(hm);
	}

}
