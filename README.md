# individual-project-cmpe202-03-pragnesh16

1. The Credit Card Application is equipped with different Structural and Behavioural design patterns

2. The design Patterns include Strategy and Factory

3. Factory pattern was used to describe the methodology identifying cardit card type and validating the card number. However, using Factory Pattern might voilate the open/closed principle of design pattern.The designer could easily make mistakes, include boolean methods in the factory and have the factory to determine the card type. The problem here is that, the responsiblity of identifing card type should not be the job of the factory but of the subclass. The primary problem this project was going to solve is the violation of open/closed principle. Therefore, in this project, static method and abstact factory were used to solve this problem, and the boolean method was moved to the concrete classes.

4. This project was extended to parse different input file formats (json, xml, csv). Strategy pattern was used to decide the input file format and therefore which method was going to be used to parse the file and the type of output file

# Class Diagram
![alt text](https://github.com/gopinathsjsu/individual-project-cmpe202-03-pragnesh16/blob/main/images/Class%20Diagram1.png)
