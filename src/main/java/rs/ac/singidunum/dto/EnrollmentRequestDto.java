package rs.ac.singidunum.dto;

import java.util.List;

public class EnrollmentRequestDto {
    
    private String studentIndex;
    
    private List<Long> studyProgramIds;
    
    private int year;

    public EnrollmentRequestDto() {
    }

    public EnrollmentRequestDto(String studentIndex, List<Long> studyProgramIds, int year) {
        this.studentIndex = studentIndex;
        this.studyProgramIds = studyProgramIds;
        this.year = year;
    }

    public String getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(String studentIndex) {
        this.studentIndex = studentIndex;
    }

    public List<Long> getStudyProgramIds() {
        return studyProgramIds;
    }

    public void setStudyProgramIds(List<Long> studyProgramIds) {
        this.studyProgramIds = studyProgramIds;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}