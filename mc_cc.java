import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mc_cc {


        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] creditCardNoString = reader.readLine().split("");
            int[] creditCardNo = new int[20];
            int[] AlternateDouble;
            int sum;
            for (int k = 0; k < creditCardNoString.length; k++) {
                creditCardNo[k] = Integer.parseInt(creditCardNoString[creditCardNoString.length - k - 1]);
            }

            AlternateDouble = DoubleAlternateDigit(creditCardNo);

            sum = AddNumber(creditCardNo, AlternateDouble);

            ValidateCreditCard(sum);

        }

        private static void ValidateCreditCard(int sum) {
            // TODO Auto-generated method stub
            if (sum % 10 == 0) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID " + sum % 10);

            }
        }

        private static int AddNumber(int[] creditCardNo, int[] alternateDouble) {
            int sum = 0;
            int sumAlternate = 0;
            int temp = 0;
            for (int i = 0; i < alternateDouble.length; i++) {
                temp = (alternateDouble[i] / 10) + (alternateDouble[i] % 10);
                sumAlternate = sumAlternate + temp;

            }
            // System.out.println(sumAlternate);

            sum = sumAlternate;
            // System.out.println(sum);

            for (int i = 0; i < creditCardNo.length; i = i + 2) {
                sum += creditCardNo[i];
            }
            return sum;
        }

        private static int[] DoubleAlternateDigit(int[] creditCardNo) {
            // TODO Auto-generated method stub
            int[] AlternateDouble = new int[20];
            int doubleNumber = 0;
            for (int i = 1; i < creditCardNo.length; i = i + 2) {
                doubleNumber = creditCardNo[i] * 2;
                AlternateDouble[i] = doubleNumber;
            }
            return AlternateDouble;

        }

    }


