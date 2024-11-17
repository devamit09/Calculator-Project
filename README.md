# Calculator-Project

 1. Project Overview
              The Responsive Calculator is a graphical user interface (GUI)-based application built using Java Swing and AWT. It allows users to perform basic arithmetic operations (addition, subtraction, multiplication, division, percentage, etc.) with a responsive and visually appealing interface. The application also displays the operation being performed on the screen.
________________________________________
2. Features
•	Basic Arithmetic Operations: Addition, subtraction, multiplication, division.
•	Additional Functions:
o	Percentage calculation.
o	Toggle for positive/negative numbers.
o	Clear (AC) functionality.
•	Operation Display: Shows the current calculation in progress.
•	Fully Responsive UI: Adapts to various screen sizes.
•	Modern Design: Styled buttons and color-coded operations for user-friendliness.
________________________________________
3. Technology Stack
•	Programming Language: Java
•	Frameworks: Java Swing, AWT
•	IDE: Eclipse IDE (can also be run in IntelliJ IDEA or other Java IDEs)
________________________________________
4. Prerequisites
•	JDK: Install Java Development Kit (JDK) version 8 or above.
•	IDE: Install Eclipse or any Java-compatible IDE.
•	Environment Variables: Ensure JAVA_HOME is set correctly.
________________________________________
5. Class Design
Main Class: ResponsiveCalculatorWithOperations
Attributes:
•	JTextField display: Displays the current number or result.
•	JLabel operationLabel: Shows the current operation being performed.
•	String currentInput: Stores the current input from the user.
•	String currentOperation: Keeps track of the entire operation (e.g., "7 +").
•	double num1, num2, result: Store operands and the result of operations.
•	char operator: Holds the operator (+, -, ×, ÷).
________________________________________
Methods
1. Constructor
•	Initializes the UI components.
•	Sets up a JPanel for buttons using GridBagLayout for responsiveness.
•	Defines button styles and listeners.
2. actionPerformed(ActionEvent e)
             Handles button clicks based on the label:
•	Number Buttons (0-9): Appends to currentInput and updates the display.
•	Decimal Button (.): Adds a decimal point if it doesn't exist in currentInput.
•	Operators (+, -, ×, ÷):
o	Stores the first operand (num1).
o	Updates the operator and resets currentInput.
•	Equals (=):
o	Computes the result based on the operator.
o	Updates the operationLabel and display with the result.
•	AC (All Clear):
o	Resets all variables and clears the display.
•	+/- (Toggle Sign): Changes the sign of the current input.
•	% (Percentage): Divides the current input by 100.
________________________________________
6. How to Run
1.	Clone or Create the Project:
o	Copy the Java code into a new class file in your IDE.
2.	Run the Application:
o	Execute the program using the IDE's "Run" button.
3.	Test the Calculator:
o	Perform various operations to verify functionality.
________________________________________
7. Screenshots
              1. Main Screen: A fully responsive calculator with buttons for digits, operations, and additional functions.
               2. Example Usage:
•	Input: 7, +, 8, =.
•	Output on the display: 15.
•	Operation Label: 7 + 8 =.
________________________________________
8. Future Enhancements
1.	Advanced Functions:
o	Add scientific calculator features (e.g., trigonometry, logarithms).
2.	History:
o	Store and display past calculations.
3.	Error Handling:
o	Improve handling of invalid operations (e.g., divide by zero).
4.	Themes:
o	Add light/dark mode toggle.
________________________________________
9. Common Errors and Solutions
1.	UI Does Not Display Properly:
o	Ensure all import statements are included (javax.swing.*, java.awt.*).
2.	Button Clicks Not Registered:
o	Verify that actionPerformed is implemented and buttons have listeners attached.
3.	Division by Zero:
o	Handle this edge case explicitly in the code to avoid exceptions.
________________________________________
10. Acknowledgments
           This project was built as an educational demonstration of:
•	Java GUI programming using Swing and AWT.
•	Object-Oriented Programming (OOP) principles.
________________________________________
11. Conclusion
              This project demonstrates the power of Java for creating interactive GUI-based applications. It provides a robust and user-friendly calculator interface suitable for basic arithmetic operations.
