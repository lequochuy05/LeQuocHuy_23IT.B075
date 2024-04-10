
import java.sql.Date;

public class Employee implements IEmployee {
	private String ID;
	private String FullName;
	private Date BirthDay;
	private String Phone;
	private String Email;
	private String Employee_type;
	private int Employee_count;

	public Employee(String iD, String fullName, Date birthDay, String phone, String email, String employee_type,
			int employee_count) {
		super();
		ID = iD;
		FullName = fullName;
		BirthDay = birthDay;
		Phone = phone;
		Email = email;
		Employee_type = employee_type;
		Employee_count = employee_count;
	}

	public Employee(String iD, String fullName, Date birthDay, String phone, String email) {
		super();
		ID = iD;
		FullName = fullName;
		BirthDay = birthDay;
		Phone = phone;
		Email = email;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmployee_type() {
		return Employee_type;
	}

	public void setEmployee_type(String employee_type) {
		Employee_type = employee_type;
	}

	public int getEmployee_count() {
		return Employee_count;
	}

	public void setEmployee_count(int employee_count) {
		Employee_count = employee_count;
	}

	@Override
	public void showInfo() {
		System.out.println("ID: " + this.ID);
		System.out.println("FName: " + this.FullName);
		System.out.println("BirthDay: " + this.BirthDay);
		System.out.println("Phone: " + this.Phone);
		System.out.println("Email: " + this.Email);
		System.out.println("Employee_Type: " + this.Employee_type);
		System.out.println("Employee_Count: " + this.Employee_count);
	}

}
