package yuown.iseejobs.business.services;

import java.util.List;

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

	public List<EducationModel> getEducations(Integer profileId) {
		return transformer().transformTo(repoService().findAllByProfileId(profileId));
	}

	public void saveEducations(int profileId, List<EducationModel> educations) {
		for (EducationModel educationModel : educations) {
			educationModel.setProfileId(profileId);
		}
		repoService().save(transformer().transformFrom(educations));
	}
}
