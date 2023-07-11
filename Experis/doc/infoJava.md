###### WINDOWS TERMINAL -> GITBASH TERMINAL

* dir -> ls
* cd -> cd
* type -> cat
* ren -> mv
* move -> mv
* copy -> cp

---

* javac fileName.java - compile
* java fileName - run application

---
Integer.valueOf("123"); - returns an Integer object
Integer.parseInt("123"); - This method returns a primitive int
---

# logging.Level

* Level.ALL - ALL indicates that all messages should be logged.
* Level.CONFIG - CONFIG is a message level for static configuration messages.
* Level.FINE - FINE is a message level providing tracing information.
* Level.FINER - FINER indicates a fairly detailed tracing message.
* Level.FINEST - FINEST indicates a highly detailed tracing message.
* Level.INFO - INFO is a message level for informational messages.
* Level.OFF - OFF is a special level that can be used to turn off logging.
* Level.SEVERE - SEVERE is a message level indicating a serious failure.
* Level.WARNING - WARNING is a message level indicating a potential problem.

---
    The expression input.charAt(i) - '0' is used to convert a character representing a digit to its corresponding integer value. In Java, characters are represented using Unicode values, where the characters '0' to '9' have consecutive Unicode values. By subtracting the Unicode value of '0' from the Unicode value of the character, we can obtain the numeric value represented by that character.
    For example:
    '0' - '0' will give 0
    '1' - '0' will give 1