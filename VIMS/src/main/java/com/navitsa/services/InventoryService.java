package com.navitsa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.repository.SupplierMasterRepository;
import com.navitsa.entity.Gate;
import com.navitsa.entity.ItemMaster;
import com.navitsa.entity.SupplierMaster;
import com.navitsa.repository.ItemMasterRepository;

@Service
public class InventoryService {

	@Autowired
	SupplierMasterRepository supplierMasterRepository;

	@Autowired
	ItemMasterRepository itemMasterRepository;

	// Supplier related codes

	public String maxSupplierId() {
		if (supplierMasterRepository.maxSupplierId() == null) {
			return "1";
		} else {
			return supplierMasterRepository.maxSupplierId();

		}
	}

	public void saveSupplierMaster(@Valid SupplierMaster supplierMaster) {
		supplierMasterRepository.save(supplierMaster);
	}

	public List<SupplierMaster> getSupplierList() {
		return (List<SupplierMaster>) supplierMasterRepository.findAll();
	}

	public SupplierMaster getSupplierMasterById(String id) {
		return supplierMasterRepository.findById(id).get();
	}

	// Item related codes

	public String maxItemCode() {
		if (itemMasterRepository.maxItemCode() == null) {
			return "1";
		} else {
			return itemMasterRepository.maxItemCode();

		}
	}

	public void saveItemMaster(@Valid ItemMaster itemMaster) {
		itemMasterRepository.save(itemMaster);
	}

	public List<ItemMaster> getItemList() {
		return (List<ItemMaster>) itemMasterRepository.findAll();
	}

	public ItemMaster getItemMasterById(String id) {
		return itemMasterRepository.findById(id).get();
	}
}
