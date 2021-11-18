public class PolymorphismPlusOperator {

    public int addingVariables(int a, int b) {
        return a+b;
    }

    public  String addingVariables(String x, String y) {
        return  x+y;
    }

    public static void main(String[] args) {
        PolymorphismPlusOperator p = new PolymorphismPlusOperator();
        System.out.println("Sum of 2 numbers is " + p.addingVariables(2, 3));
        System.out.println("Concatenation of 2 strings is: " + p.addingVariables("Hello", " World"));
    }
}
