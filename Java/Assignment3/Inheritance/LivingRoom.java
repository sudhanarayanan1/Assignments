package Inheritance;

public class LivingRoom extends Home {
    public String description = "Living";

    @Override
    public void noOfLights() {
        super.noOfLights();
        System.out.println("Number of lights in Living Room: 3\n\n");
    }
}
