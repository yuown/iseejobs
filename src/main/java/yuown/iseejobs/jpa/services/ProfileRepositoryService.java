package yuown.iseejobs.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuown.iseejobs.entity.Profile;
import yuown.iseejobs.jpa.repository.ProfileRepository;

@Service
public class ProfileRepositoryService extends AbstractRepositoryService<ProfileRepository, Profile, Integer> {

	@Autowired
	private ProfileRepository repository;

	@Override
	public ProfileRepository repository() {
		return repository;
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	public List<Profile> findAll() {
		return super.findAll();
	}

	@Override
	public Profile findOne(Integer id) {
		return super.findOne(id);
	}

	@Override
	public Profile save(Profile entity) {
		return super.save(entity);
	}
}
