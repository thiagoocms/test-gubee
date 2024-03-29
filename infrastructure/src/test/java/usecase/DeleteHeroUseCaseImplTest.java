package usecase;

import br.com.gubee.interview.application.gateway.DeleteHeroGateway;
import br.com.gubee.interview.application.usecaseimpl.DeleteHeroUseCaseImpl;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.DeletePowerStatsUseCase;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class DeleteHeroUseCaseImplTest {

    @Mock
    private DeleteHeroGateway deleteHeroGateway;

    @Mock
    private DeletePowerStatsUseCase deletePowerStatsUseCase;

    @Mock
    private FindHeroByIdUseCase findHeroByIdUseCase;

    private DeleteHeroUseCaseImpl deleteHeroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteHeroUseCase = new DeleteHeroUseCaseImpl(deleteHeroGateway, deletePowerStatsUseCase, findHeroByIdUseCase);
    }

    @Test
    void deleteByIdValidIdDeletesHeroAndPowerStats() {

        UUID id = UUID.randomUUID();
        Hero hero = new Hero();
        hero.setId(id);
        hero.setPowerStats(new PowerStats(UUID.randomUUID()));

        when(findHeroByIdUseCase.findById(id)).thenReturn(hero);

        deleteHeroUseCase.deleteById(id);

        verify(deleteHeroGateway, times(1)).deleteById(id);
        verify(deletePowerStatsUseCase, times(1)).deleteById(hero.getPowerStats().getId());
    }
}
