package utils;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


//En estos test se simula la entrada del usuario pasandole un scanner con texto predefinido , sin
// tener la necesidad de escrbir por teclado
class ImputValidatorTest {
    @Test
    @DisplayName("readInt retorna el numero correcto cuando la entrada es valida")
    void testReadInt_entradaValida() {
        // ingresamos cinco espacios vacios
        Scanner sc = new Scanner("5\n");

        int resultado = ImputValidator.readInt(sc, "");
        // verifica que efectivamente esten los 5 caracteres en la variable resultado
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("readDouble retorna el numero correcto cuando la entrada es valida")
    void testReadDouble_entradaValida() {
        // ingresamos el numero 10.50 como si lo hiciera de forma manual el usuario
        Scanner sc = new Scanner("10.50\n");

        double resultado = ImputValidator.readDouble(sc, "");
        // verifica que el resultado esperado sea el que ingresamos previamente
        assertEquals(10.50, resultado);
    }

    @Test
    @DisplayName("readInt acepta el numero despues de una entrada invalida")
    void testReadInt_recuperaDespuesDeEntradaInvalida() {
       /* Simula que el usuario escribe primero abc (texto inválido) y luego 3.
       Verifica que readInt ignora el error, pide de nuevo y devuelve 3.
        Esto prueba que tu validador es robusto.*/

        Scanner sc = new Scanner("abc\n3\n");

        int resultado = ImputValidator.readInt(sc, "");

        assertEquals(3, resultado);
    }

    @Test
    @DisplayName("readDouble acepta el numero despues de una entrada invalida")
    void testReadDouble_recuperaDespuesDeEntradaInvalida() {
        // en este caso ingresa precio (invalido ya que solo acepta datos tipo double) y luego 9.99
        Scanner sc = new Scanner("precio\n9.99\n");

        double resultado = ImputValidator.readDouble(sc, "");
        // verifica el resultado esperado
        assertEquals(9.99, resultado);
    }
}
