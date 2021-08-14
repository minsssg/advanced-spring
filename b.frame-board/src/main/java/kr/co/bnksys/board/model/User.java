package kr.co.bnksys.board.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable {

	
	/**
	 * REMOTE 객체를 serialVersionUID아이디로 압축을 해서 다른 시스템에서 해당 시리얼ID로 Deserializable 할 수 있다. 
	 */
	private static final long serialVersionUID = 3047632672773925906L;
	
	private Long id;
	private String userId;
	private String password;
	private String name;
	private String useYn;
	private String fstRgprId;
	private String fstRgDtti;
	private String ltChprId;
	private String ltChDtti;
	
	
}
