package br.com.gubee.interview.core.domain;

import br.com.gubee.interview.core.domain.enums.HeroRaceEnum;
import br.com.gubee.interview.core.exception.BadRequestException;

import java.util.UUID;

public class Hero extends AbstractAuditing {

    private UUID id;
    private String name;
    private HeroRaceEnum race;
    private PowerStats powerStats;
    private boolean enabled = Boolean.TRUE;

    public Hero(UUID id, String name, HeroRaceEnum race, PowerStats powerStats, boolean enabled) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.powerStats = powerStats;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 255) {
            throw new BadRequestException("");
        }
        this.name = name;
    }

    public HeroRaceEnum getRace() {
        return race;
    }

    public void setRace(HeroRaceEnum race) {
        this.race = race;
    }

    public PowerStats getPowerStats() {
        return powerStats;
    }

    public void setPowerStats(PowerStats powerStats) {
        this.powerStats = powerStats;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
