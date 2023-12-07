package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.moves.Ascuas;
import mx.edu.itsur.pokebatalla.model.moves.Derribo;
import mx.edu.itsur.pokebatalla.model.moves.Rugido;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Charmander extends Pokemon {
    
    public enum Movimientos {
        ASCUAS,
        DERRIBO,
        RUGIDO
    }
        
    public Charmander() {
        this.tipo = "FUEGO";
        this.hp = 84;
        this.ataque = 35;
        this.defensa = 84;
        this.nivel = 1;
        this.precision = 4;
    }    
    
    public Charmander(String nombre){
        this(); 
        this.nombre = nombre;
    }
    
    @Override
    public Enum[] getMovimiento() {
        return Charmander.Movimientos.values();
    }

    @Override
    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        if (this.hp <= 0) {
            System.out.println("Charmander esta agotado y no puede realizar mas movimientos.");
            return;
        }

        Charmander.Movimientos movimientoAUtilizar = Charmander.Movimientos.values()[ordinalMovimiento];
        Movimiento instanciaMovimiento;

        switch (movimientoAUtilizar) {
            case ASCUAS:
                instanciaMovimiento = new Ascuas();
                break;
            case DERRIBO:
                instanciaMovimiento = new Derribo();
                break;
            case RUGIDO:
                instanciaMovimiento = new Rugido();
                break;
            default:
                throw new AssertionError();
        }

        instanciaMovimiento.utilizar(this, oponente);
    }
    
}