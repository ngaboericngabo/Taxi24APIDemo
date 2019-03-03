package com.bk.service.interfaces;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bk.domain.Users;
import com.bk.dto.UserRadissonDto;



@RequestMapping({"/getTaxi24"})
public interface IGenerateTaxi24Service {

	   @GetMapping("/getDriverById/{id}")
	    public UserRadissonDto getDriverById(@PathVariable(value = "id") Long userId) ;
	     
	   @GetMapping("/getRidersById/{id}")
	    public Optional<Users>  getRidersById(@PathVariable(value = "id") 	Long userId) ;
	     
	@PostMapping(path="/saveUsers")
	public Users saveUsers(@Valid @RequestBody Users users) ;
		
	
	@GetMapping(path="/allDrives")
	@ResponseBody
	public List<Users> getAllUsers() ;
		
	
}
