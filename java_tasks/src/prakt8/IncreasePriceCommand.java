package prakt8;

public class IncreasePriceCommand implements IProductCommand {
    private int percents;
    public IncreasePriceCommand(int percents) {
        this.percents = percents;
    }
    @Override
    public void execute(Product product) {
        product.setPrice( product.getPrice() * (1.0 + percents / 100.0) );
    }
}
