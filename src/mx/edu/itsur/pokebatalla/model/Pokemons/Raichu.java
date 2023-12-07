package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.moves.Impactrueno;
import mx.edu.itsur.pokebatalla.model.moves.Rayo;
import mx.edu.itsur.pokebatalla.model.moves.Malisioso;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Raichu extends Pokemon {
    
    public enum Movimientos {
        IMPACTRUENO,
        RAYO,
        MALISIOSO,
    }
        
    public Raichu() {
        this.tipo = "ELECTRICO";
        this.hp = 59;
        this.ataque = 66;
        this.defensa = 90;
        this.nivel = 1;
        this.precision = 4;
    }    
    
    public Raichu(String nombre){
        this(); 
        this.nombre = nombre;
    }
    
    @Override
    public Enum[] getMovimiento() {
        return Raichu.Movimientos.values();
    }

    @Override
    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        if (this.hp <= 0) {
            System.out.println("Raichu esta agotado y no puede realizar mas movimientos.");
            return;
        }

        Raichu.Movimientos movimientoAUtilizar = Raichu.Movimientos.values()[ordinalMovimiento];
        Movimiento instanciaMovimiento;

        switch (movimientoAUtilizar) {
            case IMPACTRUENO:
                instanciaMovimiento = new Impactrueno();
                break;
            case RAYO:
                instanciaMovimiento = new Rayo();
                break;
            case MALISIOSO:
                instanciaMovimiento = new Malisioso();
                break;
            default:
                throw new AssertionError();
        }

        instanciaMovimiento.utilizar(this, oponente);
    }
    
}