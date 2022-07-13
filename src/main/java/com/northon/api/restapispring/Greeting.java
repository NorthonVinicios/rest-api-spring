package com.northon.api.restapispring;

public class Greeting {
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    private final Long id;
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
