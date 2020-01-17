/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package org.rust.openapiext

import com.intellij.openapi.application.Experiments

fun isFeatureEnabled(featureId: String): Boolean = Experiments.getInstance().isFeatureEnabled(featureId)
fun setFeatureEnabled(featureId: String, enabled: Boolean) = Experiments.getInstance().setFeatureEnabled(featureId, enabled)
