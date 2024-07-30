public class Main {
    public static void main(String[] args) {
        // Create the repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById(1);
        System.out.println(customer);
    }
}
