package com.registration.service;

import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.entity.City;
import com.registration.entity.Country;
import com.registration.entity.State;
import com.registration.entity.UnlockAcc;
import com.registration.entity.User;
import com.registration.repository.CityRepo;
import com.registration.repository.CountryRepo;
import com.registration.repository.StateRepo;
import com.registration.repository.UserRepo;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	private StateRepo stateRepo;

	@Override
	public String cheackSignIn(String email, String password) {
		User user = this.getUserByEmail(email);
		if (user != null) {
			if (user.getEmail() == email && user.getPassword() == password && this.updatePassword(email, password)) {
				return "succcsess";
			}

			if (user.getEmail() != email || user.getPassword() == password && this.updatePassword(email, password)) {
				return "invalid";
			}

			if (user.getEmail() == email && user.getPassword() == password && !this.updatePassword(email, password)) {
				return "locked";
			}
		}
		return null;
	}

	@Override
	public Map<Integer, String> getCountry() {
		List<Country> countriesList = this.countryRepo.findAll();
		Map<Integer, String> countriesMap = countriesList.stream()
				.collect(Collectors.toMap(Country::getCountryCode, Country::getCountryName));
		return countriesMap;
	}

	@Override
	public Map<Integer, String> getState(Integer countryId) {
		List<State> liststates = this.stateRepo.findAllByCountryId(countryId);
		return liststates.stream().collect(Collectors.toMap(State::getStateCode, State::getStateName));
	}

	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		List<City> listCities = this.cityRepo.findAllByStateId(stateId);

		return listCities.stream().collect(Collectors.toMap(City::getCityCode, City::getCityName));

	}

	@Override
	public User getUserByEmail(String email) {
		User user = this.userRepo.findByEmail(email);
		return user;
	}

	@Override
	public boolean saveUser(User u) {

		u.setPassword(this.getGeneratePasword());
		return this.userRepo.save(u) != null;
	}

	@Override
	public String unLockAcc(UnlockAcc acc) {
		if (this.updatePassword(acc.getEmail(), acc.getNewPassword())) {
			return "User Account is unlocked please proceed with login";
		}
		return null;

	}

	private boolean updatePassword(String email, String password) {

		boolean isUpdatedPassword = false;
		UnlockAcc unlockAcc = new UnlockAcc();
		User userObj = this.getUserByEmail(email);
		if (userObj.getPassword() == unlockAcc.getTemPassword()) {
			unlockAcc.setNewPassword(password);
			if (unlockAcc.getNewPassword() == unlockAcc.getConformPassword()) {
				userObj.setPassword(unlockAcc.getNewPassword());
				return isUpdatedPassword = true;
			}
		}
		return isUpdatedPassword;
	}

	@Override
	public User forgotPassword(String emailId) {
		User userForgotPassword = this.getUserByEmail(emailId);
		if (userForgotPassword != null) {
			userForgotPassword.getPassword();
		}
		return userForgotPassword;
	}

	private String getGeneratePasword() {

		return null;

	}

	public String sendEmail(String email) {

		return "";
	}

}
