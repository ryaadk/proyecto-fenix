package com.example;

import java.util.List;

/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {

    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins = getAdmins(admins, nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados = getInvitados(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String getInvitados(String invitados, String nombre) {
        invitados = getAdmins(invitados, nombre);
        return invitados;
    }

    private String getAdmins(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
}