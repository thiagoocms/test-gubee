package br.com.gubee.interview.infrastructure.repository;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.domain.enums.HeroRaceEnum;
import br.com.gubee.interview.core.exception.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository
public class HeroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Hero create(Hero hero) {
        String sql = "INSERT INTO hero (" +
                "id, name, race, power_stats_id, enabled, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            hero.setId(UUID.randomUUID());
            jdbcTemplate.update(sql, hero.getId(), hero.getName(), hero.getRace().name(), hero.getPowerStats().getId(),
                    hero.isEnabled(), Timestamp.valueOf(hero.getCreatedAt()), Timestamp.valueOf(hero.getUpdatedAt()));
            return hero;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public Hero findById(UUID id) {
        String selectSql = "SELECT * FROM hero WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(selectSql, new Object[]{id}, (rs, rowNum) -> {
                Hero hero = new Hero();
                hero.setId(UUID.fromString(rs.getString("id")));
                hero.setName(rs.getString("name"));
                hero.setRace(HeroRaceEnum.valueOf(rs.getString("race")));
                hero.setPowerStats(new PowerStats(UUID.fromString(rs.getString("power_stats_id"))));
                hero.setEnabled(rs.getBoolean("enabled"));
                hero.setCreatedAt(rs.getObject("created_at", Timestamp.class).toLocalDateTime());
                hero.setUpdatedAt(rs.getObject("updated_at", Timestamp.class).toLocalDateTime());
                return hero;
            });
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public Hero findByName(String name) {
        String selectSql = "SELECT * FROM hero WHERE name = ?";
        try {
            return jdbcTemplate.queryForObject(selectSql, new Object[]{name}, (rs, rowNum) -> {
                Hero hero = new Hero();
                hero.setId(UUID.fromString(rs.getString("id")));
                hero.setName(rs.getString("name"));
                hero.setRace(HeroRaceEnum.valueOf(rs.getString("race")));
                hero.setPowerStats(new PowerStats(UUID.fromString(rs.getString("power_stats_id"))));
                hero.setEnabled(rs.getBoolean("enabled"));
                hero.setCreatedAt(rs.getObject("created_at", Timestamp.class).toLocalDateTime());
                hero.setUpdatedAt(rs.getObject("updated_at", Timestamp.class).toLocalDateTime());
                return hero;
            });
        } catch (Exception e) {
           return null;
        }
    }
}
