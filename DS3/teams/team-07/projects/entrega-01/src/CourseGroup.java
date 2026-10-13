/**
 * Grupo de una asignatura con un cupo máximo.
 * Por ahora solo controla los cupos; los inscritos y la lista de espera por
 * prioridad se agregan cuando estén LinkedList y SortedLinkedPriorityQueue.
 */
public class CourseGroup
{
    private String courseCode;
    private String courseName;
    private String groupNumber;
    private int availableSeats;

    public CourseGroup(String courseCode, String courseName, String groupNumber, int availableSeats) {
        if (availableSeats < 0) throw new IllegalArgumentException("El cupo no puede ser negativo");
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.groupNumber = groupNumber;
        this.availableSeats = availableSeats;
    }

    /** Ocupa un cupo si hay disponible. O(1). */
    public boolean occupySeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getGroupNumber() {
        return groupNumber;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
}
