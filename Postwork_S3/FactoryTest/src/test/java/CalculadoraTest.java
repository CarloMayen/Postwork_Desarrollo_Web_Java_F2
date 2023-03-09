import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @TestFactory
    @DisplayName("1000 pruebas de multiplicaciones")
    Stream<DynamicTest> dynamicTestsForMultiplica() {
        // Crea una lista con numero de 0 a 999 (1000 elementos)
        List<Integer> casesInput = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        // Crea una lista con numero de 0 a 999 (1000 elementos) y multiplica por dos(n -> n * 2), cada elemento de la lista
        List<Integer> casesResponses = IntStream.range(0, 1000).map(n -> n * 5).boxed().collect(Collectors.toList());

        // Recorre nuestra lista de números sin ninguna operación, y hace la prueba dinámica con la variable numero que es el elemento actual del recorrido de la lista.
        // DynamicTest.dynamicTest(), envía dos parámetros:
        // DisplayName = "Multiplica: " + numero + " * 2"
        // función Lambda que llama al método a probar, enviándola como 1er parámetro en el método assertEquals(), y e el segundo parámetro de el numero de nuestra segunda lista
        // que contiene los resultados.
        return casesInput.stream().map(numero -> DynamicTest.dynamicTest("Multiplica: " + numero + " * 5", () -> {
            assertEquals(calculadora.multiplica(numero, 5), casesResponses.get(numero));
        }));
    }

    @TestFactory
    @DisplayName("1000 pruebas de sumas")
    Stream<DynamicTest> dynamicTestsForSuma() {
    }

    @TestFactory
    @DisplayName("1000 pruebas de restas")
    Stream<DynamicTest> dynamicTestsForResta() {
    }

    @TestFactory
    @DisplayName("1000 pruebas de divisiones")
    Stream<DynamicTest> dynamicTestsForDivicion() {
    }

    @TestFactory
    @DisplayName("1000 pruebas de divisiones entre 0")
    Stream<DynamicTest> dynamicTestsForDivicionByZero() {
        List<Integer> casesInput = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        // Respuesta general para recibir el mensaje de la excepción.
        String exceptionResponse = "No es posible dividir un valor entre 0";
        return casesInput.stream().map(numero -> DynamicTest.dynamicTest("Divide: " + numero + " / 0", () -> {
            assertEquals(assertThrows(IllegalArgumentException.class, () -> calculadora.divide(numero, 0)).getMessage(),
                    exceptionResponse);
        }));
    }
}