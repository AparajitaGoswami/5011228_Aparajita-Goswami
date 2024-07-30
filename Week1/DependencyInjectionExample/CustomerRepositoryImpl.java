// CustomerRepositoryImpl.java
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // For demonstration purposes, returning a dummy customer
        return new Customer(id, "John Doe");
    }
}
