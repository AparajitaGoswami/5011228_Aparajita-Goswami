package DSA;

public class Ex5_TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        
        taskManager.addTask(new Task("T001", "Complete project documentation", "Pending"));
        taskManager.addTask(new Task("T002", "Review code", "In Progress"));
        taskManager.addTask(new Task("T003", "Team meeting", "Pending"));

        System.out.println("All Tasks:");
        taskManager.traverseTasks();

        System.out.println("\nSearching for Task T002:");
        Task task = taskManager.searchTask("T002");
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task T002:");
        taskManager.deleteTask("T002");
        taskManager.traverseTasks();
    }

    static class Task {
        private String taskId;
        private String taskName;
        private String status;
        private Task next; 

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Task getNext() {
            return next;
        }

        public void setNext(Task next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "TaskID: " + taskId + ", TaskName: " + taskName + ", Status: " + status;
        }
    }

    static class TaskManager {
        private Task head; // Head of the list

        public TaskManager() {
            this.head = null; 
        }

        // Add a new task to the end of the list
        public void addTask(Task newTask) {
            if (head == null) {
                head = newTask;
            } else {
                Task current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newTask);
            }
        }

        // Search for a task by taskId
        public Task searchTask(String taskId) {
            Task current = head;
            while (current != null) {
                if (current.getTaskId().equals(taskId)) {
                    return current;
                }
                current = current.getNext();
            }
            return null; // Task not found
        }

        // Traverse and print all tasks
        public void traverseTasks() {
            Task current = head;
            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }

        // Delete a task by taskId
        public void deleteTask(String taskId) {
            if (head == null) {
                return; // List is empty
            }

            if (head.getTaskId().equals(taskId)) {
                head = head.getNext(); // Delete the head task
                return;
            }

            Task current = head;
            while (current.getNext() != null) {
                if (current.getNext().getTaskId().equals(taskId)) {
                    current.setNext(current.getNext().getNext()); // Remove the task
                    return;
                }
                current = current.getNext();
            }
        }
    }
}

