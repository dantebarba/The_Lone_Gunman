package ar.edu.unlp.lifia.grupo8.domain.rank;

import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public class Counterintelligent extends Rank {
	
	public Counterintelligent() {}

	
	@Override
	public String toString() {	
		return "Contrainteligente";
	}
	
	
	public CodedMessage encodeMessage(CodedMessage message){
		return message;
	}
	public CodedMessage decodeMessage(CodedMessage message){
		return message;
	}
	public CryptedFile encryptFile(CryptedFile file){
		return file;
	}
	public CryptedFile decryptFile(CryptedFile file){
		return file;
	}
	
	
}
