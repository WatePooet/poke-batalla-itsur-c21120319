package mx.edu.itsur.pokebatalla.model.battles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;
import mx.edu.itsur.pokebatalla.FileManager;
import java.io.Serializable;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Batalla implements Serializable{
    
    protected Entrenador entrenador1;
    protected Entrenador entrenador2;
    protected int turno = 1;
    protected boolean batallaFinalizada = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void desarrollarBatalla() {
        Entrenador entrenadorEnTurno = null;
        Entrenador entrenadorOponente = null;

        System.out.println("NUEVA BATALLA!!\n");
        System.out.println(entrenador1.nombre + " V.S " + entrenador2.nombre);
        System.out.println("\n-------------------------------------------\n");
        
        do {
            try {
                seleccionarPokemon(entrenador1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("SOLO CUENTAS CON " + entrenador1.getPokemonsCapturados().size()
                        + " ELIGE ALGUNO DE ELLOS!!! \n");
                entrenador1.setPokemonActual(null);
            }
        } while (entrenador1.getPokemonActual() == null);

        do {
            try {
                seleccionarPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("SOLO CUENTAS CON " + entrenador2.getPokemonsCapturados().size()
                        + " ELIGE ALGUNO DE ELLOS!!! \n");
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

    while (!batallaFinalizada) {

            if (turno == 1) {
                entrenadorEnTurno = entrenador1;
                entrenadorOponente = entrenador2;
            } else {
                entrenadorEnTurno = entrenador2;
                entrenadorOponente = entrenador1;
            }
            System.out.println("Es el turno de: " + entrenadorEnTurno.nombre);

            System.out.println(entrenadorEnTurno.getNombre() + " tu Pokemon actual es: " + entrenadorEnTurno.getPokemonActual());
            System.out.println("El Pokemon de tu oponente " + entrenadorOponente.getNombre() + " es: " + entrenadorOponente.getPokemonActual());
            System.out.println("Deseas cambiar de Pokemon?");
            System.out.println("1 -> NO");
            System.out.println("2 -> SI");
char auxLectura = '0';
while (auxLectura != '1' && auxLectura != '2') {
    try {
        auxLectura = (char) System.in.read();
        System.in.read(new byte[System.in.available()]);
        if (auxLectura != '1' && auxLectura != '2') {
            System.out.println("Por favor, elige 1 o 2.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
if (auxLectura == '2') {
    do {
        try {
            seleccionarPokemon(entrenador1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("SOLO CUENTAS CON " + entrenador1.getPokemonsCapturados().size()
            + " ELIGE ALGUNO DE ELLOS!!! \n");
            entrenadorEnTurno.setPokemonActual(null);
        }
    } while (entrenadorEnTurno.getPokemonActual() == null);
}
if (auxLectura == '1') {
    auxLectura = '0';
    do {
        for (Enum movimiento : entrenadorEnTurno.getPokemonActual().getMovimiento()) {
            System.out.println(movimiento.ordinal() + 1 + " " + movimiento.name());
        }
        System.out.println("");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = null;
            while (input == null || input.length() != 1) {
                try {
                    input = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            auxLectura = input.charAt(0);
            if (auxLectura < '1' || auxLectura > '3') {
                throw new IndexOutOfBoundsException("\n        "
                + "ELIGE UNA TECLA DEL 1 AL 3.");
            }
            entrenadorEnTurno.instruirMovimientoAlPokemonActual(entrenadorOponente.
            getPokemonActual(), Character.getNumericValue(auxLectura) - 1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
            auxLectura = '0';
        }
    } while (auxLectura < '1' || auxLectura > '3');
}
if (entrenadorOponente.estaDerotado()) {
    System.out.println(entrenadorOponente.getNombre() + " esta derrotado!!!");
    System.out.println("Felicidades " + entrenadorEnTurno.getNombre() + "!! HAS GANADO LA BATALLA!!!");
    batallaFinalizada = true;
} else {
    if (turno == 1) {
        turno = 2;
    } else {
        turno = 1;
    }
}
System.out.println("-----------------------------------------");
FileManager.guardarHaciaArchivo(this);
    }
    }
    
    private void seleccionarPokemon(Entrenador ent) {
        char auxLectura = '0';
                   
        System.out.println("Cual de los siguientes Pokemon desea utilizar " + ent.nombre + "?");
        int auxCount = 1;
        for (Pokemon p : ent.getPokemonsCapturados()) {
            System.out.println(auxCount + " -> " + p);
            auxCount++;
        }
        try {
            auxLectura = (char) System.in.read(); 
            System.in.read(new byte[System.in.available()]); 

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Pokemon pokemonSeleccionado = ent.getPokemonsCapturados()
                .get(Character.getNumericValue(auxLectura) - 1);

        ent.setPokemonActual(pokemonSeleccionado);
        System.out.println(ent.nombre + " ha seleccionado a: " + ent.getPokemonActual());
        System.out.println("-----------------------------------------");

    }

}