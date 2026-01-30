package com.example;

import java.util.List;
// Probando


/**
 * Esta clase procesa listas de usuarios y los clasifica según su rol.
 * <p>
 * Contiene la lógica refactorizada para identificar administradores e invitados
 * a partir de una lista de cadenas de texto.
 * </p>
 * * @author Ryad Khaj Jy El Mrabet
 * @version 1.0
 */
public class ProcesadorUsuarios {

    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

    /**
     * Procesa una lista de usuarios en formato texto y devuelve un resumen clasificado.
     * <p>
     * Recorre la lista, parsea el rol de cada usuario y concatena los nombres
     * en la categoría correspondiente.
     * </p>
     *
     * @param usuarios Lista de cadenas de texto donde cada elemento tiene el formato "Nombre:CódigoRol". 
     * Ejemplo: "Ana:1" o "Luis:2".
     * @return Una cadena de texto (String) formateada que muestra los nombres de los 
     * administradores y de los invitados separados por comas.
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                try {
                    int rol = Integer.parseInt(parts[1]);

                    // Número Mágico refactorizado a constante: 1 es Admin
                    if (rol == ROL_ADMIN) {
                        admins = getAdmins(admins, nombre);
                    }
                    // Número Mágico refactorizado a constante: 2 es Invitado
                    else if (rol == ROL_INVITADO) {
                        invitados = getInvitados(invitados, nombre);
                    }
                } catch (NumberFormatException e) {
                    // Se ignora si el rol no es un número válido
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    /**
     * Método auxiliar para concatenar un nombre a la lista de invitados.
     *
     * @param invitados La cadena actual de nombres de invitados.
     * @param nombre El nombre del nuevo invitado a añadir.
     * @return La cadena de invitados actualizada con el nuevo nombre y una coma.
     */
    private String getInvitados(String invitados, String nombre) {
        invitados = getAdmins(invitados, nombre);
        return invitados;
    }

    /**
     * Método auxiliar para concatenar un nombre a la lista de administradores.
     *
     * @param admins La cadena actual de nombres de administradores.
     * @param nombre El nombre del nuevo administrador a añadir.
     * @return La cadena de admins actualizada con el nuevo nombre y una coma.
     */
    private String getAdmins(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
}