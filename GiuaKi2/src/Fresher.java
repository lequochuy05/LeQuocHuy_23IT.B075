import java.sql.Date;

public class Fresher extends Employee {
	private Date Graduation_date; // Thoi gian tot nghiep
	private String Graduation_rank; // Xep loai tot nghiep
	private String Education; // Truong tot nghiep

	public Fresher(String iD, String fullName, Date birthDay, String phone, String email, Date graduation_date, String graduation_rank, String education) {
		super(iD, fullName, birthDay, phone, email);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Thoi gian tot nghiep: "+this.Graduation_date);
		System.out.println("Xep loai tot nghiep: "+this.Graduation_rank);
		System.out.println("Truong tot nghiep: "+this.Education);
	}
}
