package yuown.iseejobs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Profile;
import yuown.iseejobs.jpa.services.ProfileRepositoryService;
import yuown.iseejobs.model.ProfileModel;
import yuown.iseejobs.transformer.ProfileTransformer;

@Service
public class ProfileService extends AbstractServiceImpl<Integer, ProfileModel, Profile, ProfileRepositoryService, ProfileTransformer> {

	@Autowired
	private ProfileRepositoryService ProfileRepositoryService;

	@Autowired
	private ProfileTransformer ProfileTransformer;

	@Override
	protected ProfileRepositoryService repoService() {
		return ProfileRepositoryService;
	}

	@Override
	protected ProfileTransformer transformer() {
		return ProfileTransformer;
	}
}
