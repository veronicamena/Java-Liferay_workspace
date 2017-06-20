/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package serviciocoches.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import serviciocoches.exception.NoSuchCocheException;

import serviciocoches.model.Coche;

import serviciocoches.model.impl.CocheImpl;
import serviciocoches.model.impl.CocheModelImpl;

import serviciocoches.service.persistence.CochePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the coche service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CochePersistence
 * @see serviciocoches.service.persistence.CocheUtil
 * @generated
 */
@ProviderType
public class CochePersistenceImpl extends BasePersistenceImpl<Coche>
	implements CochePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CocheUtil} to access the coche persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CocheImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheModelImpl.FINDER_CACHE_ENABLED, CocheImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheModelImpl.FINDER_CACHE_ENABLED, CocheImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CochePersistenceImpl() {
		setModelClass(Coche.class);
	}

	/**
	 * Caches the coche in the entity cache if it is enabled.
	 *
	 * @param coche the coche
	 */
	@Override
	public void cacheResult(Coche coche) {
		entityCache.putResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheImpl.class, coche.getPrimaryKey(), coche);

		coche.resetOriginalValues();
	}

	/**
	 * Caches the coches in the entity cache if it is enabled.
	 *
	 * @param coches the coches
	 */
	@Override
	public void cacheResult(List<Coche> coches) {
		for (Coche coche : coches) {
			if (entityCache.getResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
						CocheImpl.class, coche.getPrimaryKey()) == null) {
				cacheResult(coche);
			}
			else {
				coche.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coches.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CocheImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coche.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coche coche) {
		entityCache.removeResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheImpl.class, coche.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Coche> coches) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coche coche : coches) {
			entityCache.removeResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
				CocheImpl.class, coche.getPrimaryKey());
		}
	}

	/**
	 * Creates a new coche with the primary key. Does not add the coche to the database.
	 *
	 * @param Matricula the primary key for the new coche
	 * @return the new coche
	 */
	@Override
	public Coche create(String Matricula) {
		Coche coche = new CocheImpl();

		coche.setNew(true);
		coche.setPrimaryKey(Matricula);

		return coche;
	}

	/**
	 * Removes the coche with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Matricula the primary key of the coche
	 * @return the coche that was removed
	 * @throws NoSuchCocheException if a coche with the primary key could not be found
	 */
	@Override
	public Coche remove(String Matricula) throws NoSuchCocheException {
		return remove((Serializable)Matricula);
	}

	/**
	 * Removes the coche with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coche
	 * @return the coche that was removed
	 * @throws NoSuchCocheException if a coche with the primary key could not be found
	 */
	@Override
	public Coche remove(Serializable primaryKey) throws NoSuchCocheException {
		Session session = null;

		try {
			session = openSession();

			Coche coche = (Coche)session.get(CocheImpl.class, primaryKey);

			if (coche == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCocheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coche);
		}
		catch (NoSuchCocheException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Coche removeImpl(Coche coche) {
		coche = toUnwrappedModel(coche);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coche)) {
				coche = (Coche)session.get(CocheImpl.class,
						coche.getPrimaryKeyObj());
			}

			if (coche != null) {
				session.delete(coche);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coche != null) {
			clearCache(coche);
		}

		return coche;
	}

	@Override
	public Coche updateImpl(Coche coche) {
		coche = toUnwrappedModel(coche);

		boolean isNew = coche.isNew();

		Session session = null;

		try {
			session = openSession();

			if (coche.isNew()) {
				session.save(coche);

				coche.setNew(false);
			}
			else {
				coche = (Coche)session.merge(coche);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
			CocheImpl.class, coche.getPrimaryKey(), coche, false);

		coche.resetOriginalValues();

		return coche;
	}

	protected Coche toUnwrappedModel(Coche coche) {
		if (coche instanceof CocheImpl) {
			return coche;
		}

		CocheImpl cocheImpl = new CocheImpl();

		cocheImpl.setNew(coche.isNew());
		cocheImpl.setPrimaryKey(coche.getPrimaryKey());

		cocheImpl.setMatricula(coche.getMatricula());
		cocheImpl.setMarca(coche.getMarca());
		cocheImpl.setModelo(coche.getModelo());
		cocheImpl.setPrecio(coche.getPrecio());
		cocheImpl.setPrecioConIva(coche.getPrecioConIva());

		return cocheImpl;
	}

	/**
	 * Returns the coche with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the coche
	 * @return the coche
	 * @throws NoSuchCocheException if a coche with the primary key could not be found
	 */
	@Override
	public Coche findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCocheException {
		Coche coche = fetchByPrimaryKey(primaryKey);

		if (coche == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCocheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coche;
	}

	/**
	 * Returns the coche with the primary key or throws a {@link NoSuchCocheException} if it could not be found.
	 *
	 * @param Matricula the primary key of the coche
	 * @return the coche
	 * @throws NoSuchCocheException if a coche with the primary key could not be found
	 */
	@Override
	public Coche findByPrimaryKey(String Matricula) throws NoSuchCocheException {
		return findByPrimaryKey((Serializable)Matricula);
	}

	/**
	 * Returns the coche with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coche
	 * @return the coche, or <code>null</code> if a coche with the primary key could not be found
	 */
	@Override
	public Coche fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
				CocheImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Coche coche = (Coche)serializable;

		if (coche == null) {
			Session session = null;

			try {
				session = openSession();

				coche = (Coche)session.get(CocheImpl.class, primaryKey);

				if (coche != null) {
					cacheResult(coche);
				}
				else {
					entityCache.putResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
						CocheImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
					CocheImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coche;
	}

	/**
	 * Returns the coche with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Matricula the primary key of the coche
	 * @return the coche, or <code>null</code> if a coche with the primary key could not be found
	 */
	@Override
	public Coche fetchByPrimaryKey(String Matricula) {
		return fetchByPrimaryKey((Serializable)Matricula);
	}

	@Override
	public Map<Serializable, Coche> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Coche> map = new HashMap<Serializable, Coche>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Coche coche = fetchByPrimaryKey(primaryKey);

			if (coche != null) {
				map.put(primaryKey, coche);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
					CocheImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Coche)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_COCHE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Coche coche : (List<Coche>)q.list()) {
				map.put(coche.getPrimaryKeyObj(), coche);

				cacheResult(coche);

				uncachedPrimaryKeys.remove(coche.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CocheModelImpl.ENTITY_CACHE_ENABLED,
					CocheImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the coches.
	 *
	 * @return the coches
	 */
	@Override
	public List<Coche> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CocheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coches
	 * @param end the upper bound of the range of coches (not inclusive)
	 * @return the range of coches
	 */
	@Override
	public List<Coche> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CocheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coches
	 * @param end the upper bound of the range of coches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coches
	 */
	@Override
	public List<Coche> findAll(int start, int end,
		OrderByComparator<Coche> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the coches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CocheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coches
	 * @param end the upper bound of the range of coches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of coches
	 */
	@Override
	public List<Coche> findAll(int start, int end,
		OrderByComparator<Coche> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Coche> list = null;

		if (retrieveFromCache) {
			list = (List<Coche>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COCHE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COCHE;

				if (pagination) {
					sql = sql.concat(CocheModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coche>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coche>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the coches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Coche coche : findAll()) {
			remove(coche);
		}
	}

	/**
	 * Returns the number of coches.
	 *
	 * @return the number of coches
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COCHE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CocheModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the coche persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CocheImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COCHE = "SELECT coche FROM Coche coche";
	private static final String _SQL_SELECT_COCHE_WHERE_PKS_IN = "SELECT coche FROM Coche coche WHERE Matricula IN (";
	private static final String _SQL_COUNT_COCHE = "SELECT COUNT(coche) FROM Coche coche";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coche.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Coche exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CochePersistenceImpl.class);
}