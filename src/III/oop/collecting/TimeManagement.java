package III.oop.collecting;

import java.util.LinkedList;
import java.util.Queue;

public class TimeManagement {

    public static void main(String[] args) {
        Queue<Employee> emplyees = new LinkedList<>();
        emplyees.add(new Employee("Larry", 480, 28));
        emplyees.add(new Employee("Barry", 412, 40));
        emplyees.add(new Employee("Garry", 510, 36));

        emplyees.peek(); //enqueue
        emplyees.poll(); //dequeue
//        emplyees.offer();

        Queue<Task> tasks = new LinkedList<>();
        tasks.add(new Task("Exchange cables", 60));
        tasks.add(new Task("Update OS", 45));
        tasks.add(new Task("Install antivirus", 30));
        tasks.add(new Task("Replace hard drive", 120));
        tasks.add(new Task("Clean workstation", 20));
        tasks.add(new Task("Configure network", 90));
        tasks.add(new Task("Test hardware", 50));
        tasks.add(new Task("Set up printer", 25));
        tasks.add(new Task("Troubleshoot Wi-Fi", 35));
        tasks.add(new Task("Backup files", 75));
        tasks.add(new Task("Assemble PC", 150));
        tasks.add(new Task("Optimize performance", 40));
        tasks.add(new Task("Create user accounts", 15));
        tasks.add(new Task("Train new staff", 180));
        tasks.add(new Task("Remove malware", 55));
        tasks.add(new Task("Upgrade RAM", 25));
        tasks.add(new Task("Set up email client", 20));
        tasks.add(new Task("Reset passwords", 10));
        tasks.add(new Task("Patch security vulnerabilities", 80));
        tasks.add(new Task("Calibrate display", 30));

        while (!tasks.isEmpty() && !emplyees.isEmpty()){
            Employee top = emplyees.peek();
            Task currentTask = tasks.peek();

            System.out.println(top);
            System.out.println("Doing task: " + currentTask.taskName + ", duration: " + currentTask.completitionTime);
            if (top.freeTime >= currentTask.completitionTime){
                //splni ukol za cas
                top.freeTime -= currentTask.completitionTime;
                //splni ukol, ukol jde z fronty ukolu
                tasks.poll();
                System.out.println(top.name + " did task " + currentTask.taskName);
            }else{
                emplyees.poll();
                System.out.println(top.name + " coulnt finish the task due to his time management");
            }
        }

    }
}
class Employee{
    String name;
    int freeTime,shoesize;

    public Employee(String name, int freeTime, int shoesize) {
        this.name = name;
        this.freeTime = freeTime;
        this.shoesize = shoesize;
    }

    @Override
    public String toString() {
        return "Employee " + name + " has time: " + freeTime + ". Btw his shoesize is " + shoesize;
    }
}
class Task {
    String taskName;
    int completitionTime;

    public Task(String taskName, int taskCompletitionTime) {
        this.taskName = taskName;
        this.completitionTime = taskCompletitionTime;
    }
}
