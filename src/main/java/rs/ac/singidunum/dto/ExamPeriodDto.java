package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.ExamPeriod;

public class ExamPeriodDto {
	
	private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ExamPeriodDto() {}

    public ExamPeriodDto(ExamPeriod period) {
        this.id = period.getId();
        this.name = period.getName();
        this.startDate = period.getStartDate();
        this.endDate = period.getEndDate();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	
}
