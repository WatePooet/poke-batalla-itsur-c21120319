package mx.edu.itsur.pokebatalla;

import mx.edu.itsur.pokebatalla.model.Pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.Pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.Pokemons.Raichu;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pidgeot;
import mx.edu.itsur.pokebatalla.model.Pokemons.Gyarados;
import mx.edu.itsur.pokebatalla.model.Pokemons.Blastoise;
import mx.edu.itsur.pokebatalla.model.battles.Batalla;
import mx.edu.itsur.pokebatalla.model.battles.Entrenador;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hola Pokemon\n");

        Charmander chr = new Charmander();
        Raichu rai = new Raichu();
        Pidgeot pid = new Pidgeot();
        Gyarados gya = new Gyarados();
        Pikachu pik = new Pikachu();
        Blastoise blas = new Blastoise();
        
        Entrenador ent1 = new Entrenador("RED");
        ent1.capturarPokemon(chr);
        ent1.capturarPokemon(rai);
        ent1.capturarPokemon(pid);
        
        Entrenador ent2 = new Entrenador("BLUE");
        ent2.capturarPokemon(gya);
        ent2.capturarPokemon(pik);
        ent2.capturarPokemon(blas);
        
        Batalla a = null;
        
        Batalla batallaGuardada = FileManager.leerDesdeArchivo();
        
        if(batallaGuardada != null){
            a = batallaGuardada;
        } else {
            a = new Batalla(ent1, ent2);                 
        }
        a.desarrollarBatalla();
    }
}
