/*
 * https://open.kattis.com/problems/dutub
 * 
 * Recursion-type problem (I might be able to use DP, idk yet)
 * 
 * 
 * Variables:
 * Set of categories (reinitialize at the beginning of the loop to reset)
 * 
 * Steps:
 * 1. Make a video object class with 2 fields for video length and categories
 * 2. Get all inputs and store in an object array
 * 3. Loop through the array and add score to total & remove categories from the set
 * 4. Check against if statements until 1 i reached
 *      if(category not in set) do not choose
 *      if(empty set) check if length is minumum against global min
 *      if(end of array) set is not empty, so not valid
 *  5. Once we reach end of the array from the first video, we need to start from the second video and check
 * 
 * Time Complexity: O(N^2)
 * 
 */

import java.util.Set;

public class MeTube {
    public static void main(String[] args) {
        
    }

    public static Video[] getInputs() {
        return null;
    }

    public static int calculateLength(Video[] videos) {
        int length = 0;
        return length;
    }

    

    // public static boolean calculateMinimumLength(int currentMin, int temp) {
        
    // }

}
class Video{
    int time;
    Set<Character> categories;
    public Video(int time, Set<Character> categories) {
        this.time = time;
        this.categories = categories;
    }

    
}