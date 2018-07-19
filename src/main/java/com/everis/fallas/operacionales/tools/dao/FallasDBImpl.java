package com.everis.fallas.operacionales.tools.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;

import com.everis.fallas.operacionales.tools.bean.App;
import com.everis.fallas.operacionales.tools.util.ConexionMongo;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FallasDBImpl implements FallasDB{

	private List<App> response = new ArrayList<App>();

	@SuppressWarnings("unchecked")
	public List<App> obtenerApp(String name) {
		ConexionMongo mongo = new ConexionMongo();
		MongoDatabase database = mongo.conectar();
		MongoCollection<Document> collection = database.getCollection("listaapp");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("apps.name", Pattern.compile(".*" + name + ".*", Pattern.CASE_INSENSITIVE));
		FindIterable<Document> docs = collection.find(searchQuery);
		for (Document doc : docs) {
			App var = new App();
			var.setIp(doc.getString("ip"));
			var.setPort(doc.getString("port"));
			var.setProveedor(doc.getString("proveedor"));
			var.setVersion(doc.getString("version"));
			var.setUser(doc.getString("user"));
			var.setPass(doc.getString("pass"));
			List<Document> apps = (List<Document>)doc.get("apps");
			List<String> ws = new ArrayList<String>();
			for (Document app : apps) {
				String tmpName = app.getString("name");
				if (tmpName.toUpperCase().contains(name.toUpperCase())) {
					ws.add(tmpName);
				}
			}
			var.setApps(ws);
			response.add(var);
		}
		return response;
	}

}
