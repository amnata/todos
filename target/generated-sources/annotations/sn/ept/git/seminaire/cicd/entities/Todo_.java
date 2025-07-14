package sn.ept.git.seminaire.cicd.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Todo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Todo_ extends sn.ept.git.seminaire.cicd.entities.BaseEntity_ {

	public static final String DATE_DEBUT = "dateDebut";
	public static final String DESCRIPTION = "description";
	public static final String COMPLETED = "completed";
	public static final String DATE_FIN = "dateFin";
	public static final String TITLE = "title";
	public static final String TAGS = "tags";

	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#dateDebut
	 **/
	public static volatile SingularAttribute<Todo, LocalDateTime> dateDebut;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#description
	 **/
	public static volatile SingularAttribute<Todo, String> description;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#completed
	 **/
	public static volatile SingularAttribute<Todo, Boolean> completed;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#dateFin
	 **/
	public static volatile SingularAttribute<Todo, LocalDateTime> dateFin;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#title
	 **/
	public static volatile SingularAttribute<Todo, String> title;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo
	 **/
	public static volatile EntityType<Todo> class_;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Todo#tags
	 **/
	public static volatile SetAttribute<Todo, Tag> tags;

}

