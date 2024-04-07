
import java.io.*;

class MyClass implements Serializable {
    int id;
    String name;

    MyClass(int i, String n) {
        id = i;
        name = n;
    }
}

public class Test {
    public static void main(String[] args) {
        // Testing calculation
        System.out.println("Testing calculation:");
        int a = 5, b = 10, result;
        result = Calculator.add(a, b);
        System.out.println("Expected result: " + (a + b));
        System.out.println("Actual result: " + result);

        // Testing serialization
        System.out.println("\nTesting serialization:");
        MyClass obj = new MyClass(1, "Object 1");
        try {
            FileOutputStream fos = new FileOutputStream("test.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            System.out.println("Serialized successfully!");

            FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MyClass objRead = (MyClass) ois.readObject();
            ois.close();
            System.out.println("Deserialized successfully!");
            System.out.println("Name: " + objRead.name + ", ID: " + objRead.id);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException c) {
            System.out.println("Error: " + c);
        }
    }
}

class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}