import java.util.Random;

public class SecuritySystem {
        Person[] employees;
        String[] names = {"Juan", "Alejandro", "Camila", "Esteban", "Mary", "Lucia", "Brian", "Matilda", "Luis", "Sandra"};
        String[] roles = {"Analista", "Ingeniero", "Técnico", "Administrador"};
        boolean hackerIdentified = false;

        private SecuritySystem (Person[] employee, String[] names, String[] roles, boolean hackerIdentified) {
            this.employees = employee;
            this.names = names;
            this.roles = roles;
            this.hackerIdentified = hackerIdentified;
        }

        /* Crea empleados con nombres aleatorios y asigna uno de ellos como hacker. */
        public void generateEmployees(int amount) {
            employees = new Person[amount];
            Random random = new Random();
            int randomIsHacker = random.nextInt(amount) + 1;

            for(int i = 0; i < amount; i ++) {
                // selecciono un elemento random de mis arrays
                int randomNameIndex = random.nextInt(names.length);
                String randomName = names[randomNameIndex];

                int accesLevel = random.nextInt(5) + 1;

                int randomCareerIndex = random.nextInt(roles.length);
                String randomCareer = roles[randomCareerIndex];

                boolean isHacker;

                isHacker = randomIsHacker == i;

                employees[i] = new Person(randomName,accesLevel,randomCareer,isHacker);
            }
        }
        /* Muestra la lista de empleados registrados. */
        public void showEmployees() {

        }
        /* Ejecuta pruebas de seguridad en los empleados para detectar al hacker.
         El usuario puede realizar 3 pruebas de seguridad como maximo. */
        public void performTests() {

        }
        /* El usuario elige a un sospechoso y el sistema revela si acertó o falló. */
        public void identifyHacker(String name) {

        }

}
