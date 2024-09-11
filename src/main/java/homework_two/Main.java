package homework_two;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Class<String> clazz = String.class;
        Method[] methods = clazz.getDeclaredMethods();

        StringBuilder stringBuilder = new StringBuilder();

        for (Method method : methods) {
            StringBuilder tmp = new StringBuilder();
            Class<?>[] params = method.getParameterTypes();
            for (Class<?> p : params) {
                tmp.append(p.getSimpleName()).append(", ");
            }
            String parameters = tmp.length() < 2 ? tmp.toString() : tmp.substring(0, tmp.length() - 2);

            stringBuilder.append("\u001B[32m")
                    .append(method.getName())
                    .append("\u001B[34m")
                    .append("(")
                    .append(parameters)
                    .append(")")
                    .append("\u001B[31m return:")
                    .append(method.getReturnType().getSimpleName())
                    .append("\n");
        }
        System.out.println(stringBuilder);

    }
}
