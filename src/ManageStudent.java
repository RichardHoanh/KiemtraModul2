import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageStudent {
    static ArrayList<Student> students = ReadAndWrite.read();
    static Scanner scanner = new Scanner(System.in);

    public static void showStudent() {
        System.out.printf("%-25s%-15s%-25s%-15s%-15s%-15s%-15s\n", "", "Mã sinh viên", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
        for (int i = 0; i < students.size(); i++) {
            Student p = students.get(i);
            System.out.printf("%-25s%-15s%-25s%-15d%-15s%-15s%-15f\n", "", p.getId(), p.getName(), p.getAge(), p.getGender(), p.getAddress(), p.getPointTB());
        }
        System.out.println("Nhấn Enter để tiếp tục!");
        scanner.nextLine();
    }

    public static Student createStudent() {
        int id;
        String name, gender, address;
        int age;
        double pointTB;

        do {
            try {
                System.out.println("Nhập vào mã sinh viên");
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    break;
                } else {
                    System.out.println("id phải là số tự nhiên khác 0");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Mã sinh viên phải là số!");
            }
        } while (true);

        System.out.println("Nhập vào tên sinh viên");
        name = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập vào tuổi sinh viên");
                age = Integer.parseInt(scanner.nextLine());
                if (age < 100 && age > 17) {
                    break;
                } else {
                    System.out.println("Tuổi từ 18 đến 99");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Tuổi phải là số!");
            }
        } while (true);
        System.out.println("Nhập vào giới tính sinh viên");
        gender = scanner.nextLine();
        System.out.println("Nhập vào địa chỉ sinh viên");
        address = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập vào điểm trung bình của sinh viên");
                pointTB = Double.parseDouble(scanner.nextLine());
                if (pointTB <= 10 && pointTB >= 0) {
                    break;
                } else {
                    System.out.println("Tuổi từ 0 đến 10");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Điểm phải là số!");
            }
        } while (true);
        return new Student(id, name, age, gender, address, pointTB);

    }

    public static void addStudent() {
        Student student = createStudent();
        students.add(student);
        System.out.println("Bạn đã thêm mới sinh viên thành công!");
        System.out.println("Nhấn Enter để tiếp tục!");
        scanner.nextLine();

    }

    public static int findIndexById() {
        int id;
        do {
            try {
                System.out.println("Nhập vào mã sinh viên");
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    break;
                } else {
                    System.out.println("id phải là số tự nhiên khác 0");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Mã sinh viên phải là số!");
            }
        } while (true);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }

        }

        return -1;
    }

    public static void edit() {
        int index;
        index = findIndexById();
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên");
        } else {
            System.out.println("Tìm thấy sinh viên có thông tin như sau:");
            System.out.printf("%-25s%-15s%-25s%-15s%-15s%-15s%-15s\n", "", "Mã sinh viên", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
            Student p = students.get(index);
            System.out.printf("%-25s%-15s%-25s%-15d%-15s%-15s%-15f\n", "", p.getId(), p.getName(), p.getAge(), p.getGender(), p.getAddress(), p.getPointTB());
            System.out.println(students.get(index).toString());
        }
        Student student = createStudent();
        students.set(index, student);
        System.out.println("Nhấn Enter để tiếp tục!");
        scanner.nextLine();

    }

    public static void delete() {
        int index;
        index = findIndexById();
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên");
        } else {
            System.out.println("Tìm thấy sinh viên có thông tin như sau:");
            System.out.printf("%-25s%-15s%-25s%-15s%-15s%-15s%-15s\n", "", "Mã sinh viên", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
            Student p = students.get(index);
            System.out.printf("%-25s%-15s%-25s%-15d%-15s%-15s%-15f\n", "", p.getId(), p.getName(), p.getAge(), p.getGender(), p.getAddress(), p.getPointTB());

        }
        System.out.println("Bạn có muốn xóa sinh viên này không? Nếu có nhấn EnTer để xóa");
        scanner.nextLine();
        students.remove(index);
        System.out.println("Nhấn Enter để tiếp tục!");
        scanner.nextLine();
    }

    public static void menuSapxep() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("<----------Sắp xếp theo điểm trung bình---------->");
            System.out.println("""
                    1. Sắp xếp điểm trung bình tăng dần
                    2. Sắp xếp điểm trung bình giảm dần                                                 
                    3. Thoát""");
            int choice;
            do {
                try {
                    System.out.print("Mời nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Lựa chọn phải là số!");
                }
            } while (true);
            switch (choice) {
                case 1:
                    Collections.sort(students, new SortStudentByPoint());
                    showStudent();

                    break;
                case 2:
                    Collections.reverse(students);
                    showStudent();

                    break;
                case 3:
                    return;
            }
        }

    }


}
