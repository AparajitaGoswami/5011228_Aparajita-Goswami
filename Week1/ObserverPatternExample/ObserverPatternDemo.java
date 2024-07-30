// ObserverPatternDemo.java
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create a stock market
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        stockMarket.setPrice(150.00);
        stockMarket.setPrice(175.50);
    }
}
