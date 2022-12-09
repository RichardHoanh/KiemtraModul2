import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private Double pointTB;

    public Student() {
    }

    public Student(int id, String name, int age, String gender, String address, Double pointTB) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.pointTB = pointTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPointTB() {
        return pointTB;
    }

    public void setPointTB(Double pointTB) {
        this.pointTB = pointTB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", pointTB=" + pointTB +
                '}';
    }
}
