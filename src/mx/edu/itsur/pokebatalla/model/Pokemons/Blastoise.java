package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.moves.HidroBomba;
import mx.edu.itsur.pokebatalla.model.moves.Niebla;
import mx.edu.itsur.pokebatalla.model.moves.PistolaAgua;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Blastoise extends Pokemon{
    
    public enum Movimientos {
        HIDROBOMBA,
        NIEBLA,
        PISTOLA_AGUA
    }
    
    public Blastoise(){
        this.tipo = "AGUA";
        this.hp = 64;
        this.ataque = 51;
        this.defensa = 90;
        this.nivel = 1;
        this.precision = 5;
    }
    
    public Blastoise(String nombre){
        this();
        this.nombre = nombre;
    }
    
    @Override
    public Enum[] getMovimiento() {
        return Blastoise.Movimientos.values();
    }
    
    @Override
    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        if (this.hp <= 0) {
            System.out.println("Blastoise esta agotado y no puede realizar mas movimientos.");
            return;
        }
        
        Blastoise.Movimientos movimientoAUtilizar = Blastoise.Movimientos.values()[ordinalMovimiento];
        Movimiento instanciaMovimiento;
        
        switch(movimientoAUtilizar) {
            case HIDROBOMBA:
                instanciaMovimiento = new HidroBomba();
                break;
            case NIEBLA:
                instanciaMovimiento = new Niebla();
                break;
            case PISTOLA_AGUA:
                instanciaMovimiento = new PistolaAgua();
            default:
                throw new AssertionError();
        }
        instanciaMovimiento.utilizar(this, oponente);
    }
}