package com.navitsa.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.navitsa.entity.ItemMaster;
import com.navitsa.entity.SupplierMaster;
import com.navitsa.services.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/SupplierMaster", method = RequestMethod.GET)
	public String supplierMasterPage(Map<String, Object> map) {
		SupplierMaster supplierMaster = new SupplierMaster();
		supplierMaster.setSupplierId(
				"00000".substring(inventoryService.maxSupplierId().length()) + inventoryService.maxSupplierId());
		map.put("supplierMasterForm", supplierMaster);
		return "SupplierMaster";
	}

	@ModelAttribute("supplierList")
	public List<SupplierMaster> getSupplierList() {
		List<SupplierMaster> list = inventoryService.getSupplierList();
		return list;
	}

	@RequestMapping("/UpdateSupplierMaster")
	public ModelAndView updateSupplierMaster(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("SupplierMaster");
		SupplierMaster supplierMaster = inventoryService.getSupplierMasterById(id);
		mav.addObject("supplierMasterForm", supplierMaster);
		return mav;
	}

	@RequestMapping(value = "/saveSupplierMaster", method = RequestMethod.POST)
	public String saveSupplierMaster(@Valid @ModelAttribute("supplierMasterForm") SupplierMaster supplierMaster,
			BindingResult br, RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "SupplierMaster";
		} else {

			try {
				inventoryService.saveSupplierMaster(supplierMaster);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/SupplierMaster";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}
		return "SupplierMaster";
	}

	@RequestMapping(value = "/ItemMaster", method = RequestMethod.GET)
	public String itemMasterPage(Map<String, Object> map) {
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItemCode(
				"00000".substring(inventoryService.maxItemCode().length()) + inventoryService.maxItemCode());
		map.put("itemMasterForm", itemMaster);
		return "ItemMaster";
	}

	@ModelAttribute("itemList")
	public List<ItemMaster> getItemList() {
		List<ItemMaster> list = inventoryService.getItemList();
		return list;
	}

	@RequestMapping("/UpdateItemMaster")
	public ModelAndView updateItemMaster(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("ItemMaster");
		ItemMaster itemMaster = inventoryService.getItemMasterById(id);
		mav.addObject("itemMasterForm", itemMaster);
		return mav;
	}

	@RequestMapping(value = "/saveItemMaster", method = RequestMethod.POST)
	public String saveItemMaster(@Valid @ModelAttribute("itemMasterForm") ItemMaster itemMaster, BindingResult br,
			RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "ItemMaster";
		} else {

			try {
				inventoryService.saveItemMaster(itemMaster);
				redirectAttributes.addFlashAttribute("success", 1);
				return "redirect:/ItemMaster";
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("success", 0);
			}
		}
		return "ItemMaster";
	}
}
