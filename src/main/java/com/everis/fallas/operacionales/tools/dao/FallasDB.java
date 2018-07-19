package com.everis.fallas.operacionales.tools.dao;

import java.util.List;

import com.everis.fallas.operacionales.tools.bean.App;

public interface FallasDB {
	public List<App> obtenerApp(String name);
}
