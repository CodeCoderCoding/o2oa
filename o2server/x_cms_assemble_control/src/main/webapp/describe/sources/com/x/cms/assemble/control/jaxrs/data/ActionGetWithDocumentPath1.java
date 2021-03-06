package com.x.cms.assemble.control.jaxrs.data;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.cms.assemble.control.Business;
import com.x.cms.assemble.control.jaxrs.data.exception.ExceptionDocumentNotExist;
import com.x.cms.core.entity.Document;

class ActionGetWithDocumentPath1 extends BaseAction {

	ActionResult<JsonElement> execute(EffectivePerson effectivePerson, String id, String path0, String path1)
			throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			ActionResult<JsonElement> result = new ActionResult<>();
			Business business = new Business(emc);
			Document document = emc.find(id, Document.class);
			if (null == document) {
				throw new ExceptionDocumentNotExist(id);
			}
			result.setData(this.getData(business, document.getId(), path0, path1));
			return result;
		}
	}
}
