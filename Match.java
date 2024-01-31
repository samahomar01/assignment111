package departmentStore;
import departmentStore.datamoudle.proudect.Category;
import departmentStore.datamoudle.order.Order;
import departmentStore.datamoudle.order.OrderItem;
import java.util.ArrayList;
import java.util.Date;
import departmentStore.datamoudle.proudect.Product;

public class Match extends Promotion {
    private int qtyitemsOrder;
    private int qtyitemsPayed;
    private ArrayList<Product> products;

    public Match(String name, Constants.PromotionType promotionType, Validatot validator, int qtyitemsOrder, int qtyitemsPayed) {
        super(name, promotionType, validator);
        this.qtyitemsOrder = qtyitemsOrder;
        this.qtyitemsPayed = qtyitemsPayed;
        this.products = new ArrayList<>();
    }

    // Getters and Setters for products ArrayList

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Getters and Setters for products ArrayList
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void applyDiscountByCategory(Order order, double discountPercentage, Category category) {
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = orderItem.getProduct();
            if (products.contains(product) && product.getCategory() == category) {
                double discountAmount = product.getUnitprice() * (discountPercentage / 100);
                double newUnitPrice = product.getUnitprice() - discountAmount;
                orderItem.setPrice(newUnitPrice);
            }
        }
    }

    @Override
    public boolean isValid(Date today) {
        return validator.validate(today);
    }

    @Override
    public Order applyPromotion(Order order) {
        int n = qtyitemsOrder;
        int m = qtyitemsPayed;

        int count = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = orderItem.getProduct();
            if (products.contains(product)) {
                count++;
                if (count % n == 0) {
                    double unitPrice = product.getUnitprice();
                    double newUnitPrice = (unitPrice * (n - m)) / n;
                    orderItem.setPrice(newUnitPrice);
                } else if (count % n != 0 && count <= n) {
                    int l = count % n;
                    double unitPrice = product.getUnitprice();
                    double newUnitPrice = (unitPrice * (l - (l % n))) + (unitPrice * (l % n)) / l;
                    orderItem.setPrice(newUnitPrice);
                }
            }
        }

        return order;
    }
}