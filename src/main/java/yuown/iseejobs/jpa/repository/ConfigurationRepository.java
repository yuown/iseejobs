package yuown.iseejobs.jpa.repository;

import org.springframework.stereotype.Repository;

import yuown.iseejobs.entity.Configuration;

@Repository
public interface ConfigurationRepository extends BaseRepository<Configuration, Integer> {

	public Configuration findByName(String name);

}
