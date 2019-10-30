
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class withoutstring {
	
	

	
	
	public static void main (String argus[]) {
		
		
		String base = "Hello there";
		String remove = "llo";
		String output = null;
		
		int size1= remove.length();
		StringBuilder sb = new StringBuilder();
		int breaker=0;

		StringBuffer text = new StringBuffer(base);
		for (int i = 0; i <= base.length()-3; i++) {
		
			if (breaker==1) {
				break;
			}
			String check = base.substring(i, i+3);
			/* System.out.println(check); */
			if(check.equalsIgnoreCase(remove)) {
				
				output= base.substring(0,i) + base.substring(i+3);
			}
			
		}
		
		
		System.out.print(output);
		
	}

}
