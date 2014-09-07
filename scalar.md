---
layout: page
title: "Elementwise Scalar Operations"
description: ""
---
{% include JB/setup %}

The basic operations of linear algebra are matrix creation, addition and multiplication. This guide will show you how to perform those operations with ND4J. 

The Java code below will create a simple 2 x 2 matrix, populate it with integers, and place it in the nd-array variable nd:

    INDArray nd = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});

If you print out this array

    System.out.println(nd);

you'll see this

    [[1.0 ,3.0]
    [2.0 ,4.0]
    ]

A matrix with two rows and two columns, which orders its elements by column. 

A matrix that ordered its elements by row would look like this:

    [[1.0 ,2.0]
    [3.0 ,4.0]
    ]

The simplest operations you can perform on a matrix are elementwise scalar operations; for example, adding the scalar 1 to each element of the matrix, or multiplying each element by the scalar 5. Let's try it. 

    nd.addi(1);

This line of code represents this operation:

    [[1.0 + 1 ,3.0 + 1]
    [2.0 + 1,4.0 + 1]
    ]

which will appear like this

    [[2.0 ,4.0]
    [3.0 ,5.0]
    ]

The "i" in nd.addi means this operation is performed "in place," directly on the data, which is to say it is destructive. nd.add() would simply perform scalar addition on a copy of the data and leave the original untouched. 

Elementwise scalar multiplication looks like this:

    nd.muli(5);

And produces this:

    [[10.0 ,20.0]
    [15.0 ,25.0]
    ]

Subtraction and division follow a similar pattern:

    nd.subi(3);
    nd.divi(2);

If you perform all these operations on your initial 2 x 2 matrix, you should end up with this matrix:

    [[3.5 ,8.5]
    [6.0 ,11.0]
    ]

