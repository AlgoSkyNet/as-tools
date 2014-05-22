# Developers

## Building AS Tools



### Setting up Maven

All AS Tools projects are built in Java using [Apache Maven](http://maven.apache.org/).

After you have installed Maven run the following command to add the ActiveSpaces Java library to the Maven repository:

```
mvn install:install-file -Dfile=$AS_HOME/lib/as-common.jar -DgroupId=com.tibco.as -DartifactId=as-common -Dversion=2.1.2 -Dpackaging=jar
```


### Getting the Source

```
svn checkout http://svn.tibco.com/fieldprojects/trunk/as
```


### Building the Projects

Open a terminal and cd to the checkout location.

cd to the `parent` directory and run the following command:

```
mvn clean install
```

You should see the following message indicating that the project built successfully:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 41.801s
[INFO] Finished at: Tue Apr 29 17:56:45 PDT 2014
[INFO] Final Memory: 29M/81M
[INFO] ------------------------------------------------------------------------
```

Run the same command for each of the following projects:

* `tools-parent`
* `com.tibco.as.common`
* `com.tibco.as.convert`
* `com.tibco.as.io`
* `com.tibco.as.io.cli`
* `com.tibco.as.io.db`
* `com.tibco.as.io.excel`
* `com.tibco.as.io.excel2as`
* `com.tibco.as.io.file`
* `com.tibco.as.io.file2as`

All projects should be building successfully.

Now the `com.tibco.as.io.simulation` project has a dependency on a third-party project called `xeger` which is not available in the public Maven repositories.

Check out the Xeger project from [https://github.com/bluezio/xeger](https://github.com/bluezio/xeger) and build it with the following command:

```
mvn clean install
```

Build the simulation projects:

* `com.tibco.as.io.simulation`
* `com.tibco.as.io.simulator`



