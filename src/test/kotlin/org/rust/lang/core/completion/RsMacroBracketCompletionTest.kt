/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package org.rust.lang.core.completion

class RsMacroBracketCompletionTest : RsCompletionTestBase() {

    fun `test default bracket`() = doSingleCompletion("""
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo/*caret*/
        }
    """, """
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo!(/*caret*/)
        }
    """)

    fun `test bracket from documentation`() = doSingleCompletion("""
        /// `foo![]`
        ///
        /// ```
        /// bar_foo!();
        /// foo();
        /// ```
        ///
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo/*caret*/
        }
    """, """
        /// `foo![]`
        ///
        /// ```
        /// bar_foo!();
        /// foo();
        /// ```
        ///
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo![/*caret*/]
        }
    """)

    fun `test insert space for before braces`() = doSingleCompletion("""
        /// `foo! {}`
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo/*caret*/
        }
    """, """
        /// `foo! {}`
        macro_rules! foo {
            () => {};
        }
        fn main() {
            foo! {/*caret*/}
        }
    """)
}
