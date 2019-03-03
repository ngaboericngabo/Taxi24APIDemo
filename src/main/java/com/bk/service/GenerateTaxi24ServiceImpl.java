package com.bk.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

import com.bk.Utilities.GenerateNumberUtil;
import com.bk.Utilities.LocationUtil;
import com.bk.domain.Invoice;
import com.bk.domain.Trip;
import com.bk.domain.Users;
import com.bk.domain.UsersAvailability;
import com.bk.dto.TripRadissonDto;
import com.bk.dto.UserAvaibilityRadissonDto;
import com.bk.dto.UserCategoryRaddissonDto;
import com.bk.dto.UserCatgoryDto;
import com.bk.dto.UserRadissonDto;
import com.bk.repo.IAvailability;
import com.bk.repo.IInvoice;
import com.bk.repo.IUsersRepo;
import com.bk.repo.Itrip;

@RestController
@RequestMapping({ "/getTaxi24" })
public class GenerateTaxi24ServiceImpl {
	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	@Autowired
	IUsersRepo usersDaoImpl;

	@Autowired
	IAvailability availability;

	@Autowired
	Itrip tripImpl;
	
	@Autowired
	IInvoice invoiceImpl;

	@PostMapping(path = "/saveUsers")
	public Users saveUsers(@Valid @RequestBody Users users) {
		return usersDaoImpl.save(users);
	}

	@GetMapping(path = "/allUsers/{categoryCode}")
	@ResponseBody
	public List<UserRadissonDto> getAllUsersByCategoryCode(@PathVariable(value = "categoryCode") String categoryCode) {
		List<UserRadissonDto> userRadissonDtoList = new ArrayList<UserRadissonDto>();

		for (Users temp : usersDaoImpl.findAll()) {
			UserRadissonDto userRadissonDto = new UserRadissonDto();
			UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
			if (temp != null && temp.getUserCat().getUserCategoryCode() != null
					&& temp.getUserCat().getUserCategoryCode().equals(categoryCode)) {

				userRadissonDto.setUserId(temp.getUserId());
				userRadissonDto.setFname(temp.getFname());
				userRadissonDto.setLname(temp.getFname());
				userRadissonDto.setPhone(temp.getPhone());
				userRadissonDto.setEmail(temp.getEmail());

				cat.setUserCategoryCode(temp.getUserCat().getUserCategoryCode());
				cat.setUserCategoryName(temp.getUserCat().getUserCategoryName());
				cat.setUserCategoryDescription(temp.getUserCat().getUserCategoryDescription());
				userRadissonDto.setUserCat(cat);
				userRadissonDtoList.add(userRadissonDto);
			}
		}

		return userRadissonDtoList;
	}

	@GetMapping(path = "/availableDriver}")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> getAvailableDriver() {
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();

		for (UsersAvailability temp : availability.findAll()) {
			UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();
			UserRadissonDto userRadissonDto = new UserRadissonDto();
			UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
			if (temp != null && temp.getStatus().equals("AVAILABLE")
					&& temp.getUsers().getUserCat().getUserCategoryCode().equals("DRIVER")) {
				userRadissonDto.setUserId(temp.getUsers().getUserId());
				userRadissonDto.setFname(temp.getUsers().getFname());
				userRadissonDto.setLname(temp.getUsers().getFname());
				userRadissonDto.setPhone(temp.getUsers().getPhone());
				userRadissonDto.setEmail(temp.getUsers().getEmail());

				cat.setUserCategoryCode(temp.getUsers().getUserCat().getUserCategoryCode());
				cat.setUserCategoryName(temp.getUsers().getUserCat().getUserCategoryName());
				cat.setUserCategoryDescription(temp.getUsers().getUserCat().getUserCategoryDescription());
				userRadissonDto.setUserCat(cat);
				userAvaibilityRadissonDto.setAvailableDateTime(temp.getAvailableDateTime());
				userAvaibilityRadissonDto.setLatitude(temp.getLatitude());
				userAvaibilityRadissonDto.setLongitude(temp.getLongitude());
				userAvaibilityRadissonDto.setStatus(temp.getStatus());
				userAvaibilityRadissonDto.setUserRadissonDto(userRadissonDto);
				userAvaibilityRadissonDtoList.add(userAvaibilityRadissonDto);
			}
		}

		return userAvaibilityRadissonDtoList;
	}

