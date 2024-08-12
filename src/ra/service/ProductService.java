package ra.service;

import ra.model.Catalog;
import ra.model.Product;

import java.util.*;

public class ProductService implements IGenericService<Product, String>{
    List<Product> productList= new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
//    public Product findById(String id) {
//        Optional<Product> product= productList.stream().filter(p->p.getProductId().equals(id)).findFirst();
//        return null;
//    }
    public Product findById(String productId) {
        // Assuming products are stored in a list
        return productList.stream()
                .filter(p -> p.getProductId().equalsIgnoreCase(productId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        productList.removeIf(p->p.getProductId().equals(id));
    }

    public void sortByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getProductPrice).reversed());
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        if (name == null || name.trim().isEmpty()) {
            return result; // Return empty list if search name is null or empty
        }
        String lowerCaseName = name.toLowerCase();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(lowerCaseName)) {
                result.add(product);
            }
        }
        return result;
    }

    public static String validateProductId(Scanner scanner) {
        String productId;
        do {
            System.out.print("Nhập mã sản phẩm (bắt đầu bằng 'P' và theo sau là 4 chữ số, ví dụ: P1234): ");
            productId = scanner.nextLine();
            if (!productId.matches("P\\d{4}")) {
                System.out.println("Mã sản phẩm không hợp lệ. Mã sản phẩm phải bắt đầu bằng 'P' và theo sau là 4 chữ số.");
            }
        } while (!productId.matches("P\\d{4}"));
        return productId;
    }

    public static String validateProductName(Scanner scanner) {
        String productName;
        do {
            productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Tên sản phẩm không được để trống. Vui lòng nhập lại.");
            }
        } while (productName.trim().isEmpty());
        return productName;
    }

    public static double validateProductPrice(Scanner scanner) {
        double productPrice;
        do {
            try {
                productPrice = Double.parseDouble(scanner.nextLine());
                if (productPrice <= 0) {
                    System.out.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                productPrice = -1;
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        } while (productPrice <= 0);
        return productPrice;
    }

    public static int validateProductStock(Scanner scanner) {
        int stock;
        do {
            System.out.print("(ít nhất là 10): ");
            stock = Integer.parseInt(scanner.nextLine());
            if (stock < 10) {
                System.out.println("Số lượng tồn kho phải ít nhất là 10. Vui lòng nhập lại.");
            }
        } while (stock < 10);
        return stock;
    }

    public static int validateCatalogId(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
