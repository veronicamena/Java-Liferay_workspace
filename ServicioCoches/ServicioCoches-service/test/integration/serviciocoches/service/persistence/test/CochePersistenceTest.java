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

package serviciocoches.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import serviciocoches.exception.NoSuchCocheException;

import serviciocoches.model.Coche;

import serviciocoches.service.persistence.CochePersistence;
import serviciocoches.service.persistence.CocheUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CochePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CocheUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Coche> iterator = _coches.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		Coche coche = _persistence.create(pk);

		Assert.assertNotNull(coche);

		Assert.assertEquals(coche.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Coche newCoche = addCoche();

		_persistence.remove(newCoche);

		Coche existingCoche = _persistence.fetchByPrimaryKey(newCoche.getPrimaryKey());

		Assert.assertNull(existingCoche);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCoche();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		Coche newCoche = _persistence.create(pk);

		newCoche.setMarca(RandomTestUtil.randomString());

		newCoche.setModelo(RandomTestUtil.randomString());

		newCoche.setPrecio(RandomTestUtil.nextDouble());

		newCoche.setPrecioConIva(RandomTestUtil.nextDouble());

		_coches.add(_persistence.update(newCoche));

		Coche existingCoche = _persistence.findByPrimaryKey(newCoche.getPrimaryKey());

		Assert.assertEquals(existingCoche.getMatricula(),
			newCoche.getMatricula());
		Assert.assertEquals(existingCoche.getMarca(), newCoche.getMarca());
		Assert.assertEquals(existingCoche.getModelo(), newCoche.getModelo());
		AssertUtils.assertEquals(existingCoche.getPrecio(), newCoche.getPrecio());
		AssertUtils.assertEquals(existingCoche.getPrecioConIva(),
			newCoche.getPrecioConIva());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Coche newCoche = addCoche();

		Coche existingCoche = _persistence.findByPrimaryKey(newCoche.getPrimaryKey());

		Assert.assertEquals(existingCoche, newCoche);
	}

	@Test(expected = NoSuchCocheException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Coche> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("FOO_Coche", "Matricula",
			true, "Marca", true, "Modelo", true, "Precio", true,
			"PrecioConIva", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Coche newCoche = addCoche();

		Coche existingCoche = _persistence.fetchByPrimaryKey(newCoche.getPrimaryKey());

		Assert.assertEquals(existingCoche, newCoche);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		Coche missingCoche = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCoche);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Coche newCoche1 = addCoche();
		Coche newCoche2 = addCoche();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoche1.getPrimaryKey());
		primaryKeys.add(newCoche2.getPrimaryKey());

		Map<Serializable, Coche> coches = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, coches.size());
		Assert.assertEquals(newCoche1, coches.get(newCoche1.getPrimaryKey()));
		Assert.assertEquals(newCoche2, coches.get(newCoche2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Coche> coches = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(coches.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Coche newCoche = addCoche();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoche.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Coche> coches = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, coches.size());
		Assert.assertEquals(newCoche, coches.get(newCoche.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Coche> coches = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(coches.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Coche newCoche = addCoche();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCoche.getPrimaryKey());

		Map<Serializable, Coche> coches = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, coches.size());
		Assert.assertEquals(newCoche, coches.get(newCoche.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Coche newCoche = addCoche();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Coche.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Matricula",
				newCoche.getMatricula()));

		List<Coche> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Coche existingCoche = result.get(0);

		Assert.assertEquals(existingCoche, newCoche);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Coche.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Matricula",
				RandomTestUtil.randomString()));

		List<Coche> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Coche newCoche = addCoche();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Coche.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Matricula"));

		Object newMatricula = newCoche.getMatricula();

		dynamicQuery.add(RestrictionsFactoryUtil.in("Matricula",
				new Object[] { newMatricula }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingMatricula = result.get(0);

		Assert.assertEquals(existingMatricula, newMatricula);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Coche.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Matricula"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("Matricula",
				new Object[] { RandomTestUtil.randomString() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Coche addCoche() throws Exception {
		String pk = RandomTestUtil.randomString();

		Coche coche = _persistence.create(pk);

		coche.setMarca(RandomTestUtil.randomString());

		coche.setModelo(RandomTestUtil.randomString());

		coche.setPrecio(RandomTestUtil.nextDouble());

		coche.setPrecioConIva(RandomTestUtil.nextDouble());

		_coches.add(_persistence.update(coche));

		return coche;
	}

	private List<Coche> _coches = new ArrayList<Coche>();
	private CochePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}