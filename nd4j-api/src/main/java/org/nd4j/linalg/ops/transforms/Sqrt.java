package org.nd4j.linalg.ops.transforms;

import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.BaseElementWiseOp;
import org.nd4j.linalg.util.ComplexUtil;

/**
 * Created by agibsonccc on 8/16/14.
 */
public class Sqrt extends BaseElementWiseOp {
    /**
     * The transformation for a given value (a scalar ndarray)
     *
     * @param value the value to applyTransformToOrigin (a scalar ndarray)
     * @param i     the index of the element being acted upon
     * @return the transformed value based on the input
     */
    @Override
    public Object apply(INDArray from,Object value, int i) {
        if(value instanceof IComplexNDArray) {
            return ComplexUtil.sqrt((org.nd4j.linalg.api.complex.IComplexNumber) value);
        }
        return (float) Math.sqrt((float) value);
    }
}
