package Week_02.PalindromeNumber;


public class PalindromeNumber {

    static  boolean isPalindrome(int number){
        int temp = number, reverseNumber = 0,lastNumber;
        while (temp!=0){
            System.out.println("-------------------------------");
            System.out.println("Number => " + temp);

            lastNumber = temp%10;
            System.out.println("Last Number " + lastNumber);

            reverseNumber = (reverseNumber*10) + lastNumber;
            System.out.println("New Number =>" + reverseNumber);

            temp /=10;
        }

        if (number==reverseNumber) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {


        System.out.println(isPalindrome(2476));

    }
}
