package com.bk.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bk.domain.Users;
import com.bk.dto.UserCategoryRaddissonDto;
import com.bk.dto.UserRadissonDto;
import com.bk.repo.IUsersRepo;

@RestController
@RequestMapping({"/getTaxi24"})
public class GenerateTaxi24ServiceImpl {
	@Autowired
	IUsersRepo usersDaoImpl;
	

	  @GetMapping("/getDriverById/{id}")
		public UserRadissonDto getDriverById(@PathVariable(value = "id") 	Long userId){
		UserRadissonDto userRadissonDto= new UserRadissonDto();
		UserCategoryRaddissonDto cat=new UserCategoryRaddissonDto();
		Optional<Users> u=usersDaoImpl.findById(userId);
		
		cat.setUserCategoryCode(u.get().getUserCat().getUserCategoryCode());
		cat.setUserCategoryName(u.get().getUserCat().getUserCategoryName());
		cat.setUserCategoryDescription(u.get().getUserCat().getUserCategoryDescription());
		
		userRadissonDto.setFname(u.get().getFname());
		userRadissonDto.setLname(u.get().getLname());
		userRadissonDto.setPhone(u.get().getPhone());
		userRadissonDto.setEmail(u.get().getEmail());
		userRadissonDto.setUserCat(cat);
		return userRadissonDto;
	}


	  @GetMapping("/getRidersById/{id}")
	public Optional<Users> getRidersById(@PathVariable(value = "id") 	Long userId) {
		System.out.println("the parameter is::"+userId);
		Optional<Users> u=usersDaoImpl.findById(userId);
		System.out.println("the code is::"+u.get().getUserCat().getUserCategoryCode());
		return u;
	}



	  @PostMapping(path="/saveUsers")
		public Users saveUsers(@Valid @RequestBody Users users) {
		return usersDaoImpl.save(users);
	}



	@GetMapping(path="/allDrives")
	@ResponseBody
	public List<Users> getAllUsers() {
	
		return usersDaoImpl.findAll();
	}



	
	
	

}
