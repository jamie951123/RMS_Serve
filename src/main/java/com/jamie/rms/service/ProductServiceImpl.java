package com.jamie.rms.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.ImageDao;
import com.jamie.rms.dao.ProductDao;
import com.jamie.rms.model.Product;
import com.jamie.rms.model.Image;
import com.jamie.rms.model.ResponseMessage;

@Service
public class ProductServiceImpl implements ProductService{

	Log log = LogFactory.getLog(ProductServiceImpl.class);
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}
	@Override
	public List<Product> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return productDao.findByPartyId(partyId);
	}
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}
	@Override
	public int updateWeightIdNullByWeightIdAndPartyId(Long weightId,String partyId) {
		// TODO Auto-generated method stub
		return productDao.updateWeightIdNullByWeightIdAndPartyId(weightId, partyId);
//		return null;
	}
	@Override
	public int updateQuantityIdNullByQuantityIdAndPartyId(Long quantityId, String partyId) {
		// TODO Auto-generated method stub
		return productDao.updateQuantityIdNullByQuantityIdAndPartyId(quantityId, partyId);
	}
	@Override
	public Product findByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productDao.findByProductId(productId);
	}
	@Override
	public int updateQuantityIdAndWeightIdNullByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productDao.updateQuantityIdAndWeightIdNullByProductId(productId);
	}
	@Override
	public ResponseMessage deleteByProductId(Long productId){
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
		r.setMessage_request(String.valueOf(productId));
			productDao.delete(productId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table");
			r.setMessage_count(0);
		}
		return r;
	}
	@Override
	public ResponseMessage delete(Product product) {
		// TODO Auto-generated method stub
		if(product == null){
			return null;
		}
		ResponseMessage r = new ResponseMessage();
		r.setMessage_request(product.toString());
		try{
			productDao.delete(product);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table"); 
			r.setMessage_count(0);
		}
		return r;
	}
	
	@Override
	public Boolean createProductImage(MultipartFile file, String folderFilePath,Long productId) {
		// TODO Auto-generated method stub
		File folder = new File(folderFilePath);
    	
    	if(!folder.exists()){
    		folder.mkdirs();
    	}
    	
    	
		String imageFileName = UUID.randomUUID().toString()+".jpg";
		File imageFile = new File(folder,imageFileName);
		try {
			FileCopyUtils.copy(file.getBytes(), imageFile);
			
			Image thatImage = Image.createImage(productId,imageFileName);
			imageDao.save(thatImage);
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
	}
	@Override
	public byte[] getProductImage(String folderFilePath, Long productId) throws IOException {
		File folder = new File(folderFilePath);
    	
    	if(!folder.exists()){
    		folder.mkdirs();
    	}
    	
    	Image imageObj = imageDao.findByProductId(productId);
    	if(imageObj==null) {
    		log.error("image in db ,not found");
    		throw new IOException("image object not found");
    	}
    	
    	File file = new File(folderFilePath,imageObj.getFileName());
		FileInputStream fis = new FileInputStream(file);
		log.debug("image has input stream!!");
		return IOUtils.toByteArray(fis);
		
	}
	@Override
	public byte[] getProductImage(String folderFilePath, String fileName) throws IOException {
		File folder = new File(folderFilePath);
    	
    	if(!folder.exists()){
    		folder.mkdirs();
    	}
    	Image imageObj = imageDao.findByFileName(fileName);
    	if(imageObj==null) {
    		log.error("image in db ,not found");
    		throw new IOException("image object not found");
    	}
    	
    	File file = new File(folderFilePath,imageObj.getFileName());
		FileInputStream fis = new FileInputStream(file);
		log.debug("image has input stream!!");
		return IOUtils.toByteArray(fis);
	}
	@Override
	public byte[] getProductImageById(String folderFilePath, Long photoId) throws IOException {
		Image imageObj = imageDao.findOne(photoId);
    	if(imageObj==null) {
    		log.error("image in db ,not found");
    		throw new IOException("image object not found");
    	}
    	
    	File file = new File(folderFilePath,imageObj.getFileName());
		FileInputStream fis = new FileInputStream(file);
		log.debug("image has input stream!!");
		return IOUtils.toByteArray(fis);
	}
	@Override
	public byte[] getProductImageByFileNameLike(String folderFilePath, String fileName) throws IOException {
		log.info("----------------- filename = "+fileName);
		Image imageObj = imageDao.findByFileNameLike(fileName);
    	if(imageObj==null) {
    		log.error("image in db ,not found");
    		throw new IOException("image object not found");
    	}
    	
    	File file = new File(folderFilePath,imageObj.getFileName());
		FileInputStream fis = new FileInputStream(file);
		log.debug("image has input stream!!");
		return IOUtils.toByteArray(fis);
	}
	
	
}
