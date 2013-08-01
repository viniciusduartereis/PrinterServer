package br.com.company;

public class CircularQueue implements Queue {
    public final int capacity;
    public PrintJob[] jobs;
    public int index;
    public Queue queue;


    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.index = 0;
        this.jobs = new PrintJob[capacity];
    }


    @Override
    public int getNumberOfJobs() {
        return index--;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public void AddBck(PrintJob job) throws QueueException {
        synchronized (this) {
            if (index + 1 > capacity) {
                throw new QueueException("Overflow");
            }

            this.jobs[index] = job;
            notify();
        }
    }

    @Override
    public PrintJob removeFront() throws InterruptedException {
        synchronized (this) {
            if (isEmpty()) {
                wait();
            }
            PrintJob job = this.jobs[0];
            PrintJob aux[] = new PrintJob[capacity];
            System.arraycopy(jobs, 1, aux, 0, index);
            this.jobs = aux;

            if (index > 0) {
                index--;
            }

            notify();
            return job;

        }
    }

}

