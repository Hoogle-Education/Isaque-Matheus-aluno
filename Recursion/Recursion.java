package recursiontutorial;

public class RecursionTutorial {

    // Given a string, compute recursively (no loops) the number of times lowercase “hi”
    // appears in the string.
    public int countHi(String str) {
        System.out.println("working on the string " + str);
        // base case (when will be know we are finished?)
        if (str.length() < 2) {
            System.out.println("String: " + str + " was too small to recurse on");
            return 0;
        } else if (str.substring(0, 2).equals("hi")) {
            System.out.println("String: " + str + " started with hi");
            // we found hi at the start of the string
            return 1 + countHi(str.substring(2));
        } else {
            System.out.println("String: " + str + " did NOT start with hi, so we throw away " + str.charAt(0));

            // we didn't find hi, so what character can we discount?
            return countHi(str.substring(1));
        }
    }

    // Given a string, compute recursively a new string where all the ’x’ chars have been
    // removed.
    public String removeX(String str) {
        // base case is that the string is empty
        if (str.length() == 0) {
            return "";
        } else if (str.charAt(0) == 'x') {
            // we need to remove x from the string
            return removeX(str.substring(1));
        } else {
            // the string is not empty and the first char is not an x
            return str.charAt(0) + removeX(str.substring(1));
        }
    }

    // Given an array of ints, compute recursively if the array contains somewhere a value
    // followed in the array by that value times 10. We’ll use the convention of considering
    // only the part of the array that begins at the given index. In this way, a recursive call
    // can pass index+1 to move down the array. The initial call will pass in index as 0.
    public boolean containsTimes10(int[] arr, int index) {
        System.out.println("index is " + index);
        // [10,200,5,50]
        // base case could be based the bounds of the array so if index getting too big
        // we need to be one back from the end because we are checking 2 integers side by side
        if (index >= (arr.length - 1)) {
            return false;
        } // handle the case where we find a pair
        else if ((arr[index] * 10) == arr[index + 1]) {
            return true;
        } else {
            // we did not find what we were looking for at index
            return containsTimes10(arr, ++index);
        }
    }

    // Given a string, compute recursively a new string where all the lowercase ’x’ chars have
    // been moved to the end of the string
    public String endX(String str) {
        if (str.length() <= 1) {
            return str;
        } else if (str.charAt(0) == 'x') {
            return endX(str.substring(1)) + str.charAt(0);
        } else {
            return str.charAt(0) + endX(str.substring(1));
        }
    }

    // Given a non-negative int n, return the sum of its digits recursively (no loops). Note
    // that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10
    // removes the rightmost digit (126 / 10 is 12).
    public int sumDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) + sumDigits(n / 10);
        }
    }

    // Given a string, compute recursively (no loops) a new string where all the lowercase ’x’
    // chars have been changed to ’y’ chars.
    public String changeXY(String str) {
        if (str.length() == 0) {
            return str;
        } else if (str.charAt(0) == 'x') {
            return 'y' + changeXY(str.substring(1));
        } else {
            return str.charAt(0) + changeXY(str.substring(1));
        }
    }

    // Given a string, return recursively a “cleaned” string where adjacent chars that are the
    // same have been reduced to a single char. So “yyzzza” yields “yza”.
    public String stringClean(String str) {
        if (str.length() <= 1) {
            return str;
        } else {
            String sub = str.substring(0, 2);
            if (sub.charAt(0) == sub.charAt(1)) {
                return stringClean(str.substring(1));
            } else {
                return sub.charAt(0) + stringClean(str.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        RecursionTutorial recursionTutorial = new RecursionTutorial();      
        System.out.println(recursionTutorial.endX("xhixixamxdom "));
        System.out.println(recursionTutorial.sumDigits(121));
        System.out.println(recursionTutorial.changeXY("xxxhixxlsxx"));
        System.out.println(recursionTutorial.stringClean("yyzzza"));
    }

}