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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link serviciocoches.service.http.CocheServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see serviciocoches.service.http.CocheServiceSoap
 * @generated
 */
@ProviderType
public class CocheSoap implements Serializable {
	public static CocheSoap toSoapModel(Coche model) {
		CocheSoap soapModel = new CocheSoap();

		soapModel.setMatricula(model.getMatricula());
		soapModel.setMarca(model.getMarca());
		soapModel.setModelo(model.getModelo());
		soapModel.setPrecio(model.getPrecio());
		soapModel.setPrecioConIva(model.getPrecioConIva());

		return soapModel;
	}

	public static CocheSoap[] toSoapModels(Coche[] models) {
		CocheSoap[] soapModels = new CocheSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CocheSoap[][] toSoapModels(Coche[][] models) {
		CocheSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CocheSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CocheSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CocheSoap[] toSoapModels(List<Coche> models) {
		List<CocheSoap> soapModels = new ArrayList<CocheSoap>(models.size());

		for (Coche model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CocheSoap[soapModels.size()]);
	}

	public CocheSoap() {
	}

	public String getPrimaryKey() {
		return _Matricula;
	}

	public void setPrimaryKey(String pk) {
		setMatricula(pk);
	}

	public String getMatricula() {
		return _Matricula;
	}

	public void setMatricula(String Matricula) {
		_Matricula = Matricula;
	}

	public String getMarca() {
		return _Marca;
	}

	public void setMarca(String Marca) {
		_Marca = Marca;
	}

	public String getModelo() {
		return _Modelo;
	}

	public void setModelo(String Modelo) {
		_Modelo = Modelo;
	}

	public double getPrecio() {
		return _Precio;
	}

	public void setPrecio(double Precio) {
		_Precio = Precio;
	}

	public double getPrecioConIva() {
		return _PrecioConIva;
	}

	public void setPrecioConIva(double PrecioConIva) {
		_PrecioConIva = PrecioConIva;
	}

	private String _Matricula;
	private String _Marca;
	private String _Modelo;
	private double _Precio;
	private double _PrecioConIva;
}