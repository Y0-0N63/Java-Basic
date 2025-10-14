package model.dto;

public class DatePlan {
	private String applicant;
	private String receiver;
	// YYYYMMDD
	private String date;
	
	public DatePlan() {
		super();
	}

	public DatePlan(String applicant, String receiver, String date) {
		super();
		this.applicant = applicant;
		this.receiver = receiver;
		this.date = date;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		applicant = applicant;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("<데이트 신청 완료: %s -> %s %s (+2점)>", applicant, receiver, date);
	}
}
