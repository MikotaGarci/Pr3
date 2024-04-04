import java.io.*;

public class SerializationDemo implements Serializable {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("calculation_result.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Створення об'єкта CalculationResult
            CalculationResult result = new CalculationResult(1.5, 2.5);
            oos.writeObject(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        CalculationResult deserializedResult = null;

        try (FileInputStream fis = new FileInputStream("calculation_result.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            deserializedResult = (CalculationResult) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (deserializedResult != null) {
            System.out.println(deserializedResult.getParameter1());
            System.out.println(deserializedResult.getParameter2());
            System.out.println(deserializedResult.getResult());
        } else {
            System.out.println("Failed to deserialize CalculationResult.");
        }
    }
}