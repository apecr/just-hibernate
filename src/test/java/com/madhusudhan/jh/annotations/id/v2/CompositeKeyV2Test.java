/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v2;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mkonda
 */
public class CompositeKeyV2Test {
    
    private CompositeKeyV2 compositeKeyV2 = new CompositeKeyV2();

    
    @Test(expected = ConstraintViolationException.class)
    public void main() {
        this.compositeKeyV2.init();
        Assert.assertTrue(this.compositeKeyV2.persist());
    }
}
