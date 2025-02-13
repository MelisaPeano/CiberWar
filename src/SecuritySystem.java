import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class SecuritySystem {
    private Person[] employees;
    boolean hackerIdentified = false;

    public SecuritySystem(int amount) {
        this.employees = generateEmployees(amount);
    }

    /* Crea empleados con nombres aleatorios y asigna uno de ellos como hacker. */
    public Person[] generateEmployees(int amount) {
        employees = new Person[amount];
        String[] names = {"Juan", "Alejandro", "Camila", "Esteban", "Mary",
                "Lucia", "Brian", "Matilda", "Luis", "Sandra", "Carlos",
                "Fernanda", "Sergio", "Diana", "Roberto", "Valentina",
                "Andrés", "Natalia", "Emilio", "Sofía", "Javier", "Mariana", "Pablo",
                "Gabriela", "Ricardo"};
        String[] roles = {"Analista", "Ingeniero", "Técnico", "Administrador"};
        Random random = new Random();
        int randomIsHacker = random.nextInt(amount) + 1;
        int numberPerson = 1;

        for (int i = 0; i < amount; i++) {
            // selecciono un elemento random de mis arrays
            int randomNameIndex = random.nextInt(names.length);
            String randomName = names[randomNameIndex];

            int accesLevel = random.nextInt(5);

            int randomCareerIndex = random.nextInt(roles.length);
            String randomCareer = roles[randomCareerIndex];

            boolean isHacker;

            isHacker = randomIsHacker == i;


            Person newemployee = new Person(randomName, accesLevel, randomCareer, isHacker, numberPerson);

            employees[i] = newemployee;

            numberPerson++;
        }
        return employees;
    }

    /* Muestra la lista de empleados registrados. */
    public void showEmployees() {

        for (Person employee : employees) {
            System.out.println("Empleado numero : " + employee.numberPerson);
            employee.showData();
            System.out.println("");

        }
    }

    /* Ejecuta pruebas de seguridad en los empleados para detectar al hacker.
     El usuario puede realizar 3 pruebas de seguridad como maximo. */
    public void performTests() {
        int accumulator = 0;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("Realizado la prueba, las respuestas de los empleados son: ");
            for (int i = 0; i < employees.length; i++) {
                employees[i].performSecurityTest();
            }
            accumulator++;
            System.out.println("desea arriesgar un sospechoso? yes/no :");
            String response = reader.next();
            if (Objects.equals(response, "yes")) {
                System.out.println("Ingrese el numero del sospechoso : ");
                int suspicious = reader.nextInt();
                boolean valueOfTest = identifyHacker(suspicious);

                if (valueOfTest) {
                    System.out.println(""" 
                            \n 
                            Encontraste al Hacker, felicitaciones !!
                            ahora el mundo es un lugar mas seguro ✮
                            """);
                    break;
                } else {
                    System.out.println(" \n hagamos otra prueba! 🧪 \n");
                }
            }
        } while (accumulator < 3);
        if (accumulator > 3 ){

            System.out.println("""
            \n
            Oh no! ahora el Hacker se nos ha escapado!! \n
            Creo que las noticias mañana serán muy interesantes 🤣 \n
            \n
            """);
        }
        reader.close();

    }

    /* El usuario elige a un sospechoso y el sistema revela si acertó o falló. */
    public boolean identifyHacker(int number) {
        HashMap<Integer, Boolean> hackerId = new HashMap<>();

        for (Person employee : employees) {
            hackerId.put(employee.numberPerson, employee.getIsHacker(employee.numberPerson));
        }
        if (hackerId.containsKey(number)) {
            boolean isHacker = hackerId.get(number);
            if (isHacker) {
                System.out.println("¡El hacker ha sido identificado!");
                employees[number].showData();
                return true;
            } else {
                System.out.println("No es el Hacker");
                return false;
            }


        }
        System.out.println("Número no encontrado en la base de datos.");
        return false;
    }
}
