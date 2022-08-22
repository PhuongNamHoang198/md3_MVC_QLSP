package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements ProductServiceInter{
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1,new Product(1,"toi thay hoa vang tren co xanh","fahasa",2200));
        productMap.put(2,new Product(2,"10 van cau hoi vi sao","phuong nam",20000));
        productMap.put(3,new Product(3,"thuoc ho","shoppe",9000));
        productMap.put(4,new Product(4,"7 thoi quen hieu qua","thai ha book",1500));
        productMap.put(5,new Product(5,"dam bi ghet","thai ha book",9100));
        productMap.put(6,new Product(6,"dac nhan tam","nha sach tri tue",1800));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        productMap.put(id,product);
    }

}
