import java.util.ArrayList;
import java.util.Arrays;

public class brackets {
	
	public static void main(String argus[]) {
		
		String str = "{\\\\*\\\\listtable{\\\\list{\\\\listlevel{\\\\leveltext}}}}";
		
		String [] str2 = str.replaceAll("}", "").trim().split("\\{");
		
		ArrayList<String> strstore = new ArrayList<>();
		
		for (int i = 0; i <= str2.length-1; i++) {
			
			if(str2[i] !=null && str2[i].length()> 0) {
				
				strstore.add(str2[i]);
			}
			
		}
		
			for (int i = 0; i < strstore.size(); i++) {
				
				System.out.print("{"+strstore.get(i)+"}");
				
			}
	}

}
