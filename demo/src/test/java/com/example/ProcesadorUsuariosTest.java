package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
// PEQUEÑO CAMBIO

/**
 * Clase de pruebas unitarias para verificar el correcto funcionamiento de ProcesadorUsuarios.
 * <p>
 * Esta clase garantiza la red de seguridad necesaria antes y después de la refactorización,
 * comprobando tanto el flujo normal como los casos borde (listas vacías).
 * </p>
 *
 * @author Ryad Khaj Jy El Mrabet
 * @version 1.0
 */
class ProcesadorUsuariosTest {

    /**
     * Verifica que el método procesarLista mantiene el comportamiento original del código heredado.
     * <p>
     * Se prueba una lista mixta con administradores (1), invitados (2) y
     * usuarios con roles desconocidos (99) para asegurar que el filtrado es correcto.
     * </p>
     */
    @Test
    void testProcesarListaComportamientoActual() {
        // 1. Configuración (Arrange)
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();

        // Lista con datos de prueba: Ana(Admin), Luis(Invitado), Eva(Admin), Juan(Ignorado)
        List<String> lista = List.of("Ana:1", "Luis:2", "Eva:1", "Juan:99");

        // 2. Ejecución (Act)
        String resultado = procesador.procesarLista(lista);

        // 3. Verificación (Assert)
        // Nota: Se valida que el formato de salida sea idéntico al original, incluyendo las comas finales.
        assertEquals("Admins: Ana,Eva, | Invitados: Luis,", resultado);
    }

    /**
     * Verifica el comportamiento del procesador cuando recibe una lista vacía.
     * <p>
     * El resultado esperado no debe contener nombres, pero sí la estructura base del mensaje.
     * </p>
     */
    @Test
    void testProcesarListaVacia() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();
        List<String> lista = List.of();

        String resultado = procesador.procesarLista(lista);

        assertEquals("Admins:  | Invitados: ", resultado);
    }
}