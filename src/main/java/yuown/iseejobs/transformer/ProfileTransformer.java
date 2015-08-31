package yuown.iseejobs.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yuown.iseejobs.entity.Profile;
import yuown.iseejobs.model.ProfileModel;

@Component
public class ProfileTransformer extends AbstractDTOTransformer<ProfileModel, Profile> {

	private static final String[] FROM_EXCLUDES = new String[] { "user" };
	private static final String[] TO_EXCLUDES = new String[] { "user", "skills", "educations" };
	
	@Autowired
	private SkillTransformer skillTransformer;
	
	@Autowired
	private EducationTransformer educationTransformer;

	@Override
	public Profile transformFrom(ProfileModel source) {
		Profile dest = null;
		if (source != null) {
			try {
				dest = new Profile();
				BeanUtils.copyProperties(source, dest, FROM_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}

	@Override
	public ProfileModel transformTo(Profile source) {
		ProfileModel dest = null;
		if (source != null) {
			try {
				dest = new ProfileModel();
				BeanUtils.copyProperties(source, dest, TO_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}
}
