import java.util.Scanner;

public class Main {
    /* ✅ Generar una lista de empleados (mínimo 5, incluyendo un hacker).
       ✅ Mostrar la lista de empleados sin revelar al hacker.
       ✅ Permitir al usuario realizar pruebas para analizar el comportamiento de los empleados.
       ✅ Permitir al usuario hacer una acusación y revelar si atrapó al hacker o si falló.
       ✅ Si el usuario falla, el hacker escapa con los datos.  */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("""
                \n
                Las megacorporaciones han tomado el control de los gobiernos y \n
                luchan por el dominio digital. Un grupo de hackers anónimos conocidos \n
                como "🏴‍☠️ Glitch Society 🏴‍☠️" han infiltrado el Sistema Central de Seguridad \n
                Global (SCSG), amenazando con liberar información altamente clasificada.\n
                Eres un agente de la Unidad de Ciberseguridad (UC) y tu misión es descubrir al hacker infiltrado\n
                antes de que robe los datos. Sin embargo, el problema es que el hacker se oculta\n
                entre los empleados del SCSG y se hace pasar por un trabajador normal.\n
                
                Are you ready? Let's go! \n
                \n
                \n
                Cuantos empleados desea analizar?
                """);
        int amount = reader.nextInt();

        if( amount > 5 && amount <= 20) {
            SecuritySystem employees = new SecuritySystem(amount);
            employees.showEmployees();

            System.out.println(""" 
                    \n
                    Perfecto, ya has generado los emplados, ahora tomemos sus declaraciones, \n
                    son muy sospechosos aquellos que no pueden responder un numero mayor a 5 \n
                   
                    
                    """);

            employees.performTests();
            reader.close();

        } else {
            System.out.println("Por favor, ingrese un numero mayor a 5 y menor a 20");
        }


    }


}
