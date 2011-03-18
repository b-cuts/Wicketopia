/*
 * Copyright (c) 2011 Carman Consulting, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketopia.editor.decorator;

import org.wicketopia.editor.PropertyEditor;
import org.wicketopia.editor.context.EditorContext;
import org.wicketopia.editor.context.EditorContextPredicate;

/**
 * @since 1.0
 */
public class VisibleDecorator extends ContextualDecorator
{
//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public VisibleDecorator(EditorContextPredicate predicate)
    {
        super(predicate);
    }

//----------------------------------------------------------------------------------------------------------------------
// PropertyEditorDecorator Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void apply(PropertyEditor editor, EditorContext context)
    {
        editor.show(predicate.evaluate(context));
    }
}