/**
 * Copyright 2014 Nikita Koksharov, Nickolay Borbit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.core;

import org.reactivestreams.Publisher;

public interface RKeysReactive {

    Publisher<String> getKeys();

    Publisher<String> getKeysByPattern(String pattern);

    /**
     * Get hash slot identifier for key in  mode.
     * Available for cluster nodes only
     *
     * @param key
     * @return
     */
    Publisher<Integer> getSlot(String key);

    /**
     * Get random key in  mode
     *
     * @return
     */
    Publisher<String> randomKey();

    /**
     * Delete multiple objects by a key pattern in  mode
     *
     *  Supported glob-style patterns:
     *    h?llo subscribes to hello, hallo and hxllo
     *    h*llo subscribes to hllo and heeeello
     *    h[ae]llo subscribes to hello and hallo, but not hillo
     *
     * @param pattern
     * @return
     */
    Publisher<Long> deleteByPattern(String pattern);

    /**
     * Delete multiple objects by name in  mode
     *
     * @param keys - object names
     * @return
     */
    Publisher<Long> delete(String ... keys);

}