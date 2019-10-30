import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class transcript {


    public static void main (String argus [] ){


        Scanner input = new Scanner(System.in);
        String inputStream = input.nextLine();
        String [] name = inputStream.split(" ");


        int lenght = name.length;
        List <Character> characters = List.of('a','e','i','o','u','A','E','I','O','U','b');


        if (lenght==3){

            for (int i = 0; i <name.length ; i++) {

                System.out.println(name[name.length-1] + " "+ name[i] +" " + name[name.length-2]);
                break;

            }
            //System.out.println("Check 1");
        }
        if (lenght == 2) {

            char [] temp1;
            char [] temp2 = null;
            int check =0;
            for (int i = 0; i <name.length-1 ; i++) {

                temp1 = name[i].toCharArray();
                temp2 = name[i+1].toCharArray();
            }

            for (int i = 0; i <temp2.length; i++) {

                if (characters.contains(temp2[temp2.length-1])){

                    check =1;

                }
                else {

                    check=0;
                }
            }


        if (check==1){
            for (int i = 0; i <name.length-1 ; i++){
                System.out.println(name[i+1]+" "+name[i]);
                System.out.println("Check 2");
            }

        }
        else {
            for (int i = 0; i <name.length-1 ; i++){
            System.out.println(name[i]+" "+name[i+1]);
            System.out.println("Check 2.1");
            break;
            }
        }







            }
        }



        }




