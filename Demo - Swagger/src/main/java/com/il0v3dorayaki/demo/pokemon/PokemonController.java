package com.il0v3dorayaki.demo.pokemon;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@OpenAPIDefinition(info = @Info(
        description = "This is a sample server Pokemon",
        version = "1.0.0",
        title = "Swagger Pokemon"
))
@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    List<Pokemon> pokemonList = new ArrayList<>();

    public PokemonController() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", "Seed");
        pokemon1.addType("Grass");
        pokemon1.addType("Poison");

        Pokemon pokemon4 = new Pokemon(4, "Charmander", "Lizard");
        pokemon4.addType("Fire");

        Pokemon pokemon7 = new Pokemon(7, "Squirtle", "Tiny Turtle");
        pokemon7.addType("Water");

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon4);
        pokemonList.add(pokemon7);
    }

    @Operation(summary = "List all pokemons")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List all Pokemons",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Pokemon.class)))
                    })
    })
    @GetMapping()
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    @Operation(summary = "Get Pokemon detail by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pokemon Found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Pokemon.class))
                    })
    })
    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        Optional<Pokemon> tempPokemon = pokemonList.stream()
                .filter(pokemon -> pokemon.getId() == id)
                .findFirst();
        return tempPokemon.orElse(new Pokemon());

    }

    @Operation(summary = "Add New Pokemon to the Pokemon List")
    @ApiResponse(responseCode = "200", description = "Pokemon Created")
    @PostMapping()
    public String createPokemon(@RequestBody PokemonRequestBody thePokemon) {
        Optional<Pokemon> tempPokemon = pokemonList.stream()
                .filter(pokemon -> pokemon.getId() == thePokemon.getId())
                .findFirst();

        if (tempPokemon.isEmpty()) {
            Pokemon newPokemon = new Pokemon();
            newPokemon.setId(thePokemon.getId());
            newPokemon.setName(thePokemon.getName());
            newPokemon.setCategory(thePokemon.getCategory());
            newPokemon.setType(thePokemon.getTypes());

            pokemonList.add(newPokemon);

            return "Pokemon created";
        }

        return "Cannot create a Pokemon";
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemonById(@PathVariable int id, @RequestBody PokemonRequestBody requestBody) {
        Optional<Pokemon> tempPokemon = pokemonList
                .stream()
                .filter(pokemon -> pokemon.getId() == id)
                .findFirst();

        Pokemon existPokemon = new Pokemon();

        if (tempPokemon.isPresent()) {
            existPokemon = tempPokemon.get();
            existPokemon.setName(requestBody.getName());
            existPokemon.setType(requestBody.getTypes());
            existPokemon.setCategory(requestBody.getCategory());
        }

        return existPokemon;
    }

    @Operation(summary = "Remove Pokemon by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Deleted",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PokemonResponse.class))),

            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PokemonResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<PokemonResponse> deletePokemonById(@PathVariable int id) {
        Optional<Pokemon> tempPokemon = pokemonList
                .stream()
                .filter(pokemon -> pokemon.getId() == id)
                .findFirst();

        if (tempPokemon.isPresent()) {
            pokemonList.remove(id);

            return new ResponseEntity<>(new PokemonResponse(
                    HttpStatus.OK.value(), "Deleted Pokemon ID: " + id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new PokemonResponse(
                    HttpStatus.NOT_FOUND.value(), "Not found Pokemon ID: " + id), HttpStatus.NOT_FOUND);
        }
    }

}
