package departmentStore.datamoudle.paymentMethod;
public abstract class PaymentMethod {
    String name;
    public abstract double calculateAmount(double amount);
}
