package ar.edu.unlp.lifia.grupo8.dao;

import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;


public interface CryptedFileDao extends GenericDao<CryptedFile>{
	public List<CryptedFile> findByOwner(String owner);
	public List<CryptedFile> findByName(String name);
	public CryptedFile findByNameAndOwner (String name , String owner);
	public List<CryptedFile> findAllFilesDifferentOwner(String username);
	
}
