package yuown.iseejobs.rest.impl;

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

import yuown.iseejobs.business.services.SkillService;
import yuown.iseejobs.model.SkillModel;

@RestController
@RequestMapping(value = "/skills", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SkillResourceImpl {

	@Autowired
	private SkillService skillService;

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public SkillModel save(@RequestBody SkillModel model) {
		return skillService.save(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public SkillModel getById(@PathVariable("id") int id) {
		return skillService.getById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> removeById(@PathVariable("id") int id) throws Exception {
		SkillModel skill = skillService.getById(id);
		HttpHeaders headers = new HttpHeaders();
		if (null == skill) {
			headers.add("errorMessage", "Skill with ID " + id + " Not Found");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		} else {
			try {
				skillService.removeById(id);
				headers.add("errorMessage", "Skill with ID " + id + " Deleted Successfully");
				return new ResponseEntity<String>(headers, HttpStatus.OK);
			} catch (Exception e) {
				headers.add("errorMessage", "Skill with ID " + id + " cannot be Deleted");
				return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}
