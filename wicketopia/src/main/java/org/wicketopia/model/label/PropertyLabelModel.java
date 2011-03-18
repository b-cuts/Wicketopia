/*
 * Copyright (c) 2010 Carman Consulting, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketopia.model.label;

import org.apache.wicket.model.ResourceModel;
import org.metastopheles.PropertyMetaData;
import org.wicketopia.metadata.WicketopiaFacet;

/**
 * @since 1.0
 */
public class PropertyLabelModel extends ResourceModel
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private static final long serialVersionUID = 1L;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public PropertyLabelModel( PropertyMetaData propertyMetadata )
    {
        super(WicketopiaFacet.get(propertyMetadata).getLabelTextMessageKey(), WicketopiaFacet.get(propertyMetadata).getDefaultLabelText());
    }
}