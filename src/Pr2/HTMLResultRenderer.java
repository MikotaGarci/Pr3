public class HTMLResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result) {
        return "<html><body>Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult() + "</body></html>";
    }
}