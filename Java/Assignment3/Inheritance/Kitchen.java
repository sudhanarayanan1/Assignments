package Inheritance;

public class Kitchen extends Home {
    public String description = "Kitchen";

    @Override
    public void noOfLights() {
        System.out.println("Number of lights in the Kitchen: 3\n\n");
    }
}
