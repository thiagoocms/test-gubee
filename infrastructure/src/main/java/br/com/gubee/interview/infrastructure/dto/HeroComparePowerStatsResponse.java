package br.com.gubee.interview.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroComparePowerStatsResponse implements Serializable {

    private UUID heroId;
    private UUID opponentId;
    int strengthDifference;
    int agilityDifference;
    int dexterityDifference;
    int intelligenceDifference;
}
