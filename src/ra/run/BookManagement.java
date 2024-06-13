package ra.run;

import ra.bussiness.Book;
import java.util.Scanner;

public class BookManagement {
    private static final int MAX_BOOKS = 100;
    private static ra.bussiness.Book[] bookList = new ra.bussiness.Book[MAX_BOOKS];
    private static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBooksByInterest();
                    break;
                case 4:
                    deleteBookById(scanner);
                    break;
                case 5:
                    searchBooks(scanner);
                    break;
                case 6:
                    updateBookById(scanner);
                    break;
                case 7:
                    System.out.println("Thoát chương trình");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }


    public static void addBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        String input = scanner.nextLine();

        while (!input.matches("\\d+")) {
            System.out.print("Đây là 1 số, vui lòng nhập lại: ");
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(input);
        for (int i = 0; i < n && bookCount < MAX_BOOKS; i++) {
            Book book = new Book();
            book.inputData();
            bookList[bookCount++] = book;
        }
    }

    public static void displayBooks() {
        if (bookCount == 0 || bookList.length == 0) {
            System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            bookList[i].displayData();
            System.out.println("----------------------");
        }
    }

    public static void sortBooksByInterest() {
        if (bookCount == 0 || bookList.length == 0) {System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = i + 1; j < bookCount; j++) {
                if (bookList[i].getInterest() > bookList[j].getInterest()) {
                    Book temp = bookList[i];
                    bookList[i] = bookList[j];
                    bookList[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    public static void deleteBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int id = scanner.nextInt();
        if (bookCount == 0 || bookList.length == 0) {
            System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId() == id) {
                for (int j = i; j < bookCount - 1; j++) {
                    bookList[j] = bookList[j + 1];
                }
                bookList[--bookCount] = null; // clear the last element
                System.out.println("Xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sách này.");
    }

    public static void searchBooks(Scanner scanner) {
        System.out.print("Nhập chuỗi tìm kiếm: ");
        String searchString = scanner.nextLine().toLowerCase();
        if (bookCount == 0 || bookList.length == 0) {
            System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookName().toString().toLowerCase().contains(searchString) ||
                    bookList[i].getDescription().toString().toLowerCase().contains(searchString)) {
                bookList[i].displayData();
                System.out.println("----------------------");
            }
        }
    }

    public static void updateBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (bookCount == 0 || bookList.length == 0) {
            System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId() == id) {
                bookList[i].inputData();
                System.out.println("Cập nhật sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sách này.");
    }
}