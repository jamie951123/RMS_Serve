package com.jamie.rms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jamie.rms.model.Product;
import com.jamie.rms.model.ResponseMessage;

public interface ProductService {
	List<Product> findAll();
	List<Product> findByPartyId(String partyId);
	Product save(Product product);
	int updateWeightIdNullByWeightIdAndPartyId(Long weightId,String partyId);
	int updateQuantityIdNullByQuantityIdAndPartyId(Long quantityId,String partyId);
	Product findByProductId (Long productId);
	int updateQuantityIdAndWeightIdNullByProductId(Long productId);
	ResponseMessage deleteByProductId(Long productId);
	ResponseMessage delete(Product product);
	
	/**
	 *  create product image
	 * @param file the file of product image
	 * @param folderFilePath the folder file path
	 */
	Boolean createProductImage(MultipartFile file, String folderFilePath,Long productId);
	byte[] getProductImage(String folderFilePath,Long productId) throws IOException;
	byte[] getProductImage(String folderFilePath,String fileName) throws IOException;
	byte[] getProductImageById(String folderFilePath,Long photoId) throws IOException;
	byte[] getProductImageByFileNameLike(String folderFilePath,String fileName) throws IOException;
}
