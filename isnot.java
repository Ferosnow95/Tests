
public class isnot {

	
	public static boolean equalIsNot(String str) {
		
		  if (str.length()<1){
				    return true;
				  }
				  
				  
				  int iscount = 0;
				  int notcount=0;
				  String check;
				  String str2 = str.trim();
				  
				  for (int i=0;i<=str2.length()-2;i++ ){
				    
				   	
				    if(str2.charAt(i)=='i' && str2.charAt(i+1)=='s'){
				      
				      iscount++;
				    }
				  }
				  
				  for (int i=0;i<=str2.length()-2;i++)
				  {
				    
				    check = str.substring(i,i+2);
				    
				    if(str2.charAt(i)=='n' && str2.charAt(i+1)=='o' && str2.charAt(i+2)=='t'){
				      
				      notcount++;
				    }
				  }
				  
				
				  
				  if(iscount==notcount){
				    return true;
				  }
				  else {
				    return false;
				  }
				  
				  
			}
	
	


	
	public static void main (String argus[]) {
		boolean output = false;
		String str = "mis3notnotpotbotis";
		output= equalIsNot(str);
		
		System.out.print(output);
		
	}
	
}
