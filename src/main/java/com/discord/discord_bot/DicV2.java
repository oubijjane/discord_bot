package com.discord.discord_bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DicV2 {

    private List<Dictionary> dictionaryList;

    public DicV2(){}

    public DicV2(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    @Override
    public String toString() {
        return "DicV2{" +
                "dictionaryList=" + dictionaryList +
                '}';
    }
}
