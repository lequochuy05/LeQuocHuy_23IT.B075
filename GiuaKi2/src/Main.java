import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EManagement management = new EManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== Quản lý nhân viên =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Sửa thông tin nhân viên");
            System.out.println("4. Hiển thị danh sách nhân viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    management.addEmployee();
                    break;
                case 2:
                    management.deleteEmployee();
                    break;
                case 3:
                    management.editEmployee();
                    break;
                case 4:
                    management.displayEmployeeList();
                    break;
                case 5:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
    
    
}

