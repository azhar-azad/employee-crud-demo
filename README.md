## Commit Versions: 
 
 v1: Use EntityManager but leverage native Hibernate API
 
 v2: Use EntityManager and standard JPA API
 
 v3: Spring Data JPA
 
### v2 Insights: Benefits of JPA, JPA vs Native Hibernate Methods

#### Benefits
 * By having a standard API, you are not locked to vendor's implementation
 * Maintain portable, flexible code
 * Can theoretically switch vendor implementations
 * If vendor ABC stops supporting their product, switch to vendor XYZ without vendor lock in
 
#### Comparison
 * Create/save new entity: 
 
	Native Hibernate method: session.save()
	
	JPA method: entityManager.persist()
	
 * Retrieve entity by id
 
	Native Hibernate method: session.get()/load()
	
	JPA method: entityManager.find()
	
 * Retrieve list of entities
 
	Native Hibernate method: session.createQuery()
	
	JPA method: entityManager.createQuery()
	
 * Save or update entity
 
	Native Hibernate method: session.saveOrUpdate()
	
	JPA method: entityManager.merge()
	
 * Delete entity
 
	Native Hibernate method: session.delete()
	
	JPA method: entityManager.remove()
 
 