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

package serviciocoches.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import serviciocoches.model.Coche;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Coche in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Coche
 * @generated
 */
@ProviderType
public class CocheCacheModel implements CacheModel<Coche>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CocheCacheModel)) {
			return false;
		}

		CocheCacheModel cocheCacheModel = (CocheCacheModel)obj;

		if (Matricula.equals(cocheCacheModel.Matricula)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Matricula);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{Matricula=");
		sb.append(Matricula);
		sb.append(", Marca=");
		sb.append(Marca);
		sb.append(", Modelo=");
		sb.append(Modelo);
		sb.append(", Precio=");
		sb.append(Precio);
		sb.append(", PrecioConIva=");
		sb.append(PrecioConIva);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Coche toEntityModel() {
		CocheImpl cocheImpl = new CocheImpl();

		if (Matricula == null) {
			cocheImpl.setMatricula(StringPool.BLANK);
		}
		else {
			cocheImpl.setMatricula(Matricula);
		}

		if (Marca == null) {
			cocheImpl.setMarca(StringPool.BLANK);
		}
		else {
			cocheImpl.setMarca(Marca);
		}

		if (Modelo == null) {
			cocheImpl.setModelo(StringPool.BLANK);
		}
		else {
			cocheImpl.setModelo(Modelo);
		}

		cocheImpl.setPrecio(Precio);
		cocheImpl.setPrecioConIva(PrecioConIva);

		cocheImpl.resetOriginalValues();

		return cocheImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Matricula = objectInput.readUTF();
		Marca = objectInput.readUTF();
		Modelo = objectInput.readUTF();

		Precio = objectInput.readDouble();

		PrecioConIva = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (Matricula == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Matricula);
		}

		if (Marca == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Marca);
		}

		if (Modelo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Modelo);
		}

		objectOutput.writeDouble(Precio);

		objectOutput.writeDouble(PrecioConIva);
	}

	public String Matricula;
	public String Marca;
	public String Modelo;
	public double Precio;
	public double PrecioConIva;
}