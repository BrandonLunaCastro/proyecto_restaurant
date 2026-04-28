package utils;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class ImputValidatorTest {
    @Test
    @DisplayName("readInt retorna el numero correcto cuando la entrada es valida")
    void testReadInt_entradaValida() {
        Scanner sc = new Scanner("5\n");

        int resultado = ImputValidator.readInt(sc, "");

        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("readDouble retorna el numero correcto cuando la entrada es valida")
    void testReadDouble_entradaValida() {
        Scanner sc = new Scanner("10.50\n");

        double resultado = ImputValidator.readDouble(sc, "");

        assertEquals(10.50, resultado);
    }

    @Test
    @DisplayName("readInt acepta el numero despues de una entrada invalida")
    void testReadInt_recuperaDespuesDeEntradaInvalida() {
        // Simula que el usuario escribe "abc" primero, luego "3"
        Scanner sc = new Scanner("abc\n3\n");

        int resultado = ImputValidator.readInt(sc, "");

        assertEquals(3, resultado);
    }

    @Test
    @DisplayName("readDouble acepta el numero despues de una entrada invalida")
    void testReadDouble_recuperaDespuesDeEntradaInvalida() {
        Scanner sc = new Scanner("precio\n9.99\n");

        double resultado = ImputValidator.readDouble(sc, "");

        assertEquals(9.99, resultado);
    }
}
