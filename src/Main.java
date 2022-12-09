import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("<----------MENU---------->");
            System.out.println("""
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp sinh viên theo điểm trung bình
                    6. Đọc từ file
                    7. Ghi vào file                       
                    8. Thoát""");
            int choice;
            do {
                try {
                    System.out.print("Mời nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 9 && choice > 0){
                        break;
                    } else {
                        System.out.println("Nhập lựa chọn từ 1-8");
                    }


                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Lựa chọn phải là số!");
                }
            } while (true);
            switch (choice) {
                case 1:
                    ManageStudent.showStudent();

                    break;
                case 2:
                    ManageStudent.addStudent();

                    break;
                case 3:
                    ManageStudent.edit();

                    break;
                case 4:
                    ManageStudent.delete();

                    break;
                case 5:
                    ManageStudent.menuSapxep();

                    break;
                case 6:
                    ReadAndWrite.read();

                    break;
                case 7:
                    ReadAndWrite.write(ManageStudent.students);

                    break;
                case 8:


                    System.exit(0);
            }
        }

    }
}