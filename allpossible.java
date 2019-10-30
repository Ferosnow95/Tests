import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allpossible {

	
	public static void main(String[] argus ) {
		
		
		String str = "qploresinazxrhqknhoilerthf";
		String patcher = null;
		String shortest = null;
		int shortestwindow = 10;
		
		ArrayList <String> sString = new ArrayList();
		List<Character> characters = Arrays.asList('l','i','o','n');
		
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1;j<=str.length();j++) {
				
				patcher = str.substring(i, j);
				sString.add(patcher);
				
				}
			
			}
		
		
		for(int i=0; i<=sString.size()-1;i++) {
			
			String temp = sString.get(i);
			for (int j = 0; j < temp.length(); j++) {
				
				if(characters.contains(temp.toCharArray())) {
					if(temp.length()<shortestwindow) {
						
						shortestwindow=temp.length();
						shortest=temp;
					}
					
				}
				
				
			}
			
		}
		
		System.out.println(sString.toString());
		System.out.println(shortest);
		}
}
