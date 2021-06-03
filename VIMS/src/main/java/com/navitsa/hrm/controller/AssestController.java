
package com.navitsa.hrm.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.navitsa.hrm.entity.Assestclass;
import com.navitsa.hrm.entity.Depreciationgroup;
import com.navitsa.hrm.entity.ReligionMaster;
import com.navitsa.hrm.service.AssetclassService;
import com.navitsa.hrm.service.DepreciationgroupService;


@Controller
public class AssestController {

	@Autowired
	private AssetclassService assetclassService;
	@Autowired
	private DepreciationgroupService depreciationgroupService;
	
	@RequestMapping(value = "/Asset_Classes", method = RequestMethod.GET)
	public String loadAsPage(Map<String, Object> map) {
		map.put("Asset", new Assestclass());
		Assestclass asset = new Assestclass();
		//map.put("id", asset);
		return "hrm/Asset_Classes";
	}
	
		@ModelAttribute ("depreciationgroupstable")
		public List<Depreciationgroup>showdeprection()
		{
			return assetclassService.getAlldata();
			
		}
		
	/*public List<Assestclass> getDetailsofDeprection() {
		return (List<Assestclass>) assetclassService.findAll();
	}

	*/
	@RequestMapping(value = "/saveAssetAcount", method = RequestMethod.POST)
	public String savell(@Valid @ModelAttribute("Asset") Assestclass asset ,BindingResult br) {
		
		if (br.hasErrors()) {
			return "hrm/Asset_Classes";
		} else {
			try {
				 assetclassService.savell(asset);
				return "redirect:/hrm/Asset_Classes";
			} catch (Exception e) {
				System.out.println("Details Not Saved");
			}
		}
		return "hrm/Asset_Classes";
		
		/*assetclassService.savell(asset);
				return "redirect:/Asset_Classes";*/
		
	}
	@ModelAttribute("Assestclass")
	public List<Assestclass> getAllRm() {
		return assetclassService.getAllRm();
	}
	@RequestMapping(value="/Updatecode", method= RequestMethod.GET)
	public ModelAndView updatecode(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("hrm/Asset_Classes");
		Assestclass asset = assetclassService.getRm(id);
		mav.addObject("Asset", asset);
		return mav;
	}
}

	

