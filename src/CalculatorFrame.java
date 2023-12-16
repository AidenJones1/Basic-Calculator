import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorFrame implements ActionListener {
    private static final Font mainFont = new Font("Serif", Font.BOLD, 25);
    private final JLabel display = new JLabel("0", SwingConstants.RIGHT);

    //Buttons - Numbers
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    //Button - Operators
    JButton addButton, subButton, mulButton, divButton, decButton, clearButton, clearEntryButton, negButton, equalsButton, delButton;

    //Operands, Operators, and Result
    private static String currentEntry = "";
    private static String operand1 = "";
    private static String operator = "";
    private static String operand2 = "";
    private static double result = 0.0;

    //Creates frame
    public CalculatorFrame() {
        //Frame
        JFrame frame = new JFrame("Calculator"); //Title
        frame.setSize(450, 650); //Size
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label - Display
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        display.setPreferredSize(new Dimension(175, 100));
        display.setFont(mainFont);

        ArrayList<JButton> buttonsList = new ArrayList<>();

        button1 = new JButton("1");
            button1.addActionListener(this);
        button2 = new JButton("2");
            button2.addActionListener(this);
        button3 = new JButton("3");
            button3.addActionListener(this);
        button4 = new JButton("4");
            button4.addActionListener(this);
        button5 = new JButton("5");
            button5.addActionListener(this);
        button6 = new JButton("6");
            button6.addActionListener(this);
        button7 = new JButton("7");
            button7.addActionListener(this);
        button8 = new JButton("8");
            button8.addActionListener(this);
        button9 = new JButton("9");
            button9.addActionListener(this);
        button0 = new JButton("0");
            button0.addActionListener(this);

        addButton = new JButton("+");
            addButton.addActionListener(this);
        subButton = new JButton("-");
            subButton.addActionListener(this);
        mulButton = new JButton("x");
            mulButton.addActionListener(this);
        divButton = new JButton("/");
            divButton.addActionListener(this);
        decButton = new JButton(".");
            decButton.addActionListener(this);
        clearButton = new JButton("C");
            clearButton.addActionListener(this);
        clearEntryButton = new JButton("CE");
            clearEntryButton.addActionListener(this);
        negButton = new JButton("+/-");
            negButton.addActionListener(this);
        equalsButton = new JButton("=");
            equalsButton.addActionListener(this);
        delButton = new JButton("<");
            delButton.addActionListener(this);

        //Adds buttons to GridLayout
        buttonsList.add(delButton);
        buttonsList.add(clearEntryButton);
        buttonsList.add(clearButton);
        buttonsList.add(divButton);
        buttonsList.add(button1);
        buttonsList.add(button2);
        buttonsList.add(button3);
        buttonsList.add(mulButton);
        buttonsList.add(button4);
        buttonsList.add(button5);
        buttonsList.add(button6);
        buttonsList.add(subButton);
        buttonsList.add(button7);
        buttonsList.add(button8);
        buttonsList.add(button9);
        buttonsList.add(addButton);
        buttonsList.add(decButton);
        buttonsList.add(button0);
        buttonsList.add(negButton);
        buttonsList.add(equalsButton);

        JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(5,4));

        for (JButton button : buttonsList) {
            button.setFont(mainFont);
            centerPanel.add(button);
        }

        frame.add(display, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Checks the results is still displayed and resets the display
        if (currentEntry.equals("" + result)) { currentEntry = "0"; }

        //button0 is pressed
        if (e.getSource() == button0) { currentEntry += "0"; }

        //button1 is pressed
        else if (e.getSource() == button1) { currentEntry += "1"; }

        //button2 is pressed
        else if (e.getSource() == button2) { currentEntry += "2"; }

        //button3 is pressed
        else if (e.getSource() == button3) { currentEntry += "3"; }

        //button4 is pressed
        else if (e.getSource() == button4) { currentEntry += "4"; }

        //button5 is pressed
        else if (e.getSource() == button5) { currentEntry += "5"; }

        //button6 is pressed
        else if (e.getSource() == button6) { currentEntry += "6"; }

        //button7 is pressed
        else if (e.getSource() == button7) { currentEntry += "7"; }

        //button8 is pressed
        else if (e.getSource() == button8) { currentEntry += "8"; }

        //button9 is pressed
        else if (e.getSource() == button9) { currentEntry += "9"; }

        //clearButton is pressed, resets the display (previous operand and operator is still saved)
        else if (e.getSource() == clearButton) { currentEntry = "0"; }

        //delButton is pressed, removes the last character from currentEntry
        else if (e.getSource() == delButton) {
            if (currentEntry.length() > 1) { currentEntry = currentEntry.substring(0, currentEntry.length() - 1); }
            else { currentEntry = "0"; }
        }

        //clearEntryButton is pressed, resets the display (previous operand is deleted and operator is removed)
        else if (e.getSource() == clearEntryButton) {
            currentEntry = "0";
            operand1 = "";
            operator = "";
            operand2 = "";
            result = 0.0;
        }

        //decButton is pressed, add a decimal to the number if none exist
        else if (e.getSource() == decButton) {
            if (!currentEntry.contains(".")) {
                currentEntry += ".";
            }
        }

        //negButton is pressed, adds/removes the negative sign at the first character of the number
        else if (e.getSource() == negButton) {
            if (currentEntry.charAt(0) != '-') {
                currentEntry = "-" + currentEntry;
            }
            else {
                currentEntry = currentEntry.substring(1);
            }
        }

        /* addButton is pressed, checks if there are no numbers in the first operand,
            display is saved as the first operand,
            operator set to "+",
            resets display for second operand
        */
        else if (e.getSource() == addButton) {
            if (operand1.equals("")) {
                operand1 = currentEntry;
                currentEntry = "0";
                operator = "+";
            }
        }

        /* subButton is pressed, checks if there are no numbers in the first operand,
            display is saved as the first operand,
            operator set to "-",
            resets display for second operand
        */
        else if (e.getSource() == subButton) {
            if (operand1.equals("")) {
                operand1 = currentEntry;
                currentEntry = "0";
                operator = "-";
            }
        }

        /* mulButton is pressed, checks if there are no numbers in the first operand,
            display is saved as the first operand,
            operator set to "+",
            resets display for second operand
        */
        else if (e.getSource() == mulButton) {
            if (operand1.equals("")) {
                operand1 = currentEntry;
                currentEntry = "0";
                operator = "x";
            }
        }

        /* divButton is pressed, checks if there are no numbers in the first operand,
            display is saved as the first operand,
            operator set to "+",
            resets display for second operand
        */
        else if (e.getSource() == divButton) {
            if (operand1.equals("")) {
                operand1 = currentEntry;
                currentEntry = "0";
                operator = "/";
            }
        }

        /* equalsButton is pressed, checks if there is currently an operator set,
            Calculates the equation and saves it in result
            Displays the result
            Resets the operands and operator
         */
        else if (e.getSource() == equalsButton) {
            if (!operator.equals("")) {
                operand2 = currentEntry;

                try {
                    switch (operator) {
                        case "+" ->
                                result = MathOperation.Add(Double.parseDouble(operand1), Double.parseDouble(operand2));
                        case "-" ->
                                result = MathOperation.Subtract(Double.parseDouble(operand1), Double.parseDouble(operand2));
                        case "x" ->
                                result = MathOperation.Multiply(Double.parseDouble(operand1), Double.parseDouble(operand2));
                        case "/" ->
                                result = MathOperation.Divide(Double.parseDouble(operand1), Double.parseDouble(operand2));
                    }
                }
                catch (Exception ignored) {}

                currentEntry = "" + result;
                operand1 = "";
                operator = "";
                operand2 = "";
            }
        }


        display.setText(currentEntry);
    }
}
//Project by Aiden Jones