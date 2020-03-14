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
 
### v3 Insights: Benefits of Spring Data JPA, JpaRepository

#### Benefits
 * Create a DAO and just plug in your entity type and primary key
 * Spring will give you CRUD implementation for FREE ... like MAGIC!!
 * Helps to minimize boiler-plate DAO code (Approx. more than 70%).
 
#### JpaRepository
 * Spring Data JPA provides the interface: JpaRepository.
 * Exposes methods (some by inheritance by parents).
 * Methods: findAll(), findById(id), save(entity), deleteById(id), others...
 
#### Advanced Features
 * Extending and adding custom queries with JPQL.
 * Query Domain Specific Language (Query DSL)
 * Defining custom methods (low-level coding)