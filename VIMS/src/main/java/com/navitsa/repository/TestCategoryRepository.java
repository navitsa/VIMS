
package com.navitsa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.TestCategory;

public interface TestCategoryRepository extends CrudRepository<TestCategory, String> {

	@Query(value = "SELECT (max(t.categoryId)+1) FROM TestCategory t ")
    public String maxCategoryId();
	
	@Query(value="SELECT tc.testProfileId.testProfileID FROM TestCategory tc WHERE tc.categoryId =:cat_id")
	public int getProfileID(@Param("cat_id") String cat_id);
	
	@Query(value="SELECT tc.viProfileId.visualProfileID FROM TestCategory tc WHERE tc.categoryId =:catID")
	public String getVIProfileID(@Param("catID") String catID);
}
