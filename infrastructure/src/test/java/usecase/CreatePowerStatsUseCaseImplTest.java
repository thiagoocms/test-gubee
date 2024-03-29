package usecase;

import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.application.usecaseimpl.CreatePowerStatsUseCaseImpl;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class CreatePowerStatsUseCaseImplTest {

    @Mock
    private CreatePowerStatsGateway createPowerStatsGateway;

    private CreatePowerStatsUseCaseImpl createPowerStatsUseCase;

    public CreatePowerStatsUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
        this.createPowerStatsUseCase = new CreatePowerStatsUseCaseImpl(createPowerStatsGateway);
    }

    @Test
    void createValidPowerStatsReturnsCreatedPowerStats() {

        PowerStats powerStats = new PowerStats(/* provide necessary constructor arguments */);
        when(createPowerStatsGateway.create(powerStats)).thenReturn(powerStats);

        PowerStats createdPowerStats = createPowerStatsUseCase.create(powerStats);

        assertNotNull(createdPowerStats);
        assertEquals(powerStats, createdPowerStats);
        verify(createPowerStatsGateway, times(1)).create(powerStats);
    }

    @Test
    void createNullPowerStatsThrowsBadRequestException() {
        PowerStats powerStats = null;
        assertThrows(BadRequestException.class, () -> {
            createPowerStatsUseCase.create(powerStats);
        });
        verifyNoInteractions(createPowerStatsGateway); // Ensure gateway was not called
    }
}
