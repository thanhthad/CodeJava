public class Student_Management {
    private int ID_Student;
    private String Name_Student;
    private double Mark_Student;

    public Student_Management(int id_Student, String name_Student, double mark_Student) {
        this.ID_Student = id_Student;
        this.Name_Student = name_Student;
        this.Mark_Student = mark_Student;
    }

    public void Student_Ranking() {
        if (Mark_Student >= 0 && Mark_Student < 5.0) {
            System.out.println("Rank: Fail");
        } else if (Mark_Student >= 5.0 && Mark_Student < 6.5) {
            System.out.println("Rank: Medium");
        } else if (Mark_Student >= 6.5 && Mark_Student < 7.5) {
            System.out.println("Rank: Good");
        } else if (Mark_Student >= 7.5 && Mark_Student < 9.0) {
            System.out.println("Rank: Very Good");
        } else {
            System.out.println("Rank: Excellent");
        }
    }

    public int getID_Student() {
        return ID_Student;
    }

    public String getName_Student() {
        return Name_Student;
    }

    public double getMark_Student() {
        return Mark_Student;
    }

    public void setID_Student(int ID_Student) {
        this.ID_Student = ID_Student;
    }

    public void setName_Student(String name_Student) {
        Name_Student = name_Student;
    }

    public void setMark_Student(double mark_Student) {
        Mark_Student = mark_Student;
    }
}
