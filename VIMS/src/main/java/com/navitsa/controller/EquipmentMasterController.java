package com.navitsa.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.InventoryLocation;
import com.navitsa.services.CenterService;
import com.navitsa.services.EquipmentService;
import com.navitsa.utils.DateHelperWeb;

@Controller("equipmentMasterController")
public class EquipmentMasterController {

@Autowired
private EquipmentService eqervice;
@Autowired
private CenterService centerService;

			@RequestMapping("/equipmentmaster")
			public String equipmentMaster(Map<String, Object> model) {
				model.put("equipmentMaster", new EquipmentMaster());
				EquipmentMaster eqMaster = new EquipmentMaster();
				eqMaster.setEquipmentID("0000".substring(eqervice.maxEquipmentID().length()) + eqervice.maxEquipmentID());
				model.put("equipmentMaster", eqMaster);
				List<EquipmentMaster> listEquipmentMaster = eqervice.findAllEquipmentMaster();
				model.put("listEquipmentMaster", listEquipmentMaster);
			return "equipmentMaster";
					}

				@RequestMapping(value = "/saveEquipmentMaster", method = RequestMethod.POST)
				public String saveEquipmentMaster(@Valid @ModelAttribute("equipmentMaster") EquipmentMaster equipmentMaster,  BindingResult br,RedirectAttributes redirectAttributes )
				 {
						if(br.hasErrors()) {
							return "equipmentMaster";
						}
						else {
							try {
								redirectAttributes.addFlashAttribute("success", 1);
								eqervice.saveEquipmentMaster(equipmentMaster);
								
							}catch(Exception e) {
								System.out.println(e);
								redirectAttributes.addFlashAttribute("success", 0);
							}
							return "redirect:/equipmentmaster.do";
						}
				}
				
					@RequestMapping(value = "/editEqMaster",method = RequestMethod.GET)
					public ModelAndView editEqMaster(@RequestParam String equipmentID) {
						ModelAndView mav = new ModelAndView("equipmentMaster");
						EquipmentMaster equipmentMaster =null; 
						try {
							equipmentMaster =eqervice.equipmentMasterByID(equipmentID);					
							mav.addObject("equipmentMaster", equipmentMaster);
						}catch(Exception e) {
							System.out.println(e);
						}
						try {		
						//to handle error when editing eqmodel combo no data load
						String emid = equipmentMaster.getEqModelID().getEqMakeID().getEqMakeID();
						List<EquipmentModel> eqlist =eqervice.searcheqmodel(emid);
						mav.addObject("eqlist", eqlist);
						String SctModelname = equipmentMaster.getEqModelID().getEqModel();
						mav.addObject("SctModelname", SctModelname);
						
						}catch(Exception e) {
							System.out.println(e);
						//getEqImg	
						}try {
						String eqLogo = equipmentMaster.getEquipmentImageView();
						mav.addObject("eqLogo", eqLogo);	
						}catch(Exception e) {
							System.out.println(e);
						//getMakeLogo	
						}try {
							String makeLogo = equipmentMaster.getEqModelID().getEqMakeID().getEqMakeLogoView();
							mav.addObject("makeLogo", makeLogo);
						}catch(Exception e) {
							System.out.println(e);
						}
						//getModelLogo
						try {
							String eqmodelLogo = equipmentMaster.getEqModelID().getEqModelLogoView();
							mav.addObject("eqmodelLogo", eqmodelLogo);
						} catch(Exception e) {
							System.out.println(e);
						}
						//getLastCerImg
						try {
							String lastCer = equipmentMaster.getLastCalibrationCerView();
							mav.addObject("lastCer", lastCer);
						}catch(Exception e) {
							System.out.println(e);
						//getLastSerImg	
						}try {
							String lastSerCer = equipmentMaster.getLastServieCerView();
							mav.addObject("lastSerCer", lastSerCer);
						}catch(Exception e) {
							System.out.println(e);
						}
						return mav;
					}
					
