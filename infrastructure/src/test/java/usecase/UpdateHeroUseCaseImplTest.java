package usecase;

import br.com.gubee.interview.application.gateway.UpdateHeroGateway;
import br.com.gubee.interview.application.usecaseimpl.UpdateHeroUseCaseImpl;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;
import br.com.gubee.interview.usecase.UpdatePowerStatsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateHeroUseCaseImplTest {

    @Mock
    private UpdateHeroGateway updateHeroGateway;

    @Mock
    private UpdatePowerStatsUseCase updatePowerStatsUseCase;

    @Mock
    private FindHeroByIdUseCase findHeroByIdUseCase;

    private UpdateHeroUseCaseImpl updateHeroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        updateHeroUseCase = new UpdateHeroUseCaseImpl(updateHeroGateway, updatePowerStatsUseCase, findHeroByIdUseCase);
    }

    @Test
    void updateByIdValidIdReturnsUpdatedHero() {

        UUID id = UUID.randomUUID();
        Hero existingHero = new Hero();
        existingHero.setId(id);
        PowerStats existingPowerStats = new PowerStats();
        existingHero.setPowerStats(existingPowerStats);

        Hero updatedHero = new Hero();
        PowerStats updatedPowerStats = new PowerStats();
        updatedHero.setId(id);
        updatedHero.setPowerStats(updatedPowerStats);

        when(findHeroByIdUseCase.findById(id)).thenReturn(existingHero);
        when(updatePowerStatsUseCase.updateById(existingPowerStats.getId(), updatedPowerStats)).thenReturn(updatedPowerStats);
        when(updateHeroGateway.updateById(id, updatedHero)).thenReturn(updatedHero);

        Hero result = updateHeroUseCase.updateById(id, updatedHero);

        assertEquals(updatedHero, result);
        assertEquals(updatedPowerStats, result.getPowerStats());
    }
}
