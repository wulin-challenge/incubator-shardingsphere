/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shardingproxy.transport.mysql.packet.handshake;

import com.google.common.primitives.Bytes;
import lombok.Getter;

/**
 * MySQL auth plugin data.
 * 
 * <p>
 *     The auth-plugin-data is the concatenation of strings auth-plugin-data-part-1 and auth-plugin-data-part-2.
 *     The auth-plugin-data-part-1's length is 8; The auth-plugin-data-part-2's length is 12.
 * </p>
 *
 * @author zhangliang
 */
@Getter
public final class MySQLAuthPluginData {
    
    private final byte[] authPluginDataPart1;
    
    private final byte[] authPluginDataPart2;
    
    public MySQLAuthPluginData() {
        this(MySQLRandomGenerator.getInstance().generateRandomBytes(8), MySQLRandomGenerator.getInstance().generateRandomBytes(12));
    }
    
    public MySQLAuthPluginData(final byte[] authPluginDataPart1, final byte[] authPluginDataPart2) {
        this.authPluginDataPart1 = authPluginDataPart1;
        this.authPluginDataPart2 = authPluginDataPart2;
    }
    
    /**
     * Get auth plugin data.
     * 
     * @return auth plugin data
     */
    public byte[] getAuthPluginData() {
        return Bytes.concat(authPluginDataPart1, authPluginDataPart2);
    }
}
