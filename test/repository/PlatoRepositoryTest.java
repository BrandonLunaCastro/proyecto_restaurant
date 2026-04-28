package repository;

import model.Plato;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PlatoRepositoryTest {

    private PlatoRepository repo;

    // Se ejecuta antes de cada test, dejando siempre un estado limpio, en este caso cada test arranca con siempre con dos platos
    @BeforeEach
    void setUp() {
        repo = new PlatoRepository();
        repo.add(new Plato(1, "Milanesa", 1500.0, "Principal"));
        repo.add(new Plato(2, "Ensalada", 800.0, "Entrada"));
    }


    @Test
    @DisplayName("Agregar un plato incrementa el tamanio de la lista")

    /* Primer test agrega un elemento mas al array que simula la base de
     * datos y luego verifica que efectivamente se encuentren 3 elementos en el array
    */
    void testAdd_incrementaLista() {
        // Act
        repo.add(new Plato(3, "Postre", 600.0, "Postre"));

        // Assert
        assertEquals(3, repo.getPlatos().size());
    }

    @Test
    @DisplayName("El plato agregado se encuentra en la lista")
    /*
    * Agrega el plato y recorre la lista buscando si existe alguno con id = 3 y
    * luego verifica que realmente fue guardado
    * */

    void testAdd_platoExisteEnLista() {
        Plato nuevo = new Plato(3, "Postre", 600.0, "Postre");

        repo.add(nuevo);

        assertTrue(repo.getPlatos().stream().anyMatch(p -> p.getId() == 3));
    }

    @Test
    @DisplayName("Eliminar un plato existente reduce el tamanio de la lista")
    // Elimina el plato con id 1
    void testDelete_eliminaCorrectamente() {
        repo.delete(1);
        //verifica que la lista quedo con un solo elemento
        assertEquals(1, repo.getPlatos().size());
    }

    @Test
    @DisplayName("El plato eliminado ya no existe en la lista")
    //Elimina el id 1
    void testDelete_platoNoExisteEnLista() {
        repo.delete(1);
        // verifica que ya no existe ningún plato con ese id en la lista.
        assertFalse(repo.getPlatos().stream().anyMatch(p -> p.getId() == 1));
    }

    @Test
    @DisplayName("Eliminar un id inexistente no modifica la lista")
    //Intenta eliminar un id que no existe (99) y verifica que la lista sigue teniendo 2 elementos
    void testDelete_idInexistenteNoModificaLista() {
        repo.delete(99);
        // pasa el test ya que no elimina nada debido a que no se encuentra el plato con id 99
        assertEquals(2, repo.getPlatos().size());
    }


    @Test
    @DisplayName("Listar retorna todos los platos cargados")
    //verifica que los dos platos esten efectivamente bien cargados
    void testGetPlatos_retornaTodos() {
        assertEquals(2, repo.getPlatos().size());
    }

    @Test
    @DisplayName("La lista esta vacia si no se agrego nada")
    void testGetPlatos_listaVacia() {
        //crea un repositorio nuevo
        PlatoRepository repoVacio = new PlatoRepository();
        // verifica que este vacio
        assertTrue(repoVacio.getPlatos().isEmpty());
    }
}
