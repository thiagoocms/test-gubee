package br.com.gubee.interview.core.domain;

public class HeroFilter {


    private String name;


    public HeroFilter() {
    }

    public HeroFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
