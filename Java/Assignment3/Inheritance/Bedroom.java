package Inheritance;

public class Bedroom extends Home {
    public String description = "Bedroom";

    @Override
    public void noOfLights() {
        super.noOfLights();
        System.out.println("Number of lights in the Bedroom: 4\n\n");
    }
}
