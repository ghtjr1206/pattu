package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int insertUser(UserVO vo) {
		return mybatis.insert("UserDAO.insertUser",vo);
	}
	
	public void updateUser(UserVO vo) {
		mybatis.update("UserDAO.updateUser",vo);
	}
	
	public void deleteUser(UserVO vo) {
		mybatis.delete("UserDAO.deleteUser",vo);
	}
	
	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser",vo);
	}
	
	public UserVO selectOne(String selId) {
		return mybatis.selectOne("UserDAO.selectOne",selId);
	}
	
	public List<UserVO> selectList(String keyword) {
		return mybatis.selectList("UserDAO.selectList",keyword);
	}
	
}
