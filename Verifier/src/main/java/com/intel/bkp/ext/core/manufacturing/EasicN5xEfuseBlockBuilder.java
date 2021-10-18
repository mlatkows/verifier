/*
 * This project is licensed as below.
 *
 * **************************************************************************
 *
 * Copyright 2020-2021 Intel Corporation. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * **************************************************************************
 *
 */

package com.intel.bkp.ext.core.manufacturing;

import com.intel.bkp.ext.utils.ByteBufferSafe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

@Getter
@NoArgsConstructor
public class EasicN5xEfuseBlockBuilder extends EfuseBlockBuilder {

    private static final int OFFSET_BETWEEN_ROM_FUSES_AND_ROOT_HASH_FIRST_PART = 20;
    private static final int OFFSET_BETWEEN_ROOT_HASH_FIRST_PART_AND_SECOND_PART = 4;

    private final byte[] rootHashFirstPart = new byte[60];
    private final byte[] rootHashSecondPart = new byte[4];

    @Override
    protected void parseInternal(ByteBufferSafe buffer) {
        buffer.get(romFuses); // words 0..7
        buffer.skip(OFFSET_BETWEEN_ROM_FUSES_AND_ROOT_HASH_FIRST_PART);
        buffer.get(rootHashFirstPart); // words 13..27
        buffer.skip(OFFSET_BETWEEN_ROOT_HASH_FIRST_PART_AND_SECOND_PART);
        buffer.get(rootHashSecondPart); // word 29
        ByteBufferSafe.wrap(ArrayUtils.addAll(rootHashFirstPart, rootHashSecondPart)).getAll(rootHash);
    }
}