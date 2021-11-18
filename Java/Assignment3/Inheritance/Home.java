package Inheritance;

public class Home {
    public String title = "Room details: ";

    public void noOfLights() {
        System.out.println("Light Details:");
    }

    public static void main(String[] args) {
        LivingRoom l = new LivingRoom();
        System.out.println(l.title +  l.description);
        l.noOfLights();

        Kitchen k = new Kitchen();
        System.out.println(k.title +  k.description);
        k.noOfLights();

        Bedroom b = new Bedroom();
        System.out.println(b.title +  b.description);
        b.noOfLights();
    }
}
