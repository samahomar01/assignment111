package departmentStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import departmentStore.database.ProductDB;
import departmentStore.datamoudle.order.Order;
import departmentStore.datamoudle.order.OrderItem;
import departmentStore.datamoudle.paymentMethod.Cash;
import departmentStore.datamoudle.paymentMethod.CreditCard;
import departmentStore.datamoudle.paymentMethod.PaymentMethod;
import departmentStore.datamoudle.proudect.Product;
import departmentStore.datamoudle.proudect.Category;

import javax.xml.crypto.Data;

public class DepartmentStore {
    public static void main(String[] args) {

        // إنشاء منتجات
        Product product1 = new Product(1, "منتج 1", Category.MENFASHON, 10.0, 20.0);
        Product product2 = new Product(2, "منتج 2", Category.WOMENFASHON, 15.0, 30.0);
        Product product3 = new Product(3, "منتج 3", Category.CHILDFASHON, 5.0, 10.0);

        // إنشاء عناصر الطلبية
        OrderItem item1 = new OrderItem(2, 200.0, product1);
        OrderItem item2 = new OrderItem(1, 300.0, product2);
        OrderItem item3 = new OrderItem(3, 100.0, product3);

        // إنشاء الطلبية
        Order order = new Order(1, new Date(), 0.0);
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);

        // قم بتعيين القيم المناسبة للمعاملات
        String name = "Flat Discount";
        Constants.PromotionType promotionType = Constants.PromotionType.DAYOFWEEK;
        Validatot validator = new DayOfWeek(new String[]{"Monday", "Tuesday", "Wednesday"}); // مثال لكائن من Validatot
        double discount = 0.1; // 10% خصم

        // قم بإنشاء كائن FlatDiscount
        FlatDiscount flatDiscount = new FlatDiscount(name, promotionType, validator, discount);

        // قم بتطبيق الخصم المسطح على الطلب باستخدام الكائن FlatDiscount
        order = flatDiscount.applyPromotion(order);

        System.out.println(order.toString());
    }
}