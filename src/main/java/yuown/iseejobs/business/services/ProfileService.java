package yuown.iseejobs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Profile;
import yuown.iseejobs.jpa.services.ProfileRepositoryService;
import yuown.iseejobs.model.ConfigurationModel;
import yuown.iseejobs.model.ProfileModel;
import yuown.iseejobs.transformer.ProfileTransformer;

@Service
public class ProfileService extends AbstractServiceImpl<Integer, ProfileModel, Profile, ProfileRepositoryService, ProfileTransformer> {

	@Autowired
	private ProfileRepositoryService ProfileRepositoryService;

	@Autowired
	private ProfileTransformer ProfileTransformer;
	
	@Autowired
	private ConfigurationService configurationService;
	
	private static final String PROFILES_PAGE_SIZE = "profile_pagesize";

	@Override
	protected ProfileRepositoryService repoService() {
		return ProfileRepositoryService;
	}

	@Override
	public ProfileTransformer transformer() {
		return ProfileTransformer;
	}
	
	public PageImpl<Profile> getAll(Integer page, Integer size) {
		if (page == null || page < 0) {
			page = 0;
		}
		Integer fromSystem = Integer.parseInt(System.getProperty(PROFILES_PAGE_SIZE));
		if (size == null || (size < 0 || size > fromSystem)) {
			size = fromSystem;
		}
		return repoService().findAll(new PageRequest(page, size));
	}
	
	public Integer getPageSize() {
		ConfigurationModel pageSize = configurationService.getByName(PROFILES_PAGE_SIZE);
		Integer size = 10;
		if (pageSize != null) {
			size = pageSize.getValue();
		}
		return size;
	}

	public void setPageSize(Integer size) {
		ConfigurationModel pageSize = configurationService.getByName(PROFILES_PAGE_SIZE);
		if (pageSize == null) {
			pageSize = new ConfigurationModel();
			pageSize.setName(PROFILES_PAGE_SIZE);
		}
		if (size == null || size <= 0) {
			size = 10;
		}
		pageSize.setValue(size);
		configurationService.save(pageSize);
	}
}
