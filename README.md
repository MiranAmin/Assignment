# Assignment
This repository contains two classes: 
  - ProcessFiles: preforms the statistical operations on a file
  - InputCleaner: will clean the contents of the file so ProcessFiles class can perform its operations without error

The ProcessFiles class contains an object of the InputCleaner class and uses it's methods
in order to perform its own methods without cluttering up the code.

A singleton design pattern was used for the object of the InputCleaner to save memory.  

  
