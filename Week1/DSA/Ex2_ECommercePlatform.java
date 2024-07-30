package DSA;

class Product1 {
    private String productId;
    private String productName;
    private String category;

    public Product1(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class LinearSearch {
    public static int search(Product1[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i; // Found the product
            }
        }
        return -1; // Product not found
    }
}

class BinarySearch {
    public static int search(Product1[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return mid; // Found the product
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Product not found
    }
}

public class Ex2_ECommercePlatform {
    public static void main(String[] args) {
        Product1[] products = {
            new Product1("P1", "Laptop", "Electronics"),
            new Product1("P2", "Smartphone", "Electronics"),
            new Product1("P3", "Book", "Books"),
            new Product1("P4", "Tablet", "Electronics"),
            new Product1("P5", "Headphones", "Electronics")
        };

        // Sort products for binary search
        java.util.Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        // Linear Search
        int index = LinearSearch.search(products, "Book");
        if (index != -1) {
            System.out.println("Linear Search: Found " + products[index]);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Binary Search
        index = BinarySearch.search(products, "Book");
        if (index != -1) {
            System.out.println("Binary Search: Found " + products[index]);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}
