/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.broker.loadbalance.extensions.models;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Defines the information required for a service unit split(e.g. bundle split).
 */
public record Split(
        String serviceUnit, String sourceBroker, Map<String, Optional<String>> splitServiceUnitToDestBroker) {

    public Split {
        Objects.requireNonNull(serviceUnit);
        if (splitServiceUnitToDestBroker != null && splitServiceUnitToDestBroker.size() != 2) {
            throw new IllegalArgumentException("Split service unit should be split into 2 service units.");
        }
    }

    public Split(String serviceUnit, String sourceBroker) {
        this(serviceUnit, sourceBroker, null);
    }
}
