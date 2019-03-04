package com.bk.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
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
import com.bk.Utilities.GenerateNumberUtil;
import com.bk.Utilities.LocationUtil;
import com.bk.dto.TripRadissonDto;
import com.bk.dto.UserAvaibilityRadissonDto;
import com.bk.dto.UserCategoryRaddissonDto;
import com.bk.dto.UserRadissonDto;
import com.bk.model.Invoice;
import com.bk.model.Trip;
import com.bk.model.UserCategory;
import com.bk.model.Users;
import com.bk.model.UsersAvailability;
import com.bk.repo.IAvailability;
import com.bk.repo.IInvoice;
import com.bk.repo.IUsersRepo;
import com.bk.repo.Itrip;
import com.bk.service.interfaces.IGenerateTaxi24Constant;

/**
 * @author Eric
 *
 */
@RestController
@RequestMapping({ "/getTaxi24" })
public class GenerateTaxi24ServiceImpl implements IGenerateTaxi24Constant {
	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	private static final String CLASSNAME = "GenerateTaxi24ServiceImpl :: ";
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

	@GetMapping(path = "/findUserByUserCategoryCode/{categoryCode}")
	@ResponseBody
	public List<UserRadissonDto> getAllUsersByCategoryCode(@PathVariable String categoryCode) {
		LOGGER.info(CLASSNAME + "getAllUsersByCategoryCode:: start");
		UserCategory cat = new UserCategory();
		List<UserRadissonDto> userRadissonDtoList = new ArrayList<UserRadissonDto>();
		List<Object[]> list = usersDaoImpl.findUserByUserCategoryCode(categoryCode);
		List<Users> uslist = new ArrayList<>();
		List<UserCategory> usCatlist = new ArrayList<>();
		if (list != null) {
			for (Object[] ob : list) {
				Users u = new Users();
				u = (Users) ob[0];
				cat = (UserCategory) ob[1];
				uslist.add(u);
				usCatlist.add(cat);
			}

			for (Users temp : uslist) {
				UserRadissonDto userRadissonDto = new UserRadissonDto();
				UserCategoryRaddissonDto cate = new UserCategoryRaddissonDto();

				cate.setUserCategoryCode(temp.getUserCat().getUserCategoryCode());
				cate.setUserCategoryName(temp.getUserCat().getUserCategoryName());
				cate.setUserCategoryDescription(temp.getUserCat().getUserCategoryDescription());

				userRadissonDto.setUserId(temp.getUserId());
				userRadissonDto.setFname(temp.getFname());
				userRadissonDto.setLname(temp.getFname());
				userRadissonDto.setPhone(temp.getPhone());
				userRadissonDto.setEmail(temp.getEmail());
				userRadissonDto.setUserCat(cate);
				userRadissonDtoList.add(userRadissonDto);
			}

		}
		LOGGER.info(CLASSNAME + "getAllUsersByCategoryCode:: End");
		return userRadissonDtoList;
	}

	@GetMapping(path = "/findAvailableDriver")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> findAvailableDriver() {
		LOGGER.info(CLASSNAME + "findAvailableDriver:: start");
		UserCategory cat = new UserCategory();
		UsersAvailability av = new UsersAvailability();
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();
		List<Object[]> list = availability.findUserByUserCategoryCodeAndSatus(PARAM_DRIVER, PARAM_AVAILABLE);
		List<Users> uslist = new ArrayList<>();
		List<UserCategory> usCatlist = new ArrayList<>();
		List<UsersAvailability> avlist = new ArrayList<>();
		if (list != null) {
			for (Object[] ob : list) {
				Users u = new Users();
				u = (Users) ob[0];
				cat = (UserCategory) ob[1];
				av = (UsersAvailability) ob[2];
				uslist.add(u);
				usCatlist.add(cat);
				avlist.add(av);
			}

			for (UsersAvailability temp : avlist) {
				UserRadissonDto userRadissonDto = new UserRadissonDto();
				UserCategoryRaddissonDto cate = new UserCategoryRaddissonDto();
				UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();

				cate.setUserCategoryCode(temp.getUsers().getUserCat().getUserCategoryCode());
				cate.setUserCategoryName(temp.getUsers().getUserCat().getUserCategoryName());
				cate.setUserCategoryDescription(temp.getUsers().getUserCat().getUserCategoryDescription());
				userRadissonDto.setUserId(temp.getUsers().getUserId());
				userRadissonDto.setFname(temp.getUsers().getFname());
				userRadissonDto.setLname(temp.getUsers().getFname());
				userRadissonDto.setPhone(temp.getUsers().getPhone());
				userRadissonDto.setEmail(temp.getUsers().getEmail());
				userRadissonDto.setUserCat(cate);
				userAvaibilityRadissonDto.setAvailableDateTime(temp.getAvailableDateTime());
				userAvaibilityRadissonDto.setLatitude(temp.getLatitude());
				userAvaibilityRadissonDto.setLongitude(temp.getLongitude());
				userAvaibilityRadissonDto.setStatus(temp.getStatus());
				userAvaibilityRadissonDto.setUserRadissonDto(userRadissonDto);
				userAvaibilityRadissonDtoList.add(userAvaibilityRadissonDto);
			}
		}
		LOGGER.info(CLASSNAME + "findAvailableDriver:: end");
		return userAvaibilityRadissonDtoList;
	}

