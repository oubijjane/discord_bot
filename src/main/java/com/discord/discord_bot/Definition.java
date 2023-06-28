package com.discord.discord_bot;

import java.util.List;

public class Definition {

    private String definition;



    private String example;

    public Definition() {
        System.out.println("!!!!!!!!!"+toString());
    }

    public Definition(String definition, String example) {
        this.definition = definition;
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }



    public String getExample() {
        return example;

    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {

        return "definition='" + definition + '\n' +
                ", example='" + example + '\n';
    }
}
