package com.location.velo.res;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
	private int id;
	private int userId;
	private Trottinette trottinette;
	private Date dateStart;
	private Date dateEnd;	
	private Long totalElement;
}