package yuown.iseejobs.rest.impl;

import java.util.ArrayList;
import java.util.List;

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

import yuown.iseejobs.business.services.EducationService;
import yuown.iseejobs.business.services.ProfileService;
import yuown.iseejobs.model.EducationModel;
import yuown.iseejobs.model.ProfileModel;

@RestController
@RequestMapping(value = "/educations", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EducationResourceImpl {

	@Autowired
	private EducationService educationService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EducationModel save(@RequestBody EducationModel model) {
		return educationService.save(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public EducationModel getById(@PathVariable("id") int id) {
		return educationService.getById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{educationId}/{profileId}")
	public ResponseEntity<String> removeById(@PathVariable("educationId") int educationId, @PathVariable("profileId") int profileId) throws Exception {
		EducationModel education = educationService.getById(educationId);
		HttpHeaders headers = new HttpHeaders();
		if (null == education) {
			headers.add("errorMessage", "Education with ID " + educationId + " Not Found");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			try {
				ProfileModel profile = profileService.getById(profileId);
				if (null == profile) {
					headers.add("errorMessage", "Profile with ID " + profileId + " Not Found");
					return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
				} else {
					educationService.removeById(educationId);
					headers.add("errorMessage", "Education with ID " + educationId + " Deleted Successfully");
					return new ResponseEntity<String>(headers, HttpStatus.OK);
				}
			} catch (Exception e) {
				headers.add("errorMessage", "Education with ID " + educationId + " cannot be Deleted");
				return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "profile/{id}")
	@ResponseBody
	public List<EducationModel> getProfileEducations(@PathVariable("id") int id) {
		List<EducationModel> educations = new ArrayList<EducationModel>();
		ProfileModel profile = profileService.getById(id);
		if (null != profile) {
			educations = educationService.getEducations(profile.getId());
		}
		return educations;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "profile/{id}")
	public void saveProfileEducations(@PathVariable("id") int profileId, @RequestBody List<EducationModel> educations) {
		ProfileModel profile = profileService.getById(profileId);
		if (null != profile) {
			educationService.saveEducations(profileId, educations);
		}
	}
}
