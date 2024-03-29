package br.com.gubee.interview.infrastructure.repository;

import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Map;
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
                "strength, agility, dexterity, intelligence) " +
                "VALUES (?, ?, ?, ?) RETURNING id";

        final Map<String, Object> params = Map.of(
                "strength", powerStats.getStrength(),
                "agility", powerStats.getAgility(),
                "dexterity", powerStats.getDexterity(),
                "intelligence", powerStats.getIntelligence()
        );
        try {
            UUID id = jdbcTemplate.queryForObject(sql, params.values().toArray(), UUID.class);
            powerStats.setId(id);
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
        final Map<String, Object> params = Map.of(
                "strength", powerStats.getStrength(),
                "agility", powerStats.getAgility(),
                "dexterity", powerStats.getDexterity(),
                "intelligence", powerStats.getIntelligence(),
                "updatedAt", powerStats.getUpdatedAt(),
                "id", id
        );
        try {
            jdbcTemplate.update(sql, powerStats.getStrength(), powerStats.getAgility(), powerStats.getDexterity(),
                    powerStats.getIntelligence(), powerStats.getUpdatedAt(), id);
            return powerStats;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

}
