import java.lang.reflect.Array;
import java.util.*;

public class charclose {

    public static void main (String argus[]){

        //Scanner input = new Scanner(System.in);
        String input_string= "{\\\\*\\\\listtable{\\\\list{\\\\listlevel{\\\\leveltext}}}}";
        //String input_string= "[hello[world][don't][[[really]care]]]";
        //String input_string= "((!!(123(x))))";
        //String input_string= "{)(a,b}";


        char [] char_string = input_string.toCharArray();
        ArrayList <String> test = new ArrayList<>();

        String [] output_String = input_string.replaceAll("\\}","").split("\\{" );

        ArrayList<String> y = new ArrayList<>();



       /* String temp=" ";
        for (int i = 0; i <input_string.length() ; i++) {

            if(input_string.charAt(i)=='('){

                startindex=i;

                if (input_string.charAt(i)==')'){

                    endindex=i;
                }

                 temp = input_string.substring(startindex,endindex);
            }

        }*/

        for (int i = 0; i <output_String.length ; i++) {

            if(output_String[i] != null && output_String[i].length()>0){

                y.add(output_String[i]);

            }
        }

        for (int i = 0; i <y.size() ; i++) {

            System.out.print("{"+y.get(i)+"}");
        }

        }

    }


