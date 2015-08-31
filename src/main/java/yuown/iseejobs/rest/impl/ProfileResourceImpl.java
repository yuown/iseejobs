package yuown.iseejobs.rest.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yuown.iseejobs.business.services.ProfileService;
import yuown.iseejobs.business.services.SkillService;
import yuown.iseejobs.model.ProfileModel;
import yuown.iseejobs.model.SkillModel;

@RestController
@RequestMapping(value = "/profiles", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfileResourceImpl {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private SkillService skillService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ProfileModel> getAllProfiles() {
		return profileService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ProfileModel saveProfile(@RequestBody ProfileModel model) {
		return profileService.save(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public ProfileModel getProfileById(@PathVariable("id") int id) {
		return profileService.getById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> removeProfileById(@PathVariable("id") int id) throws Exception {
		ProfileModel profile = profileService.getById(id);
		HttpHeaders headers = new HttpHeaders();
		if (null == profile) {
			headers.add("errorMessage", "Profile with ID " + id + " Not Found");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			try {
				profileService.removeById(id);
				headers.add("errorMessage", "Profile with ID " + id + " Deleted Successfully");
				return new ResponseEntity<String>(headers, HttpStatus.OK);
			} catch (Exception e) {
				headers.add("errorMessage", "Profile with ID " + id + " cannot be Deleted");
				return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/skills")
	@ResponseBody
	public Set<SkillModel> getProfileSkills(@PathVariable("id") int id) {
		Set<SkillModel> skills = new HashSet<SkillModel>();
		ProfileModel profile = profileService.getById(id);
		if(null != profile) {
			// skills = skillService.getSkills();
		}
		return skills;
	}
}
