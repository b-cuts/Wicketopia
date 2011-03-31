package org.wicketopia.metadata;

import org.metastopheles.BeanMetaData;
import org.metastopheles.FacetKey;
import org.metastopheles.PropertyMetaData;
import org.wicketopia.util.Displayable;
import org.wicketopia.util.Pluralizer;

import java.io.Serializable;

/**
 * @author James Carman
 */
public class WicketopiaBeanFacet implements Serializable, Displayable
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private static final FacetKey<WicketopiaBeanFacet> FACET_KEY = new FacetKey<WicketopiaBeanFacet>()
    {
    };

    private final BeanMetaData beanMetaData;
    private String displayName;
    private String displayNameMessageKey;

//----------------------------------------------------------------------------------------------------------------------
// Static Methods
//----------------------------------------------------------------------------------------------------------------------

    public static WicketopiaBeanFacet get(BeanMetaData beanMetaData)
    {
        synchronized (beanMetaData)
        {
            WicketopiaBeanFacet meta = beanMetaData.getFacet(FACET_KEY);
            if (meta == null)
            {
                meta = new WicketopiaBeanFacet(beanMetaData);
                beanMetaData.setFacet(FACET_KEY, meta);
            }
            return meta;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public WicketopiaBeanFacet(BeanMetaData beanMetaData)
    {
        this.beanMetaData = beanMetaData;
        this.displayNameMessageKey = getBeanMetaData().getBeanDescriptor().getBeanClass().getName();
        this.displayName = Pluralizer.splitIntoWords(beanMetaData.getBeanDescriptor().getBeanClass().getSimpleName());
    }

//----------------------------------------------------------------------------------------------------------------------
// Getter/Setter Methods
//----------------------------------------------------------------------------------------------------------------------

    public BeanMetaData getBeanMetaData()
    {
        return beanMetaData;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayNameMessageKey()
    {
        return displayNameMessageKey;
    }

    public void setDisplayNameMessageKey(String displayNameMessageKey)
    {
        this.displayNameMessageKey = displayNameMessageKey;
    }

//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    private Object writeReplace()
    {
        return new SerializedForm(getBeanMetaData());
    }

//----------------------------------------------------------------------------------------------------------------------
// Inner Classes
//----------------------------------------------------------------------------------------------------------------------

    private static class SerializedForm implements Serializable
    {
        private final BeanMetaData beanMetaData;

        private SerializedForm(BeanMetaData beanMetaData)
        {
            this.beanMetaData = beanMetaData;
        }

        private Object readResolve()
        {
            return WicketopiaBeanFacet.get(beanMetaData);
        }
    }
}
