package com.navitsa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.Customer;
import com.navitsa.entity.Levelmanage;
import com.navitsa.entity.Role;
import com.navitsa.entity.Roleassign;
import com.navitsa.entity.SysLocation;
import com.navitsa.entity.TaxConfiguration;
import com.navitsa.entity.UserLevel;
import com.navitsa.entity.Users;
import com.navitsa.repository.BusinessPartnerRepository;
import com.navitsa.repository.CustomerRepository;
import com.navitsa.repository.LevelmanageRepository;
import com.navitsa.repository.OcrDetailsRepository;
import com.navitsa.repository.RoleRepository;
import com.navitsa.repository.RoleassignRepository;
import com.navitsa.repository.SysLocationRepository;
import com.navitsa.repository.TaxConfigurationRepository;
import com.navitsa.repository.UserLevelRepository;
import com.navitsa.repository.UsersRepository;



@Service
public class UsersService {
	@Autowired
	UsersRepository repo;

	@Autowired
	BusinessPartnerRepository partnerRepo;
	
	@Autowired
	UserLevelRepository userlevelrepo;
	@Autowired
	RoleassignRepository roleassignRepository;
	
	@Autowired
	TaxConfigurationRepository taxConfigrepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	LevelmanageRepository levelManageRepo;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OcrDetailsRepository ocrDetailsRepository;
	
	@Autowired
	SysLocationRepository sysLocationRepository;
	
	public List<Users> listAll(){
		return (List<Users>) repo.findAll();
		
	}
	public void save(Users users) {
		repo.save(users);			
	}
	
	public List<Users> findUser(String uname, String pass ){
		return repo.checkLogin(uname, pass);	
	}
	
	public Users profileItemByID(String userId) {
		Users result=repo.findById(userId).get();
		return result;
	}

	public List <UserLevel> listAllUserlevel(){
		return (List<UserLevel>) userlevelrepo.findAll();
	}
	
	public String maxUsersID() {
		if (repo.maxUsersID() == null) {
			return "1";
		} else {

			return repo.maxUsersID();
		}

	}
	
	public void saveUserLevel(UserLevel userlevel) {
		userlevelrepo.save(userlevel);
	}
	public List<UserLevel> getUserLevel() {
		return (List<UserLevel>) userlevelrepo.findAll();
	}
	
	
	public UserLevel userLevelBYId(String id) {
		UserLevel ulist=userlevelrepo.findById(id).get();
		return ulist ;
	}
	
	public String maxUserlevelID() {
		if (userlevelrepo.maxUserlevelID() == null) {
			return "1";
		} else {

			return userlevelrepo.maxUserlevelID();
		}

	}
	
	public List<BusinessPartner> getAllPartners() {
		return (List<BusinessPartner>) partnerRepo.findAll();
	}
	public List<Users> userbyuserName(String uname){
		return (List<Users>) repo.userbyuserName(uname);
		
	}
	public List<Users> userbyLevel(String userLevel){
		return repo.userbyLevel(userLevel);
		
	}
	public Users searchUser(String userid) {
		return repo.userDet(userid);
		
	}
	public Users searchUserName(String userName) {
		return repo.userNamesearch(userName);
		
	}
	public List<Roleassign> findUserIdRoles(String userid){
		return roleassignRepository.findUserIdRoles(userid);
		
	}
	 public List<Levelmanage> getUserLevelmanageRole(String userid){
		return levelManageRepo.getUserLevelmanageRole(userid);
	}
	//save taxConfiguration
	public void  saveTax(TaxConfiguration taxc) {
		 taxConfigrepository.save(taxc);
	}
	
	//configure auto increment of tax configure primary key
	public String maxtaxID() {
		if (taxConfigrepository.maxtaxID() == null) {
			return "1";
		} else {

			return taxConfigrepository.maxtaxID();
		}

	}
	//getAll taxes
	public List<TaxConfiguration> getAllsavedtaxes() {
		return (List<TaxConfiguration>) taxConfigrepository.findAll();
	}
	//update taxInfo
	public TaxConfiguration taxByid(String taxCode) {
		TaxConfiguration result=taxConfigrepository.findById(taxCode).get();
		return result;
	}
	//roles according to userlevel id
	public String[] listsOfRoles(String ulid ) {
		return roleRepository.listOfRoles(ulid);
	}
	//save role assign
	public void save(Roleassign roleassign) {
		roleassignRepository.save(roleassign);
	}
	
	public List<Role> getAll()
	{
		return (List<Role>) roleRepository.getAllRoles();		
	}
	
	public void saveLevelManage(Levelmanage lm)
	{
		levelManageRepo.save(lm);
	}
	public void saveCustomer(Customer cus) {
		
		customerRepository.save(cus);
		
	}
	public List<Customer> viewAllCustomers() {
		
		return (List<Customer>)customerRepository.findAll();
		
	}
	
	public String maxCusID() {
		
		if (customerRepository.maxCusID() == null) {
			return "1";
		} else {

			return customerRepository.maxCusID();
		}
	}
	public Customer viewCustomersDetailByID(String cusid) {
		Customer result=customerRepository.findById(cusid).get();
		return result;
	}
	public void deleteUserLevelManageByLevelid(String levelid) {
		levelManageRepo.deleteUserLevelManageByLevelid(levelid);
		
	}
//	public void deleteUserLevelManageByLevelid(String levelid) {
//		levelManageRepo.deleteUserLevelManageByLevelid(levelid);
//		
//	}
	public List<Role> getAllNotAssignRole(String ulid){
		return roleRepository.getAllNotAssignRole(ulid);		
	}
	
	public List<Role> getAssignRoleByLevel(String ulid){
		return roleRepository.getAssignRoleByLevel(ulid);
	}
	public UserLevel getUserLevel(String ulevel) {
		return userlevelrepo.findById(ulevel).get();
	}
	public List<Users> findQrUser(String uname, String login ){
		return repo.checkQrLogin(uname, login);		
	}
	
	public String[][] getDashBordOCrDetails(String selectedDate){
		String selectedDate1=selectedDate+"%";
		return  ocrDetailsRepository.getDashBordOCrDetails(selectedDate1);
	}
	public List<SysLocation> getSysLocation(){		
		return  (List<SysLocation>) sysLocationRepository.findAll();
	}
	
}//sysLocationRepository
