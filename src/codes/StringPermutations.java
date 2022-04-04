package codes;

public class StringPermutations {

    /**
     * Helper function to swap characters at 2 positions in the string
     * @param s Source string
     * @param a position to swap
     * @param b position to swap
     * @return Swapped String
     */
    public String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(a, s.charAt(b));
        sb.setCharAt(b, s.charAt(a));
        return sb.toString();
    }

    /**
     * Print all possible permutations of the string
     * @param s Source string to permute
     */
    public void makePermutations(String s) {
        this.makePermutations(s, 0, s.length() - 1);
    }

    /**
     * Prints All Possible permutations of a string
     * @param source The source String to be permuted
     * @param left The left pointer for permuting (default to 0)
     * @param right The right pointer for permuting (default to N - 1)
     */
    public void makePermutations(String source, int left, int right) {
        if(left == right) {
            System.out.println(source);
            return;
        }

        for(int i = left; i <= right; i++) {
            // swap the characters
            source = swap(source, left, i);

            // recurse for other characters
            this.makePermutations(source, left + 1, right);

            // backtrack
            source = swap(source, i, left);
        }
    }
}
