package br.com.gubee.interview.infrastructure.repository;

import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository
public class PowerStatsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PowerStatsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PowerStats create(PowerStats powerStats) {
        String sql = "INSERT INTO power_stats (" +
                "id, strength, agility, dexterity, intelligence, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            powerStats.setId(UUID.randomUUID());
            jdbcTemplate.update(sql, powerStats.getId(), powerStats.getStrength(), powerStats.getAgility(), powerStats.getDexterity(),
                    powerStats.getIntelligence(), Timestamp.valueOf(powerStats.getCreatedAt()), Timestamp.valueOf(powerStats.getUpdatedAt()));
            return powerStats;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public PowerStats findById(UUID id) {
        String selectSql = "SELECT * FROM power_stats WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(selectSql, new Object[]{id}, (rs, rowNum) -> {
                PowerStats powerStats = new PowerStats();
                powerStats.setId(UUID.fromString(rs.getString("id")));
                powerStats.setStrength(rs.getInt("strength"));
                powerStats.setAgility(rs.getInt("agility"));
                powerStats.setDexterity(rs.getInt("dexterity"));
                powerStats.setIntelligence(rs.getInt("intelligence"));
                powerStats.setCreatedAt(rs.getObject("created_at", Timestamp.class).toLocalDateTime());
                powerStats.setUpdatedAt(rs.getObject("updated_at", Timestamp.class).toLocalDateTime());
                return powerStats;
            });
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(UUID id) {
        String sql = "DELETE FROM power_stats WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            throw new InternalErrorException("Falha ao tentar apagar as habilidades do heroi com o id: " + id);
        }
    }

    public PowerStats update(UUID id, PowerStats powerStats) {
        String sql = "UPDATE power_stats SET strength = ?, agility = ?, dexterity = ?, intelligence = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, powerStats.getStrength(), powerStats.getAgility(), powerStats.getDexterity(),
                    powerStats.getIntelligence(), Timestamp.valueOf(powerStats.getUpdatedAt()), id);
            return powerStats;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

}
