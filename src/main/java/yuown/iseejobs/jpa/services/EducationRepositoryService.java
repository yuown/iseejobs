package yuown.iseejobs.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Education;
import yuown.iseejobs.jpa.repository.EducationRepository;

@Service
public class EducationRepositoryService extends AbstractRepositoryService<EducationRepository, Education, Integer> {

	@Autowired
	private EducationRepository repository;

	@Override
	public EducationRepository repository() {
		return repository;
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	public List<Education> findAll() {
		return super.findAll();
	}

	@Override
	public Education findOne(Integer id) {
		return super.findOne(id);
	}

	@Override
	public Education save(Education entity) {
		return super.save(entity);
	}

	public List<Education> findAllByProfileId(Integer profileId) {
		return repository().findAllByProfileId(profileId);
	}
}
