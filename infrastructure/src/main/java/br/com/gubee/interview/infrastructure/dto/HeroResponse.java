package br.com.gubee.interview.infrastructure.dto;

import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.domain.enums.HeroRaceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroResponse implements Serializable {

    private UUID heroId;
    private String name;
    private HeroRaceEnum race;
    private PowerStats powerStats;
    private int strength;
    private int agility;
    private int dexterity;
    private int intelligence;
}
