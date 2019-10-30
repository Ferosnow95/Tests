package creditCard;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class creditCard {

    public static void  main (String argus []) throws IOException{

        // Scanner input = new Scanner(System.in);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] creditCardNoString = reader.readLine().split("");





        int [] cardNumber = new int [creditCardNoString.length];
        for (int i = 0; i < cardNumber.length; i++) {
            cardNumber[i] = Integer.parseInt(creditCardNoString[i]);

            //System.out.print( cardNumber[i] + " " );
        }

        //System.out.println();

        /*for (int i = 0; i <20 ; i++) {
             cardNumber [i] = input.nextInt();
        }*/

        // int [] cardNumber = {4,9,9,2,7,3,9,8,7,1,6};
        //int [] cardNumber2 = {5,1,3,4,6,7,8,8,2,1,3,4};
        //int [] cardNumber3= {4,3,2,8,7,6,1,2,6};

        int lenght = cardNumber.length-1;
        int jump=1;
        int [] alternateDouble;
        int sum;
        int sumAlternate=0;
        for(int i = cardNumber.length-2; i>=0;i =i-2) {


            cardNumber[i] = cardNumber[i] * 2;


        }
        // System.out.println(Arrays.toString(cardNumber));


        for(int i=0; i <cardNumber.length;i++){

            int temp = (cardNumber[i] / 10) + (cardNumber[i] % 10); //used to add indavidual digits at a element
            sumAlternate = sumAlternate + temp;

        }

        System.out.println(sumAlternate);
        sum = sumAlternate;

        int checkdigit=sumAlternate%10;
        int correctdigit;



        if (checkdigit == 0){

            System.out.println("VALID");

        }
        else {
           for(int i=0; i<9;i++) {


               cardNumber[cardNumber.length-1]=i;
               int temp = (cardNumber[i] / 10) + (cardNumber[i] % 10);
               checkdigit= cardNumber[cardNumber.length-i];

               if (sumAlternate%10==0){

                   System.out.println("INVALID" + " " + checkdigit);
                    break;
               }
           }

            }

        }

    }


