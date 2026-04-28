import model.Plato;
import repository.PlatoRepository;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
// agregar platos

    Scanner sc = new Scanner(System.in);
    PlatoRepository platoRepository = new PlatoRepository();
    int option;

    System.out.println("Bienvenido al Sistema");
    System.out.println("Seleccione una de las siguientes opciones");

    while (true) {
        System.out.println("Para listar todos los platos 1");
        System.out.println("Para agregar un plato 2 ");
        System.out.println("Para eliminar un plato 3");
        System.out.println("Para salir precione 0");
        option = sc.nextInt();

        if (option == 1) {
            for (Plato p : platoRepository.getPlatos()) {
            System.out.println(p);
        }
        }
        if(option == 2) {
            System.out.println("Ingrese un id para su plato ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese un nombre para su plato ");
            String name = sc.nextLine();

            System.out.println("Ingrese un precio para su plato ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Ingrese una categoria para su plato ");
            String category = sc.nextLine();

            Plato plato = new Plato(id, name, price, category);

            platoRepository.add(plato);
        }
        //logica para eliminar un plato
        if(option == 3) {
            System.out.println("Ingrese el identificador del plato que quiera eliminar");
            int id = sc.nextInt();
            sc.nextLine();
            platoRepository.delete(id);
        }

        if(option == 0){
            System.out.println("Finalizando la ejecucion del programa...");
            break;
        }

    }




}
