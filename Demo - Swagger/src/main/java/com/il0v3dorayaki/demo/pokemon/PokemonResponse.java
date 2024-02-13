package com.il0v3dorayaki.demo.pokemon;

public class PokemonResponse {

    private int status;

    private String message;

    public PokemonResponse() {
    }

    public PokemonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
