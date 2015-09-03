package yuown.iseejobs.jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import yuown.iseejobs.entity.Education;

@Repository
public interface EducationRepository extends BaseRepository<Education, Integer> {

	List<Education> findAllByProfileId(Integer profileId);

}
