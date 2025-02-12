import java.util.Random;

public class Person {
    private String name;
    private int levelAcces;
    private String role;
    private boolean isHacker;

    public Person(String name, int levelAcces, String role, boolean isHacker) {
        this.name = name;
        this.levelAcces = levelAcces;
        this.role = role;
        this.isHacker = isHacker;
    }
    /* Muestra la información de la persona sin revelar si es un hacker.  */
    private void showData(String name, int[] levelAcces, String[] role) {
        System.out.println("El nombre es :" + name);
        System.out.println("El nivel de acceso es :" + levelAcces);
        System.out.println("El rol es :" + role);
    }
    /* Genera una respuesta aleatoria las personas responden un numero
       del 1 al 10 las pruebas de seguridad
      pero los hackers solo pueden responder números del 1 al 5). */
    private int performSecurityTest(String name, boolean isHacker) {
        Random random = new Random();
        int randomNumber;
        if (isHacker = false) {
            randomNumber = random.nextInt(10) + 1;
            System.out.println("Yo respondo con el número :" + randomNumber);
            return randomNumber;
        } else {
            randomNumber = random.nextInt(5) + 1;
            System.out.println("Yo respondo con el número :" + randomNumber);
            return randomNumber;
        }
    }
}
