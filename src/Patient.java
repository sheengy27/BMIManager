/**
 * Patient - represents the details of a individual patient.
 * Created by Jason on 13/03/2015.
 */
public class Patient {
    private String name;
    private int age;
    private double height, weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDetails(double height, double weight) {
        this.weight = weight;
        this.height = height;
    }

    public double getBMI() {
        return weight / Math.pow(height, 2);
    }
}

