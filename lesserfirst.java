import java.util.Arrays;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class lesserfirst {


    public static void main (String argus[]){


        int [] arr = new int[] {-2,3,4,-1,-3,1,2,-4,0};
        //Arrays.sort(arr);

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr.length-1; j=j+1) {

                if (arr[j]>arr[j+1]){
                   int temp2 ;
                    temp2 = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp2;


                }
            }

        }

        System.out.print(Arrays.toString(arr));

    }
}
