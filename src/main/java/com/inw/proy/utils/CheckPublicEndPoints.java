package com.inw.proy.utils;

import org.springframework.stereotype.Component;


@Component
public class CheckPublicEndPoints {

	private static final String[] publicPaths = {
			"/shop/findmany",
			"/user/find"
	};
	
	
	
	public Boolean execute(String path) {	
	
		for ( String pathPublic : publicPaths ) {
			
			if (path.contains(pathPublic))
				return true;
			
		}
		return false;
	}
	
}
