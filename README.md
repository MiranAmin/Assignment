# Assignment
This repository contains four classes: 
  - FileStatistics.java: preforms the statistical operations on a file
  - InputCleaner.java: will clean the contents of the file so ProcessFiles class can perform its operations without error
  - FileDetails.java: stores the details about the file that is to be processed such as the path, file contents and each word
  - Main.java: main simply shows an example of the library working

To abide by the SOLID design principles, the FileStatistics class contains objects of InputCleaner class and FileDetails class 

A singleton design pattern was used for the object of the InputCleaner to save memory.  

  
