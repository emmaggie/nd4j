---
layout: page
title: "Functions"
description: ""
---
{% include JB/setup %}

A static import at the top of your Java file makes advanced functions fairly simple to use with ND4J:

    import static org.nd4j.linalg.ops.transforms.Transforms.*;

Here's the [example code](https://github.com/SkymindIO/nd4j/blob/master/nd4j-examples/src/main/java/org/nd4j/examples/FunctionsExample.java). That done, create your arrays and call a function on them.

        INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, new int[]{2, 7});
        INDArray ndv;

### Sigmoid

Sigmoid is a mathematical funciton in the shape of an S, or sigmoid curve, which normalizes data to a range between -1 and 1, so that it can be understood in terms of probabilities. Sigmoid functions are one of several activation functions used for [artificial neurons](http://deeplearning4j.org/). 

    ndv = sigmoid(nd);

Here's what Sigmoid should return for the above array

     [0.7310586 ,0.95257413 ,0.9933072 ,0.999089 ,0.9998766 ,0.9999833]
     [0.880797 ,0.98201376 ,0.9975274 ,0.99966466 ,0.9999546 ,0.9999938]

### Tanh

Tanh -- pronounced "tan H" -- is a hyperbolic trigonometric function, the hyperbolic tangent, which like Sigmoid serves as a transform to activate artificial neurons, among other uses. It resembles a windblown S. 

     ndv = tanh(nd);
     
Here's what Sigmoid should return for the above array

     [0.7615942 ,0.9950548 ,0.9999092 ,0.99999833 ,0.99999994 ,1.0 ,-0.9999877]
     [0.9640276 ,0.9993293 ,0.9999877 ,0.99999976 ,1.0 ,1.0 ,-0.99999976]

### Absolute Value

Absolute Value returns the distance of an element from zero, regardless of its positive or negative value.

     abs(nd2);

So if the array nd2 looked like this 

     [1.0 ,3.0 ,5.0 ,7.0 ,9.0 ,11.0 ,-6.0]
     [2.0 ,4.0 ,6.0 ,8.0 ,10.0 ,12.0 ,-8.0]   

It would appear like this after absolute value is performed on it

     [1.0 ,3.0 ,5.0 ,7.0 ,9.0 ,11.0 ,6.0]
     [2.0 ,4.0 ,6.0 ,8.0 ,10.0 ,12.0 ,8.0]   

### Square Root

Should go without saying. Calling square root on the array nd above

     ndv = sqrt(nd);

produces this result

     [1.0 ,1.7320508 ,2.236068 ,2.6457512 ,3.0 ,3.3166249]
     [1.4142135 ,2.0 ,2.4494898 ,2.828427 ,3.1622777 ,3.4641016]
