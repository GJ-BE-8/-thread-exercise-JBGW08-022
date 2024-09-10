/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.count;

public class SharedCounter {
    private long count;

    public SharedCounter(){
        count =0l;
    }

    public SharedCounter(long count) {
        if(count < 0){
            throw new IllegalArgumentException();
        }

        this.count = count;

    }

    public long getCount(){
        return this.count;
    }

    public long increaseAndGet(){
        return ++count;
    }

    public long decreaseAndGet(){

        return --count;
    }
}
