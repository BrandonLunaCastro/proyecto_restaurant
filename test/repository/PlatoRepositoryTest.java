package repository;

import model.Plato;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PlatoRepositoryTest {

    private PlatoRepository repo;

    // Arrange: se ejecuta antes de cada test, dejando siempre un estado limpio
    @BeforeEach
    void setUp() {
        repo = new PlatoRepository();
        repo.add(new Plato(1, "Milanesa", 1500.0, "Principal"));
        repo.add(new Plato(2, "Ensalada", 800.0, "Entrada"));
    }

    // --- TEST DE AGREGAR ---

    @Test
    @DisplayName("Agregar un plato incrementa el tamanio de la lista")
    void testAdd_incrementaLista() {
        // Act
        repo.add(new Plato(3, "Postre", 600.0, "Postre"));

        // Assert
        assertEquals(3, repo.getPlatos().size());
    }

    @Test
    @DisplayName("El plato agregado se encuentra en la lista")
    void testAdd_platoExisteEnLista() {
        Plato nuevo = new Plato(3, "Postre", 600.0, "Postre");

        repo.add(nuevo);

        assertTrue(repo.getPlatos().stream().anyMatch(p -> p.getId() == 3));
    }

    // --- TEST DE ELIMINAR ---

    @Test
    @DisplayName("Eliminar un plato existente reduce el tamanio de la lista")
    void testDelete_eliminaCorrectamente() {
        repo.delete(1);

        assertEquals(1, repo.getPlatos().size());
    }

    @Test
    @DisplayName("El plato eliminado ya no existe en la lista")
    void testDelete_platoNoExisteEnLista() {
        repo.delete(1);

        assertFalse(repo.getPlatos().stream().anyMatch(p -> p.getId() == 1));
    }

    @Test
    @DisplayName("Eliminar un id inexistente no modifica la lista")
    void testDelete_idInexistenteNoModificaLista() {
        repo.delete(99);

        assertEquals(2, repo.getPlatos().size());
    }

    // --- TEST DE LISTAR ---

    @Test
    @DisplayName("Listar retorna todos los platos cargados")
    void testGetPlatos_retornaTodos() {
        assertEquals(2, repo.getPlatos().size());
    }

    @Test
    @DisplayName("La lista esta vacia si no se agrego nada")
    void testGetPlatos_listaVacia() {
        PlatoRepository repoVacio = new PlatoRepository();

        assertTrue(repoVacio.getPlatos().isEmpty());
    }
}
