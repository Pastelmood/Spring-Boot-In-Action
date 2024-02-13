package com.il0v3dorayaki.demo.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private int id;

    private String name;

    private List<String> types;

    private String category;

    public Pokemon() {
    }

    public Pokemon(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Pokemon(int id, String name, List<String> types, String category) {
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

    public void setType(List<String> types) {
        this.types = types;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Util method
    public void addType(String type) {
        if (types == null) {
            types = new ArrayList<>();
        }

        types.add(type);
    }
}
