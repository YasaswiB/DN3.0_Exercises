import java.util.List;

public class BinarySearch {
	public Product binarySearch(List<Product> products, String searchTerm) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = products.get(mid);
            int comparison = midProduct.getProductName().compareTo(searchTerm);

            if (comparison == 0) {
                return midProduct;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

}
