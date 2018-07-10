/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;
import ar.edu.unlp.lifia.grupo8.services.GroupService;

/**
 * @author Agustin
 *
 */
@RestController
public class GroupController {

	private GroupService groupService;
	
	public GroupService getGroupService() {
		return groupService;
	}
	
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	
	/*
	 * Obtener todos los grupos del Sistema	 * 
	 * 
	 */
	@RequestMapping(value = "/group/", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDto>> listAllAgents() {
        List<ResponseDto> groups = this.getGroupService().findAllGroups();
        if(groups.isEmpty()){
            return new ResponseEntity<List<ResponseDto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ResponseDto>>(groups, HttpStatus.OK);
    }
	
	
    /*
     * Obtener el grupo con un determinado id
     * 
     * @param id el id del grupo
     */
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getAgent(@PathVariable("id") int id) {
    	ResponseDto group = this.getGroupService().findById(id);
        if (group == null) {            
            return new ResponseEntity<ResponseDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ResponseDto>(group, HttpStatus.OK);
    }
}