	@GetMapping(path = "/availableDriverWithin3km/{lat}/{longi}")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> getAvailableDriverWithin3km(@PathVariable double lat,
			@PathVariable double longi) {
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();

		for (UsersAvailability temp : availability.findAll()) {
			UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();
			UserRadissonDto userRadissonDto = new UserRadissonDto();
			UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
			if (temp != null && temp.getStatus().equals("AVAILABLE")
					&& temp.getUsers().getUserCat().getUserCategoryCode().equals("DRIVER")) {
				if (LocationUtil.getDistance(lat, longi, temp.getLatitude(), temp.getLongitude(), 'K') <= 3) {
					LOGGER.info("Distance between is:: "
							+ LocationUtil.getDistance(lat, longi, temp.getLatitude(), temp.getLongitude(), 'K')
							+ "Km");

					userRadissonDto.setUserId(temp.getUsers().getUserId());
					userRadissonDto.setFname(temp.getUsers().getFname());
					userRadissonDto.setLname(temp.getUsers().getFname());
					userRadissonDto.setPhone(temp.getUsers().getPhone());
					userRadissonDto.setEmail(temp.getUsers().getEmail());
					cat.setUserCategoryCode(temp.getUsers().getUserCat().getUserCategoryCode());
					cat.setUserCategoryName(temp.getUsers().getUserCat().getUserCategoryName());
					cat.setUserCategoryDescription(temp.getUsers().getUserCat().getUserCategoryDescription());
					userRadissonDto.setUserCat(cat);
					userAvaibilityRadissonDto.setDistance(
							LocationUtil.getDistance(lat, longi, temp.getLatitude(), temp.getLongitude(), 'K'));
					userAvaibilityRadissonDto.setAvailableDateTime(temp.getAvailableDateTime());
					userAvaibilityRadissonDto.setLatitude(temp.getLatitude());
					userAvaibilityRadissonDto.setLongitude(temp.getLongitude());
					userAvaibilityRadissonDto.setStatus(temp.getStatus());
					userAvaibilityRadissonDto.setUserRadissonDto(userRadissonDto);
					userAvaibilityRadissonDtoList.add(userAvaibilityRadissonDto);

				}
			}
		}

		return userAvaibilityRadissonDtoList;
	}

	@GetMapping("/getDriverById/{id}")
	public UserRadissonDto getDriverById(@PathVariable(value = "id") Long userId) {
		UserRadissonDto userRadissonDto = new UserRadissonDto();
		UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
		for (Users temp : usersDaoImpl.findAll()) {

			if (temp != null && temp.getUserCat().getUserCategoryCode() != null && temp.getUserId() == userId
					&& temp.getUserCat().getUserCategoryCode().equals("DRIVER")) {

				userRadissonDto.setUserId(temp.getUserId());
				userRadissonDto.setFname(temp.getFname());
				userRadissonDto.setLname(temp.getFname());
				userRadissonDto.setPhone(temp.getPhone());
				userRadissonDto.setEmail(temp.getEmail());
				cat.setUserCategoryCode(temp.getUserCat().getUserCategoryCode());
				cat.setUserCategoryName(temp.getUserCat().getUserCategoryName());
				cat.setUserCategoryDescription(temp.getUserCat().getUserCategoryDescription());
				userRadissonDto.setUserCat(cat);

			}
		}

		return userRadissonDto;
	}

	@GetMapping("/getRidersById/{id}")
	public UserRadissonDto getRidersById(@PathVariable(value = "id") Long userId) {

		UserRadissonDto userRadissonDto = new UserRadissonDto();
		UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
		for (Users temp : usersDaoImpl.findAll()) {

			if (temp != null && temp.getUserCat().getUserCategoryCode() != null && temp.getUserId() == userId
					&& temp.getUserCat().getUserCategoryCode().equals("RIDER")) {

				userRadissonDto.setUserId(temp.getUserId());
				userRadissonDto.setFname(temp.getFname());
				userRadissonDto.setLname(temp.getFname());
				userRadissonDto.setPhone(temp.getPhone());
				userRadissonDto.setEmail(temp.getEmail());
				cat.setUserCategoryCode(temp.getUserCat().getUserCategoryCode());
				cat.setUserCategoryName(temp.getUserCat().getUserCategoryName());
				cat.setUserCategoryDescription(temp.getUserCat().getUserCategoryDescription());
				userRadissonDto.setUserCat(cat);

			}
		}

		return userRadissonDto;
	}

