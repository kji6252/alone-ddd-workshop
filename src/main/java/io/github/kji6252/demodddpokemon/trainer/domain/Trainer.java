package io.github.kji6252.demodddpokemon.trainer.domain;

import java.util.List;

public class Trainer {
    private String id;
    private int level;
    private Party party;

    public Trainer(String id) {
        this.id = id;
        this.level = 1;
        this.party = new Party();
    }

    public void levelUp() {
        if (this.level < 30) {
            this.level++;
        }
    }

    public void gotPokemon(final PokemonCaught pokemonCaught){
        this.party.add(pokemonCaught);
        levelUp();
    }

    public double getTrainerBonus() {
        if(this.level <= 10) {
            return 1.0;
        }
        return this.level / 10.0 ;
    }
}
