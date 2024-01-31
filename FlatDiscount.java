package departmentStore;

import departmentStore.datamoudle.order.Order;
import departmentStore.datamoudle.order.OrderItem;

import java.util.Date;

public class FlatDiscount extends Promotion {
    private double discount;

    public FlatDiscount(String name, Constants.PromotionType promotionType, Validatot validator, double discount) {
        super(name, promotionType, validator);
        this.discount = discount;
    }

    @Override
    public boolean isValid(Date today) {
        return validator.validate(today);
    }

    @Override
    public Order applyPromotion(Order order) {
        if (order.isPromotionApplied()) {
            System.out.println("The discount has already been applied.");
        } else {
            double totalCost = order.getTotalCost();

            if (totalCost >= 500 && totalCost < 700) {
                // Apply 5% discount
                double discountAmount = totalCost * 0.05;
                totalCost -= discountAmount;
            } else if (totalCost >= 700 && totalCost < 1000) {
                // Apply 7% discount
                double discountAmount = totalCost * 0.07;
                totalCost -= discountAmount;
            } else if (totalCost >= 1000) {
                // Apply 10% discount
                double discountAmount = totalCost * 0.1;
                totalCost -= discountAmount;
            }

            order.setTotalCost(totalCost);
            order.applyPromotion();
        }

        return order;
    }
}