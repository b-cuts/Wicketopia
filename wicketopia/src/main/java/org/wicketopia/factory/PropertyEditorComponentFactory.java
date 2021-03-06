/*
 * Copyright (c) 2011 Carman Consulting, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketopia.factory;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.metastopheles.PropertyMetaData;
import org.wicketopia.Wicketopia;
import org.wicketopia.context.Context;

public class PropertyEditorComponentFactory<T> extends AbstractPropertyComponentFactory<T> {
//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public PropertyEditorComponentFactory(Class<T> beanType) {
        super(beanType);
    }

//----------------------------------------------------------------------------------------------------------------------
// PropertyComponentFactory Implementation
//----------------------------------------------------------------------------------------------------------------------

    public Component createPropertyComponent(String id, IModel<T> beanModel, String propertyName, Context context) {
        Wicketopia plugin = Wicketopia.get();
        PropertyMetaData propertyMetaData = plugin.getBeanMetaData(getBeanType()).getPropertyMetaData(propertyName);
        return plugin.createPropertyEditor(id, propertyMetaData, new PropertyModel(beanModel, propertyName), context);
    }
}
