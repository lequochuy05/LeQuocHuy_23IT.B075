import java.sql.Date;

public class Experience extends Employee {
	private int ExpInYear; // so nam kinh nghiem
	private String ProSkill; // ki nang chuyen mon
	public Experience(String iD, String fullName, Date birthDay, String phone, String email, int expInYear, String proSkill) {
		super(iD, fullName, birthDay, phone, email);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

	@Override
	public void showInfo() {
		System.out.println("So nam kinh nghiem: "+this.ExpInYear);
		System.out.println("Ki nang chuyen mon: "+this.ProSkill);
	}

}
