/*
 * Copyright (C) 2017-2020 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package com.here.ort.reporter.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonInclude

import com.here.ort.model.PackageLinkage
import com.here.ort.model.config.PathExclude
import com.here.ort.model.config.ScopeExclude
import com.here.ort.reporter.utils.ZeroBasedIntSequenceGenerator

/**
 * A node for the dependency trees of the [EvaluatedModel].
 */
@JsonIdentityInfo(property = "key", generator = ZeroBasedIntSequenceGenerator::class, scope = DependencyTreeNode::class)
data class DependencyTreeNode(
    val title: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val linkage: PackageLinkage?,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val pkg: EvaluatedPackage?,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val pathExcludes: List<PathExclude> = emptyList(),
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val scopeExcludes: List<ScopeExclude> = emptyList(),
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val issues: List<EvaluatedOrtIssue> = emptyList(),
    val children: List<DependencyTreeNode>
)