	@GetMapping(path = "/createNewTrip/{driver}/{rider}")
	@ResponseBody
	public TripRadissonDto createNewTrip(@PathVariable Long driver, @PathVariable Long rider) {
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
		TripRadissonDto trpDto = new TripRadissonDto();
		Trip trp = new Trip();
		Optional<Users> drv;
		Optional<Users> rder;
		drv = usersDaoImpl.findById(driver);
		rder = usersDaoImpl.findById(rider);
		trp.setDriver(drv.get());
		trp.setRider(rder.get());
		trp.setStatLongitude(-1.970970);
		trp.setStatLatutide(-1.970970);
		trp.setCreatedTime(timestamp);
		trp.setStatTimeDate(timestamp);
		trp.setPrice(GenerateNumberUtil.getPrice());
		trp.setTripStatusCode("NEW");
		trp.setComment("This an new trip request");
		trp = tripImpl.save(trp);
		trpDto.setDriver(trp.getDriver());
		trpDto.setRider(trp.getRider());
		trpDto.setStatLatutide(trp.getStatLatutide());
		trpDto.setStatLongitude(trp.getStatLongitude());
		trpDto.setCreatedTime(trp.getCreatedTime());
		trpDto.setStatTimeDate(trp.getStatTimeDate());
		trpDto.setPrice(trp.getPrice());
		trpDto.setTripId(trp.getTripId());
		trpDto.setTripStatusCode(trp.getTripStatusCode());

		return trpDto;
	}

	@PutMapping("/competeTrip/{id}")
	public Invoice competeTrip(@PathVariable(value = "id") Long tripId) {
		Trip trp1 = new Trip();
		
		Optional<Trip> trp;
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		trp = tripImpl.findById(tripId);
		trp.get().setFinishLatutide(LocationUtil.getLat());
		trp.get().setFinishLongitude(LocationUtil.getLog());
		trp.get().setFinishTimeDate(timestamp);
		trp.get().setTripStatusCode("COMPLETED");
		trp1 = trp.get();
		trp1 = tripImpl.save(trp1);

		return generateInvoice(trp1);
	}

