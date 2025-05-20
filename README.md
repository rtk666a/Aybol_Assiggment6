
Assignment #6
Unit 11 - Unit Testing
01 - What is Unit Testing
02 - Test Driven Development
03 - More Unit Test Examples
04 - Java Generics
05 - Java Reflection
06 - Java Annotations
Assignment #7
Unit 12 - Multi-Threading
01 - What is Multi-threading
02 - Running a Task
03 - Understanding Asynchronous Programming
04 - Leveraging Executors
05 - CachedThreadPool
06 - Futures in Java
07 - CompletableFutures in Java
08 - The Default ForkJoinPool with CompletableFutures
09 - Using a Custom Executor with CompletableFutures
10 - Thread Safety with Multi-Threading
Assignment #8
Next Section Locked
At least 75% of the previous section's lessons must be marked as complete
Assignment #6
Assignment #6
Important note for those outside of the USA:  I'm putting this note at the top so that you'll actually read it! If you're outside of the USA, when parsing a date using DateTimeFormatter you'll also need to pass in a Locale for your area (i.e. Locale.CANADA or Locale.UK etc.)


In this assignment you will be analyzing sales data for the sales of Tesla vehicles between 2016 and 2019.

Your job will be to read the data from 3 different CSV files and store that information for analysis and reporting.

You will need to use Java Streams to go through this data and output the following information onto the console:

Note: anywhere you see #### or yyyy-MM, you'll need to output actual numbers / dates based on your analysis.


Model 3 Yearly Sales Report
---------------------------
2017 -> ####
2018 -> ####
2019 -> ####

The best month for Model 3 was: yyyy-MM
The worst month for Model 3 was: yyyy-MM

Model S Yearly Sales Report
---------------------------
2016 -> ####
2017 -> ####
2018 -> ####
2019 -> ####

The best month for Model S was: yyyy-MM
The worst month for Model S was: yyyy-MM

Model X Yearly Sales Report
---------------------------
2016 -> ####
2017 -> ####
2018 -> ####
2019 -> ####

The best month for Model X was: yyyy-MM
The worst month for Model X was: yyyy-MM
The CSV Files
You can download the three CSV files via these links:

https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/model3.csv
https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/modelS.csv
https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/modelX.csv


Hints
You don't need to output this entire report in a single stream.

You'll want to read the data into three separate Lists.

You will likely need to stream through each of the Lists a few times to be able to output all the necessary data in the report.

Remember that grouping data is an important thing to do.
