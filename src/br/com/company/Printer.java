package br.com.company;

public class Printer implements Runnable {
    public String name;
    public Queue queue;
    private boolean halt = false;
    public final long MILLIS_PER_PAGE = 500;


    public Printer(String name, Queue queue) {
        this.name = name;
        this.queue = queue;

    }

    public void halt() {

        this.halt = true;

    }

    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.println(String.format("[%s]: Turn on...", getPrinterName()));
        System.out.println(String.format("[%s]: Waiting for print job", getPrinterName()));
        try {
            PrintJob job;
            while (!halt && (job = queue.removeFront()) != null) {
                System.out.println(String.format("[%s]: Printing '%s'...", getPrinterName(), job.getJobName()));
                long sleepTime = job.getNumberOfPages() * MILLIS_PER_PAGE;
                Thread.sleep(sleepTime);
                System.out.println(String.format("[%s]: '%s' ok.", getPrinterName(), job.getJobName()));
                System.out.println(String.format("[%s]: Waiting for print job", getPrinterName()));
            }
            System.out.println(String.format("[%s]: Turn off", getPrinterName()));
        } catch (InterruptedException ignored) {

        }
    }
}