	@PutMapping("/startTrip/{id}")
	public Trip startTrip(@PathVariable(value = "id") Long tripId) {
		Trip trp1 = new Trip();
		Optional<Trip> trp;
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		trp = tripImpl.findById(tripId);
		trp.get().setFinishLatutide(LocationUtil.getLat());
		trp.get().setFinishLongitude(LocationUtil.getLog());
		trp.get().setFinishTimeDate(timestamp);
		trp.get().setTripStatusCode("ACTIVE");

		trp1 = trp.get();
		trp1 = tripImpl.save(trp1);

		return trp1;
	}
	
	
	@GetMapping(path="/getActiveTrip")
	@ResponseBody
	public List<TripRadissonDto> getActiveTrip() {
	  List<TripRadissonDto> tripRadissonDtoList = new ArrayList<TripRadissonDto>();
		
		for (Trip temp : tripImpl.findAll()) {
			TripRadissonDto tripRadissonDtoDto= new TripRadissonDto();
			if(temp!=null && temp.getTripStatusCode().equals("ACTIVE")){	
				tripRadissonDtoDto.setDriver(temp.getDriver());
				tripRadissonDtoDto.setRider(temp.getRider());
				tripRadissonDtoDto.setStatLatutide(temp.getStatLatutide());
				tripRadissonDtoDto.setStatLongitude(temp.getStatLongitude());
				tripRadissonDtoDto.setPrice(temp.getPrice());
				tripRadissonDtoDto.setTripStatusCode(temp.getTripStatusCode());
				tripRadissonDtoDto.setStatTimeDate(temp.getStatTimeDate());
				tripRadissonDtoDto.setCreatedTime(temp.getCreatedTime());
				tripRadissonDtoDto.setTripId(temp.getTripId());
				tripRadissonDtoList.add(tripRadissonDtoDto);
			}
		}
	
	return tripRadissonDtoList;
	}
	
	
	
	
	@GetMapping(path = "/get3closeClosestDriver/{driver}/{km}")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> get3closeClosestDriver(@PathVariable Long driver, @PathVariable double km) {
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();
		UsersAvailability usersDrive =new UsersAvailability() ;
		usersDrive=getDriverAvailaableByIdOnly(driver);
		System.out.println(usersDrive.getUsers().getEmail());
		if(usersDrive!=null) {
		for (UsersAvailability temp : availability.findAll()) {
			UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();
			UserRadissonDto userRadissonDto = new UserRadissonDto();
			UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
			
			
			if (temp != null&& temp.getUsers().getUserCat().getUserCategoryCode().equals("DRIVER")&&temp.getUsers().getUserId()!=driver) {
				if (LocationUtil.getDistance(usersDrive.getLatitude(), usersDrive.getLongitude(), temp.getLatitude(), temp.getLongitude(), 'K') <= km) {
					LOGGER.info("Closest driver distance  between is:: "
							+ LocationUtil.getDistance(usersDrive.getLatitude(), usersDrive.getLongitude(), temp.getLatitude(), temp.getLongitude(), 'K')
							+ "Km");
					userRadissonDto.setUserId(temp.getUsers().getUserId());
					userRadissonDto.setFname(temp.getUsers().getFname());
					userRadissonDto.setLname(temp.getUsers().getFname());
					userRadissonDto.setPhone(temp.getUsers().getPhone());
					userRadissonDto.setEmail(temp.getUsers().getEmail());
					cat.setUserCategoryCode(temp.getUsers().getUserCat().getUserCategoryCode());
					cat.setUserCategoryName(temp.getUsers().getUserCat().getUserCategoryName());
					cat.setUserCategoryDescription(temp.getUsers().getUserCat().getUserCategoryDescription());
					userRadissonDto.setUserCat(cat);
					userAvaibilityRadissonDto.setDistance(
					LocationUtil.getDistance(usersDrive.getLatitude(),  usersDrive.getLongitude(), temp.getLatitude(), temp.getLongitude(), 'K'));
					userAvaibilityRadissonDto.setAvailableDateTime(temp.getAvailableDateTime());
					userAvaibilityRadissonDto.setLatitude(temp.getLatitude());
					userAvaibilityRadissonDto.setLongitude(temp.getLongitude());
					userAvaibilityRadissonDto.setStatus(temp.getStatus());
					userAvaibilityRadissonDto.setUserRadissonDto(userRadissonDto);
					userAvaibilityRadissonDtoList.add(userAvaibilityRadissonDto);

				}
			}
		}
		}

		return userAvaibilityRadissonDtoList;
	}
	
	public UsersAvailability getDriverAvailaableByIdOnly(Long userId) {
		UsersAvailability usersAvailabilityDto = new UsersAvailability();
		for (UsersAvailability temp :  availability.findAll()) {

			if (temp != null && temp.getUsers().getUserId() == userId
					&& temp.getUsers().getUserCat().getUserCategoryCode().equals("DRIVER")) {

				usersAvailabilityDto.setAvailableDateTime(temp.getAvailableDateTime());
				usersAvailabilityDto.setAvailableDriverId(temp.getAvailableDriverId());
				usersAvailabilityDto.setLatitude(temp.getLatitude());
				usersAvailabilityDto.setLongitude(temp.getLongitude());
				usersAvailabilityDto.setStatus(temp.getStatus());
				usersAvailabilityDto.setUsers(temp.getUsers());
			

			}
		}

		return usersAvailabilityDto;
	}
	
	public Invoice generateInvoice(Trip trp) {
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		Invoice inv=new Invoice();
		
		inv.setTrip(trp);
		inv.setAmount(trp.getPrice());
		inv.setBillNumber("BILL"+GenerateNumberUtil.getBillNumber());
		inv.setCreatedDate(timestamp);
		inv.setInvoiceStatus("Payed");
		inv=invoiceImpl.save(inv);
		return inv;
		
		
	}
	
	

}
