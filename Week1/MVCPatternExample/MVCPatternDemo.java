// MVCPatternDemo.java
public class MVCPatternDemo {
    public static void main(String[] args) {
        // Create a model
        Student model = new Student("John Doe", 1, "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        controller.updateView();

        // Update the model data
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");

        // Display updated details
        controller.updateView();
    }
}
