package DSA;

public class Ex7_FinancialForecasting {
    public static void main(String[] args) {
        double initialInvestment = 1000.0; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValue = calculateFutureValue(initialInvestment, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: $" + futureValue);
    }

    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        } else {
            return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
        }
    }
}
