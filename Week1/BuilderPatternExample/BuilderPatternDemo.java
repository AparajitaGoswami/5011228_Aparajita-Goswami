// BuilderPatternDemo.java
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        // Create a high-end gaming computer
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .build();

        // Print computer configurations
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}
