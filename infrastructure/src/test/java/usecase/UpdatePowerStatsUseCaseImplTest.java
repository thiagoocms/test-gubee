package usecase;

import br.com.gubee.interview.application.gateway.UpdatePowerStatsGateway;
import br.com.gubee.interview.application.usecaseimpl.UpdatePowerStatsUseCaseImpl;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdatePowerStatsUseCaseImplTest {

    @Mock
    private UpdatePowerStatsGateway updatePowerStatsGateway;

    @Mock
    private FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    private UpdatePowerStatsUseCaseImpl updatePowerStatsUseCase;

    public UpdatePowerStatsUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
        this.updatePowerStatsUseCase = new UpdatePowerStatsUseCaseImpl(updatePowerStatsGateway, findPowerStatsByIdUseCase);
    }

    @Test
    void updateByIdValidIdAndPowerStatsReturnsUpdatedPowerStats() {
        UUID id = UUID.randomUUID();
        PowerStats existingPowerStats = new PowerStats();
        when(findPowerStatsByIdUseCase.findById(id)).thenReturn(existingPowerStats);

        PowerStats updatedPowerStats = new PowerStats();
        updatedPowerStats.setId(id);
        updatedPowerStats.setCreatedAt(existingPowerStats.getCreatedAt());
        updatedPowerStats.setUpdatedAt(LocalDateTime.now());
        when(updatePowerStatsGateway.updateById(id, updatedPowerStats)).thenReturn(updatedPowerStats);

        PowerStats result = updatePowerStatsUseCase.updateById(id, updatedPowerStats);

        assertEquals(updatedPowerStats, result);
        verify(findPowerStatsByIdUseCase, times(1)).findById(id);
        verify(updatePowerStatsGateway, times(1)).updateById(id, updatedPowerStats);
    }
}
