package com.fouter.dao;

import com.fouter.domain.User;

public interface UserDao {

	User getByUserCode(String user_code);

}
