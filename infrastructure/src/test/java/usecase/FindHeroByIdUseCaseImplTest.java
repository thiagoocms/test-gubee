package usecase;

import br.com.gubee.interview.application.gateway.FindHeroByIdGateway;
import br.com.gubee.interview.application.gateway.FindPowerStatsByIdGateway;
import br.com.gubee.interview.application.usecaseimpl.FindHeroByIdUseCaseImpl;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FindHeroByIdUseCaseImplTest {

    @Mock
    private FindHeroByIdGateway findHeroByIdGateway;

    @Mock
    private FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    private FindHeroByIdUseCaseImpl findHeroByIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        findHeroByIdUseCase = new FindHeroByIdUseCaseImpl(findHeroByIdGateway, findPowerStatsByIdUseCase);
    }

    @Test
    void findByIdExistingIdReturnsHeroWithPowerStats() {

        UUID id = UUID.randomUUID();
        Hero expectedHero = new Hero();
        expectedHero.setId(id);
        PowerStats powerStats = new PowerStats();
        expectedHero.setPowerStats(powerStats);

        when(findHeroByIdGateway.findById(id)).thenReturn(expectedHero);
        when(findPowerStatsByIdUseCase.findById(powerStats.getId())).thenReturn(powerStats);

        Hero result = findHeroByIdUseCase.findById(id);

        assertNotNull(result);
        assertEquals(expectedHero, result);
        assertEquals(powerStats, result.getPowerStats());
    }

    @Test
    void findByIdNonExistingIdThrowsResourceNotFoundException() {

        UUID id = UUID.randomUUID();
        when(findHeroByIdGateway.findById(id)).thenReturn(null);

        assertThrows(ResourceNotFoundException.class, () -> {
            findHeroByIdUseCase.findById(id);
        });
    }
}
