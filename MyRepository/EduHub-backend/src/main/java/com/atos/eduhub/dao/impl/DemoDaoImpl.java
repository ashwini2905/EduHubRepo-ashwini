package com.atos.eduhub.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atos.eduhub.dao.DemoDao;
import com.atos.eduhub.model.User;


@Repository
public class DemoDaoImpl implements DemoDao {
	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;

	@Value("${userprofile_fetchAll}")
	private String fetchAll;
	@Value("${userprofile_fetchById}")
	private String userprofile_fetchById;
	@Value("${userprofile_deleteById}")
	private String userprofile_deleteById;
	@Value("${userprofile_updateById}")
	private String userprofile_updateById;
	@Value("${userprofile_save}")
	private String userprofile_save;

	@Override
	public List<Map<String, Object>> findAll() {
		return jdbcTemplate.queryForList(fetchAll);
	}

	/*
	 * @Override public List<UserModel> findAllWithRowMapper() { return
	 * jdbcTemplate.query(fetchAll, new UserRowMapper()); }
	 *
	 * @Override public UserModel findById(String userId) { return
	 * jdbcTemplate.queryForObject(userprofile_fetchById, new UserRowMapper(), new
	 * Object[] { userId }); }
	 */
	@Override
	public int saveUserProfile(User user) {
//		return jdbcTemplate.update(userprofile_save, usermodel.getUserId(), usermodel.getFirstName(),
//				usermodel.getLastName(), usermodel.getPassword(), usermodel.getDesignation(),
//				usermodel.getExperience());
		return 1;
	}
}