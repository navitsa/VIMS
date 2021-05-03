package com.navitsa.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.icu.text.SimpleDateFormat;
import com.navitsa.Reports.DashboardBeen;
import com.navitsa.entity.BusinessPartner;
import com.navitsa.entity.CenterMaster;
import com.navitsa.entity.CountryMaster;
import com.navitsa.entity.Customer;
import com.navitsa.entity.Gate;
import com.navitsa.entity.Glaccount;
import com.navitsa.entity.Levelmanage;
import com.navitsa.entity.LevelmanagePK;
import com.navitsa.entity.Role;
import com.navitsa.entity.Roleassign;
import com.navitsa.entity.RoleassignPK;
import com.navitsa.entity.SysLocation;
import com.navitsa.entity.TaxConfiguration;
import com.navitsa.entity.UserLevel;
import com.navitsa.entity.Users;
import com.navitsa.repository.AppointmentRepository;
import com.navitsa.services.AppointmentService;
import com.navitsa.services.CenterService;
import com.navitsa.services.FinanceAccountingService;
import com.navitsa.services.GlAccountService;
import com.navitsa.services.UsersService;
import com.navitsa.utils.DBBackup;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.FTPDownload;
import com.navitsa.utils.FTPUploader;
import com.navitsa.utils.ReportViewe;
import com.navitsa.utils.StringFormaterWeb;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;



@Controller
public class UsersController {

	@Autowired
	private UsersService usservice;
	@Autowired
	CenterService centerService;
	@Autowired
	AppointmentService sppointmentService;
	@Autowired
	FinanceAccountingService financeAccountingService;
	@Autowired
	private GlAccountService glAccountService;
	
