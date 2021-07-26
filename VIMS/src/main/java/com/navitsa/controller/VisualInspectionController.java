package com.navitsa.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.Reports.ChecklistSummaryBean;
import com.navitsa.entity.ItemRemarks;
import com.navitsa.entity.ProfileItemsStatus;
import com.navitsa.entity.ProfileStages;
import com.navitsa.entity.TestCategory;
import com.navitsa.entity.VehicleOwner;
import com.navitsa.entity.VehicleRegistration;
import com.navitsa.entity.VisualChecklistDetail;
import com.navitsa.entity.VisualChecklistDetailForm;
import com.navitsa.entity.VisualChecklistMaster;
import com.navitsa.entity.VisualProfile;
import com.navitsa.entity.VisualProfileItems;
import com.navitsa.services.VehicleService;
import com.navitsa.services.VisualInspectionServices;
import com.navitsa.utils.DateHelperWeb;
import com.navitsa.utils.ReportViewe;

import org.springframework.ui.Model;

@Controller
public class VisualInspectionController {

	@Autowired
	private VisualInspectionServices inspectionServices;
	
	@Autowired
	private VehicleService vehicleServices;
	
	/*Requesting view of profile master jsp*/
	@RequestMapping("/profileMaster")
	public String loadVisualProfileMaster(Model m) {
		try {
			VisualProfile profile = new VisualProfile();
			String pid = inspectionServices.maxProfileID();
			profile.setVisualProfileID("0000".substring(pid.length())+pid);
			m.addAttribute("visualProfile",profile);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return "visualProfileMaster";	
	}

	
	/*Requesting view of profile stages jsp*/
	@RequestMapping("/ProfileStages")
	public  String loadStageView(Model m) {
		
		ProfileStages stage = new ProfileStages();
		try {
			
		String sid = inspectionServices.maxStageID();
		stage.setStageID("0000".substring(sid.length())+sid);
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		m.addAttribute("visualStage", stage);
		
		return "visualProfileStages";
		
	}

	//Return all stages
	 @ModelAttribute("listStages")
	 	public List<ProfileStages> getStages(){
		 List<ProfileStages> a = inspectionServices.listStages();
		 return a;
	 }
	 
	 /*@ModelAttribute("listStagesByProID")
	 	public List<ProfileStages> getStagesByProID(){
		 List<ProfileStages> a = inspectionServices.getStagesByProID("0002");
		 return a;
	 }*/
	 
	
	//	Saving visual Profile
	 @RequestMapping(value="/visualProfile_act" ,method=RequestMethod.POST)
	 public String saveProfile(@Valid @ModelAttribute("visualProfile") VisualProfile profile,  BindingResult br,Model m) {
		 
			 if(br.hasErrors())  
		        {  
				 return "visualProfileMaster";  
		        }  
		        else  
		        { 
		        	try {
		        		
			        	inspectionServices.saveProfile(profile);
			        	return "redirect:/profile_Master";
						
					} catch (Exception e) {
						// TODO: handle exception
						m.addAttribute("success",0);
					}

		        }
			 
			 return "visualProfileMaster";  
	
	 }

	 // Saving profile stages
	 @RequestMapping(value="/profileStage_act",method=RequestMethod.POST)
	 public String saveStage(@Valid @ModelAttribute("visualStage") ProfileStages stage,  BindingResult br,Model m) {
		 
		 if(br.hasErrors())  
	        {  
			 return "visualProfileStages";
	        }  
	        else  
	        {  
	        	try {
	        		inspectionServices.saveStage(stage);
	        		return "redirect:/profile_stages";
	        	}catch (Exception e) {
					// TODO: handle exception
	        		m.addAttribute("success",0);
				}
	        }
		return "visualProfileStages"; 
	 }
	 
	 // Edit profile stage
	 @RequestMapping("/editStage")
	 public ModelAndView getStage(@RequestParam String id) {
		 
		 ModelAndView mav = new ModelAndView("visualProfileStages");
		 try {
			 
		     ProfileStages ps = inspectionServices.getStage(id);
		     mav.addObject("visualStage", ps);
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
	  
	     return mav;
	 }
	 
	 // Edit Profile Details
	 @RequestMapping("/getProfileInfo")
	 public ModelAndView getProfile(@RequestParam String id) {
	     ModelAndView mav = new ModelAndView("visualProfileMaster");
	     try {
		     VisualProfile vp = inspectionServices.getProfile(id);
		     mav.addObject("visualProfile",vp);
	     }catch (Exception e) {
			System.out.println(e);
		}
	  
	     return mav;
	 }

// following has Item Status Operations
	 
	 @ModelAttribute("listItemsStatus")
	 	public List<ProfileItemsStatus> getAllStatus(){
		 List<ProfileItemsStatus> is = inspectionServices.listStatus();
		 return is;
	 }
	 
	 @RequestMapping("/ProfileItemsStatus" )
	 public String loadItemStatusPage(Model m)
	 {
		 try {
			 
			 ProfileItemsStatus st = new ProfileItemsStatus();
			 String stid = inspectionServices.maxStatusID();
			 st.setProfileItemStatusID("0000".substring(stid.length())+stid);
			 m.addAttribute("saveStatus", st);
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "visualProfileItemStatus";
		 
	 }

	 //Saving item status
	 @RequestMapping(value="/saveStatus_act",method=RequestMethod.POST)
	 public String saveStatus(@Valid @ModelAttribute("saveStatus") ProfileItemsStatus status,BindingResult br,Model m) {		
		 
		 if(br.hasErrors()) 
		 {
			 return "visualProfileItemStatus";
		 }
		 else
		 {
			/*
			 * if(updateAll.equals("true")) { String pro_id = status.getVisualprofileID();
			 * String stage_id = status.getVisualProfileStageID();
			 * 
			 * List<VisualProfileItems> itemlist = inspectionServices.searchItems(pro_id,
			 * stage_id); System.out.println("List size is"+itemlist.size());
			 * 
			 * for (int i = 0; i < itemlist.size(); i++) {
			 * 
			 * String stid = inspectionServices.maxStatusID();
			 * status.setProfileItemStatusID("0000".substring(stid.length())+stid);
			 * status.setItem(itemlist.get(i)); inspectionServices.saveStatus(status); }
			 * }else { inspectionServices.saveStatus(status); }
			 */
			 try {
				 
				 inspectionServices.saveStatus(status);
				 return "redirect:/Profile_item_status";
				 
			} catch (Exception e) {
				// TODO: handle exception
				 m.addAttribute("success",0);
			}
			 

		 }
		 
		 return "visualProfileItemStatus";
	 }
	 
	 //Edit item status
	 @RequestMapping("/editStatus")
	 public ModelAndView editStatus(@RequestParam String id) {
	     ModelAndView mav = new ModelAndView("visualProfileItemStatus");
	     ProfileItemsStatus is = inspectionServices.getStatus(id);
	     mav.addObject("saveStatus",is);
	  
	     return mav;
	 }
	 
	 
/*Loading combo box in item status UI*/
	 
	 @RequestMapping(value="/getStagesForCombo", method=RequestMethod.GET)
		public   @ResponseBody List<ProfileStages> search(@RequestParam String profileID) {
			List<ProfileStages> listStages = inspectionServices.searchStages(profileID);
			return listStages;
		}
	 
	 @RequestMapping(value="/getItemsForCombo", method=RequestMethod.GET)
		public   @ResponseBody List<VisualProfileItems> searchItems(@RequestParam String profileID, String stageID) {
			List<VisualProfileItems> listItems = inspectionServices.searchItems(profileID,stageID);
			return listItems;
		}
	 
	 @RequestMapping(value="/getStatusForTable", method=RequestMethod.GET)
		public  @ResponseBody List<ProfileItemsStatus> searchStatus(@RequestParam String profileID,String stageID,String itemID) {
			List<ProfileItemsStatus> listStatus = inspectionServices.searchStatus(profileID,stageID,itemID);
			return listStatus;
		}
	 /*End*/
	 
	 // End of Item status operations
	 
	 
		/*Following has checklist operations*/
	 
	 @ModelAttribute("remark")
	 	public List<ItemRemarks> getRemarks(){
		 
		 List<ItemRemarks> remark = inspectionServices.listRemarks();
		 return remark;
	 }
	 
	 //@ModelAttribute("pendingViVehicles")
	 	public List<VehicleRegistration> getPendingVehiclesForInspection(){
		 
		 List<VehicleRegistration> pendingVi = null;
		 
		 try {
			 pendingVi= inspectionServices.getPendingVehiclesForInspection();
			 
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}finally {
			System.out.println("finished.");
		}
		 
		 if(pendingVi.isEmpty())
		 {
			 return null;
		 }
		 else {
			 List<VehicleRegistration> list = new ArrayList<VehicleRegistration>();

			 for (VehicleRegistration vr : pendingVi) {
				if(vr.getOcrid().getVrStatus().equalsIgnoreCase("completed")) {
					list.add(vr);
				}
			}
			 
			 return list;
		 }
		 
		 
	 }
	 
	 
		@RequestMapping("/visualChecklist")
		public String checklist(Model m)
		{
			VisualChecklistMaster vcm = new VisualChecklistMaster();
			String chID = inspectionServices.maxCheckListMasterID();
			vcm.setCheklistID("0000".substring(chID.length())+chID);
			m.addAttribute("checklistMaster", vcm);
			m.addAttribute("pendingViVehicles", getPendingVehiclesForInspection());
			return "visualInspectionChecklist";
		}
		
		/*@RequestMapping("/getPrint")
		public ModelAndView getPrint(String ch_ID)
		{
			ModelAndView mav = new ModelAndView("visualInspectionChecklist");
			
			VisualChecklistMaster vcm = new VisualChecklistMaster();
			
			String chID = inspectionServices.maxCheckListMasterID();
			vcm.setCheklistID("0000".substring(chID.length())+chID);
			
			mav.addObject("checklistMaster", vcm);
			mav.addObject("requestPrint",ch_ID);
			System.out.println(ch_ID);
			return mav;
		}*/
		
		@RequestMapping(value="/getRemaksforCombo", method=RequestMethod.GET)
			public   @ResponseBody List<ItemRemarks> searchRemarks(@RequestParam String statusID) {
				List<ItemRemarks> listRemaks = inspectionServices.searchRemarks(statusID);
				return listRemaks;
			} 
		 
		@RequestMapping(value="/checktPendingVehiclesAreAvailable", method=RequestMethod.GET)
			public @ResponseBody VehicleRegistration checktPendingVehiclesAreAvailable(@RequestParam String vehicle_no){
			 
		     VehicleRegistration vr = null;
		     String status = null;
		     
			 try {
				 vr = inspectionServices.getPendingVehicleForInspection(vehicle_no);
			     status = vr.getViTestStatus();
			} catch (Exception e) {
				// TODO: handle exception
			}

			     if("pending".equalsIgnoreCase(status)) 
			    	 return vr;
			     else
			    	 return null;

			}
		 
		// load visual inspection form
		 @RequestMapping(value="/gettingDataForVI",method = RequestMethod.GET)
			public ModelAndView gettingDataForVI(@RequestParam String vReg_Id) {
				
				ModelAndView mav = new ModelAndView("visualInspectionChecklist");
				
			     VehicleRegistration vr = null;
			     VisualChecklistMaster vm = new VisualChecklistMaster();
			     //String status = null;
			     String catID = null;
			     VisualProfile vp = null;
			     String viProfileID = null;
			     
			     try {
					 vr = inspectionServices.getPendingVehicleForInspection(vReg_Id);
				     //status = vr.getViTestStatus();
				     catID = vr.getTestCategory().getCategoryId();
				     viProfileID = inspectionServices.getProfileByCatID(catID);
				     mav.addObject("vProId", viProfileID);
				     
				     vm.setVr(vr);;
					 String chID = inspectionServices.maxCheckListMasterID();
					 vm.setCheklistID("0000".substring(chID.length())+chID);
					 
				} catch (Exception e) {
					System.out.println(e);
					mav.addObject("msg", "Please create a visual profile with matching this vehicle category !");
				}finally {
					
				}
			     
			     mav.addObject("checklistMaster", vm);
				 mav.addObject("regVehicleInfo", vr);
				 mav.addObject("pendingViVehicles", getPendingVehiclesForInspection());
				 
				 
				 return mav;
				
			}
		 
		 //Checklist Saving
		 
		 @RequestMapping(value="/saveCheckListData",method=RequestMethod.POST)
		 public String saveChecklist(@Valid @ModelAttribute("checklistMaster") VisualChecklistMaster vcm,BindingResult br,
				 @ModelAttribute("visualChecklistDetailForm") VisualChecklistDetailForm chDetailForm,Model m,RedirectAttributes redirectAttributes) {
			 
			 if(br.hasErrors())
			 {
				 return "visualInspectionChecklist";
			 }
			 else {
				 try {
					 
					 List<VisualChecklistDetail> detail = chDetailForm.getChecklistDetail();
					 
					 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					 Date endTime = df.parse(df.format(new Date()));
					 vcm.setEndtime(endTime);
					 inspectionServices.saveChMasterData(vcm);
						
						if(null != detail && detail.size() > 0) {
							
							for (VisualChecklistDetail detail1 : detail) {
								
								//System.out.println("Partner ID"+detail1.getPartnerID());
								//System.out.printf("%s \t %s \t %s \t %s \t %s \t %s \n",detail1.getVcm().getCheklistID(),detail1.getPartnerID(),detail1.getStage().getStageID(),detail1.getItem().getItemId());
								if(detail1.getPartnerID() != null)
									inspectionServices.saveChDetailData(detail1);
							}
						}
						
						String vRegID = vcm.getVr().getVregID();
						inspectionServices.update_Vi_test_status(vRegID);
						//return "redirect:/getPrint?ch_ID="+ch_ID;
						redirectAttributes.addFlashAttribute("success", 1);
						return "redirect:/visualChecklist";
					
				} catch (Exception e) {
					// TODO: handle exception
					redirectAttributes.addFlashAttribute("success", 0);
				}
				 
			 }

			 
			 return "visualInspectionChecklist";

		 }

		 @RequestMapping("/visualInspectReport")
		 public ModelAndView print(@RequestParam String id,String status,HttpServletResponse response,HttpSession session)
		 {
			 //List<Object> ls = new ArrayList<Object>();

			 ModelAndView mav = new ModelAndView("comPdfReportView");
			 VisualChecklistMaster a = inspectionServices.getLastRecord(id);
			 List<VisualChecklistDetail> b = null;
			 
			 if(status.equals("true")) {
				  b = inspectionServices.getCheckedData(a.getCheklistID());
			 }else {
				  b = inspectionServices.getAllData(a.getCheklistID());
			 }
			 	 
			 	
			 Map<String,Object> params = new HashMap<>();
			 String name,address,mobileNo;
			 
			 if(!a.getVr().getCusid().getId().equals("0000"))
			 {
				 //System.out.println("This is a customer");
				 name		= a.getVr().getCusid().getName();
				 address	= a.getVr().getCusid().getAddress();
				 mobileNo	= a.getVr().getCusid().getTpno(); 
			 }
			 else
			 {
				 //System.out.println("this is a owner");			 
				 VehicleOwner vo =  vehicleServices.getVehicleOwnerIDByVehicleID(a.getVehicleID());
				 name 		= vo.getOwnerName();
				 address	= vo.getPostalBox()+ " "+vo.getStateid().getState()+" "+vo.getCity();
				 mobileNo	= vo.getContactNo();
				 
			 }
			 
			 params.put("bpartnerLogo",a.getVr().getCentermaster().getPartner_ID().getPartner_Logo());
			 params.put("name",name);
			 params.put("address",address);
			 params.put("mobileNo",mobileNo);
			 
			 SimpleDateFormat sdf = new SimpleDateFormat(session.getAttribute("dateFormat")+"");
			 params.put("testDate",sdf.format(a.getDate()) );
			 
			 ReportViewe view =new ReportViewe();
			 String pdf_result = null;
			 
			try {
				pdf_result = view.pdfReportViewInlineSystemOpen("checklistReport.jasper","checklistReport",b,params,response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 mav.addObject("pdfViewEq", pdf_result); 
			 return mav;

			 //m.addAttribute("audit", b);
			 //m.addAttribute("genaral", a);
			 //return "xyz";
		 }
		 
		 // Request visual inspection report page
			@RequestMapping("/visualInspectReports")
			public ModelAndView viewReportPage()
			{
				ModelAndView mav=new ModelAndView("visualChecklistReport");
				List<VisualChecklistMaster> a = inspectionServices.getAll();
				mav.addObject("checklistMaster", a);
				return mav;
			}
	 
	 
	//L.A.N.S Begin
		 
		 //used
		@RequestMapping("/stageitems")
			public String loadVisualProfileItemPage(Model m) {
				
				VisualProfileItems vi = new VisualProfileItems();
				String vid = inspectionServices.maxItemID();
				vi.setItemId("0000".substring(vid.length())+vid);
				m.addAttribute("profileItem", vi);
				
				return "visualProfileItem";	
			}
			
		//used
			@RequestMapping("/itemremarks")
			public String loadItemStatusRemarksPage(Model m) {
				
				ItemRemarks isr = new ItemRemarks();
				String isrID  = inspectionServices.maxRemarkID();
				isr.setRemarksID("0000".substring(isrID.length())+isrID);
				
				m.addAttribute("itemRemarks", isr);
				
				return "visualProfileItemStatusRemark";
				
			}
			
			
			@RequestMapping("/vehiclemaster")
			public String regVehicleMaster() {
				
				return "vehicleMasterForm";
				
			}
			
			
			//used
			@RequestMapping(value = "/addStageItem", method = RequestMethod.POST)
			public String saveItem(@Valid @ModelAttribute("profileItem") VisualProfileItems item,BindingResult br,Model m) {
				
				 if(br.hasErrors())
				 {
					 return "visualProfileItem";
				 }
				 else {
					 
					 try {
						 inspectionServices.save(item);
						 return "redirect:/stage_items";
						
					} catch (Exception e) {
						// TODO: handle exception
						m.addAttribute("success", 0);
					}
					 
			    }
				 
				 return "visualProfileItem";
			}
			
			//used
			@RequestMapping(value = "/addStatusRemarks", method = RequestMethod.POST)
			public String saveItem(@Valid @ModelAttribute("itemRemarks") ItemRemarks remarks,BindingResult br,Model m ) {	
				
				 if(br.hasErrors())
				 {
					 return "visualProfileItemStatusRemark";
				 }
				 else
				 {
					 try {
							inspectionServices.save(remarks);
							return "redirect:/item_remarks";
						
					} catch (Exception e) {
						// TODO: handle exception
						m.addAttribute("success",0);
					}

				 }
				 
				 return "visualProfileItemStatusRemark";
			}
			
	       //used
			@RequestMapping("/editRemark")
	        public ModelAndView editRemark(@RequestParam String id) {
				
				ModelAndView mav=new ModelAndView("visualProfileItemStatusRemark");
				ItemRemarks itr=inspectionServices.itemRemarkByID(id);
	            mav.addObject("itemRemarks",itr);
	            
	            return mav;
	        }
			
			//used
			@RequestMapping("/editProfileItem")
	        public ModelAndView editProItem(@RequestParam String id) {
	                    
				ModelAndView mav=new ModelAndView("visualProfileItem");
	            VisualProfileItems it=inspectionServices.profileItemByID(id);
	            mav.addObject("profileItem",it);
	           
	            return mav;
	        }
			//L.A.N.S END
			
			//Return all items
			 @ModelAttribute("listItems")
			 	public List<VisualProfileItems> getItems(){
				 List<VisualProfileItems> a = inspectionServices.listAll1();
				 return a;
			 }
			 
			 //Return all profiles
			 @ModelAttribute("profileNames")
			 	public List<VisualProfile> getProfiles(){
				 
				 List<VisualProfile> pro = inspectionServices.listProfiles();
				 return pro;
			 }

// following are used to preview success messages
			 
			 @RequestMapping("/Profile_item_status" )
			 public String load_item_status_page(Model m)
			 {
				 try {
					 
					 ProfileItemsStatus st = new ProfileItemsStatus();
					 String stid = inspectionServices.maxStatusID();
					 st.setProfileItemStatusID("0000".substring(stid.length())+stid);
					 m.addAttribute("saveStatus", st);
					 m.addAttribute("success",1);
					 
				} catch (Exception e) {
					// TODO: handle exception
				}
				return "visualProfileItemStatus";
				 
			 }
			 
				@RequestMapping("/item_remarks")
				public String load_item_remark_page(Model m) {
					
					ItemRemarks isr = new ItemRemarks();
					String isrID  = inspectionServices.maxRemarkID();
					isr.setRemarksID("0000".substring(isrID.length())+isrID);
					
					m.addAttribute("itemRemarks", isr);
					m.addAttribute("success", 1);
					
					return "visualProfileItemStatusRemark";
					
				}
				
				
				// print visual inspection summary report
				 @GetMapping("/getTemplate")
				 public ModelAndView print1(@RequestParam String proId,HttpServletResponse response)
				 {
					 ModelAndView mav = new ModelAndView("comPdfReportView");
					 
					 String[][] result = inspectionServices.getSummary(proId);
					 
					 List<ChecklistSummaryBean> list = new ArrayList<>();
					 
					 for(int i=0; i<result.length;i++ )
					 {
						 ChecklistSummaryBean obj = new ChecklistSummaryBean();
						 
						 obj.setStage(result[i][0]);
						 obj.setItem(result[i][1]);
						 obj.setStatus(result[i][2]);
						 obj.setRemark(result[i][3]);
						 list.add(obj);
					 }
					 
					 ReportViewe view =new ReportViewe();
					 String pdf_result = null;
					 
					 try {
						 pdf_result = view.pdfReportViewInlineSystemOpen("checklistTempReport.jasper","checklistTempReport",list,null,response);
					} catch (Exception e) {
						// TODO: handle exception
					}
					 
					 mav.addObject("pdfViewEq", pdf_result);
					 return mav;
					 //m.addAttribute("cheklistSummary", list);
					//return "abc";
				 }
				 
				 @RequestMapping("/profile_stages")
					public  String load_stage_view(Model m) {
						
						ProfileStages stage = new ProfileStages();
						try {
							
						String sid = inspectionServices.maxStageID();
						stage.setStageID("0000".substring(sid.length())+sid);
						
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						m.addAttribute("visualStage", stage);
						m.addAttribute("success",1);
						
						return "visualProfileStages";
						
					}
				 
					@RequestMapping("/stage_items")
					public String load_item_page(Model m) {
						
						VisualProfileItems vi = new VisualProfileItems();
						String vid = inspectionServices.maxItemID();
						vi.setItemId("0000".substring(vid.length())+vid);
						m.addAttribute("profileItem", vi);
						m.addAttribute("success",1);
						
						return "visualProfileItem";	
					}
			 
					@RequestMapping("/profile_Master")
					public String load_Visual_ProfileMaster(Model m) {
						try {
							VisualProfile profile = new VisualProfile();
							String pid = inspectionServices.maxProfileID();
							profile.setVisualProfileID("0000".substring(pid.length())+pid);
							m.addAttribute("visualProfile",profile);
							m.addAttribute("success",1);
						}
						catch (Exception e) {
							System.out.println(e);
						}
						
						return "visualProfileMaster";	
					}
					
					//load Test category to Visual profile master jsp
					@ModelAttribute("testCategory")
					public List <TestCategory> getTestCategory(){
						List <TestCategory> listTestCategory = inspectionServices.getTestCat();
						return listTestCategory;
					}
					
			 @RequestMapping(value="/getRemarks", method=RequestMethod.GET)
				public   @ResponseBody List<ItemRemarks> getRemarks(@RequestParam String statusID) {
					List<ItemRemarks> listRemarks = inspectionServices.getRemarks(statusID);
					return listRemarks;
				}
			 
}
