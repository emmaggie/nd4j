---
layout: page
title: "Matrix manipulation"
description: ""
---
{% include JB/setup %}

There are several other basic matrix manipulations to highlight as you learn ND4J's workings. 

* Transpose: The transpose of a matrix is its mirror image. An element located in row 1, column 2, in matrix A will be located in row 2, column 1, in the the transpose of matrix A, whose mathematical notation is A to the T, or A^T. Notice that the elements along the diagonal of a square matrix do not move -- they are at the hinge of the reflection. In ND4J, transpose matrices like this: 

    INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});

    [1.0 ,3.0]
    [2.0 ,4.0]                                                                                                                      
    nd.transpose();
    
    [1.0 ,2.0]
    [3.0 ,4.0]

And a long matrix like this

    [1.0 ,3.0 ,5.0 ,7.0 ,9.0 ,11.0]
    [2.0 ,4.0 ,6.0 ,8.0 ,10.0 ,12.0]
    
Looks like this when it is transposed

    [1.0 ,2.0]
    [3.0 ,4.0]
    [5.0 ,6.0]
    [7.0 ,8.0]
    [9.0 ,10.0]
    [11.0 ,12.0]

In fact, transpose is just an important subset of a more general operation: reshape. 

* Reshape: Yes, matrices can be reshaped. You can change the number of rows and columns they have. The reshaped matrix has to fulfill one condition: the product of its rows and columns must equal the product of the row and columns of the original matrix. For example, proceeding columnwise, you can reshape a 3 by 4 matrix into a 2 by 6 matrix: 

    INDArray nd2 = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, new int[]{2, 6});
    
The array nd2 looks like this

    [1.0 ,3.0 ,5.0 ,7.0 ,9.0 ,11.0]
    [2.0 ,4.0 ,6.0 ,8.0 ,10.0 ,12.0]

Reshaping it is easy, and follows the same convention by which we gave it shape to begin with

    nd2.reshape(3,4);

    [1.0 ,4.0 ,7.0 ,10.0]
    [2.0 ,5.0 ,8.0 ,11.0]
    [3.0 ,6.0 ,9.0 ,12.0]

* Linear view: This is straight view of an arbitrary nd-array. You can go through the nd-array like a vector, linearly, squashing it into one long line. Linear view allows you to do nondestructive operations (reshape and other operations can be destructive because elements are changed within the nd-array). Linear views are only good for elementwise operations (rather than matrix operations), since the views do not preserve the order of the buffer. 

    nd2.linearView();
    
    [1.0 ,2.0 ,3.0 ,4.0 ,5.0 ,6.0 ,7.0 ,8.0 ,9.0 ,10.0 ,11.0 ,12.0]
