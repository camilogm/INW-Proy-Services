package com.inw.proy.services.deletes;

import java.sql.SQLException;

import com.inw.proy.DTO.menu.DeleteMenuDetailDTO;

public interface DeleteMenuDetailService {

	Object deleteMany(DeleteMenuDetailDTO[] details) throws NullPointerException, SQLException;

	Object delete(DeleteMenuDetailDTO detail) throws NullPointerException, SQLException;

}
