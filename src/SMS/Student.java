package SMS;

public class Student {
    private String name;
    private String father_name;
    private String mother_name;
    private String roll_number;
    private String course_name;
    private String course_code;
    Student(String name,String father_name,String mother_name,
            String course_name, String course_code){
        this.name=name;
        this.father_name=father_name;
        this.mother_name=mother_name;
        this.roll_number=generateRollNumber();
        this.course_name=course_name;
        this.course_code=course_code;
    }
    private static int currentRollNumber = 0;
    public static String generateRollNumber() {
        currentRollNumber++;
        return "DCS"+currentRollNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", mother_name='" + mother_name + '\'' +
                ", roll_number='" + roll_number + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_code='" + course_code + "}";
    }
    public Student next_student;

}
