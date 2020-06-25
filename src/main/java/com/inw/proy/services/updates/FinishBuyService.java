package com.inw.proy.services.updates;

import java.sql.SQLException;

public interface FinishBuyService {

	Object execute(Integer buyId, Object productsDetails, Object promotionsDetails) throws NullPointerException, SQLException;

}
