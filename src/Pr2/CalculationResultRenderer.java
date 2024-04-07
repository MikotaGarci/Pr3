import java.io.Serializable;

public interface CalculationResultRenderer extends Serializable {
    String render(CalculationResult result);
}