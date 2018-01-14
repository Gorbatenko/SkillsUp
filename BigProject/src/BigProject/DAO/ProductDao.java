package BigProject.DAO;

import BigProject.services.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDao {

    private Connection connection;
    private String sql;


    public ProductDao(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/Product", "", "");
            isAbsentProductDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void isAbsentProductDao() {
        sql = "SELECT * FROM INFORMATION_SCHEMA.CATALOGS";
        try (PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            boolean isAbsentProductDao = true;
            while (rs.next()) {
                if (Objects.equals(rs.getString("CATALOG_NAME"), "PRODUCT")) {
                    isAbsentProductDao = false;
                    break;
                }
            }
            if(isAbsentProductDao) {
                sql ="CREATE TABLE PRODUCT (ID BIGINT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(100), AMOUNT INTEGER(6), PRICE NUMERIC(11,2), STOCK INTEGER(6))";
                try (Statement st = connection.createStatement()) {
                    st.execute(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewProduct(Product productNew) {
        sql = "SELECT * FROM Product WHERE NAME = '" + productNew.getName() +"'";
        List<Product> products = new ArrayList<>();

        int id, stock, amount;
        String name;
        double price;

        try (PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while(rs.next() ) {
                id  = rs.getInt("ID");
                name = rs.getString("NAME");
                amount = rs.getInt("AMOUNT");
                price = rs.getDouble("PRICE");
                stock = rs.getInt("STOCK");

                products.add(new Product(id, name, amount, price, stock));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (products.size() > 0) {
            for (int i = 0; i < products.size(); i++) {
                Product productOld = products.get(i);
                if (Objects.equals(productOld.getPrice(), productNew.getPrice())&Objects.equals(productOld.getStock(), productNew.getStock())) {
                    amount = productOld.getAmount() + productNew.getAmount();
                    productOld.setAmount(amount);
                    editProduct(productOld);
                    System.out.println("Продукт '" + productOld.getName() + "' добавлен на склад №" + productOld.getStock() + " по старой цене.\n");
                    break;
                } else {
                    if (i == products.size()-1) {
                        addProduct(productNew);
                        System.out.println("Продукт '" + productOld.getName() + "' добавлен на склад №" + productNew.getStock() + " по новой цене.\n");
                    }
                }
            }
        } else {
            addProduct(productNew);
            System.out.println("Добавлен новый продукт - '" + productNew.getName() + "'.\n");
        }
    }

    private void addProduct(Product product) {
        sql = "INSERT INTO PRODUCT (NAME, AMOUNT, PRICE, STOCK) values(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, product.getName());
            ps.setInt(2, product.getAmount());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        sql = "SELECT * FROM Product";
        try (PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();

            while(rs.next() ) {
                int id  = rs.getInt("ID");
                String name = rs.getString("NAME");
                int amount = rs.getInt("AMOUNT");
                double price = rs.getDouble("PRICE");
                int stock = rs.getInt("STOCK");

                products.add(new Product(id, name, amount, price, stock));
            }
            return products;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void editProduct(Product product) {
        sql = "UPDATE PRODUCT SET NAME = ?, AMOUNT = ?, PRICE = ?, STOCK = ? WHERE ID = " + product.getId();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setInt(2, product.getAmount());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(int id) {
        try (Statement cs = connection.createStatement()) {
            sql = "DELETE FROM PRODUCT " + "WHERE ID = " + id ;
            cs.executeUpdate(sql);
            System.out.println("Продукт " + id + "удалён.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
