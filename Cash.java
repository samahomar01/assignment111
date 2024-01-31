package departmentStore.datamoudle.paymentMethod;
public class Cash extends PaymentMethod {
    private double discountPercentage;

    public Cash(double discountPercentage){
        this.discountPercentage=discountPercentage;
    }
    @Override
    public double calculateAmount(double amount) {
        // TODO Implement the method to apply a discount to the amount and return the modified value.
        double discountAmount = amount * (discountPercentage / 100);
        return amount - discountAmount;
    }
}
