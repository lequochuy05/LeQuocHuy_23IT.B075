import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EManagement {
	private ArrayList<Employee> listEmployee;
	Scanner sc = new Scanner(System.in);

	public EManagement(ArrayList<Employee> listEmployee) {
		super();
		this.listEmployee = listEmployee;
	}

	public EManagement() {
		this.listEmployee = new ArrayList<Employee>();
	}

	public void addEmployee() {
	    System.out.print("Nhập ID: ");
	    String id = sc.nextLine();
	    System.out.print("Nhập FName: ");
	    String name = sc.nextLine();
	    System.out.print("Nhập ngày sinh(dd-MM-yyyy): ");
	    String dateStr = sc.nextLine();
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	        java.util.Date ngaySinh = format.parse(dateStr);
	        java.sql.Date birthday = new java.sql.Date(ngaySinh.getTime());
	        
	        System.out.print("Nhập sdt: ");
	        String sdt = sc.nextLine();
	        System.out.print("Nhập email: ");
	        String email = sc.nextLine();
	        System.out.print("Nhập loại nhân viên(Experience/Fresher/Intern): ");
	        String loaiNV = sc.nextLine();
	        Employee emp = null;
	        switch (loaiNV) {
	            case "Experience": {
	                emp = addExperience(id, name, birthday, sdt, email);
	                break;
	            }
	            case "Fresher": {
	                emp = addFresher(id, name, birthday, sdt, email);
	                break;
	            }
	            case "Intern": {
	                emp = addIntern(id, name, birthday, sdt, email);
	                break;
	            }
	            default:
	                throw new IllegalArgumentException("Unexpected value: " + loaiNV);
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

	
	private Experience addExperience(String id, String name, Date birthday, String sdt, String email) {
        System.out.print("Số năm kinh nghiệm: ");
        int exp = Integer.parseInt(sc.nextLine()); // Đọc số năm kinh nghiệm
        System.out.print("Kỹ năng chuyên môn: ");
        String proSkill = sc.nextLine(); // Đọc kỹ năng chuyên môn
        return new Experience(id, name, birthday, sdt, email, exp, proSkill);
    }
	
	private Fresher addFresher(String id, String name, Date ngaySinh, String sdt, String email) {
	    System.out.print("Thoi gian tot nghiep: ");
	    String tgTotNghiepStr = sc.nextLine();
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    Date tgTotNghiep = null;
	    String xloai = "";
	    String truong = "";
	    try {
	        tgTotNghiep = (Date) format.parse(tgTotNghiepStr);
	        System.out.print("Xếp loại tốt nghiệp: ");
	        xloai = sc.nextLine(); 
	        System.out.print("Trường tốt nghiệp: ");
	        truong = sc.nextLine();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    return new Fresher(id, name, ngaySinh, sdt, email, tgTotNghiep, xloai, truong);
	}
	
	private Intern addIntern(String id, String name, Date ngaySinh, String sdt, String email) {
		System.out.print("Chuyên nganh dang hoc: ");
		String chuyenNganh = sc.nextLine();
		System.out.print("Hoc ki: ");
		int hki = Integer.parseInt(sc.nextLine());
		System.out.print("Truong dai hoc: ");
		String truong = sc.nextLine();
		
		return new Intern(id, name, ngaySinh, sdt, email, chuyenNganh, hki, truong);
	}
	
	 public void deleteEmployee() {
	        System.out.print("Nhập ID nhân viên cần xóa: ");
	        String id = sc.nextLine();
	        Employee employeeToRemove = null;
	        for (Employee emp : listEmployee) {
	            if (emp.getID().equals(id)) {
	                employeeToRemove = emp;
	                break;
	            }
	        }
	        if (employeeToRemove != null) {
	            listEmployee.remove(employeeToRemove);
	            System.out.println("Nhân viên có ID " + id + " đã được xóa khỏi danh sách.");
	        } else {
	            System.out.println("Không tìm thấy nhân viên có ID " + id);
	        }
	    }
	 
	 public void editEmployee() {
	        System.out.print("Nhập ID nhân viên cần sửa: ");
	        String id = sc.nextLine();
	        for (Employee emp : listEmployee) {
	            if (emp.getID().equals(id)) {
	                System.out.println("Chọn thông tin cần sửa:");
	                System.out.println("1. Full Name");
	                System.out.println("2. Ngày sinh");
	                System.out.println("3. Số điện thoại");
	                System.out.println("4. Email");
	                int choice = Integer.parseInt(sc.nextLine());
	                switch (choice) {
	                    case 1:
	                        System.out.print("Nhập tên mới: ");
	                        String newName = sc.nextLine();
	                        emp.setFullName(newName);
	                        break;
	                    case 2:
	                        System.out.print("Nhập ngày sinh mới (dd-MM-yyyy): ");
	                        String newBirthdayStr = sc.nextLine();
	                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	                        try {
	                            Date newBirthday = new Date(dateFormat.parse(newBirthdayStr).getTime());
	                            emp.setBirthDay(newBirthday);
	                        } catch (ParseException e) {
	                            System.out.println("Định dạng ngày không hợp lệ!");
	                        }
	                        break;
	                    case 3:
	                        System.out.print("Nhập số điện thoại mới: ");
	                        String newPhone = sc.nextLine();
	                        emp.setPhone(newPhone);
	                        break;
	                    case 4:
	                        System.out.print("Nhập email mới: ");
	                        String newEmail = sc.nextLine();
	                        emp.setEmail(newEmail);
	                        break;
	                    default:
	                        System.out.println("Lựa chọn không hợp lệ!");
	                        break;
	                }
	                System.out.println("Thông tin của nhân viên có ID " + id + " đã được cập nhật.");
	                return;
	            }
	        }
	        System.out.println("Không tìm thấy nhân viên có ID " + id);
	    }

	public void displayEmployeeList() {
		System.out.println("Danh sách nhân viên:");
	    for (Employee employee : listEmployee) {
	        employee.showInfo();
	    }
	}
	
	public void writeEmployeeToFile(String fileName) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        for (Employee emp : listEmployee) {
	            writer.write(emp.toString()); // Ghi thông tin nhân viên vào file
	            writer.newLine(); // Xuống dòng cho nhân viên tiếp theo
	        }
	        System.out.println("Thông tin nhân viên đã được ghi vào file " + fileName);
	    } catch (IOException e) {
	        System.out.println("Đã xảy ra lỗi khi ghi vào file.");
	        e.printStackTrace();
	    }
	}
	


}
