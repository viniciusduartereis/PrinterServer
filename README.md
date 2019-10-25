# PrinterServer

This application uses a form academic to emulate and interpret the service of a printer with a print queue, respected the rule of his circle print.

- Implementations:

Respecting the UML diagram created classes and interface, the application used to develop vectors to receive impressions in class CircularQueue, methods and addBack removeFront to respect the FIFO queue impressions (first in first out), which implements the Queue, used the race condition and synchronized threads for tasks printer and Producers, using the mechanism of the light, the method isEmpty allowed cooperation between printing processes by sending the signal queue wait and notify, the native method java.

- Instructions for compiling and running:

To compile and run the application you need a file called "jobs" extension. Txt in the folder "src", containing the name of the print file and the number of pages, separate by ";".

Ex:

file1.txt;7
file2.pdf;20







