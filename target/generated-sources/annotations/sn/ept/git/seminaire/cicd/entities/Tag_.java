package sn.ept.git.seminaire.cicd.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Tag.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Tag_ extends sn.ept.git.seminaire.cicd.entities.BaseEntity_ {

	public static final String NAME = "name";
	public static final String TODOS = "todos";

	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Tag#name
	 **/
	public static volatile SingularAttribute<Tag, String> name;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Tag#todos
	 **/
	public static volatile SetAttribute<Tag, Todo> todos;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.Tag
	 **/
	public static volatile EntityType<Tag> class_;

}

