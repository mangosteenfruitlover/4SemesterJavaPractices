package prakt8;

public class Summator implements IVisitor {
    private double sum = 0;
    @Override
    public void visit(Product product) {
        sum += product.getPrice();
    }
    public double getTotal() {
        return sum;
    }
}
