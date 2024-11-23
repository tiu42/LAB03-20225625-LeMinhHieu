import javax.swing.JOptionPane;

public class Calculator {
	public static void main(String[] args) {
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(
				null,
				"Please input the first number: ",
				"Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		strNum2 = JOptionPane.showInputDialog(
				null,
				"Please input the second number: ",
				"Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double diff = num1 - num2;
		double prod = num1 * num2;
		double quotient = 0;
		if (num2 != 0) {
			quotient = num1/num2;
		} else {
			JOptionPane.showMessageDialog(null,"Division by zero is not allowed!");
		}
		System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + prod);
        if (num2 != 0) {
            System.out.println("Quotient: " + quotient);
        }
        
		System.exit(0);
	}
}
