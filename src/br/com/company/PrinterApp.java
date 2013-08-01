package br.com.company;

import java.io.FileNotFoundException;

public class PrinterApp {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Queue queue = new CircularQueue(40);
        Printer printer = new Printer("Printer", queue);
        Producer producer = new Producer("Producer", queue);
        Producer producer1 = new Producer("Producer1", queue);
        Thread threadProducer = new Thread(producer);
        Thread threadProducer1 = new Thread(producer1);
        Thread threadPrinter = new Thread(printer);
        threadPrinter.start();
        threadProducer.start();
        threadProducer1.start();
        threadProducer.join();
        threadProducer1.join();
        printer.halt();
    }
}
