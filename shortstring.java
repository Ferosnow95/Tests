import java.util.*;

public class shortstring {


    public static void main( String argus[] ) {

        Scanner input = new Scanner( System.in );
        String mainstring = input.nextLine();
        String lettersstring = input.nextLine();

       /* String mainstring = "1qnkyp098fSkkmnQryS9pkYn0Qd7mksy0fRW0a7Sxzc";
        String lettersstring = "Sky07";*/

        ArrayList<Integer> index = new ArrayList<>();
        char[] letters = lettersstring.toCharArray();

        ArrayList<Character> chars = new ArrayList<>();
        for (char c : lettersstring.toCharArray()) {
            chars.add( c );
        }

        int count = 0;
        int charcount = chars.size();
        int shortestWindow = 70;

        String output = null;

            for (int i = 0; i<mainstring.length();i++) {

                    index.clear(); //Clears the index on every iterration

                for (int j = i; j < mainstring.length(); j++) {

                    if (chars.contains(mainstring.charAt(j))) {
                        index.add(j);
                    }
                }

                    if (index.size() == letters.length) {

                        if ((index.get(index.size() - 1) - index.get(0)) < shortestWindow) {
                            shortestWindow = index.get(index.size() - 1) - index.get(0);
                            output = mainstring.substring(index.get(0), index.get(index.size() - 1)+1);

                        }

                    }

                }


       //System.out.print(Arrays.toString(index.toArray()));
        System.out.print(output);


        //System.out.print(charcount);


    }
} //End of Main