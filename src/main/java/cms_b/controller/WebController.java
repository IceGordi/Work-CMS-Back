package cms_b.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.json.JsonObject;

import org.springframework.http.HttpStatus;

import cms_b.model.Etiqueta;
import cms_b.service.EtiquetaService;

@RequestMapping("/")
@RestController
public class WebController {

	  protected static final Logger logger = LoggerFactory.getLogger(WebController.class);
	  
	  
	  @Autowired
	  private EtiquetaService service;
	  
	  @GetMapping(value = "/etiqueta/all")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findAllEtiquetas(){
		  logger.info("Trying to find all etiquetas.");
		  return service.findAllEtiquetas();
	  }
	  
	  @GetMapping(value = "/ambito/all")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findAllAmbitos(){
		  logger.info("Trying to find all ambitos.");
		  return service.findAllAmbitos();
	  }
	  
	  @GetMapping(value = "/id/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findById(@PathVariable String id) {
		  logger.info("Find by etiqueta id: {}", id);
		  return service.findById(id);
	  }
	  
	  @GetMapping(value = "/docId/{docId}")
	  @ResponseStatus(HttpStatus.OK)
	  public Etiqueta findByDocId(@PathVariable String docId) {
		  logger.info("Find by etiqueta docId: {}", docId);
		  return service.findByDocId(docId);
	  }
	  
	  
	  @GetMapping(value = "/keyId/{keyId}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findByKeyId(@PathVariable String keyId) {
		  logger.info("Find by etiqueta keyId: {}", keyId);
		  return service.findByKeyId(keyId);
	  }
	  
	  @GetMapping(value = "/etiqueta/ambitos/{ambitoList}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findByAmbitos(@PathVariable String[] ambitoList) {
		  logger.info("Find by etiqueta with ambito(s): {}", ambitoList.toString());
		  List<String> list = new ArrayList<String>();
		  for(String s:ambitoList) {
			  list.add(s);
		  }
		  try {
		  return service.findByAmbitos(list);
		  }catch(Exception e) {
			  e.printStackTrace();
			  logger.info("Houston we have a problem with findByAmbitos");
			  return null;
		  }
	  }
	  

//	  @PostMapping(value = "/etiqueta/create")
//	  @ResponseStatus(HttpStatus.CREATED)
//	  public Etiqueta createEtiqueta (@RequestBody Etiqueta etiqueta) {
//		  logger.info("Creating etiqueta");
//		  return service.create(etiqueta);
//	  }
	  

//	  @PostMapping(value = "/etiqueta/create")
//	  @ResponseStatus(HttpStatus.CREATED)
//	  public List<Etiqueta> createEtiqueta (@RequestBody List<Etiqueta> list) {
//		  logger.info("Creating etiqueta bulk");
//		  List<Etiqueta> addedList = new ArrayList<Etiqueta>();
//		  for(Etiqueta etl:list) {
//		  addedList.add(service.create(etl));
//		  }
//		  return addedList;
//	  }
	  

//	  @PostMapping(value = "/ambito/create")
//	  @ResponseStatus(HttpStatus.CREATED)
//	  public Etiqueta createAmbito (@RequestBody Etiqueta ambito) {
//		  logger.info("Creating ambito");
//		  return service.create(ambito);
//	  }
	  
	  @PostMapping(value = "/create")
	  @ResponseStatus(HttpStatus.CREATED)
	  public List<Etiqueta> create (@RequestBody List<Etiqueta> list) {
		  logger.info("Creating ambito bulk");
		  List<Etiqueta> addedList = new ArrayList<Etiqueta>();
		  for(Etiqueta etl:list) {
		  addedList.add(service.create(etl));
		  }
		  return addedList;
	  }
	  
	  @PutMapping(value = "/update")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> update (@RequestBody List<Etiqueta> etiqueta) {
		  List<Etiqueta> list = new ArrayList<Etiqueta>();
		  String s = "";
		  for(Etiqueta etl:etiqueta) {
			  s = "Updating " + etl.getTipo() + " with id:" + etl.getId();
			  logger.info(s);
			  list.add(service.update(etl));
		  }
 		  return list;
	  }
	 
	  
	  @DeleteMapping("/delete/etiqueta/{keyId}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> deleteEtiqueta(@PathVariable String keyId) {
		  logger.info("Deleting etiqueta with keyId: {}",keyId);
		  //List<Etiqueta> etl = service.findByKeyId(keyId);
		  //for(Etiqueta e:etl)
		  return service.delete(keyId);
	  }
	  
	  @DeleteMapping("/delete/ambito/{docId}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> deleteAmbito(@PathVariable String docId) {
		  logger.info("Deleting ambito with docId: {}",docId);
		  return service.delete(docId);
	  }
}
