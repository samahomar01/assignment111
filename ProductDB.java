package departmentStore.database;
import departmentStore.datamoudle.proudect.Product;
import departmentStore.datamoudle.order.Order;
public interface  ProductDB {

    public   Order getProduct(int id);
    public   void updateProduct(Order order);
    public   void deleteProduct(int id);

    }
