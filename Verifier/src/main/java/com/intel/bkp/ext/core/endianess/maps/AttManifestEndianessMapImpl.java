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

package com.intel.bkp.ext.core.endianess.maps;

import com.intel.bkp.ext.core.endianess.EndianessActor;
import com.intel.bkp.ext.core.endianess.EndianessStructureFields;

import static com.intel.bkp.ext.utils.ByteSwapOrder.CONVERT;

public final class AttManifestEndianessMapImpl extends BaseEndianessMapImpl {

    public AttManifestEndianessMapImpl(EndianessActor actor) {
        super(actor);
    }

    @Override
    void populateFirmwareMap() {
        map.put(EndianessStructureFields.ATT_MANIFEST_MAGIC, CONVERT);
        map.put(EndianessStructureFields.ATT_DEVICE_UNIQUE_ID, CONVERT);
        map.put(EndianessStructureFields.ATT_LENGTH, CONVERT);
        map.put(EndianessStructureFields.ATT_EFUSE_BLOCK, CONVERT);
        map.put(EndianessStructureFields.ATT_INTEL_CANCELLATION, CONVERT);
        map.put(EndianessStructureFields.ATT_MANIFEST_KEY_OFFSET, CONVERT);
        map.put(EndianessStructureFields.ATT_MANIFEST_AMS_KEY_ID, CONVERT);
    }
}
