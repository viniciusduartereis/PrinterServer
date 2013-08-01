package br.com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class Producer implements Runnable {
    public String name;
    public Queue queue;
    public Scanner scanner;


    public Producer(String name, Queue queue) throws FileNotFoundException {
        this.queue = queue;
        this.name = name;
        this.scanner = new Scanner(new File("./src/jobs.txt"));
    }

    public String getProducerName() {
        return this.name;
    }


    @Override
    public void run() {

        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] jobData = line.split(";");
                PrintJob printJob = new PrintJob(jobData[0], new Integer(jobData[1]));
                System.out.println(String.format("#%s# Producing file '%s', number of pages %s.", getProducerName(), printJob.getJobName(), printJob.getNumberOfPages()));
                queue.AddBck(printJob);
                int SleepTime = (int) (Math.random() * 5) + 1;
                Thread.sleep(SleepTime * 1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (QueueException e) {
            e.printStackTrace();
        }
    }
}
