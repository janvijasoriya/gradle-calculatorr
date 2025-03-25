public class App {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java App <num1> <num2> <operation>");
            System.exit(1);
        }
        double num1;
        try {
            num1 = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for num1");
            System.exit(1);
        }
        double num2;
        try {
            num2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for num2");
            System.exit(1);
        }
        String operation = args[2];

        double result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid operation! Use +, -, *, or /.");
                System.exit(1);
        }
    }
}
