package yuown.iseejobs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Skill;
import yuown.iseejobs.jpa.services.SkillRepositoryService;
import yuown.iseejobs.model.SkillModel;
import yuown.iseejobs.transformer.SkillTransformer;

@Service
public class SkillService extends AbstractServiceImpl<Integer, SkillModel, Skill, SkillRepositoryService, SkillTransformer> {

	@Autowired
	private SkillRepositoryService skillRepositoryService;

	@Autowired
	private SkillTransformer skillTransformer;

	@Override
	protected SkillRepositoryService repoService() {
		return skillRepositoryService;
	}

	@Override
	protected SkillTransformer transformer() {
		return skillTransformer;
	}
}
