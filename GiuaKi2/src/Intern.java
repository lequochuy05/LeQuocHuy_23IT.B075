import java.sql.Date;

public class Intern extends Employee{
private String Majors; //  Chuyên ngành đang học (Majors)
private int Semester; // Hoc ki dang hoc
private String University_name; //Ten truong dang hoc
public Intern(String iD, String fullName, Date birthDay, String phone, String email,
		 String majors, int semester, String university_name) {
	super(iD, fullName, birthDay, phone, email);
	Majors = majors;
	Semester = semester;
	University_name = university_name;
}
@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Chuyên ngành đang học: "+this.Majors);
		System.out.println("Hoc ki dang hoc: "+this.Semester);
		System.out.println("Truong dang hoc: "+this.University_name);
	}
}
