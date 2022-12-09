import java.util.Comparator;

public class SortStudentByPoint implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getPointTB() > o2.getPointTB()) {
            return 1;
        } else if (o1.getPointTB() < o2.getPointTB()) {
            return -1;
        } else {
            return 0;
        }
    }
}
