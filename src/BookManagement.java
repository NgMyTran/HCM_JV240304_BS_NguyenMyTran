import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice) {
                case 1:
//                    menuCatalog();
                    break;
                case 2:
//                    menuProduct();
                    break;
                case 3:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            } if (choice == 3) {
                break;
            }
        }
    }

    private static void menuCatalog() {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục\n" +
                    "2. Hiển thị thông tin tất cả các danh mục\n" +
                    "3. Sửa tên danh mục theo mã danh mục\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)\n" +
                    "5. Quay lại");
            Scanner scanner = new Scanner(System.in);
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
//                    addNewCategory();
                    break;
                case 2:
//                    showCategoryList();
                    break;
                case 3:
//                    editCategory();
                    break;
                case 4:
//                    deleteCategory();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
        }
    }

    private static void menuProduct() {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục\n" +
                    "2. Hiển thị thông tin tất cả các danh mục\n" +
                    "3. Sửa tên danh mục theo mã danh mục\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)\n" +
                    "5. Quay lại");
            Scanner scanner = new Scanner(System.in);
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
//                    addNewCategory();
                    break;
                case 2:
//                    showCategoryList();
                    break;
                case 3:
//                    editCategory();
                    break;
                case 4:
//                    deleteCategory();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
        }
    }
}