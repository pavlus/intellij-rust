/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package org.rust.clion.debugger

import com.intellij.openapi.project.Project
import com.jetbrains.cidr.cpp.toolchains.CPPToolchains
import com.jetbrains.cidr.execution.debugger.backend.DebuggerDriverConfiguration
import org.rust.debugger.RsDebuggerDriverConfigurationProvider

class RsCLionDebuggerDriverConfigurationProvider : RsDebuggerDriverConfigurationProvider {
    override fun getDebuggerDriverConfiguration(project: Project): DebuggerDriverConfiguration? {
        return CPPToolchains.getInstance().defaultToolchain?.createDriverConfiguration(project)
    }
}
