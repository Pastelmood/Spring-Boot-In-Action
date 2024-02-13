package com.il0v3dorayaki.demo.pokemon;

import java.util.List;

public class PokemonRequestBody {

    private int id;

    private String name;

    private List<String> types;

    private String category;

    public PokemonRequestBody(int id, String name, List<String> types, String category) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PokemonRequestBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", types=" + types +
                ", category='" + category + '\'' +
                '}';
    }
}
