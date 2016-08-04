/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v1;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;

import junit.framework.Assert;

/**
 *
 * @author mkonda
 */
public class CompositeKeyV1Test {
    
    
    private CompositeKeyV1 compositeKeyV1 = new CompositeKeyV1();
    
    @Test(expected = ConstraintViolationException.class)
    public void testCrud() {
        this.compositeKeyV1.init();
        Assert.assertTrue( this.compositeKeyV1.persist() );
    }
}
