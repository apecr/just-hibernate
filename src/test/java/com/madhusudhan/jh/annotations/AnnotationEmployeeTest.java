package com.madhusudhan.jh.annotations;

import org.junit.Test;

import junit.framework.Assert;

/**
 *
 * @author mkonda
 */
public class AnnotationEmployeeTest {
    
    private AnnotationEmployee annotationEmployee= new AnnotationEmployee();


    @Test
    public void testCrud() {
        this.annotationEmployee.init();
        Assert.assertTrue( this.annotationEmployee.persist());
    }
}
