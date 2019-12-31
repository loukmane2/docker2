package io.projet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;



@Entity
public class Photos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idphotos;
	
	@NotBlank(message = "Photos path is required")
	private String path;
	
	@ManyToOne
    @JoinColumn(name = "id")
    private Project projet;
	
	
	public Photos() {
		super();
	}

	public Photos(int idphotos, @NotBlank(message = "Photos path is required") String path, Project projet) {
		super();
		this.idphotos = idphotos;
		this.path = path;
		this.projet = projet;
	}

	public int getIdphotos() {
		return idphotos;
	}

	public void setIdphotos(int idphotos) {
		this.idphotos = idphotos;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Project getProjet() {
		return projet;
	}

	public void setProjet(Project projet) {
		this.projet = projet;
	}

	
}
