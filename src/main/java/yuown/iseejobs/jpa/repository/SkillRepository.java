package yuown.iseejobs.jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import yuown.iseejobs.entity.Skill;

@Repository
public interface SkillRepository extends BaseRepository<Skill, Integer> {
	
	List<Skill> findAllByProfileId(Integer profileId);

}
