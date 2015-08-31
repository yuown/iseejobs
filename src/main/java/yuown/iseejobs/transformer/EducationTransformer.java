package yuown.iseejobs.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import yuown.iseejobs.entity.Education;
import yuown.iseejobs.model.EducationModel;

@Component
public class EducationTransformer extends AbstractDTOTransformer<EducationModel, Education> {

	private static final String[] FROM_EXCLUDES = new String[] {};
	private static final String[] TO_EXCLUDES = new String[] { "profile" };

	@Override
	public Education transformFrom(EducationModel source) {
		Education dest = null;
		if (source != null) {
			try {
				dest = new Education();
				BeanUtils.copyProperties(source, dest, FROM_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}

	@Override
	public EducationModel transformTo(Education source) {
		EducationModel dest = null;
		if (source != null) {
			try {
				dest = new EducationModel();
				BeanUtils.copyProperties(source, dest, TO_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}
}
