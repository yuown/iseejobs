package yuown.iseejobs.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import yuown.iseejobs.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    public User findByUsername(String userName);
    
    @Query("select max(id) from User")
	public Integer findMaxId();
}
