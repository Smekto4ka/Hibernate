package org.jpwh.model.associations.maps.mapkey;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, String> name;
	public static volatile MapAttribute<Item, Long, Bid> bids;
	public static volatile SingularAttribute<Item, Long> id;

}

