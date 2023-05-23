package entities;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
	private int UserId ;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private RolesEnum role;
	
	@OneToOne(mappedBy="OwnerID" ,fetch=FetchType.EAGER)
	private Restaurant RestOwner;
	
	////////////////////////////////////////////////////////////
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RolesEnum getRole() {
		return role;
	}
	public void setRole(RolesEnum role) {
		this.role = role;
	}
	
	public Restaurant getRestOwner() {
	 
		return RestOwner;
	}
	public void setRestOwner(Restaurant restOwner) {
		RestOwner = restOwner;
	}
	
}
