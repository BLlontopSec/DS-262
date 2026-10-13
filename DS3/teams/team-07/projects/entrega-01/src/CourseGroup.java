public class CourseGroup
{
    private String courseCode;
    private String courseName;
    private String groupNumber;
    private int availableSeats;

    public CourseGroup(String courseCode, String courseName, String groupNumber, int availableSeats) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.groupNumber = groupNumber;
        this.availableSeats = availableSeats;
    }

    public boolean occupySeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
}