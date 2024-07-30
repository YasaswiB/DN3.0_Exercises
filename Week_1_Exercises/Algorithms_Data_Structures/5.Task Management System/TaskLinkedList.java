package taskManagementSystem;

public class TaskLinkedList {
	private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; 
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next; 
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next; 
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task(1, "Task_1", "Incomplete"));
        taskList.addTask(new Task(2, "Task_2", "Complete"));
        taskList.addTask(new Task(3, "Task_3", "Working on it"));

        // Traversing tasks
        System.out.println("All tasks:");
        taskList.traverse();

        // Searching for a task
        System.out.println("Searching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        System.out.println("Deleting Task with ID 1:");
        boolean isDeleted = taskList.deleteTask(1);
        if (isDeleted) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
        System.out.println("All tasks after deletion:");
        taskList.traverse();
    }
}
