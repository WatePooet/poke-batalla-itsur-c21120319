package mx.edu.itsur.pokebatalla.model.battles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Entrenador implements Serializable{
    protected String nombre;
    protected List<Pokemon> pokemonsCapturados;
    protected Pokemon pokemonActual;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        pokemonsCapturados = new ArrayList<>();
    }
    
    public void capturarPokemon(Pokemon pk){
        pokemonsCapturados.add(pk);
    }
    
    public void instruirMovimientoAlPokemonActual(Pokemon oponente, int ordinalMovimiento){
        this.pokemonActual.atacar(oponente, ordinalMovimiento);
    }
    
    public boolean estaDerotado(){
        int sumaHP = 0;
        for (Pokemon pokemon : pokemonsCapturados) {
        sumaHP += pokemon.getHp();
        }
        
        return (sumaHP <= 0);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void setPokemonActual(Pokemon p) {
        this.pokemonActual = p;
    }

    public List<Pokemon> getPokemonsCapturados() {
        return this.pokemonsCapturados;
    }
}
