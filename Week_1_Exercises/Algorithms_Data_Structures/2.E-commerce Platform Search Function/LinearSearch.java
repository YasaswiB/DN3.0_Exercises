import java.util.List;

public class LinearSearch {
	public Product linearSearch(List<Product> products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equals(searchTerm)) {
                return product;
            }
        }
        return null;
    }

}
