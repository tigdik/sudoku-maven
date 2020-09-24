
TO RUN:
===============

1. cd to the project dir


2. execute maven command:

       mvn package

3. remove ".rename" from the file name of the file
     validate.sh.rename if on Mac/Linux
     <BR>or<BR>
     validate.bat.rename if on Windows

4. If on mac or linux you may need to add permissions to validate.sh first: 


       chmod +x validate.sh
     
5. Execute the program:

   Mac/Linux:
      
      
       ./validate.sh  [PATH_TO_INPUT_FILE]
     
   Windows:

       validate.bat [PATH_TO_INPUT_FILE]
