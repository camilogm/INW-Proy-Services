package com.inw.proy.services.updates;

import java.sql.SQLException;

public interface PromotionUpdateService {

	Boolean auditoPromotionStatus(Integer detailMenuId, Integer menuId) throws NullPointerException, SQLException;

}
