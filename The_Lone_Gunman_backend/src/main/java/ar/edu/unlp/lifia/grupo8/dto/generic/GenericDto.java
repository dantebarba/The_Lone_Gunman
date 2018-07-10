/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.dto.generic;

import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;

/**
 * @author Agustin
 *
 */
public class GenericDto implements ResponseDto, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2284753033567550985L;
	
	private String responseText;
	
	public GenericDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GenericDto(String responseText) {
		this.setResponseText(responseText);
	}
	
	public String getResponseText() {
		return responseText;
	}
	
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

}
