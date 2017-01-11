package be.kdg.shop.persistence.dao.interfaces;

import be.kdg.shop.model.stock.Product;
import be.kdg.shop.model.stock.exceptions.StockException;

import java.util.Collection;

public interface StockDAO
{
    Product getProductByDescription(String description);

    Collection<Product> getProductsByCategoryName(String categoryName);

    Collection<String> getCategories();

    void addProduct(Product product, int amount) throws StockException;

    void removeProduct(Product product) throws StockException;

    void updateStockItem(Product product, Integer amount) throws StockException;

    Integer getStockcount(Product product);

}
