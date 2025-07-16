package sn.ept.git.seminaire.cicd.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.MappedSuperclassType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(BaseEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BaseEntity_ {

	public static final String CREATED_DATE = "createdDate";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String ID = "id";
	public static final String VERSION = "version";

	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.BaseEntity#createdDate
	 **/
	public static volatile SingularAttribute<BaseEntity, LocalDateTime> createdDate;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.BaseEntity#lastModifiedDate
	 **/
	public static volatile SingularAttribute<BaseEntity, LocalDateTime> lastModifiedDate;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.BaseEntity#id
	 **/
	public static volatile SingularAttribute<BaseEntity, String> id;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.BaseEntity
	 **/
	public static volatile MappedSuperclassType<BaseEntity> class_;
	
	/**
	 * @see sn.ept.git.seminaire.cicd.entities.BaseEntity#version
	 **/
	public static volatile SingularAttribute<BaseEntity, Integer> version;

}

