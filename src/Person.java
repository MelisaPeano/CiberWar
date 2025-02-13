import java.util.Random;

public class Person {
    private String name;
    private int levelAcces;
    private String role;
    private boolean isHacker = false;
    public int numberPerson;

    public Person(String name, int levelAcces, String role, boolean isHacker, int numberPerson) {
        this.name = name;
        this.levelAcces = levelAcces;
        this.role = role;
        this.isHacker = isHacker;
        this.numberPerson = numberPerson;
    }
    /* Muestra la información de la persona sin revelar si es un hacker.  */
    public void showData() {
        System.out.println("El nombre es: " + name);
        System.out.println("El nivel de acceso es: " + levelAcces);
        System.out.println("El rol es: " + role);
    }
    /* Genera una respuesta aleatoria las personas responden un numero
       del 1 al 10 las pruebas de seguridad
      pero los hackers solo pueden responder números del 1 al 5). */
    public int performSecurityTest() {
        Random random = new Random();
        int randomNumber;
        if (this.isHacker == false) {
            randomNumber = random.nextInt(10) + 1;
            System.out.println("Yo respondo con el número :" + randomNumber);
            return randomNumber;
        } else {
            randomNumber = random.nextInt(5) + 1;
            System.out.println("Yo respondo con el número :" + randomNumber);
            return randomNumber;
        }
    }

    public boolean getIsHacker(int number) {
        if (number == this.numberPerson && this.isHacker) {
            return true;
        } else {
            return false;
        }
    }
}
