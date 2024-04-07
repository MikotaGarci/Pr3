### Використання командного рядка Java для обчислення енергії та тестування

Цей Java-застосунок дозволяє обчислювати енергію фізичного тіла та тестувати різноманітні функції через командний рядок.

#### Виконання програми з передачею аргументів командного рядка:

```bash
java Main 5 10 15
```
**Приклад використання:**

```bash
$ java Main 5 10 15
Передані аргументи командного рядка:
Аргумент 1: 5
Аргумент 2: 10
Аргумент 3: 15
Результат обчислень:
Загальна енергія: 792.75
```
**Якщо не передано жодного аргументу, виведеться відповідне повідомлення:**

```bash
$ java Main
Не передано жодного аргументу командного рядка.
```
## CalculationResult.java
```bash


import java.io.Serializable;

public class CalculationResult implements Serializable {
    private double parameter1;
    private double parameter2;
    private double result;

    public CalculationResult(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = parameter1 + parameter2;
    }

    public double getParameter1() {
        return parameter1;
    }

    public double getParameter2() {
        return parameter2;
    }

    public double getResult() {
        return result;
    }
}
```

## CalculationResultRenderer.java
```bash
import java.io.Serializable;

public interface CalculationResultRenderer extends Serializable {
    String render(CalculationResult result);
}
```
## EnergyCalculator.java
```bash

public class EnergyCalculator {
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        // Add calculation logic here
        return mass * velocity * velocity / 2 + mass * 9.81 * height;
    }
}
```
## HTMLResultRenderer.java
```bash
public class HTMLResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result) {
        return "<html><body>Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult() + "</body></html>";
    }
}
```
## SerializationDemo.java
```bash
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        CalculationResult deserializedResult = null;
        try (FileInputStream fis = new FileInputStream("calculation_result.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializedResult = (CalculationResult) ois.readObject();
            CalculationResultRenderer renderer = new TextResultRenderer();
            System.out.println(renderer.render(deserializedResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
## Solver.java
```bash
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        // Створення об'єкта CalculationResult
        CalculationResult result = new CalculationResult(1.5, 2.5);

        // Вибір типу рендерера
        System.out.println("Choose result renderer (1 for Text, 2 for HTML):");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        CalculationResultRenderer renderer;
        if (choice == 1) {
            renderer = new TextResultRenderer();
        } else if (choice == 2) {
            renderer = new HTMLResultRenderer();
        } else {
            System.out.println("Invalid choice. Defaulting to Text renderer.");
            renderer = new TextResultRenderer();
        }

        // Виведення результату
        System.out.println(renderer.render(result));

        // Закриваємо Scanner
        scanner.close();
    }
}
```

## TextResultRenderer.java
```bash
public class TextResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result) {
        return "Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult();
    }
}
```

## Test.java
```bash

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
```

![Результат](/screenshot/Pr3.png)