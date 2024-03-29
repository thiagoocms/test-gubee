package br.com.gubee.interview.core.domain;

import java.util.UUID;

public class HeroComparePowerStats {

    private UUID heroId;
    private UUID opponentId;
    int strengthDifference;
    int agilityDifference;
    int dexterityDifference;
    int intelligenceDifference;

    public HeroComparePowerStats() {
    }

    public HeroComparePowerStats(UUID heroId, UUID opponentId, int strengthDifference, int agilityDifference, int dexterityDifference, int intelligenceDifference) {
        this.heroId = heroId;
        this.opponentId = opponentId;
        this.strengthDifference = strengthDifference;
        this.agilityDifference = agilityDifference;
        this.dexterityDifference = dexterityDifference;
        this.intelligenceDifference = intelligenceDifference;
    }

    public UUID getHeroId() {
        return heroId;
    }

    public void setHeroId(UUID heroId) {
        this.heroId = heroId;
    }

    public UUID getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(UUID opponentId) {
        this.opponentId = opponentId;
    }

    public int getStrengthDifference() {
        return strengthDifference;
    }

    public void setStrengthDifference(int strengthDifference) {
        this.strengthDifference = strengthDifference;
    }

    public int getAgilityDifference() {
        return agilityDifference;
    }

    public void setAgilityDifference(int agilityDifference) {
        this.agilityDifference = agilityDifference;
    }

    public int getDexterityDifference() {
        return dexterityDifference;
    }

    public void setDexterityDifference(int dexterityDifference) {
        this.dexterityDifference = dexterityDifference;
    }

    public int getIntelligenceDifference() {
        return intelligenceDifference;
    }

    public void setIntelligenceDifference(int intelligenceDifference) {
        this.intelligenceDifference = intelligenceDifference;
    }
}
