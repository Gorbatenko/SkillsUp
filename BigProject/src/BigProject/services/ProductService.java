package BigProject.services;

import java.io.IOException;

public interface ProductService {

    void addProduct() throws IOException;

    void editProduct() throws IOException;

    void removeProduct() throws IOException;

    void showProducts();
}