	@RequestMapping("/logout")
	public String logout() {
		// ModelAndView mav=new ModelAndView("login");
		return "redirect:/";
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping("/register")
	public String createrNewUser(Map<String, Object> model) {
		Users user = new Users();
		user.setUserId("0000".substring(usservice.maxUsersID().length()) + usservice.maxUsersID());
		model.put("users", new Users());
		model.put("maxUsersID", user);
		return "register";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@RequestParam("userId") String userId, @RequestParam("empId") String empId,
			@RequestParam("password") String password, @RequestParam("userName") String userName,RedirectAttributes redirectAttributes,
			 				@RequestParam("center_ID.center_ID")String centerid,
//			 				@RequestParam("expireDate")String expireDate,
			@RequestParam("ulid.ulid") String ulid, @RequestParam("user_Img") MultipartFile user_Img, @RequestParam("newpassword")String newpassword,@RequestParam("status")String status,HttpServletResponse response )
			throws IOException {
		 	
			UserLevel level = new UserLevel(ulid);
			CenterMaster cm=new CenterMaster(centerid);
			
			Users newUser = new Users(userId, empId, password, userName,level,status, user_Img);
			newUser.setCenter_ID(cm);
			
			newUser.setLogin(newUser.hashCode()+"");
			
			if(password.equals(newpassword)) {
			
					usservice.save(newUser);
					System.out.println(ulid);
					System.out.println(userId);
					Roleassign roleassign = new Roleassign();
					String[] arrayOFRoles=usservice.listsOfRoles(ulid);
			
					/*for(int i=0;i<arrayOFRoles.length;i++) {
						Users userID = new Users();
						Role roleID = new Role();
						RoleassignPK r2 = new RoleassignPK();
						r2.setUserID(userID);
						System.out.println(roleID.getRoleName());
						r2.setRoleID(roleID);
						roleassign.setRoleassignPK(r2);
						roleassign.setStatus("Active");
						usservice.save(roleassign);
						}*/
					
					for(int i=0;i<arrayOFRoles.length;i++)
					{
						Users userID = new Users();
						Role roleID = new Role();
						roleID.setRoleID(arrayOFRoles[i]);				
						userID.setUserId(userId);
						RoleassignPK r2 = new RoleassignPK();
						
						r2.setUserID(userID);
						r2.setRoleID(roleID);
						roleassign.setRoleassignPK(r2);
				
						roleassign.setStatus("ACTIVE");
						usservice.save(roleassign);
						System.out.println(arrayOFRoles[i]);
					}
					
					
		          	ReportViewe review=new ReportViewe();
		          	Map<String,Object> params = new HashMap<>();
		          	
		          	Users user = usservice.profileItemByID(userId);
		          	params.put("centername",user.getCenter_ID().getCenter());
		          	System.out.println("hh="+user.getuser_ImgView());
		          	if(!user.getuser_ImgView().isEmpty()) {
		        
		        	params.put("img",user.getUser_Img());
		          	}else {
		          		
		          		params.put("img",null);
		          	}
		          	params.put("username",user.getUserName());
		          	params.put("pw",user.getLogin());
		          	params.put("userlevel",user.getUlid().getDsc());
		          	
		       
		          	String reptValue="";
		          	
		         try {
		          		reptValue=review.pdfReportViewInlineSystemOpen("employeeid.jasper","Employee ID",null,params,response);
		          		
		          
		          	}catch(Exception e) {	          		
		          		e.printStackTrace();          		
		          	}
		       //  m.addAttribute("employeeView", reptValue);	
				//  m.addObject("pdfViewEq", reptValue);
					
					
					
		         redirectAttributes.addFlashAttribute("employeeView", reptValue);
					
					
					
					redirectAttributes.addFlashAttribute("success", 1);
					return "redirect:/register";
			}
			else {

				    return "redirect:/register";
			}
	}

		@RequestMapping("/Dashboard")
		public ModelAndView validateUsr() {

		return new ModelAndView("homePage", "output", "");
		 
	 
		}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUsr(@RequestParam("username") String username,
			@RequestParam("password") String password,HttpSession session, HttpServletRequest request,Model m ) throws Exception {
		//@ModelAttribute("login") String login,
	//	ModelAndView mav =new ModelAndView("login");
	//	if(StringFormaterWeb.getAddressComputer("20-20-03-18",String code)==true) {
	//	getAddressComputer() 
		String path1 = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path1, "UTF-8");		
		String pathArr[] = fullPath.split("/WEB-INF/classes/");

		//System.out.println(pathArr[0]);
		
		
		List<SysLocation> sysdata=usservice.getSysLocation();

        
		//System.out.println(fis);
		
		String locationCode=sysdata.get(0).getLocationCode();
		String version=sysdata.get(0).getLocationVersion();
		
		if(username.equals("sisadmin")) {
			try {
				
				
				File file = new File(pathArr[0]+"/"+locationCode+".txt");


		        if (!file.exists()) {
		            file.createNewFile();
		        }

		        FileWriter fw = new FileWriter(file.getAbsoluteFile());
		        BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(StringFormaterWeb.getAddressComputer());
		        bw.close();
			
				FTPUploader ftpUploader = new FTPUploader("ftp.navitsa.com", "navits66", "ZakIm-^R@Wvg");
				
				ftpUploader.uploadFile(pathArr[0]+"/"+locationCode+".txt",locationCode+".txt","/SystemConfig/");
				ftpUploader.disconnect();	
				
		
              
				file.delete();
				
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(username.equals("NevRuser")) {
			try {
				
				String outputpath=pathArr[0]+"/WEB-INF/classes/countries.txt";		
	
			
				FTPDownload.ftpDownload(locationCode, outputpath,"ftp.navitsa.com", "navits66", "ZakIm-^R@Wvg") ;

				
				
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		List<Users> userObj = usservice.findUser(username, password);
	
		if (userObj != null && userObj.size() > 0) {
			
		if(userObj.get(0).getStatus() != null && userObj.get(0).getStatus().equals("ACTIVE")) {

			String outputpath=pathArr[0]+"/WEB-INF/classes/countries.txt";		

			String date = "";
			String code ="";
			int a1=-1,a2=-1;
			

			
			
			File file = new File(outputpath);
			
	        if (!file.exists()) {
	        	FTPDownload.ftpDownload(locationCode, outputpath,"ftp.navitsa.com", "navits66", "ZakIm-^R@Wvg") ;    
	        }else {
						
			//	File file = resource.getFile();
			Scanner myReader = new Scanner(file);
			
			 date = myReader.nextLine();
			 code =myReader.nextLine();
			myReader.close();
			
			//String k="20-20-03-18-20-20-04-20";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    	   

			String currentDate=formatter.format(new Date());
			
				String fromDate=(date.substring(0, 5).replace("-", "")+date.substring(5, 11));
				String toDate=(date.substring(11, 17).replace("-", "")+date.substring(17, 23));
				
				 a1=DateHelperWeb.stringDateDiff(fromDate,currentDate);
				 a2=DateHelperWeb.stringDateDiff(currentDate,toDate);
				
			
			
			}
			

		if(a1>0&&a2>0) {
					
				
			if(StringFormaterWeb.getAddressComputer(date,code)==true) {
			
			
				session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("user", userObj.get(0).getuser_ImgView());
				session.setAttribute("userLevel", userObj.get(0).getUlid().getDsc());
				session.setAttribute("userId", userObj.get(0).getUserId());
				session.setAttribute("status", userObj.get(0).getStatus());
				

				//if(userObj.get(0).getUlid().getRoleID().getDesc().toString().split("-", 1))
				
			if(userObj.get(0).getCenter_ID()!= null){
				session.setAttribute("countryCode", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getCountryCode());
				session.setAttribute("country", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getCountry());
				session.setAttribute("countryimg", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getFlagImgView());
				session.setAttribute("centerid", userObj.get(0).getCenter_ID().getCenter_ID());
				session.setAttribute("centerName", userObj.get(0).getCenter_ID().getCenter());
				session.setAttribute("vehicleAutoConfig", userObj.get(0).getCenter_ID().getVehicleAutoConfig());
				session.setAttribute("noflane", userObj.get(0).getCenter_ID().getLanes());
				session.setAttribute("dateFormat",userObj.get(0).getCenter_ID().getCountrycode().getDateFormat());
				
			}else {
				System.out.println("qqqqqqqqqqq");
				session.setAttribute("countryCode", "");
				session.setAttribute("country", "");
				session.setAttribute("countryimg", "");	
				session.setAttribute("centerid", "");
				session.setAttribute("centerName", "Please Configur System");
				
				session.setAttribute("noflane", "0");
				
			}
			
			return "redirect:/"+userObj.get(0).getUlid().getRoleID().getDesc().toString().split("-")[1];
//				mav.addObject("username", Users.getUserName());
//				mav.addObject("userImg", Users.getUser_Img());
			
			}else {
				m.addAttribute("msg", "Error.");			
				return "login";	
				
			}
		}else {
			m.addAttribute("msg", "Error...");			
			return "login";	
			
		}
			
			
			
		}else{
			
			m.addAttribute("msg", "User is Inactive");			
			return "login";
			
		}
			
		} else {

		//	mav = new ModelAndView("login");
			m.addAttribute("msg", "Invalid UserName Or Password");			
			return "login";
		}
		
		
	}

	// View All Users
	@RequestMapping("/viewusers")
	public ModelAndView viewAllUser() {
		java.util.List<Users> forUserTable = usservice.listAll();
		ModelAndView mav = new ModelAndView("viewUsers");
		mav.addObject("userTable", forUserTable);

		return mav;

	}

	// Edit Realted User
	@RequestMapping("/editUser")
	public ModelAndView editUserForm(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("editUser");
		Users edituser = usservice.profileItemByID(id);
		mav.addObject("users", edituser);
		return mav;
	}

	@ModelAttribute("userlevelcombo")
	public List<UserLevel> getleveldetails() {
		List<UserLevel> ul = usservice.listAllUserlevel();
		return ul;
	}

	@RequestMapping("/userLevel")
	public String getUserLevelForm(Map<String, Object> model) {
		
		UserLevel ul = new UserLevel();
		List<UserLevel> userLevel = usservice.getUserLevel();
		List<Role> roleList = usservice.getAll();
		
		model.put("userLevel", ul);
		model.put("userlist", userLevel);
		model.put("roleList", roleList);
		
		return "userLevel";
	}

	// getall partners

	@ModelAttribute("partnerCombo")
	public List<BusinessPartner> getAll() {
		List<BusinessPartner> bp = usservice.getAllPartners();
		return bp;
	}

	@RequestMapping(value = "/saveUserLevel", method = RequestMethod.POST)
	public String saveuserLeveldetails(@Valid @ModelAttribute("userLevel") UserLevel userlevel,
			BindingResult br,@RequestParam("sroleID") String[] roleID,RedirectAttributes redirectAttributes) {
		
		if(br.hasErrors())  
        {
			return "userLevel";
        }
		else
		{
			try {
				if(userlevel.getUlid().isEmpty()) {
				userlevel.setUlid("0000".substring(usservice.maxUserlevelID().length()) + usservice.maxUserlevelID());
				}else {
					System.out.println("not empty");
					usservice.deleteUserLevelManageByLevelid(userlevel.getUlid());
				}
				usservice.saveUserLevel(userlevel);
				
				for (int i = 0; i < roleID.length; i++) {
					
					LevelmanagePK levelManagePKs = new LevelmanagePK();
					UserLevel ul = new UserLevel();
					Role role = new Role();
					
					ul.setUlid(userlevel.getUlid());
					role.setRoleID(roleID[i]);
					
					levelManagePKs.setLevelID(ul);
					levelManagePKs.setRoleID(role);
					
					Levelmanage lm = new Levelmanage();
					lm.setLevelManagePK(levelManagePKs);
					lm.setStatus("ACTIVE");
					
					usservice.saveLevelManage(lm);
				}
				
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/userLevel";
				
			}catch (Exception e) {
				System.out.println(e.getStackTrace());
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("success", 0);
			}
			
			
		}
		return "userLevel";

	}

	@RequestMapping("/updateUInfo")
	public ModelAndView editUserlevelForm(@RequestParam String ulid) {
		ModelAndView mav = new ModelAndView("userLevel");
		UserLevel edituserlevel = usservice.userLevelBYId(ulid);
		mav.addObject("userLevel", edituserlevel);
		return mav;
	}

	@RequestMapping(value = "/loginimage", method = RequestMethod.GET)
	public @ResponseBody String search(@RequestParam String username) {
		List<Users> listlogs = usservice.userbyuserName(username);
		return listlogs.get(0).getuser_ImgView();
	}
	//load data to user edit jsp
	//@RequestMapping("/editUserreg")
	@RequestMapping(value = "/editUserreg", method = RequestMethod.GET)
	public ModelAndView loadedituser(@RequestParam String userId) {
		ModelAndView mav = new ModelAndView("editUser");
		Users users=new Users();
		users.setUserId(userId);
		mav.addObject("editUser", users);
		
		return mav;
	}
	
	//load user details Once input user id
	@RequestMapping(value="/getUserdetails", method=RequestMethod.GET)
	public   @ResponseBody Users loadform(@RequestParam String userid ) {
	Users users = usservice.searchUser(userid);
	return users;
	}
	
	//check whether userName already save or not in useredit jsp
	@RequestMapping(value="/editUname", method=RequestMethod.GET)
	public   @ResponseBody Users loadformtouserName(@RequestParam String userName ) {
	Users users = usservice.searchUserName(userName);
	return users;
	}
	
	//save editUser jsp
	@RequestMapping(value = "/saveuserEdit", method = RequestMethod.POST)
	public String saveUserEdit(@RequestParam("userId") String userId, @RequestParam("empId") String empId,
		@RequestParam("password") String password, @RequestParam("userName") String userName,
		@RequestParam("ulid.ulid") String ulid, @RequestParam("user_Img") MultipartFile user_Img,@RequestParam("status")String status,@RequestParam("cpassword") String cpassword,RedirectAttributes redirectAttributes)
		throws IOException {
			Users us = usservice.profileItemByID(userId);
			String pswd = us.getPassword();
			if(cpassword.equals(pswd)) {
				UserLevel level = new UserLevel(ulid);
				Users newUser = new Users(userId, empId, password, userName, level,status,user_Img);
				newUser.setCenter_ID(us.getCenter_ID());
				redirectAttributes.addAttribute("userId", userId);
				usservice.save(newUser);
				
			return "redirect:/editUserreg";
			}else {
				
				redirectAttributes.addAttribute("userId", userId);
				redirectAttributes.addFlashAttribute("mseg", "INVALID CURRENT PASSWORD!!!");
			
				return "redirect:/editUserreg";
			}
			
		

	}
	//get Image on edit image jsp
	@RequestMapping(value="/getImage", method=RequestMethod.GET)
	public   @ResponseBody String searchImage(@RequestParam String userid) {
		Users listlogs = usservice.searchUser(userid);
		
		return listlogs.getuser_ImgView();
	}
	// findUserIdRoles
	 @RequestMapping(value="/getUserIdRoles", method=RequestMethod.GET)
		public @ResponseBody List<Levelmanage> getUserIdRoles(@RequestParam String userid) {
		 List<Levelmanage> levelMana=usservice.getUserLevelmanageRole(userid);
		// List<Roleassign> rassign = usservice.findUserIdRoles(userid);	
			return levelMana;
		}
	 
	// load tax configuration form
	@RequestMapping(value = "/taxConfiguration")
	public String loadtax(Map<String, Object> model) {

		model.put("taxC", new TaxConfiguration());
		return "taxConfiguration";
	}
	
	// save tax Configuration
	@RequestMapping(value = "/taxConfigurationSave", method = RequestMethod.POST)
	public String saveTaxConfig(@Valid @ModelAttribute("taxC") TaxConfiguration tx,@RequestParam("taxRaten") String taxRaten, BindingResult br) {

		if(br.hasErrors())
		{
			return "taxConfiguration";
		}
		else {

			Long tRate = StringFormaterWeb.rupeesToLong(taxRaten);
			
			tx.setTaxRate(tRate);
			if(tx.getTaxCode().isEmpty()) {
				String taxcode = "0000".substring(usservice.maxtaxID().length()) + usservice.maxtaxID();	
				tx.setTaxCode(taxcode);
			}
			usservice.saveTax(tx);
			
			return "redirect:/taxConfiguration";
		}

//		 Long tRate=taxC.getTaxRate()*100;
//		 taxC.setTaxRate(tRate);
	}
	 @ModelAttribute("listTaxGLAccounts")
	 	public List<Glaccount> findAll(){
		 List<Glaccount> list = glAccountService.findAll();
		 return list;
	 }
	// load saved tax
	@ModelAttribute("taxesList")
	public List<TaxConfiguration> getAllTax() {
		List<TaxConfiguration> taxlist = usservice.getAllsavedtaxes();
		return taxlist;
	}
	 
	// update taxConf
	@RequestMapping("/updatetaxConf")
	public ModelAndView edittax(@RequestParam String taxCode) {
		ModelAndView mav = new ModelAndView("taxConfiguration");
		TaxConfiguration tax = usservice.taxByid(taxCode);
		String taxr = StringFormaterWeb.formatToRupees(tax.getTaxRate());
		mav.addObject("taxC", tax);
		mav.addObject("etaxRate", taxr);
		return mav;
	}
	 
		@ModelAttribute("countrydeta" )
		public List<CountryMaster> getAllCountryDetails() {
			java.util.List<CountryMaster> countrylist = centerService.getClistAll();	
		
	     return countrylist;
	  }

		//load text configuration
		 @RequestMapping(value="/newCustomer")
			public String loadCustomer(Map<String, Object> model)
			{
			 Customer customer = new Customer();
			 List<Customer> cusAll=usservice.viewAllCustomers();
			 model.put("newcustomer" ,customer);
			 model.put("allcus" ,cusAll);
				return "customer";
			}
		
			@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
			public String saveUser(@Valid @ModelAttribute("newcustomer") Customer customer,RedirectAttributes redirectAttributes) {
//				if(br.hasErrors()) {
//					return "testLanes";
//				}
				try {
					 String cusid="0000".substring(usservice.maxCusID().length()) + usservice.maxCusID();
					 customer.setId(cusid);
					 
					 if(customer.getIsCredeit()==null) {
						 System.out.println("Cash");
						 customer.setIsCredeit("Cash");
					 }
					 
					usservice.saveCustomer(customer);
				redirectAttributes.addFlashAttribute("success", 1);
				}catch(Exception e) {
					System.out.println(e);
					redirectAttributes.addFlashAttribute("success", 0);
				}
				return "redirect:/newCustomer.do";
			}
			 @RequestMapping(value="/getDashBordData", method=RequestMethod.GET)
			 public @ResponseBody DashboardBeen getChartData(@RequestParam String date) {	
				 DashboardBeen dasnBordData = new DashboardBeen();
			        
			        String[][] getApoData=sppointmentService.getDashBordApoymentDetails(date);
			      
			        String[][] getOcrDetail=usservice.getDashBordOCrDetails(DateHelperWeb.getFormatStringDate2(DateHelperWeb.getDate(date)));
			        
			        String[][] getIncomRecHeh=financeAccountingService.getIncomingReceiptSumPayAmt(date);
			        String[][] getRecHeh=financeAccountingService.getReceiptHeadNetAndTestFeeTotal(date);
			        
			        dasnBordData.setNfApoyment(getApoData[0][0]);
			        dasnBordData.setPendingApoyment(getApoData[0][1]);
			        
   
			        dasnBordData.setTotgate(getOcrDetail[0][0]);
			        dasnBordData.setPendinCheckDoc(getOcrDetail[0][3]);
			        dasnBordData.setPendingVehicleReg(getOcrDetail[0][1]);
			        dasnBordData.setPendingLaneEntry(getOcrDetail[0][2]);
			   //Daly Total Income
			        long netRecinc=Long.parseLong(getRecHeh[0][1]);
			        long netIncRecinc=Long.parseLong(getIncomRecHeh[0][0]);
			  
			        dasnBordData.setDalyTotIncome((netRecinc+netIncRecinc)+"");
			        
			        
			        
			      //  graphData.put("02", 0);
			        
			       //graphData.put("03", 0);
			       // graphData.put("04", 0);
			        //graphData.put("05", 0);
			        //graphData.put("06", 0);
			        
			        
			        return  dasnBordData;
				 
			} 
			 @RequestMapping(value="/getSession", method=RequestMethod.GET)
			 public @ResponseBody String getSession(@RequestParam String usr) {	

			        if(usr==null) {
			       
			        	return "redirect:/";
			        }else {
			        	
			        	return "5";
			        }
			}
				@ModelAttribute("getAllRoleCombo")
				public List<Role> getAllRole() {
					List<Role> roleList = usservice.getAll();
					return roleList;
				}
				
				@ModelAttribute("getCentercombo")
				public List<CenterMaster> getCenterList(){
					List <CenterMaster> clist= centerService.listAll();
					return clist;
				}
				
				@ModelAttribute("getUser")
				public List<Users> getUserList(){
					List <Users> ulist= usservice.listAll();
					return ulist;
				}
				
				@RequestMapping(value = "/QRLogin", method = RequestMethod.POST)
				public  @ResponseBody  String search(@RequestParam ("qrdata") String qrdata , HttpSession session, HttpServletRequest request,Model m) {
					
					
					String username=qrdata.split("-")[0];
					String login=qrdata.split("-")[1];
					
					//System.out.println("username="+username+" password="+password);
					
					String mav = "";

					List<Users> userObj = usservice.findQrUser(username, login);
					// log.info("Is user valid?= " + isValid);

					if (userObj != null && userObj.size() > 0) {
						session = request.getSession();
						session.setAttribute("username", username);
						session.setAttribute("user", userObj.get(0).getuser_ImgView());
						session.setAttribute("userLevel", userObj.get(0).getUlid().getDsc());
						session.setAttribute("userId", userObj.get(0).getUserId());
						session.setAttribute("centerid", userObj.get(0).getCenter_ID().getCenter_ID());
						session.setAttribute("centerName", userObj.get(0).getCenter_ID().getCenter());
						session.setAttribute("noflane", userObj.get(0).getCenter_ID().getLanes());
						session.setAttribute("countryCode", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getCountryCode());
						session.setAttribute("country", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getCountry());
						session.setAttribute("countryimg", userObj.get(0).getCenter_ID().getPartner_ID().getCountry_Code().getFlagImgView());
						
						//if(userObj.get(0).getUlid().getRoleID().getDesc().toString().split("-", 1))
						mav = userObj.get(0).getUlid().getRoleID().getDesc().toString().split("-")[1];			
					//	System.out.println("ddddd");
						
//							mav.addObject("username", Users.getUserName());
//							mav.addObject("userImg", Users.getUser_Img());
						return mav;
					} else {
						System.out.println("incorrect");
						m.addAttribute("msg", "Invalid UserName Or Password");			
						return "redirect:/";
					}
					
					
				}
				
				@RequestMapping("/userLevelEdit")
				public String userLevelEdit(Map<String, Object> model,@RequestParam String ulid) {
					
					//UserLevel ul = new UserLevel();
					UserLevel ul =usservice.getUserLevel(ulid);
					//ul.setUlid(ulid);
				//	ul.
					List<UserLevel> userLevel = usservice.getUserLevel();					
					List<Role> roleList = usservice.getAllNotAssignRole(ulid);
					
					List<Role> assignRoleList = usservice.getAssignRoleByLevel(ulid);
					model.put("userLevel", ul);
					model.put("userlist", userLevel);
					model.put("roleList", roleList);
					model.put("assignRoleList", assignRoleList);
					return "userLevel";
					
					//assignRoleList
				}
				
				@RequestMapping(value="/startDbBackup")
				 public @ResponseBody String getDbBackup( HttpSession session) {	

					String centerid=session.getAttribute("centerid").toString();  
					CenterMaster centerMaster=centerService.getcenterById(centerid);
		        	
					return DBBackup.startDBBackup(centerMaster.getPartner_ID().getDbBackupPath());
				}
				
				 @RequestMapping(value="/userActiveInactive")
					public String userActiveInactive(Map<String, Object> model)
					{
					 Users users = new Users();
					 List<Users> userAll=usservice.listAll( );
					 model.put("newuser" ,users);
					 model.put("alluser" ,userAll);
						return "userActiveInactive";
					}
				 

				 @RequestMapping(value = "/saveuserActive", method = RequestMethod.POST)
					public String saveUser(@RequestParam("userId") String userId, @RequestParam("status") String status,RedirectAttributes redirectAttributes,HttpServletResponse response ) {
							{
 
								Users user = usservice.profileItemByID(userId) ;
								user.setStatus(status);
								usservice.save(user);
								
								
							return "redirect:/userActiveInactive";
							}
					}

				 
				 
}

