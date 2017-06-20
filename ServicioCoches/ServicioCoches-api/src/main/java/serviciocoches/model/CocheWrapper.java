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

package serviciocoches.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Coche}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Coche
 * @generated
 */
@ProviderType
public class CocheWrapper implements Coche, ModelWrapper<Coche> {
	public CocheWrapper(Coche coche) {
		_coche = coche;
	}

	@Override
	public Class<?> getModelClass() {
		return Coche.class;
	}

	@Override
	public String getModelClassName() {
		return Coche.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Matricula", getMatricula());
		attributes.put("Marca", getMarca());
		attributes.put("Modelo", getModelo());
		attributes.put("Precio", getPrecio());
		attributes.put("PrecioConIva", getPrecioConIva());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String Matricula = (String)attributes.get("Matricula");

		if (Matricula != null) {
			setMatricula(Matricula);
		}

		String Marca = (String)attributes.get("Marca");

		if (Marca != null) {
			setMarca(Marca);
		}

		String Modelo = (String)attributes.get("Modelo");

		if (Modelo != null) {
			setModelo(Modelo);
		}

		Double Precio = (Double)attributes.get("Precio");

		if (Precio != null) {
			setPrecio(Precio);
		}

		Double PrecioConIva = (Double)attributes.get("PrecioConIva");

		if (PrecioConIva != null) {
			setPrecioConIva(PrecioConIva);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _coche.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _coche.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _coche.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _coche.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<serviciocoches.model.Coche> toCacheModel() {
		return _coche.toCacheModel();
	}

	/**
	* Returns the precio of this coche.
	*
	* @return the precio of this coche
	*/
	@Override
	public double getPrecio() {
		return _coche.getPrecio();
	}

	/**
	* Returns the precio con iva of this coche.
	*
	* @return the precio con iva of this coche
	*/
	@Override
	public double getPrecioConIva() {
		return _coche.getPrecioConIva();
	}

	@Override
	public int compareTo(serviciocoches.model.Coche coche) {
		return _coche.compareTo(coche);
	}

	@Override
	public int hashCode() {
		return _coche.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coche.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CocheWrapper((Coche)_coche.clone());
	}

	/**
	* Returns the marca of this coche.
	*
	* @return the marca of this coche
	*/
	@Override
	public java.lang.String getMarca() {
		return _coche.getMarca();
	}

	/**
	* Returns the matricula of this coche.
	*
	* @return the matricula of this coche
	*/
	@Override
	public java.lang.String getMatricula() {
		return _coche.getMatricula();
	}

	/**
	* Returns the modelo of this coche.
	*
	* @return the modelo of this coche
	*/
	@Override
	public java.lang.String getModelo() {
		return _coche.getModelo();
	}

	/**
	* Returns the primary key of this coche.
	*
	* @return the primary key of this coche
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _coche.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _coche.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coche.toXmlString();
	}

	@Override
	public serviciocoches.model.Coche toEscapedModel() {
		return new CocheWrapper(_coche.toEscapedModel());
	}

	@Override
	public serviciocoches.model.Coche toUnescapedModel() {
		return new CocheWrapper(_coche.toUnescapedModel());
	}

	@Override
	public void persist() {
		_coche.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coche.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_coche.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_coche.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_coche.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the marca of this coche.
	*
	* @param Marca the marca of this coche
	*/
	@Override
	public void setMarca(java.lang.String Marca) {
		_coche.setMarca(Marca);
	}

	/**
	* Sets the matricula of this coche.
	*
	* @param Matricula the matricula of this coche
	*/
	@Override
	public void setMatricula(java.lang.String Matricula) {
		_coche.setMatricula(Matricula);
	}

	/**
	* Sets the modelo of this coche.
	*
	* @param Modelo the modelo of this coche
	*/
	@Override
	public void setModelo(java.lang.String Modelo) {
		_coche.setModelo(Modelo);
	}

	@Override
	public void setNew(boolean n) {
		_coche.setNew(n);
	}

	/**
	* Sets the precio of this coche.
	*
	* @param Precio the precio of this coche
	*/
	@Override
	public void setPrecio(double Precio) {
		_coche.setPrecio(Precio);
	}

	/**
	* Sets the precio con iva of this coche.
	*
	* @param PrecioConIva the precio con iva of this coche
	*/
	@Override
	public void setPrecioConIva(double PrecioConIva) {
		_coche.setPrecioConIva(PrecioConIva);
	}

	/**
	* Sets the primary key of this coche.
	*
	* @param primaryKey the primary key of this coche
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_coche.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_coche.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CocheWrapper)) {
			return false;
		}

		CocheWrapper cocheWrapper = (CocheWrapper)obj;

		if (Objects.equals(_coche, cocheWrapper._coche)) {
			return true;
		}

		return false;
	}

	@Override
	public Coche getWrappedModel() {
		return _coche;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _coche.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _coche.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_coche.resetOriginalValues();
	}

	private final Coche _coche;
}