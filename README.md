# Assignment
This repository contains four classes: 
  - ProcessFiles: preforms the statistical operations on a file
  - InputCleaner: will clean the contents of the file so ProcessFiles class can perform its operations without error
  - FileInfo: stores the details about the file that is to be processed such as the path, file contents and each word
  - Main: main simply shows an example of the library working

To abide by the SOLID design principles, the ProcessFiles class contains objects of InputCleaner and FileInfo

A singleton design pattern was used for the object of the InputCleaner to save memory.  

  
