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

package com.nhnacademy;

import com.nhnacademy.thread.CounterHandler;

public class App
{
    public static void main( String[] args )
    {
        CounterHandler counterHandler = new CounterHandler(10);

        Thread threadA = new Thread(counterHandler);

        threadA.setName("my-counter-A");
        Thread threadB = new Thread(counterHandler);

        threadB.setName("my-counter-B");
        threadA.start();
        threadB.start();
        // 생기는 문제 같은 변수를 읽으니 1 이 두번 나올수도 있고
        // 우리가 의도한건 count 가 10이하일 동안 동작하는것인데
        // while문 안에 두번읽어서 11이 나올수 있다. 
    }
}