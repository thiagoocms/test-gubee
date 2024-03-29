package br.com.gubee.interview.infrastructure.repository;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.domain.enums.HeroRaceEnum;
import br.com.gubee.interview.core.exception.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

@Repository
public class HeroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Hero create(Hero hero) {
        String sql = "INSERT INTO hero (" +
                "id, name, race, power_stats_id, enabled) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            hero.setId(UUID.randomUUID());
            jdbcTemplate.update(sql, hero.getId(), hero.getName(),
                    hero.getRace().name(), hero.getPowerStats().getId(), hero.isEnabled());
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
            return null;
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

    public void deleteById(UUID id) {
        String sql = "DELETE FROM hero WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            throw new InternalErrorException("Falha ao tentar apagar o heroi com o id: " + id);
        }
    }

    public Hero update(UUID id, Hero hero) {
        String sql = "UPDATE hero SET name = ?, race = ?, power_stats_id = ?, enabled = ?, updated_at = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, hero.getName(), hero.getRace().name(), hero.getPowerStats().getId(),
                    hero.isEnabled(), Timestamp.valueOf(hero.getUpdatedAt()), id);
            return hero;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public Set<Hero> findFilter(HeroFilter filter) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT h.id, h.name, h.race, h.power_stats_id, " +
                "p.strength, p.agility, p.dexterity, p.intelligence FROM hero h " +
                "INNER JOIN power_stats p ON h.power_stats_id = p.id WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (filter.getName() != null && !filter.getName().isEmpty()) {
            sqlBuilder.append(" AND h.name LIKE ?");
            params.add("%" + filter.getName() + "%");
        }

        try {
            return new HashSet<>(jdbcTemplate.query(sqlBuilder.toString(), params.toArray(), (rs, rowNum) -> {
                Hero hero = new Hero();
                hero.setId(UUID.fromString(rs.getString("id")));
                hero.setName(rs.getString("name"));
                hero.setRace(HeroRaceEnum.valueOf(rs.getString("race")));

                PowerStats powerStats = new PowerStats();
                powerStats.setId(UUID.fromString(rs.getString("power_stats_id")));
                powerStats.setStrength(rs.getInt("strength"));
                powerStats.setAgility(rs.getInt("agility"));
                powerStats.setDexterity(rs.getInt("dexterity"));
                powerStats.setIntelligence(rs.getInt("intelligence"));

                hero.setPowerStats(powerStats);
                return hero;
            }));
        } catch (Exception e) {
            return new HashSet<>();
        }
    }
}
