// mouths to feed
// minimum greedy
// it doesn't matter where I put the new letter, only when 1 of the 2 options that are smaller than the other
// 

public class ABCString {

    public static void main(String[] args) throws Exception {
        Kattio sc = new Kattio(System.in);
        String s = sc.getLine();
        int numOfSubstrings = findABCStrings(s);
        System.out.println(numOfSubstrings);

    }

    private static int findABCStrings(String s) {
        int[] mouthsToFeed = new int[7];
        mouthsToFeed[6] = 1; // abc is open at the beginning
        // [0] = A
        // [1] = B
        // [2] = C
        // [3] = AB
        // [4] = AC
        // [5] = BC
        // [6] = ABC

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A':
                    if (mouthsToFeed[0] > 0) { // A
                        mouthsToFeed[0] = mouthsToFeed[0] - 1; // subtract from A
                        mouthsToFeed[6] = mouthsToFeed[6] + 1; // add to ABC
                    } else if (mouthsToFeed[3] > 0) { // AB
                        mouthsToFeed[3] = mouthsToFeed[3] - 1; // subtract from AB
                        mouthsToFeed[1] = mouthsToFeed[1] + 1; // add to B
                    } else if (mouthsToFeed[4] > 0) { // AC
                        mouthsToFeed[4] = mouthsToFeed[4] - 1; // subtract from AC
                        mouthsToFeed[2] = mouthsToFeed[2] + 1; // add to C
                    } else if (mouthsToFeed[6] > 0) { // ABC
                        mouthsToFeed[6] = mouthsToFeed[6] - 1; // subtract from ABC
                        mouthsToFeed[5] = mouthsToFeed[5] + 1;// add to BC
                    } else { // make a new partition
                        mouthsToFeed[5] = mouthsToFeed[5] + 1; // BC
                    }
                    break;
                case 'B':
                    if (mouthsToFeed[1] > 0) { // B
                        mouthsToFeed[1] = mouthsToFeed[1] - 1; // subtract from B
                        mouthsToFeed[6] = mouthsToFeed[6] + 1; // add to ABC
                    } else if (mouthsToFeed[3] > 0) {
                        mouthsToFeed[3] = mouthsToFeed[3] - 1; 
                        mouthsToFeed[0] = mouthsToFeed[0] + 1;
                    } else if (mouthsToFeed[5] > 0) {
                        mouthsToFeed[5] = mouthsToFeed[5] - 1;
                        mouthsToFeed[2] = mouthsToFeed[2] + 1;
                    } else if (mouthsToFeed[6] > 0) { // ABC
                        mouthsToFeed[6] = mouthsToFeed[6] - 1;
                        mouthsToFeed[4] = mouthsToFeed[4] + 1;// AC
                    } else { // make a new partition
                        mouthsToFeed[4] = mouthsToFeed[4] + 1; // AC
                    }
                    break;
                case 'C':
                    if (mouthsToFeed[2] > 0) { // C
                        mouthsToFeed[2] = mouthsToFeed[2] - 1;
                        mouthsToFeed[6] = mouthsToFeed[6] + 1; // add to ABC
                    } else if (mouthsToFeed[4] > 0) {
                        mouthsToFeed[4] = mouthsToFeed[4] - 1;
                        mouthsToFeed[0] = mouthsToFeed[0] + 1;
                    } else if (mouthsToFeed[5] > 0) {
                        mouthsToFeed[5] = mouthsToFeed[5] - 1;
                        mouthsToFeed[1] = mouthsToFeed[1] + 1;
                    } else if (mouthsToFeed[6] > 0) { // ABC
                        mouthsToFeed[6] = mouthsToFeed[6] - 1;
                        mouthsToFeed[3] = mouthsToFeed[3] + 1;// AB
                    } else { // make a new partition
                        mouthsToFeed[3] = mouthsToFeed[3] + 1; // AB
                    }

                    break;

                default:
                    break;
            }
        }

        return mouthsToFeed[6]; // represents "ABC"
    }

}
