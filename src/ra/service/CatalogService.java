package ra.service;

import ra.model.Catalog;

import java.util.*;

public class CatalogService implements IGenericService<Catalog, Integer>{
    private List<Catalog> catalogList = new ArrayList<>();
    @Override
    public List<Catalog> getAll() {
        return catalogList;
    }

    @Override
    public void save(Catalog catalog) {
        catalogList.add(catalog);
    }

    @Override
    public Catalog findById(Integer id) {
        Optional<Catalog> catalog= catalogList.stream().filter(c->c.getCatalogId()==id).findFirst();
        return catalog.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        catalogList.removeIf(c->c.getCatalogId()==id);
    }

    public static String validateCatalogName(Scanner scanner) {
        String name;
        do {
            System.out.print("(không được để trống): ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Tên catalog không được để trống. Vui lòng nhập lại.");
            }
        } while (name.trim().isEmpty());
        return name;
    }

    public static String validateCatalogDescription(Scanner scanner) {
        String name;
        do {
            System.out.print("(không được để trống): ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Mô tả không được để trống. Vui lòng nhập lại.");
            }
        } while (name.trim().isEmpty());
        return name;
    }
}
