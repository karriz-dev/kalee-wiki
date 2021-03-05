package land.kalee.wiki.entity.auth;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name="article")
public class Article implements Serializable 
{
	private static final long serialVersionUID = -6091200688323574892L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long articleID;

	@Column(nullable = false)
	@NonNull
	private int ownerID;
	
	@Column(length=100, nullable = false)
	@NonNull
	private String title;
	
	@Column(length=5000, nullable = false)
	@NonNull
	private String contents;
	
	@Column(nullable = false)
	@NonNull
	private Date createAt;
	
	@Column
	private Date updateAt;
	
	@Column
	private Date removeAt;
}
