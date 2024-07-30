import java.util.Scanner;

public class FinancialForecasting {

    public static double calValue(double pValue, double gRate, int per) {
        double futureValue = pValue;

        for (int i = 0; i < per; i++) {
            futureValue *= (1 + gRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of periods: ");
        int periods = scanner.nextInt();

        double futureValue = calValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: %.2f\n", periods, futureValue);

    }
    
}


