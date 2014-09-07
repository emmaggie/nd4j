---
layout: page
title: "Vector Operations"
description: ""
---
{% include JB/setup %}

When performed with simple units like scalars, the operations of arithmatic are unambiguous. But working with matrices, addition and multiplication can mean several things. With vector-on-matrix operations, you have to know what kind of addition or multiplication you're performing in each case. 

First, we'll create a 2 x 2 matrix, a column vector and a row vector. 

        INDArray nd = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});
        INDArray nd2 = Nd4j.create(new float[]{5,6},new int[]{2,1}); //vector as column
        INDArray nd3 = Nd4j.create(new float[]{5,6},new int[]{2}); //vector as row

Notice that the shape of the two vectors is specified with their final parameters. {2,1} means the vector is vertical, with elements populating two rows and one column. A simple {2} means the vector populates along a single row that spans two columns -- horizontal. You're first matrix will look like this

        [[1.0 ,3.0]
         [2.0 ,4.0]
        ]

Here's how you add a column vector to a matrix:

        nd.addiColumnVector(nd2);

And here's the best way to visualize what's happening. The top element of the column vector combines with the top elements of each column in the matrix, and so forth. The sum matrix represents the march of that column vector across the matrix from left to right, adding itself along the way.


        [1.0 ,3.0]     [5.0]    [6.0 ,8.0]
        [2.0 ,4.0]  +  [6.0] =  [8.0 ,10.0]
        
But let's say you preserved the initial matrix and instead added a row vector. 

        nd.addiRowVector(nd3);

Then your equation is best visualized like this:

        [1.0 ,3.0]                   [6.0 ,9.0]
        [2.0 ,4.0]  +  [5.0 ,6.0] =  [7.0 ,10.0]

In this case, the leftmost element of the row vector combines with the leftmost elements of each row in the matrix, and so forth. The sum matrix represents that row vector falling down the matrix from top to bottom, adding itself at each level.

So vector addition can lead to different results depending on the orientation of your vector. The same is true for multiplication, subtraction and division and every other vector operation. 

In ND4J, row vectors and column vectors look the same when you print them out with 

        System.out.println(nd);

They will appear like this.

[5.0 ,6.0]

Don't be fooled. Getting the parameters right at the beginning is crucial. addRowVector and addColumnVector will not produce different results when using the same initial vector, because they do not change a vector's orientation as row or column. 
