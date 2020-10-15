package leetcode.simple;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        if(x < 10){
            return true;
        }

        if( x % 10 == 0){
            return false;
        }

        int rev = 0;
        int temp = x;
        int pop;
        while(rev < temp){
            pop = temp % 10;

            rev = rev * 10 + pop;

            if(rev == temp && rev >= 10){
                return true;
            }

            temp /= 10;
        }

        if(temp == rev){
            return true;
        }

        return false;
    }

}
