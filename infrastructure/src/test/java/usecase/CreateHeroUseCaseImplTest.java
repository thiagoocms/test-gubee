package usecase;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.usecaseimpl.CreateHeroUseCaseImpl;
import br.com.gubee.interview.application.validation.HeroValidation;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;
import br.com.gubee.interview.usecase.ExistHeroByNameUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateHeroUseCaseImplTest {

    @Mock
    private CreateHeroGateway createHeroGateway;

    @Mock
    private CreatePowerStatsUseCase createPowerStatsUseCase;

    @Mock
    private HeroValidation heroValidation;

    @Mock
    private ExistHeroByNameUseCase existHeroByNameUseCase;

    private CreateHeroUseCaseImpl createHeroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        createHeroUseCase = new CreateHeroUseCaseImpl(createHeroGateway, createPowerStatsUseCase, heroValidation, existHeroByNameUseCase);
    }

    @Test
    void createValidHeroReturnsCreatedHero() throws Throwable {

        Hero hero = new Hero();
        PowerStats powerStats = new PowerStats();
        hero.setName("Batman");
        hero.setPowerStats(powerStats);

        when(createPowerStatsUseCase.create(powerStats)).thenReturn(powerStats);
        when(createHeroGateway.create(hero)).thenReturn(hero);

        Hero result = createHeroUseCase.create(hero);

        assertNotNull(result);
        assertEquals(hero, result);
        assertEquals(powerStats, result.getPowerStats());
    }
}
