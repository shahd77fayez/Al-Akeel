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
	private int UserId ;
	private String name;
	private RolesEnum role;
	@OneToOne(mappedBy="OwnerID")
	private Restaurant RestOwner;
}
