package br.com.company;


public class PrintJob {

    public String jobName;
    public int NumberOfPages;


    public PrintJob(String jobName, int NumberOfPages) {
        this.jobName = jobName;
        this.NumberOfPages = NumberOfPages;
    }

    public String getJobName() {
        return this.jobName;

    }

    public Integer getNumberOfPages() {
        return NumberOfPages;
    }


}


