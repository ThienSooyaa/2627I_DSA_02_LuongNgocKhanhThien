package Week4.Homework.ProgrammingTask;
import java.util.*;
class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        // 1. So sánh giảm dần theo CGPA
        int compareCGPA = Double.compare(y.getCgpa(), x.getCgpa());
        if (compareCGPA != 0) {
            return compareCGPA;
        }
        
        // 2. Nếu CGPA bằng nhau, so sánh tăng dần theo tên (alphabet)
        int compareName = x.getFname().compareTo(y.getFname());
        if (compareName != 0) {
            return compareName;
        }
        
        // 3. Nếu tên giống nhau, so sánh giảm dần theo ID
        return Integer.compare(y.getId(), x.getId());
    }
}

public class StudentSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số lượng sinh viên
        int testCases = 0;
        if (scanner.hasNextInt()) {
            testCases = scanner.nextInt();
        }
        
        List<Student> studentList = new ArrayList<>();
        
        // Nhập thông tin từng sinh viên
        for (int i = 0; i < testCases; i++) {
            int id = scanner.nextInt();
            String fname = scanner.next();
            double cgpa = scanner.nextDouble();
            
            Student student = new Student(id, fname, cgpa);
            studentList.add(student);
        }
        scanner.close();

        // Sắp xếp danh sách sử dụng Comparator đã định nghĩa
        Collections.sort(studentList, new StudentComparator());

        // In kết quả tên sinh viên sau khi sắp xếp
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
