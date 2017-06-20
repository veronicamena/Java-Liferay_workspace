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

package serviciocoches.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import serviciocoches.model.Coche;

import java.util.List;

/**
 * The persistence utility for the coche service. This utility wraps {@link serviciocoches.service.persistence.impl.CochePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CochePersistence
 * @see serviciocoches.service.persistence.impl.CochePersistenceImpl
 * @generated
 */
@ProviderType
public class CocheUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Coche coche) {
		getPersistence().clearCache(coche);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coche> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coche> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coche> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Coche> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Coche update(Coche coche) {
		return getPersistence().update(coche);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Coche update(Coche coche, ServiceContext serviceContext) {
		return getPersistence().update(coche, serviceContext);
	}

	/**
	* Caches the coche in the entity cache if it is enabled.
	*
	* @param coche the coche
	*/
	public static void cacheResult(Coche coche) {
		getPersistence().cacheResult(coche);
	}

	/**
	* Caches the coches in the entity cache if it is enabled.
	*
	* @param coches the coches
	*/
	public static void cacheResult(List<Coche> coches) {
		getPersistence().cacheResult(coches);
	}

	/**
	* Creates a new coche with the primary key. Does not add the coche to the database.
	*
	* @param Matricula the primary key for the new coche
	* @return the new coche
	*/
	public static Coche create(java.lang.String Matricula) {
		return getPersistence().create(Matricula);
	}

	/**
	* Removes the coche with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Matricula the primary key of the coche
	* @return the coche that was removed
	* @throws NoSuchCocheException if a coche with the primary key could not be found
	*/
	public static Coche remove(java.lang.String Matricula)
		throws serviciocoches.exception.NoSuchCocheException {
		return getPersistence().remove(Matricula);
	}

	public static Coche updateImpl(Coche coche) {
		return getPersistence().updateImpl(coche);
	}

	/**
	* Returns the coche with the primary key or throws a {@link NoSuchCocheException} if it could not be found.
	*
	* @param Matricula the primary key of the coche
	* @return the coche
	* @throws NoSuchCocheException if a coche with the primary key could not be found
	*/
	public static Coche findByPrimaryKey(java.lang.String Matricula)
		throws serviciocoches.exception.NoSuchCocheException {
		return getPersistence().findByPrimaryKey(Matricula);
	}

	/**
	* Returns the coche with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Matricula the primary key of the coche
	* @return the coche, or <code>null</code> if a coche with the primary key could not be found
	*/
	public static Coche fetchByPrimaryKey(java.lang.String Matricula) {
		return getPersistence().fetchByPrimaryKey(Matricula);
	}

	public static java.util.Map<java.io.Serializable, Coche> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the coches.
	*
	* @return the coches
	*/
	public static List<Coche> findAll() {
		return getPersistence().findAll();
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
	public static List<Coche> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Coche> findAll(int start, int end,
		OrderByComparator<Coche> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Coche> findAll(int start, int end,
		OrderByComparator<Coche> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the coches from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of coches.
	*
	* @return the number of coches
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CochePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CochePersistence, CochePersistence> _serviceTracker =
		ServiceTrackerFactory.open(CochePersistence.class);
}