package es.upm.miw.mastermind.utils;

public enum Message {
    WELLCOME("Bienvenido a mastermind"),
    GAME_OPTION_HUMAN("1. Partida "),
    GAME_OPTION_CPU("2. Demo "),
    OPTION(" ¿Qué opción desea escoger? "),
    SECRET("*"),
    READ_PLAY("¿Intento? [%d letras entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro] "),
    DEAD("%d muerto/s "),
    INJURED("%d herido/s "),
    VICTORY("¡¡¡%d muertos!!! VICTORIA "),
    CONTINUE("Han pasado todos los turnos disponibles "),
    PLAY_AGAIN("¿Quiere seguir jugando?[S/N] "),
    GOODBYE("Hasta la próxima"),
    SECRET_WAS("La combinación secreta era: [%s] ");

    private String value;

    private Message(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    } 
}