					@ModelAttribute("eqTypeDetailsCmb")
						public List<EquipmentType> getAllTypeDetails() {
						List<EquipmentType> typedrop = eqervice.findAllEquipmentType();
						return typedrop;
					}
					@ModelAttribute("eqModleDetailsCmb")
						public List<EquipmentModel> getAllModelDetails() {
						List<EquipmentModel> modeldrop = eqervice.findAllEquipmentModel();
						return modeldrop;
					}
					//get data for combo in model interface
					@RequestMapping(value="/getImageModelcombo", method=RequestMethod.GET)
						public   @ResponseBody String search(@RequestParam String eqModleid) {
						EquipmentModel listlogs = eqervice.equipmentModelByID(eqModleid);
						return listlogs.getEqModelLogoView();
					}
					//combo box for eq.make selection
						@ModelAttribute("eqMakeDetailsCmb")
						public List<EquipmentMake> getAllMakeDetails() {
							List<EquipmentMake> makedrop = eqervice.findAllEquipmentMake();
							return makedrop;
						}
						//get eqmodel data according to eqmake in combo
						 @RequestMapping(value="/getModelcombo", method=RequestMethod.GET)
							public   @ResponseBody List<EquipmentModel> searcheqmodelcombo(@RequestParam String eqMakeid, @RequestParam String eqTypeID) {
								List<EquipmentModel> listeq= eqervice.searchModel(eqMakeid,eqTypeID);
								return listeq;
							}
						 //getMakeImg
						 @RequestMapping(value="/getMakeLogo", method=RequestMethod.GET)
						 public @ResponseBody String searcheLogo(@RequestParam String eqMakeID) {
							 EquipmentMake listeq= eqervice.searchLogo(eqMakeID);
							 return listeq.getEqMakeLogoView();
						}
						 
						 //get Model Details
						 @ModelAttribute("eqModelDetailsCmb")
						 public List<EquipmentModel> getAllModel1Details() {
								List<EquipmentModel> makedrop1 = eqervice.findAllEquipmentModel();
								return makedrop1;
							}

						 @ModelAttribute("listEquipmentMaster")
						 public List<EquipmentMaster> getAllDetails() {
							 List<EquipmentMaster> details = eqervice.findAllEquipmentMaster();
							 return details;
						 }
						 
						 @RequestMapping(value="/setCalDate", method=RequestMethod.GET)
						 public @ResponseBody String setDate(@RequestParam String id,@RequestParam String date,@RequestParam String typ) {
							int cint=0;
							EquipmentModel dt = eqervice.equipmentModelByID(id);
							System.out.println("dfdfdf  ="+typ);
							if(typ.equals("cal")) {
								cint=Integer.parseInt(dt.getCalibrationInt());
							}else {
								cint=Integer.parseInt(dt.getServiceInt());									
							}
							return DateHelperWeb.getFormatStringDate3(DateHelperWeb.addMonths(DateHelperWeb.getDate(date), cint));
 	 
						 }				 
						 //preview eqCal report
						 @RequestMapping(value="/eqCReport", method = RequestMethod.GET)
						 public ModelAndView getCalbratioView(@RequestParam String equipmentID) {
							 ModelAndView mav = new ModelAndView("comPdfReportView");
							 EquipmentMaster equipmentMaster =null; 
							 try {
									equipmentMaster =eqervice.equipmentMasterByID(equipmentID);					
									mav.addObject("pdfViewEq", equipmentMaster.getLastCalibrationReportView());
								}catch(Exception e) {
									System.out.println(e);
								}
							 return mav;
						 }
						 
						 //preview eqService Report
						 @RequestMapping(value="/eqSReport", method = RequestMethod.GET)
						 public ModelAndView getServiceView(@RequestParam String equipmentID) {
							 ModelAndView mav = new ModelAndView("comPdfReportView");
							 EquipmentMaster equipmentMaster =null; 
							 try {
									equipmentMaster =eqervice.equipmentMasterByID(equipmentID);					
									mav.addObject("pdfViewEq", equipmentMaster.getLastServieReportView());
								}catch(Exception e) {
									System.out.println(e);
								}
							 return mav;
						 }						 
						 //preview eqCal report
						 @RequestMapping(value="/eqCalibrationCertificateView", method = RequestMethod.GET)
						 public ModelAndView getCalibrationCertificate(@RequestParam String equipmentID) {
							 ModelAndView mav = new ModelAndView("comPdfReportView");
							 EquipmentMaster equipmentMaster =null; 
							 try {
									equipmentMaster =eqervice.equipmentMasterByID(equipmentID);					
									mav.addObject("pdfViewEq", equipmentMaster.getLastCalibrationCerView());
								}catch(Exception e) {
									System.out.println(e);
								}
							 return mav;
						 }	
						 //preview eqCal report
						 @RequestMapping(value="/eqServiceCertificateView", method = RequestMethod.GET)
						 public ModelAndView getServiceCertificateView(@RequestParam String equipmentID) {
							 ModelAndView mav = new ModelAndView("comPdfReportView");
							 EquipmentMaster equipmentMaster =null; 
							 try {
									equipmentMaster =eqervice.equipmentMasterByID(equipmentID);					
									mav.addObject("pdfViewEq", equipmentMaster.getLastServieCerView());
								}catch(Exception e) {
									System.out.println(e);
								}
							 return mav;
						 }					 
						 
						@ModelAttribute("allInventoryLocation")
						public List<InventoryLocation> allInventoryLocation() {
							List<InventoryLocation> allinvLoca =  centerService.getAllInventoryLocation();
						return allinvLoca;
						}	
}