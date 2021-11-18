import java.util.ArrayList;
import java.util.List;

public class EncapsulationCollege {
    // Private class variables with getter and setter methods
    private String collegeName;
    private List<String> departments;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public static void main(String[] args) {
        EncapsulationCollege[] e = new EncapsulationCollege[5];

        // Populate details for college using setter methods
        e[0] = new EncapsulationCollege();
        e[0].setCollegeName("IIT Kanpur");
        e[0].setDepartments(new ArrayList<>(List.of( "CSE", "IT", "AERO")));

        e[1] = new EncapsulationCollege();
        e[1].setCollegeName("IIT Madras");
        e[1].setDepartments(new ArrayList<>(List.of( "EC", "EEE")));

        e[2] = new EncapsulationCollege();
        e[2].setCollegeName("IIT Kharagpur");
        e[2].setDepartments(new ArrayList<>(List.of( "IT", "EEE", "AUTO")));

        e[3] = new EncapsulationCollege();
        e[3].setCollegeName("IIT Bombay");
        e[3].setDepartments(new ArrayList<>(List.of( "AERO", "AUTO")));

        e[4] = new EncapsulationCollege();
        e[4].setCollegeName("IIT Delhi");
        e[4].setDepartments(new ArrayList<>(List.of( "IT", "CS", "AUTO")));

        //Get college details using getter method and print
        for(int i=0; i<5; i++) {
            System.out.println("College Name: " + e[i].getCollegeName());
            System.out.println("Departments:");
            for (int j = 0; j < e[i].departments.size(); j++) {
                System.out.println(e[i].getDepartments().get(j));
            }
        }
    }
}
