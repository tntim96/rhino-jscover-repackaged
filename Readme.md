Rhino for JSCover
=================
[![Build Status](https://drone.io/github.com/tntim96/rhino-jscover-repackaged/status.png)](https://drone.io/github.com/tntim96/rhino-jscover-repackaged/latest)

This is intended to be a temporary repository until Rhino incorporates some bug fixes into a released version.

Changes
=======
Bug Fixes
---------
[AST toSource on getter/setter inserting 'function' keyword](https://bugzilla.mozilla.org/show_bug.cgi?id=798642)

[AST toSource on Hex string literal removes '0x'](https://bugzilla.mozilla.org/show_bug.cgi?id=800616)

[Rhino pull request for bugs 798642 and 800616 above](https://github.com/mozilla/rhino/pull/138)

Repackaging
-----------
Rename `org.mozilla` to `jscover.mozilla` to avoid classpath clashes

Repackaging Notes
=================
1. git rename `org` to `jsover` in `src`, `dprecatedsrc`, `testsrc`, `toolsrc`, `xmlimplsrc`
1. replace `org.mozilla` and `org/mozilla` with `jscover.mozilla` and `jscover/mozilla` across all files in project
1. replace `org/**` to `jscover/**` in build files
1. add `jscover` to both lists in `jscover.mozilla.javascript.ScriptRuntime.getTopPackageNames()`
