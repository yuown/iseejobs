package yuown.iseejobs.transformer;

import java.util.List;
import java.util.Set;

import yuown.iseejobs.entity.BaseEntity;
import yuown.iseejobs.model.Model;

public interface DTOTransformer<From extends Model, To extends BaseEntity<?>> {

    public List<To> transformFrom(List<From> sources);

    public To transformFrom(From source);

    public From transformTo(To source);

    public List<From> transformTo(List<To> sources);
    
    public Set<To> transformFrom(Set<From> sources);
    
    public Set<From> transformTo(Set<To> sources);

}
