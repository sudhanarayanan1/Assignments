public class LargestNumber {
    int largest;

    // Overloaded method with 2 arguments
    public int largestNumber(int a, int b) {
        if( a > b)
            largest = a;
        else
            largest = b;
        return largest;
    }

    // Overloaded method with 3 arguments
    public int largestNumber(int a, int b, int c) {
        if(a >= b) {
            if(a >= c)
                largest = a;
            else
                largest = c;
        } else if(b >= c)
                largest = b;
            else
                largest = c;

        return largest;
    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        System.out.println("Largest of 2 numbers is: " + l.largestNumber(5, 8));
        System.out.println("Largest of 3 numbers is: " + l.largestNumber( 9, 4, 7));
    }
}
