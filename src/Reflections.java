import com.sun.jdi.InterfaceType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Student{
    String nume;
    int varsta;
    private String secretId;

    public Student() {
        this.nume = "Necunoscut";
        this.varsta = 0;
        this.secretId = "ID-000";
    }

    // 2. Constructor cu un parametru
    public Student(String nume) {
        this.nume = nume;
        this.varsta = 18;
        this.secretId = "ID-000";
    }

    // 3. Constructor cu doi parametri
    public Student(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
        this.secretId = "ID-000";
    }

    // Metodă publică
    public void sayHello() {
        System.out.println("Salut! Ma numesc " + nume + " si am " + varsta + " ani");
    }

    // Metodă privată
    private void whisper() {
        System.out.println("Acesta este un mesaj secret de la " + nume);
    }

}

@interface Info {
    String author();
    String version();
}


public class Reflections{

    // 9. Construirea unui inspector simplu de obiecte
    public static void inspect(Object obj) {
        if (obj == null) return;

        Class<?> clazz = obj.getClass();
        System.out.println("Inspecting Object of type: " + clazz.getSimpleName());

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Permite accesul la câmpurile private
            try {
                System.out.println("Field: " + field.getName() + " | Value: " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("Field: " + field.getName() + " | Value: [Access Denied]");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        try{
            Class<?> studentClass = Student.class;

            //Nume clasa
            System.out.println("Class name:");
            System.out.println(studentClass.getName());
            System.out.println();

            //Nume pachet
            System.out.println("Package name:");
            System.out.println(studentClass.getPackage());
            System.out.println();

            //Nume Superclasa
            System.out.println("Superclass name:");
            System.out.println(studentClass.getSuperclass());
            System.out.println();

            //Nume interfete
            System.out.println("Interface name:");
            Class[] interfaces = studentClass.getInterfaces();
            for(int i=0; i<interfaces.length; i++)
                System.out.println(interfaces[i].getName());
            System.out.println();

            System.out.println("TASK 2: List all fields\n");
            Field[] fields = studentClass.getDeclaredFields();
            for (Field field : fields) {
                String modifiers = Modifier.toString(field.getModifiers());
                String type = field.getType().getSimpleName();
                String name = field.getName();
                System.out.println((modifiers.isEmpty() ? "" : modifiers + " ") + type + " " + name);
            }
            System.out.println();

            System.out.println("TASK 3: List all methods\n");
            Method[] methods = studentClass.getDeclaredMethods();
            for (Method method : methods) {
                String modifiers = Modifier.toString(method.getModifiers());
                String returnType = method.getReturnType().getSimpleName();
                String name = method.getName();

                System.out.print((modifiers.isEmpty() ? "" : modifiers + " ") + returnType + " " + name + "(");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    System.out.print(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }
            System.out.println();


            System.out.println("TASK 4: Create an object dynamically\n");
            Constructor<?> defaultConstructor = studentClass.getDeclaredConstructor();
            Object studentInstance = defaultConstructor.newInstance();
            System.out.println("Instanta creata: " + studentInstance);
            System.out.println();


            System.out.println("TASK 5: Call a public method\n");
            Method sayHelloMethod = studentClass.getDeclaredMethod("sayHello");
            sayHelloMethod.invoke(studentInstance);
            System.out.println();


            System.out.println("TASK 6: Access a private field\n");
            Field secretIdField = studentClass.getDeclaredField("secretId");
            secretIdField.setAccessible(true); // Trecem peste restricția de private
            System.out.println("Old secretId: " + secretIdField.get(studentInstance));
            secretIdField.set(studentInstance, "ID-999-SECRET");
            System.out.println("New secretId: " + secretIdField.get(studentInstance));
            System.out.println();


            System.out.println("TASK 7: Invoke a private method\n");
            Method whisperMethod = studentClass.getDeclaredMethod("whisper");
            whisperMethod.setAccessible(true); // Trecem peste restricția de private
            whisperMethod.invoke(studentInstance);
            System.out.println();


            System.out.println("TASK 8: Constructor selection\n");
            Constructor<?> constructor1 = studentClass.getDeclaredConstructor(String.class);
            Object studentIon = constructor1.newInstance("Ion");
            System.out.println("Creat cu Student(String): " + ((Student)studentIon).nume);

            Constructor<?> constructor2 = studentClass.getDeclaredConstructor(String.class, int.class);
            Object studentMaria = constructor2.newInstance("Maria", 22);
            System.out.println("Creat cu Student(String, int): " + ((Student)studentMaria).nume + ", " + ((Student)studentMaria).varsta);
            System.out.println();


            System.out.println("TASK 9: Build a simple object inspector\n");
            inspect(studentInstance); // Instanta modificata (default cu secretId schimbat)
            inspect(studentMaria);    // Instanta creata cu Maria, 22
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
