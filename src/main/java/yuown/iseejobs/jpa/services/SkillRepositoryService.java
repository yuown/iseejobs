package yuown.iseejobs.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Skill;
import yuown.iseejobs.jpa.repository.SkillRepository;

@Service
public class SkillRepositoryService extends AbstractRepositoryService<SkillRepository, Skill, Integer> {

	@Autowired
	private SkillRepository repository;

	@Override
	public SkillRepository repository() {
		return repository;
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	public List<Skill> findAll() {
		return super.findAll();
	}

	@Override
	public Skill findOne(Integer id) {
		return super.findOne(id);
	}

	@Override
	public Skill save(Skill entity) {
		return super.save(entity);
	}
}
