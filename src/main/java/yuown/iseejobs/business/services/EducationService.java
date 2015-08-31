package yuown.iseejobs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Education;
import yuown.iseejobs.jpa.services.EducationRepositoryService;
import yuown.iseejobs.model.EducationModel;
import yuown.iseejobs.transformer.EducationTransformer;

@Service
public class EducationService extends AbstractServiceImpl<Integer, EducationModel, Education, EducationRepositoryService, EducationTransformer> {

	@Autowired
	private EducationRepositoryService educationRepositoryService;

	@Autowired
	private EducationTransformer educationTransformer;

	@Override
	protected EducationRepositoryService repoService() {
		return educationRepositoryService;
	}

	@Override
	protected EducationTransformer transformer() {
		return educationTransformer;
	}
}
