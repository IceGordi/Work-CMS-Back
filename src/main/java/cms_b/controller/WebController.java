package cms_b.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.couchbase.client.java.document.json.JsonObject;

import org.springframework.http.HttpStatus;

import cms_b.model.Ambito;
import cms_b.model.Etiqueta;
import cms_b.model.FAQ;
import cms_b.service.AmbitoService;
import cms_b.service.EtiquetaService;
import cms_b.service.FAQService;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebController {

	  protected static final Logger logger = LoggerFactory.getLogger(WebController.class);
	  
	  
	  @Autowired
	  private EtiquetaService etiService;
	  
	  @Autowired
	  private AmbitoService ambService;
	  
	  @Autowired
	  private FAQService faqService;
	  @CrossOrigin(origins="*")
	  @GetMapping(value = "/etiqueta/all")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findAllEtiquetas(){
		  logger.info("Trying to find all etiquetas.");
		  return etiService.findAllEtiquetas();
	  }
	  @CrossOrigin(origins="*")
	  @GetMapping(value = "/ambito/all")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Ambito> findAllAmbitos(){
		  logger.info("Trying to find all ambitos.");
		  return ambService.findAllAmbitos();
	  }
	  @CrossOrigin(origins="*")
	  @GetMapping(value = "/FAQ/all")
	  @ResponseStatus(HttpStatus.OK)
	  public List<FAQ> findAllFAQ(){
		  logger.info("Trying to find all FAQs.");
		  return faqService.findAllFAQ();
	  }
	  @CrossOrigin(origins="*")
	  @GetMapping(value = "/ambito/{keyIds}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Ambito> findAmbitos(@PathVariable String[] keyIds){
		  logger.info("Trying to find all ambitos.");
		  return ambService.findAmbitos(keyIds);
	  } 
	  
	  @CrossOrigin(origins="*")
	  @GetMapping(value = "/etiqueta/ambitos/{ambitoList}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> findByAmbitos(@PathVariable String[] ambitoList) {
		  logger.info("Find by etiqueta with ambito(s): {}", ambitoList.toString());
		  List<String> list = new ArrayList<String>();
		  for(String s:ambitoList) {
			  list.add(s);
		  }
		  try {
		  return etiService.findByAmbitos(list);
		  }catch(Exception e) {
			  e.printStackTrace();
			  logger.info("Houston we have a problem with findByAmbitos");
			  return null;
		  }
	  }
	  

	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/create/etiqueta")
	  @ResponseStatus(HttpStatus.CREATED)
	  public List<Etiqueta> createEtiquetas (@RequestBody List<Etiqueta> list) {
		  logger.info("Creating etiqueta");
		  List<Etiqueta> addedList = new ArrayList<Etiqueta>();
		  for(Etiqueta etl:list) {
		  addedList.add(etiService.create(etl));
		  }
		  return addedList;
	  }
	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/create/ambito")
	  @ResponseStatus(HttpStatus.CREATED)
	  public List<Ambito> createAmbito (@RequestBody List<Ambito> list) {
		  logger.info("Creating etiqueta");
		  List<Ambito> addedList = new ArrayList<Ambito>();
		  for(Ambito etl:list) {
		  addedList.add(ambService.create(etl));
		  }
		  return addedList;
	  }
	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/create/faq")
	  @ResponseStatus(HttpStatus.CREATED)
	  public List<FAQ> createFAQ (@RequestBody List<FAQ> list) {
		  logger.info("Creating FAQs");
		  List<FAQ> addedList = new ArrayList<FAQ>();
		  for(FAQ etl:list) {
		  addedList.add(faqService.create(etl));
		  }
		  return addedList;
	  }
	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/update/etiqueta")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> updateEtiqueta (@RequestBody List<Etiqueta> etiqueta) {
		  List<Etiqueta> list = new ArrayList<Etiqueta>();
		  String s = "";
		  for(Etiqueta etl:etiqueta) {
			  s = "Updating etiqueta with id:" + etl.getId();
			  logger.info(s);
			  list.add(etiService.update(etl));
		  }
 		  return list;
	  }
	  
	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/update/ambito")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Ambito> updateAmbito (@RequestBody List<Ambito> ambito) {
		  List<Ambito> list = new ArrayList<Ambito>();
		  String s = "";
		  for(Ambito etl:ambito) {
			  s = "Updating ambito with id:" + etl.getId();
			  logger.info(s);
			  list.add(ambService.update(etl));
		  }
 		  return list;
	  }
	  @CrossOrigin(origins="*")
	  @PostMapping(value = "/update/faq")
	  @ResponseStatus(HttpStatus.OK)
	  public List<FAQ> updateFAQ (@RequestBody List<FAQ> faq) {
		  List<FAQ> list = new ArrayList<FAQ>();
		  String s = "";
		  for(FAQ etl:faq) {
			  s = "Updating FAQ with id:" + etl.getId();
			  logger.info(s);
			  list.add(faqService.update(etl));
		  }
 		  return list;
	  }
	 
	  @CrossOrigin(origins="*")
	  @GetMapping("/disable/etiqueta/{keyId}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Etiqueta> disableEtiqueta(@PathVariable String keyId) {
		  logger.info("Disabling etiqueta with keyId: {}",keyId);
		  //List<Etiqueta> etl = service.findByKeyId(keyId);
		  //for(Etiqueta e:etl)
		  return etiService.disableEtiqueta(keyId);
	  }
	  @CrossOrigin(origins="*")
	  @GetMapping("/disable/ambito/{keyId}")
	  @ResponseStatus(HttpStatus.OK)
	  public Ambito disableAmbito(@PathVariable String keyId) {
		  logger.info("Disabling ambito with keyId: {}",keyId);
		  //List<Etiqueta> etl = service.findByKeyId(keyId);
		  //for(Etiqueta e:etl)
		  return ambService.disableAmbito(keyId);
	  }
	  @CrossOrigin(origins="*")
	  @GetMapping("/disable/faq/{keyId}")
	  @ResponseStatus(HttpStatus.OK)
	  public FAQ disableFAQ(@PathVariable String keyId) {
		  logger.info("Disabling etiqueta with keyId: {}",keyId);
		  //List<Etiqueta> etl = service.findByKeyId(keyId);
		  //for(Etiqueta e:etl)
		  return faqService.disableFAQ(keyId);
	  }
	  
	  @CrossOrigin(origins="*")
	  @GetMapping("/languages/all")
	  @ResponseStatus(HttpStatus.OK)
	  public JsonObject getLangauges() {
		  logger.info("Getting an array of langauges");
		  List<String> list = new ArrayList<String>();
		  list.add("es");list.add("en");list.add("de");
		  return JsonObject.create().put("languages", list);
	  }
	  
	  
	  
//	  @DeleteMapping("/delete/etiqueta/{keyId}")
//	  @ResponseStatus(HttpStatus.OK)
//	  public List<Etiqueta> deleteEtiqueta(@PathVariable String keyId) {
//		  logger.info("Deleting etiqueta with keyId: {}",keyId);
//		  //List<Etiqueta> etl = service.findByKeyId(keyId);
//		  //for(Etiqueta e:etl)
//		  return service.delete(keyId);
//	  }
//	  
//	  @DeleteMapping("/delete/ambito/{docId}")
//	  @ResponseStatus(HttpStatus.OK)
//	  public List<Etiqueta> deleteAmbito(@PathVariable String docId) {
//		  logger.info("Deleting ambito with docId: {}",docId);
//		  return service.delete(docId);
//	  }
}
