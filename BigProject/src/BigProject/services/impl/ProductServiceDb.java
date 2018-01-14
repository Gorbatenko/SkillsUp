package BigProject.services.impl;

import BigProject.DAO.ProductDao;
import BigProject.services.ProductService;
import BigProject.services.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProductServiceDb implements ProductService {

    private BufferedReader reader;
    private ProductDao dao;

    public ProductServiceDb() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.dao = new ProductDao();
    }

    public void addProduct() throws IOException {
        System.out.println("Введите название продукта:");
        String name = reader.readLine();
        System.out.println("Введите количество:");
        int amount = readInt();
        System.out.println("Введите цену:");
        double price = readDouble();
        System.out.println("Введите склад:");
        int stock = readInt();

        dao.addNewProduct(new Product(0, name, amount, price, stock));
    }

    public void editProduct() throws IOException {
        System.out.println("Введите Id продукта");
        int id = readInt();
        System.out.println("Введите название продукта:");
        String name = reader.readLine();
        System.out.println("Введите количество:");
        int amount = readInt();
        System.out.println("Введите цену:");
        double price = readDouble();
        System.out.println("Введите склад:");
        int stock = readInt();

        dao.editProduct(new Product(id, name, amount, price, stock));
    }


    public void removeProduct() throws IOException {
        System.out.println("Введите Id продукта, который нужно удалить:");
        int id = readInt();
        dao.removeProduct(id);
        System.out.println();
    }

    public void showProducts(){
        List<Product> products = dao.getProducts();

        if(products.size()>0) {
            System.out.println("Список всех продуктов:");
            System.out.println("[Ид; Название; Количество; Цена; Склад]");
            for (Product theProduct : products) {
                System.out.println(theProduct);
            }
            System.out.println();
        } else {
            System.out.println("База продуктов пуста.\n");
        }
    }

    private int readInt() throws IOException {
        Integer id;
        while (true) {
            try {
                id = new Integer(reader.readLine());
                if (id != 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводите только цифры, пожалуйста.");
            }
        }
        return id;
    }

    private double readDouble() throws IOException {
        double id;
        while (true) {
            try {
                id = new Double(reader.readLine());
                if (id != 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводите цифры, пожалуйста.");
            }
        }
        return id;
    }

}
