### Order of Reading:
1. Fetch
2. Create
3. Embeddable
4. Mapping Relations
5. Fetch - EAGER/LAZY
6. Caching

### Steps for CRUD:
- Create Configuration:
  - `Configuration configuration = new Configuration().configure().addAnnotatedClass(_ClassName_.class);`
- Create Registry:
  - `ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();`
- Create Session Factory:
  - `SessionFactory sessionFactory = configuration.buildSessionFactory(reg);`
- Create Session:
  - `Session session = sessionFactory.openSession();`
- Begin Transaction:
  - `Transaction tx = session.beginTransaction();`
- _Perform CURD Operation_
- Commit Transaction:
  - `tx.commit();`
  
### Caching
- Level 1: Default
- Deven 2: Requires Setup

#### Setup for Level-2 Caching:
- Add Annotation in Entity:
  - `@Cacheable`
  - `@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)`
- Add dependencies for `ehcache` and `hibernate-ehcache`
- Enable level-2 cache
  - `<property name="hibernate.cache.use_second_level_cache">true</property>`
- Add cache provide:
  - `<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory
            </property>`