gradle-intellij-helloworld
==========================

A small toy project for testing out the
[gradle-intellij-plugin](https://github.com/JetBrains/gradle-intellij-plugin)
in a multi-module project.

This project has two modules:

* `plugin` - the actual IDE plugin
* `plugin-library` - a library module consumed by the `plugin` module. Contains a few tests too.

The actual code just adds a "Hello world" action.
