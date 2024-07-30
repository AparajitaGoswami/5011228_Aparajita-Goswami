// ProxyPatternDemo.java
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded from the server and displayed
        image1.display();

        // Image is already loaded, so it will be displayed directly
        image1.display();

        // Image will be loaded from the server and displayed
        image2.display();
    }
}
