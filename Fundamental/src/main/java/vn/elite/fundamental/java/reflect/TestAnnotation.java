package vn.elite.fundamental.java.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    int value() default 0;

    String name() default "1213";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Normalize {
}

class Hello {
    @MyAnnotation(name = "adw")
    private void sayHello() {
        System.out.println("hello annotation");
    }
}

//Accessing annotation
public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        Hello h = new Hello();

        Method[] declaredMethods = h.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        Method m = h.getClass().getDeclaredMethod("sayHello");
        MyAnnotation manno = m.getAnnotation(MyAnnotation.class);
        System.out.println("value is: " + manno.value());

        System.out.println("=========================================================================");

        Employee employee = new Employee("Ng%^u*yen#@ Nhat^%%#@ Ho@a*đứng;!!!-", "Software%^$ Engineer@");
        employee.normalize();

        System.out.println(employee.getName());
        System.out.println(employee.getPosition());
    }
}

class Employee {
    @Normalize
    private String name;
    @Normalize
    private String position;

    Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    String getPosition() {
        return position;
    }

    void normalize() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Normalize normalize = field.getAnnotation(Normalize.class);
            if (normalize == null) {
                continue;
            }
            try {
                field.setAccessible(true);
                if (field.get(this) == null) {
                    continue;
                }
                field.set(this, String.valueOf(field.get(this)).replaceAll("[^A-Za-z0-9 ]", ""));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
