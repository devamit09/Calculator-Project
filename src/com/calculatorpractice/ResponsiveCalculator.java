package com.calculatorpractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResponsiveCalculator extends JFrame implements ActionListener {

    private JTextField display; // Display for the result
    private JLabel operationLabel; // Label for showing the operation in progress
    private String currentInput = "";
    private String currentOperation = ""; // To store the full operation (e.g., "7 ×")
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor
    public ResponsiveCalculator() {
        setTitle("Calculator@Made by Amit");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(300, 500)); // Minimum size for responsiveness

        // Operation Label
        operationLabel = new JLabel("", SwingConstants.RIGHT);
        operationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        operationLabel.setForeground(Color.LIGHT_GRAY);
        operationLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        // Display Panel
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // Adding display and operation label to the top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(operationLabel, BorderLayout.NORTH);
        topPanel.add(display, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Button labels
        String[] buttonLabels = {
                "AC", "+/-", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "="
        };

        // Adding buttons dynamically
        int row = 0, col = 0;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusPainted(false);

            // Styling buttons
            if ("÷×-+=".contains(label)) {
                button.setBackground(new Color(255, 149, 0));
                button.setForeground(Color.WHITE);
            } else if ("AC+/-%%".contains(label)) {
                button.setBackground(new Color(128, 128, 128));
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(new Color(51, 51, 51));
                button.setForeground(Color.WHITE);
            }

            button.setOpaque(true);
            button.addActionListener(this);

            // Adding button to the panel
            gbc.gridx = col;
            gbc.gridy = row;
            gbc.weightx = 1;
            gbc.weighty = 1;

            // Special handling for "0" button
            if (label.equals("0")) {
                gbc.gridwidth = 1; // "0" button spans only 1 column
            } else {
                gbc.gridwidth = 1; // Other buttons are normal size
            }
            buttonPanel.add(button, gbc);

            col++;
            if (col == 4) { // 4 buttons per row
                col = 0;
                row++;
            }
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Set visibility
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) { // Number buttons
            currentInput += command;
            display.setText(currentInput);
        } else if (command.equals(".")) { // Decimal point
            if (!currentInput.contains(".")) {
                currentInput += ".";
                display.setText(currentInput);
            }
        } else if ("÷×-+".contains(command)) { // Operators
            if (!currentInput.isEmpty()) {
                num1 = Double.parseDouble(currentInput);
                operator = command.charAt(0);
                currentOperation = currentInput + " " + operator;
                operationLabel.setText(currentOperation);
                currentInput = "";
            }
        } else if (command.equals("=")) { // Equal button
            if (!currentInput.isEmpty()) {
                num2 = Double.parseDouble(currentInput);
                switch (operator) {
                    case '÷': result = num1 / num2; break;
                    case '×': result = num1 * num2; break;
                    case '-': result = num1 - num2; break;
                    case '+': result = num1 + num2; break;
                }
                operationLabel.setText(currentOperation + " " + currentInput + " =");
                display.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
            }
        } else if (command.equals("AC")) { // Clear button
            currentInput = "";
            currentOperation = "";
            num1 = num2 = result = 0;
            display.setText("");
            operationLabel.setText("");
        } else if (command.equals("+/-")) { // Sign toggle
            if (!currentInput.isEmpty()) {
                currentInput = String.valueOf(-Double.parseDouble(currentInput));
                display.setText(currentInput);
            }
        } else if (command.equals("%")) { // Percentage
            if (!currentInput.isEmpty()) {
                currentInput = String.valueOf(Double.parseDouble(currentInput) / 100);
                display.setText(currentInput);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ResponsiveCalculator::new);
    }
}


