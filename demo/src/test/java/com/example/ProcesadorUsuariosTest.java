package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ProcesadorUsuariosTest {

    @Test
    void testProcesarListaComportamientoActual() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();

        List<String> lista = List.of("Ana:1", "Luis:2", "Eva:1", "Juan:99");

        String resultado = procesador.procesarLista(lista);

        assertEquals("Admins: Ana,Eva, | Invitados: Luis,", resultado);
    }

    @Test
    void testProcesarListaVacia() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();
        List<String> lista = List.of();

        String resultado = procesador.procesarLista(lista);

        assertEquals("Admins:  | Invitados: ", resultado);
    }
}