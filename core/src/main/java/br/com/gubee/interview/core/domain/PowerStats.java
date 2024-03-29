package br.com.gubee.interview.core.domain;

import java.util.UUID;


public class PowerStats extends AbstractAuditing {

    private UUID id;
    private int strength;
    private int agility;
    private int dexterity;
    private int intelligence;

    public PowerStats() {
    }

    public PowerStats(UUID id) {
        this.id = id;
    }

    public PowerStats(UUID id, int strength, int agility, int dexterity, int intelligence) {
        this.id = id;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
