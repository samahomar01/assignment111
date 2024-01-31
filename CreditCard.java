package departmentStore.datamoudle.paymentMethod;
public class CreditCard extends PaymentMethod {
    private double overhead;
    public CreditCard(double overhead){
        this.overhead=overhead;
    } 
    @Override
    public double calculateAmount(double amount) {
        // TODO Add the overhead percentage to the amount.
        double overheadAmount = amount * (overhead / 100);
        return amount + overheadAmount;

    }
    
}
