package com.inw.proy.services.deletes;

import java.sql.SQLException;

public interface BuyCancelService {

	Boolean execute(Integer buyId) throws NullPointerException, SQLException;

}
