public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // For demonstration purposes, we'll just return a dummy customer.
        return new Customer(id, "John Doe");
    }
}
