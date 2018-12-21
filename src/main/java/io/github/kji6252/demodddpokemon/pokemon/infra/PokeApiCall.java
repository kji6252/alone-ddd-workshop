package io.github.kji6252.demodddpokemon.pokemon.infra;

import io.github.kji6252.demodddpokemon.pokemon.domain.Pokemon;
import io.github.kji6252.demodddpokemon.pokemon.domain.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Name;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;

public class PokeApiCall implements PokemonRepository {
    @Override
    public Pokemon findByNumber(int number) {
        final PokeApi pokeApi = new PokeApiClient();
        final PokemonSpecies pokemonSpecies = pokeApi.getPokemonSpecies(number);
        final String pokemonName = pokemonSpecies.getNames()
                .stream()
                .filter(name -> name.getLanguage().getId() == 3)
                .findFirst()
                .map(Name::getName)
                .get();
        final int captureRate = pokemonSpecies.getCaptureRate();
        final String url = pokeApi.getPokemon(number).getSprites().getFrontDefault();

        return new Pokemon(number, pokemonName, url, captureRate);
    }
}
