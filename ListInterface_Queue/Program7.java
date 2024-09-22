package assignment5.ListInterface_Queue;

import java.util.PriorityQueue;

class PrintJob implements Comparable<PrintJob> {
    private String jobName;
    private int priority;

    public PrintJob(String jobName, int priority) {
        this.jobName = jobName;
        this.priority = priority;
    }

    public String getJobName() {
        return jobName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PrintJob other) {
        return Integer.compare(other.priority, this.priority);
    }
}

class PrinterQueue {
    private PriorityQueue<PrintJob> queue;

    public PrinterQueue() {
        queue = new PriorityQueue<>();
    }

    public void addJob(PrintJob job) {
        queue.offer(job);
    }

    public void printJobs() {
        while (!queue.isEmpty()) {
            PrintJob job = queue.poll();
            System.out.println("Printing job: " + job.getJobName() + " with priority: " + job.getPriority());
        }
    }
}

public class Program7 {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        printerQueue.addJob(new PrintJob("Document1", 2));
        printerQueue.addJob(new PrintJob("Document2", 5));
        printerQueue.addJob(new PrintJob("Document3", 1));
        printerQueue.addJob(new PrintJob("Document4", 3));

        printerQueue.printJobs();
    }
}
