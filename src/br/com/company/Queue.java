package br.com.company;

public interface Queue {

    public void AddBck(PrintJob job) throws QueueException;

    public PrintJob removeFront() throws InterruptedException;

    public boolean isEmpty();

    public int getNumberOfJobs();

}
