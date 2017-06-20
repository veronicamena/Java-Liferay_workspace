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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import serviciocoches.exception.NoSuchCocheException;

import serviciocoches.model.Coche;

/**
 * The persistence interface for the coche service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see serviciocoches.service.persistence.impl.CochePersistenceImpl
 * @see CocheUtil
 * @generated
 */
@ProviderType
public interface CochePersistence extends BasePersistence<Coche> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CocheUtil} to access the coche persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the coche in the entity cache if it is enabled.
	*
	* @param coche the coche
	*/
	public void cacheResult(Coche coche);

	/**
	* Caches the coches in the entity cache if it is enabled.
	*
	* @param coches the coches
	*/
	public void cacheResult(java.util.List<Coche> coches);

	/**
	* Creates a new coche with the primary key. Does not add the coche to the database.
	*
	* @param Matricula the primary key for the new coche
	* @return the new coche
	*/
	public Coche create(java.lang.String Matricula);

	/**
	* Removes the coche with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Matricula the primary key of the coche
	* @return the coche that was removed
	* @throws NoSuchCocheException if a coche with the primary key could not be found
	*/
	public Coche remove(java.lang.String Matricula) throws NoSuchCocheException;

	public Coche updateImpl(Coche coche);

	/**
	* Returns the coche with the primary key or throws a {@link NoSuchCocheException} if it could not be found.
	*
	* @param Matricula the primary key of the coche
	* @return the coche
	* @throws NoSuchCocheException if a coche with the primary key could not be found
	*/
	public Coche findByPrimaryKey(java.lang.String Matricula)
		throws NoSuchCocheException;

	/**
	* Returns the coche with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Matricula the primary key of the coche
	* @return the coche, or <code>null</code> if a coche with the primary key could not be found
	*/
	public Coche fetchByPrimaryKey(java.lang.String Matricula);

	@Override
	public java.util.Map<java.io.Serializable, Coche> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the coches.
	*
	* @return the coches
	*/
	public java.util.List<Coche> findAll();

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
	public java.util.List<Coche> findAll(int start, int end);

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
	public java.util.List<Coche> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coche> orderByComparator);

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
	public java.util.List<Coche> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coche> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the coches from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of coches.
	*
	* @return the number of coches
	*/
	public int countAll();
}