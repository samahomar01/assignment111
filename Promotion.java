package departmentStore;
import departmentStore.Constants;
import departmentStore.datamoudle.order.Order;

import javax.xml.validation.Validator;
import java.util.Date;

public abstract class Promotion {
    private String name;
    private Constants.PromotionType promotionType;
    protected Validatot validator;

    public Promotion(String name, Constants.PromotionType promotionType, Validatot validator) {
        this.name = name;
        this.promotionType = promotionType;
        this.validator = validator;
    }

    public abstract boolean isValid(Date today);

    public abstract Order applyPromotion(Order o);
}