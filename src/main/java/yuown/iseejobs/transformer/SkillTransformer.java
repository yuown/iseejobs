package yuown.iseejobs.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import yuown.iseejobs.entity.Skill;
import yuown.iseejobs.model.SkillModel;

@Component
public class SkillTransformer extends AbstractDTOTransformer<SkillModel, Skill> {

	private static final String[] FROM_EXCLUDES = new String[] {};
	private static final String[] TO_EXCLUDES = new String[] { "profile" };

	@Override
	public Skill transformFrom(SkillModel source) {
		Skill dest = null;
		if (source != null) {
			try {
				dest = new Skill();
				BeanUtils.copyProperties(source, dest, FROM_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}

	@Override
	public SkillModel transformTo(Skill source) {
		SkillModel dest = null;
		if (source != null) {
			try {
				dest = new SkillModel();
				BeanUtils.copyProperties(source, dest, TO_EXCLUDES);
			} catch (Exception e) {
				dest = null;
			}
		}
		return dest;
	}
}
