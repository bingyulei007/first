package com.bing.dao;



import com.bing.model.PeopleModel;
public interface PeopleModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table people
	 * @mbggenerated  Mon Apr 25 19:17:18 CST 2016
	 */
	
	int insert(PeopleModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table people
	 * @mbggenerated  Mon Apr 25 19:17:18 CST 2016
	 */
	int insertSelective(PeopleModel record);
	PeopleModel getById(String id);
}