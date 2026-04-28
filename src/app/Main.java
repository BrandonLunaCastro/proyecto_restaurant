import model.ImputValidator;
import model.Plato;
import repository.PlatoRepository;

import java.util.Scanner;

import static model.ImputValidator.readInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
// agregar platos

    Scanner sc = new Scanner(System.in);
    PlatoRepository platoRepository = new PlatoRepository();
    // int option;

    System.out.println("Bienvenido al Sistema");
    System.out.println("Seleccione una de las siguientes opciones");


    while (true) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Listar todos los platos");
        System.out.println("2. Agregar un plato ");
        System.out.println("3. Eliminar un plato ");
        System.out.println("4. Para finalizar ");

        int option = ImputValidator.readInt(sc , "Opcion: ");


        if (option == 1) {
            if (platoRepository.getPlatos().isEmpty()){
                System.out.println("No hay platos registrados");
            } else {
                for (Plato p : platoRepository.getPlatos()) {
                    System.out.println(p);

                }
            }
        }
        else if(option == 2) {
            //System.out.println("Ingrese un id para su plato ");
            int id = ImputValidator.readInt(sc , "Asigne un Identificador al plato: ");
            //sc.nextInt();
            // sc.nextLine();

            System.out.println("Ingrese un nombre para su plato ");
            String name = sc.nextLine();

            // System.out.println("Ingrese un precio para su plato ");
            // double price = sc.nextDouble();
            double price = ImputValidator.readDouble(sc, "Ingrese el precio para su plato ");
            System.out.print("Ingrese una categoria para su plato ");
            String category = sc.nextLine();

            Plato plato = new Plato(id, name, price, category);
            platoRepository.add(plato);
            System.out.print("Plato agregado correctamente");
        }
        //logica para eliminar un plato
        else if(option == 3) {
            // System.out.println("Ingrese el identificador del plato que quiera eliminar");
            int id = ImputValidator.readInt(sc , "Ingrese el identificador del plato a eliminar: ");
            platoRepository.delete(id);
        }

        else if(option == 4){
            System.out.println("Finalizando la ejecucion del programa...");
            sc.close();
            break;
        }
        else  {
            System.out.println("Ingrese una opcion valida");
        }

    }




}
