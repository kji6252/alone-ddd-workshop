package io.github.kji6252.demodddpokemon.pokemon.domain;

public interface PokemonRepository {
    Pokemon findByNumber(int number);
}