	@GetMapping(path = "/getDriverById/{userId}")
	public UserRadissonDto findUserByUserIdAndUserCategoryCode(@PathVariable Long userId) {
		LOGGER.info(CLASSNAME + "findUserByUserIdAndUserCategoryCode:: start");
		UserRadissonDto userRadissonDto = new UserRadissonDto();
		UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
		Users temp = usersDaoImpl.findUserByUserIdAndUserCategoryCode(userId, PARAM_DRIVER);
		if (temp != null) {
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
		LOGGER.info(CLASSNAME + "findUserByUserIdAndUserCategoryCode:: end");
		return userRadissonDto;
	}

	@GetMapping("/getRidersById/{id}")
	public UserRadissonDto getRidersById(@PathVariable(value = "id") Long userId) {
		LOGGER.info(CLASSNAME + "getRidersById:: start");
		UserRadissonDto userRadissonDto = new UserRadissonDto();
		UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
		Users temp = usersDaoImpl.findUserByUserIdAndUserCategoryCode(userId, PARAM_RIDER);
		if (temp != null) {
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
		LOGGER.info(CLASSNAME + "getRidersById:: end");
		return userRadissonDto;
	}

	@GetMapping(path = "/createNewTrip/{driver}/{rider}")
	@ResponseBody
	public TripRadissonDto createNewTrip(@PathVariable Long driver, @PathVariable Long rider) {
		LOGGER.info(CLASSNAME + "createNewTrip:: start");
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
		TripRadissonDto trpDto = new TripRadissonDto();
		Trip trp = new Trip();
		Optional<Users> drv;
		Optional<Users> rder;
		drv = usersDaoImpl.findById(driver);
		rder = usersDaoImpl.findById(rider);
		if (drv != null)
			trp.setDriver(drv.get());
		if (rder != null)
			trp.setRider(rder.get());
		trp.setStatLongitude(-1.970970);
		trp.setStatLatutide(-1.970970);
		trp.setCreatedTime(timestamp);
		trp.setStatTimeDate(timestamp);
		trp.setPrice(GenerateNumberUtil.getPrice());
		trp.setTripStatusCode(PARAM_NEW);
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
		LOGGER.info(CLASSNAME + "createNewTrip:: end");
		return trpDto;
	}

	@PutMapping("/competeTrip/{id}")
	public Invoice competeTrip(@PathVariable(value = "id") Long tripId) {
		LOGGER.info(CLASSNAME + "competeTrip:: start");
		Trip trp1 = new Trip();

		Optional<Trip> trp;
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		trp = tripImpl.findById(tripId);
		trp.get().setFinishLatutide(LocationUtil.getLat());
		trp.get().setFinishLongitude(LocationUtil.getLog());
		trp.get().setFinishTimeDate(timestamp);
		trp.get().setTripStatusCode(PARAM_COMPLETED);
		trp1 = trp.get();
		trp1 = tripImpl.save(trp1);
		LOGGER.info(CLASSNAME + "competeTrip:: end");
		return generateInvoice(trp1);
	}

	@PutMapping("/startTrip/{id}")
	public Trip startTrip(@PathVariable(value = "id") Long tripId) {
		LOGGER.info(CLASSNAME + "competeTrip:: start");
		Trip trp1 = new Trip();
		Optional<Trip> trp;
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		trp = tripImpl.findById(tripId);
		trp.get().setFinishLatutide(LocationUtil.getLat());
		trp.get().setFinishLongitude(LocationUtil.getLog());
		trp.get().setFinishTimeDate(timestamp);
		trp.get().setTripStatusCode(PARAM_ACTIVE);

		trp1 = trp.get();
		trp1 = tripImpl.save(trp1);
		LOGGER.info(CLASSNAME + "competeTrip:: end");
		return trp1;
	}

	public Invoice generateInvoice(Trip trp) {
		LOGGER.info(CLASSNAME + "generateInvoice:: start");
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

		Invoice inv = new Invoice();

		inv.setTrip(trp);
		inv.setAmount(trp.getPrice());
		inv.setBillNumber(PARAM_BILL + GenerateNumberUtil.getBillNumber());
		inv.setCreatedDate(timestamp);
		inv.setInvoiceStatus(PARAM_PAYED);
		inv = invoiceImpl.save(inv);
		LOGGER.info(CLASSNAME + "generateInvoice:: end");
		return inv;

	}

	@GetMapping(path = "/getActiveTrip")
	@ResponseBody
	public List<TripRadissonDto> getActiveTrips() {
		LOGGER.info(CLASSNAME + "getActiveTrips:: start");
		List<TripRadissonDto> tripRadissonDtoList = new ArrayList<TripRadissonDto>();

		for (Trip temp : tripImpl.findTripByTripStatusCode(PARAM_ACTIVE)) {
			TripRadissonDto tripRadissonDtoDto = new TripRadissonDto();
			if (temp != null) {
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
		LOGGER.info(CLASSNAME + "getActiveTrips:: end");
		return tripRadissonDtoList;
	}

	@GetMapping(path = "/availableDriverWithin3km/{lat}/{longi}")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> getAvailableDriverWithin3km(@PathVariable double lat,
			@PathVariable double longi) {
		LOGGER.info(CLASSNAME + "getAvailableDriverWithin3km:: start");
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();

		for (UsersAvailability temp : availability.findAll()) {
			UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();
			UserRadissonDto userRadissonDto = new UserRadissonDto();
			UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
			if (temp != null && temp.getStatus().equals(PARAM_AVAILABLE)
					&& temp.getUsers().getUserCat().getUserCategoryCode().equals(PARAM_DRIVER)) {
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
		LOGGER.info(CLASSNAME + "getAvailableDriverWithin3km:: end");
		return userAvaibilityRadissonDtoList;
	}

	@GetMapping(path = "/get3closeClosestDriver/{driver}/{km}")
	@ResponseBody
	public List<UserAvaibilityRadissonDto> get3closeClosestDriver(@PathVariable Long driver, @PathVariable double km) {
		LOGGER.info(CLASSNAME + "getAvailableDriverWithin3km:: start");
		List<UserAvaibilityRadissonDto> userAvaibilityRadissonDtoList = new ArrayList<UserAvaibilityRadissonDto>();
		UsersAvailability usersDrive = new UsersAvailability();
		usersDrive = getDriverAvailaableByIdOnly(driver);
		if (usersDrive != null) {
			for (UsersAvailability temp : availability.findAll()) {
				UserAvaibilityRadissonDto userAvaibilityRadissonDto = new UserAvaibilityRadissonDto();
				UserRadissonDto userRadissonDto = new UserRadissonDto();
				UserCategoryRaddissonDto cat = new UserCategoryRaddissonDto();
				if (temp != null && temp.getUsers().getUserCat().getUserCategoryCode().equals(PARAM_DRIVER)
						&& temp.getUsers().getUserId() != driver) {
					if (LocationUtil.getDistance(usersDrive.getLatitude(), usersDrive.getLongitude(),
							temp.getLatitude(), temp.getLongitude(), 'K') <= km) {
						userRadissonDto.setUserId(temp.getUsers().getUserId());
						userRadissonDto.setFname(temp.getUsers().getFname());
						userRadissonDto.setLname(temp.getUsers().getFname());
						userRadissonDto.setPhone(temp.getUsers().getPhone());
						userRadissonDto.setEmail(temp.getUsers().getEmail());
						cat.setUserCategoryCode(temp.getUsers().getUserCat().getUserCategoryCode());
						cat.setUserCategoryName(temp.getUsers().getUserCat().getUserCategoryName());
						cat.setUserCategoryDescription(temp.getUsers().getUserCat().getUserCategoryDescription());
						userRadissonDto.setUserCat(cat);
						userAvaibilityRadissonDto.setDistance(LocationUtil.getDistance(usersDrive.getLatitude(),
								usersDrive.getLongitude(), temp.getLatitude(), temp.getLongitude(), 'K'));
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
		LOGGER.info(CLASSNAME + "getAvailableDriverWithin3km:: end");
		return userAvaibilityRadissonDtoList;
	}

	public UsersAvailability getDriverAvailaableByIdOnly(Long userId) {
		LOGGER.info(CLASSNAME + "getDriverAvailaableByIdOnly:: start");
		UsersAvailability usersAvailabilityDto = new UsersAvailability();
		for (UsersAvailability temp : availability.findAll()) {
			if (temp != null && temp.getUsers().getUserId() == userId
					&& temp.getUsers().getUserCat().getUserCategoryCode().equals(PARAM_DRIVER)) {
				usersAvailabilityDto.setAvailableDateTime(temp.getAvailableDateTime());
				usersAvailabilityDto.setAvailableDriverId(temp.getAvailableDriverId());
				usersAvailabilityDto.setLatitude(temp.getLatitude());
				usersAvailabilityDto.setLongitude(temp.getLongitude());
				usersAvailabilityDto.setStatus(temp.getStatus());
				usersAvailabilityDto.setUsers(temp.getUsers());
			}
		}
		LOGGER.info(CLASSNAME + "getDriverAvailaableByIdOnly:: end");
		return usersAvailabilityDto;
	}

	
}
